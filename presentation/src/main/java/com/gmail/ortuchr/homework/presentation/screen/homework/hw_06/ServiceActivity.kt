package com.gmail.ortuchr.homework.presentation.screen.homework.hw_06

import android.app.Activity
import android.content.*
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import com.gmail.ortuchr.homework.R
import com.gmail.ortuchr.homework.presentation.screen.homework.hw_06.WifiService.LocalBinder
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ServiceActivity : Activity() {

    private var mService : WifiService? = null
    private var statusConnection : Boolean = false
    private lateinit var startServiceButtonOn : String
    private lateinit var startServiceButtonOff : String
    private lateinit var statusWiFiOn : String
    private lateinit var statusWiFiGoingOn : String
    private lateinit var statusWiFiOff : String
    private lateinit var statusWiFiGoingOff : String
    private lateinit var startServiceButton : Button
    private lateinit var statusWiFiTextView : TextView

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        startServiceButtonOn = getString(R.string.startServiceButtonOn)
        startServiceButtonOff = getString(R.string.startServiceButtonOff)
        statusWiFiOn = getString(R.string.statusWiFiOn)
        statusWiFiGoingOn = getString(R.string.statusWiFiGoingOn)
        statusWiFiOff = getString(R.string.statusWiFiOff)
        statusWiFiGoingOff = getString(R.string.statusWiFiGoingOff)

        startServiceButton = findViewById(R.id.startServiceButton)
        statusWiFiTextView = findViewById(R.id.statusWiFiTextView)

        val manager : WifiManager = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        if (manager.wifiState == WifiManager.WIFI_STATE_ENABLED || manager.wifiState == WifiManager.WIFI_STATE_ENABLING) {
            startServiceButton.text = startServiceButtonOff
            statusWiFiTextView.text = statusWiFiOn
        } else {
            startServiceButton.text = startServiceButtonOn
            statusWiFiTextView.text = statusWiFiOff
        }

        startServiceButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (statusConnection) {
                    if (manager.wifiState == WifiManager.WIFI_STATE_ENABLED || manager.wifiState == WifiManager.WIFI_STATE_ENABLING) {
                        startServiceButton.text = startServiceButtonOn
                    } else {
                        startServiceButton.text = startServiceButtonOff
                    }
                    mService?.changeWiFiState()
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, WifiService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(localMessageReceiver,
                        IntentFilter("com.gmail.ortuchr.homework.CHANGE_WIFI"))
    }

    override fun onStop() {
        super.onStop()
        unbindService(mConnection)
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(localMessageReceiver)
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder : LocalBinder = service as LocalBinder
            mService = binder.getService()
            statusConnection = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            statusConnection = false
        }
    }

    private val localMessageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val stateWiFi = intent?.getIntExtra("WIFI_STATE", WifiManager.WIFI_STATE_UNKNOWN)
            when (stateWiFi) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    startServiceButton.text = startServiceButtonOff
                    statusWiFiTextView.text = statusWiFiOn
                }
                WifiManager.WIFI_STATE_ENABLING -> {
                    startServiceButton.text = startServiceButtonOff
                    statusWiFiTextView.text = statusWiFiGoingOn
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    startServiceButton.text = startServiceButtonOn
                    statusWiFiTextView.text = statusWiFiOff
                }
                WifiManager.WIFI_STATE_DISABLING -> {
                    startServiceButton.text = startServiceButtonOn
                    statusWiFiTextView.text = statusWiFiGoingOff
                }
                else -> {
                    Toast.makeText(applicationContext, "Can't define WiFi state", Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}

