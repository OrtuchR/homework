package com.gmail.ortuchr.homework.hw_05;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.gmail.ortuchr.homework.R;

import java.util.Timer;
import java.util.TimerTask;

public class ClockActivity extends Activity {
    private ImageView imageViewWiFi;
    private AnimationDrawable animationDrawable;
    private AnalogCloak analogCloak;

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable repaintCloak = new Runnable() {
        public void run() {
            analogCloak.invalidate();
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_clock);

        analogCloak = findViewById(R.id.analogCloak);
        imageViewWiFi = findViewById(R.id.imageViewWiFi);
        ImageView imageViewClock = findViewById(R.id.imageViewClock);
        imageViewClock.setBackgroundResource(R.drawable.picture_animation);
        animationDrawable = (AnimationDrawable) imageViewClock.getBackground();
        int widthScreen = getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        int heightScreen = getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        float pictureSize = Math.min(widthScreen, heightScreen) * 0.5f;

        imageViewClock.setLayoutParams(new FrameLayout.LayoutParams((int) pictureSize, (int) pictureSize));
        imageViewClock.setX(widthScreen / 2 - pictureSize / 2);
        imageViewClock.setY(heightScreen / 2 - pictureSize / 2);
        imageViewClock.getBackground().setAlpha(180);

        imageViewClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animationDrawable.isRunning()) {
                    animationDrawable.start();
                } else {
                    animationDrawable.stop();
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilterWiFi = new IntentFilter();
        intentFilterWiFi.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(statusWiFi, intentFilterWiFi);

        repaintCloak.run();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(statusWiFi);

        handler.removeCallbacks(repaintCloak);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }

    private BroadcastReceiver statusWiFi = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0) == WifiManager.WIFI_STATE_ENABLED) {
                imageViewWiFi.setBackgroundResource(R.drawable.ic_wifi_on);
            } else {
                imageViewWiFi.setBackgroundResource(R.drawable.ic_wifi_off);
            }
        }
    };
}
