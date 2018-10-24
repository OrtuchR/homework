package com.gmail.ortuchr.homework.presentation.screen.homework.hw_02;

import android.app.Activity;
import android.os.Bundle;

import com.gmail.ortuchr.homework.R;

public class FlagsActivity extends Activity {
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_flags);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}
