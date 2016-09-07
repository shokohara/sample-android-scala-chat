package com.github.skohar.sampleandroidscalachat

import android.app.IntentService
import android.content.Intent

class MainIntentService extends IntentService("MainIntentService") {
  def onHandleIntent(workIntent: Intent) {
    val dataString = workIntent.getDataString()
  }
}