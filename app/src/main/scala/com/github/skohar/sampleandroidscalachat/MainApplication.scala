package com.github.skohar.sampleandroidscalachat

import java.io.File

import android.media.{AudioFormat, AudioRecord}
import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.DateTime

class MainApplication extends MultiDexApplication {

  val SAMPLING_RATE = 44100
  val bufSize = AudioRecord.getMinBufferSize(SAMPLING_RATE, AudioFormat.CHANNEL_IN_MONO,
    AudioFormat.ENCODING_PCM_16BIT)
  var audioRecord: AudioRecord = _
  var file: File = _
  var waveFileWriter: WaveFileWriter = _

  override def onCreate() = {
    super.onCreate()
    new Fabric.Builder(this).kits(new Crashlytics()).debuggable(true).build()
    Fabric.`with`(this, new Crashlytics())
    JodaTimeAndroid.init(this)

    val dateTimeString = DateTime.now().withMinuteOfHour(0).withSecondOfMinute(0)
      .withMillisOfSecond(0).toString("yyyyMMddHHmmss")
    waveFileWriter = new WaveFileWriter(file)
    file = new File(s"/sdcard/$dateTimeString.wav")
    audioRecord = new AudioRecord(1, SAMPLING_RATE, AudioFormat.CHANNEL_IN_MONO,
      AudioFormat.ENCODING_PCM_16BIT, bufSize)
    audioRecord.setPositionNotificationPeriod(bufSize / 2)
    audioRecord.setRecordPositionUpdateListener(new AudioRecord.OnRecordPositionUpdateListener() {

      override def onPeriodicNotification(recorder: AudioRecord): Unit = {
        val array:Array[Short] = new Array[Short](bufSize / 2)
        audioRecord.read(array, 0, bufSize / 2)
        array.foreach(waveFileWriter.write(_))
      }

      override def onMarkerReached (recorder: AudioRecord): Unit ={
      }
    })  
  }

  override def onLowMemory(): Unit = {
    super.onLowMemory()
  }
}
