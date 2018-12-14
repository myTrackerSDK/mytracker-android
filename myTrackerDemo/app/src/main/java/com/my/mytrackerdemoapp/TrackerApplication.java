package com.my.mytrackerdemoapp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.my.tracker.MyTracker;
import com.my.tracker.MyTrackerParams;

public class TrackerApplication extends Application
{
	private static @NonNull String APP_ID = "66039511634340742311";

	@Override
	public void onCreate()
	{
		super.onCreate();

		MyTracker.setDebugMode(true); // for debugging, turn off in production

		MyTracker.createTracker(APP_ID, this);

		MyTrackerParams trackerParams = MyTracker.getTrackerParams();

		// example params
		trackerParams.setAge(22);
		trackerParams.setGender(MyTrackerParams.Gender.FEMALE);

		MyTracker.initTracker();
	}
}
