package com.gmail.ortuchr.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.squareup.leakcanary.LeakCanary;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);

        TextView startHomework1 = findViewById(R.id.startHomework1);
        startNewActivity(startHomework1, OnClickActivity.class);

        TextView startHomework2 = findViewById(R.id.startHomework2);
        startNewActivity(startHomework2, FlagsActivity.class);

        TextView startHomework3 = findViewById(R.id.startHomework3);
        startNewActivity(startHomework3, LoadPictureActivity.class);

        //TextView startHomework4 = findViewById(R.id.startHomework4);
        //startNewActivity(startHomework4, ???.class);
    }

    private void startNewActivity(TextView textView, final Class newClass) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, newClass);
                startActivity(intent);
            }
        });
    }
}
