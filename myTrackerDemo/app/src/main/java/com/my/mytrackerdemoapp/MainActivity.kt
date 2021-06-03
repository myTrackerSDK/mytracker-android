package com.my.mytrackerdemoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.my.tracker.MyTracker
import java.util.*

class MainActivity : AppCompatActivity()
{
    fun trackLogin(ignored: View)
    {
        // you can add custom params you want to track to all events
        // can be omitted or null
        val eventCustomParams: MutableMap<String, String> = HashMap()
        eventCustomParams["someParamKey"] = "someParamValue"
        MyTracker.trackLoginEvent("custom_user_id", "vk_connect_id", eventCustomParams)
        Toast.makeText(this, "Tracking login", Toast.LENGTH_SHORT).show()
    }

    fun trackInvite(ignored: View)
    {
        MyTracker.trackInviteEvent()
        Toast.makeText(this, "Tracking invite", Toast.LENGTH_SHORT).show()
    }

    fun trackRegistration(ignored: View)
    {
        MyTracker.trackRegistrationEvent("custom_user_id", "vk_connect_id")
        Toast.makeText(this, "Tracking registration", Toast.LENGTH_SHORT).show()
    }

    fun trackPurchase(ignored: View)
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

    fun trackLevel(ignored: View)
    {
        MyTracker.trackLevelEvent()
        Toast.makeText(this, "Tracking level", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyTracker.getTrackerConfig().isTrackingEnvironmentEnabled = true

        handleDepplink(intent)
    }

    override fun onNewIntent(intent: Intent?)
    {
        super.onNewIntent(intent)

        handleDepplink(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        // Checking if the request code is PURCHASE_REQUEST_CODE
        if (PURCHASE_REQUEST_CODE == requestCode)
        {
            MyTracker.onActivityResult(resultCode, data)
        }
    }

    fun handleDepplink(intent: Intent?)
    {
        Toast.makeText(this, "Handling deeplink", Toast.LENGTH_SHORT).show()

        val deeplink: String? = MyTracker.handleDeeplink(intent)
        if (deeplink.isNullOrEmpty())
        {
            return
        }

        Toast.makeText(this, "Deeplink tracked: $deeplink", Toast.LENGTH_SHORT).show()
    }

    companion object
    {
        const val PURCHASE_REQUEST_CODE = 1001
    }
}