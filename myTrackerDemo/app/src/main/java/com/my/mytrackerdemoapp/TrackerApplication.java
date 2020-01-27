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

		MyTracker.getTrackerParams()
				 .setAge(22)
				 .setGender(MyTrackerParams.Gender.FEMALE);

		MyTracker.initTracker(APP_ID, this);
	}
}
