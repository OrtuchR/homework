package com.gmail.ortuchr.homework.presentation.screen.homework.hw06

import android.app.Service
import android.content.*
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager

class WifiService : Service() {

    private val mBinder: IBinder = LocalBinder();
    private lateinit var manager : WifiManager
    private val changeWiFiIntent = Intent("com.gmail.ortuchr.homework.CHANGE_WIFI")

    inner class LocalBinder : Binder() {
        fun getService() : WifiService {
            return this@WifiService;
        }
    }

    override fun onBind(intent: Intent): IBinder {
        manager = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val intentFilterWiFi = IntentFilter()
        intentFilterWiFi.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(statusWiFi, intentFilterWiFi)

        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        unregisterReceiver(statusWiFi)
        return super.onUnbind(intent)
    }

    public fun changeWiFiState() {
        if (manager.wifiState == WifiManager.WIFI_STATE_ENABLED || manager.wifiState == WifiManager.WIFI_STATE_ENABLING) {
            manager.setWifiEnabled(false)
        } else {
            manager.setWifiEnabled(true)
        }
    }

    private val statusWiFi = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            sendLocalMessage()
        }
    }

    fun sendLocalMessage() {
        changeWiFiIntent.putExtra("WIFI_STATE", manager.wifiState)
        LocalBroadcastManager.getInstance(this).sendBroadcast(changeWiFiIntent)
    }
}