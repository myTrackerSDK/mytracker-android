package com.my.mytrackerdemoapp

import android.app.Application
import com.my.tracker.MyTracker
import com.my.tracker.MyTrackerParams

class TrackerApplication : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        MyTracker.setDebugMode(true) // for debugging, turn off in production

        MyTracker.getTrackerParams()
                .setAge(22)
                .setGender(MyTrackerParams.Gender.FEMALE)

        MyTracker.initTracker(APP_ID, this)
    }

    companion object
    {
        private const val APP_ID = "66039511634340742311"
    }
}