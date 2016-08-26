package com.github.skohar.sampleandroidscalachat

import android.support.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class MainApplication extends MultiDexApplication {

  override def onCreate() = {
    super.onCreate()
    new Fabric.Builder(this).kits(new Crashlytics()).debuggable(true).build()
    Fabric.`with`(this, new Crashlytics())
  }
}
