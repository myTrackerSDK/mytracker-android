package com.my.mytrackerdemoapp;

import android.app.Application;

import com.my.tracker.MyTracker;
import com.my.tracker.MyTrackerParams;

public class TrackerApplication extends Application
{

	@Override
	public void onCreate()
	{
		super.onCreate();

		MyTracker.setDebugMode(true); // for debugging, turn off in production

		MyTracker.createTracker("89232805149757155048", this);

		MyTrackerParams trackerParams = MyTracker.getTrackerParams();

		// example params
		trackerParams.setAge(22);
		trackerParams.setGender(MyTrackerParams.Gender.FEMALE);

		MyTracker.initTracker();
	}
}
