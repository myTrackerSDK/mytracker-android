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

		MyTracker.setDebugMode(true);

		MyTracker.createTracker("89232805149757155048", this);

		MyTrackerParams trackerParams = MyTracker.getTrackerParams();
		trackerParams.setMrgsId("AAAAAAAAA");
		trackerParams.setMrgsUserId("BBBBBBBB");
		trackerParams.setMrgsAppId("CCCCCCCCC");
		trackerParams.setOkId("10000000001");
		trackerParams.setVKId("testvkid");
		trackerParams.setIcqId("101101");
		trackerParams.setEmail("test@my.com");
		trackerParams.setAge(22);
		trackerParams.setGender(MyTrackerParams.Gender.FEMALE);

		trackerParams.setTrackingLaunchEnabled(true);
		trackerParams.setTrackingLocationEnabled(true);

		MyTracker.initTracker();
	}
}
