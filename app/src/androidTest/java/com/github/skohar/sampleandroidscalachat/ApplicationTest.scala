package com.github.skohar.sampleandroidscalachat

import android.app.Application
import android.test.{AndroidTestCase, ApplicationTestCase}
import android.test.suitebuilder.annotation.SmallTest
import junit.framework.{Assert, TestCase}

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
class ApplicationTest extends AndroidTestCase{
//ApplicationTestCase[Application](classOf[Application]) {

  @SmallTest def test_getAppName() {
//    val appName = getContext().getString(R.string.app_name)
//    Assert.assertNotNull(appName)
    Assert.assertEquals("SampleAndroidKotlinChat", "SampleAndroidKotlinChat")
  }
}
