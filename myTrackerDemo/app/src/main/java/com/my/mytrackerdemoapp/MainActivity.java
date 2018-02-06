package com.my.mytrackerdemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.my.tracker.MyTracker;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
	public static final int PURCHASE_REQUEST_CODE = 1001;

	public void trackLogin(View view)
	{
		// you can add custom params you want to track to all events
		// can be omitted or null
		Map<String, String> eventCustomParams = new HashMap<>();
		eventCustomParams.put("someParamKey", "someParamValue");

		boolean tracked;
		tracked = MyTracker.trackLoginEvent(eventCustomParams);
		Toast.makeText(this,
					   "Tracking login: " + (tracked ? "success" : "failure"),
					   Toast.LENGTH_SHORT).show();
	}

	public void trackInvite(View view)
	{
		boolean tracked;
		tracked = MyTracker.trackInviteEvent();
		Toast.makeText(this,
					   "Tracking invite: " + (tracked ? "success" : "failure"),
					   Toast.LENGTH_SHORT).show();
	}

	public void trackRegistration(View view)
	{
		boolean tracked;
		tracked = MyTracker.trackRegistrationEvent();
		Toast.makeText(this,
					   "Tracking registration: " + (tracked ? "success" : "failure"),
					   Toast.LENGTH_SHORT).show();
	}

	public void trackPurchase(View view)
	{
		// Create buy bundle
		// Bundle buyIntentBundle = callMethodToReceiveBundle();

		// Extracting pending intent from bundle
		// PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");

		// Starting intent sender
		// startIntentSenderForResult(pendingIntent.getIntentSender(),
		//							  PURCHASE_REQUEST_CODE,
		//							  new Intent(),
		//							  0,
		//							  0,
		//							  0);
	}

	public void trackLevel(View view)
	{
		boolean tracked;
		tracked = MyTracker.trackLevelEvent();
		Toast.makeText(this,
					   "Tracking level: " + (tracked ? "success" : "failure"),
					   Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyTracker.getTrackerParams().setTrackingEnvironmentEnabled(true);
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		MyTracker.onStartActivity(this);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		MyTracker.onStopActivity(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		// Checking if the request code is PURCHASE_REQUEST_CODE
		if(PURCHASE_REQUEST_CODE == requestCode)
		{
			MyTracker.onActivityResult(resultCode, data);
		}
	}
}
