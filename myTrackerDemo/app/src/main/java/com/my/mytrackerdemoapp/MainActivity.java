package com.my.mytrackerdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.my.tracker.MyTracker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

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

	public void trackLogin(View view)
	{
		// you can add custom params you want to track to all events
		// can be omitted or null
		Map<String, String> eventCustomParams = new HashMap<>();
		eventCustomParams.put("someParamKey", "someParamValue");

		MyTracker.trackLoginEvent(eventCustomParams);
	}

	public void trackInvite(View view)
	{
		MyTracker.trackInviteEvent();
	}

	public void trackRegistration(View view)
	{
		MyTracker.trackRegistrationEvent();
	}

	public void trackPurchase(View view)
	{
		String fakeSkuDetails = "{" +
				"  \"type\": \"inapp\"," +
				"  \"price\": \"€7.99\"," +
				"  \"price_amount_micros\": \"7990000\"," +
				"  \"price_currency_code\": \"EUR\"," +
				"  \"title\": \"Something\"," +
				"  \"description\": \"Something good for testing\"," +
				"  \"productId\": \"FakeProductId\"" +
				"}";

		String fakePurchaseData = "{" +
				"   \"orderId\":\"12999763169054705758.1371079406387615\"," +
				"   \"packageName\":\"com.example.app\"," +
				"   \"productId\":\"exampleSku\"," +
				"   \"purchaseTime\":1345678900000," +
				"   \"purchaseState\":0," +
				"   \"developerPayload\":\"bGoa+V7g/yqDXvKRqq+JTFn4uQZbPiQJo4pf9RzJ\"," +
				"   \"purchaseToken\":\"opaque-token-up-to-1000-characters\"" +
				" }";

		JSONObject fakeSkuDetailsJson = null;
		JSONObject fakePurchaseDataJson = null;

		try
		{
			fakeSkuDetailsJson = new JSONObject(fakeSkuDetails);
			fakePurchaseDataJson = new JSONObject(fakePurchaseData);
		} catch (JSONException e)
		{
			e.printStackTrace();
		}

		String fakeDataSignature = "FakeDataSignature";

		if (fakeSkuDetailsJson != null && fakePurchaseDataJson != null)
		{
			MyTracker.trackPurchaseEvent(fakeSkuDetailsJson, fakePurchaseDataJson,
					fakeDataSignature);
		}
	}

	public void trackLevel(View view)
	{
		MyTracker.trackLevelEvent();
	}
}
