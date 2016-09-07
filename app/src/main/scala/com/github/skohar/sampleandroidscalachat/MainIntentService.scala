package com.github.skohar.sampleandroidscalachat

import android.app.IntentService
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager

class MainIntentService extends IntentService("MainIntentService") {
  def onHandleIntent(workIntent: Intent) {
    val dataString = workIntent.getDataString
    LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(MainIntentService.BROADCAST_ACTION).putExtra(MainIntentService.EXTENDED_DATA_STATUS, ""))
  }
}

object MainIntentService {
  val BROADCAST_ACTION = "com.github.skohar.sampleandroidscalachat.BROADCAST"
  val EXTENDED_DATA_STATUS = "com.github.skohar.sampleandroidscalachat.STATUS"
}