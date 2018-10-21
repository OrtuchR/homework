package com.gmail.ortuchr.homework.hw_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gmail.ortuchr.homework.hw_04.AnimationActivity;
import com.gmail.ortuchr.homework.hw_03.LoadPictureActivity;
import com.gmail.ortuchr.homework.R;
import com.gmail.ortuchr.homework.hw_01.OnClickActivity;
import com.gmail.ortuchr.homework.hw_05.ClockActivity;
import com.gmail.ortuchr.homework.hw_06.ServiceActivity;
import com.gmail.ortuchr.homework.hw_07.UsersActivity;

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

        TextView startHomework4 = findViewById(R.id.startHomework4);
        startNewActivity(startHomework4, AnimationActivity.class);

        TextView startHomework5 = findViewById(R.id.startHomework5);
        startNewActivity(startHomework5, ClockActivity.class);

        TextView startHomework6 = findViewById(R.id.startHomework6);
        startNewActivity(startHomework6, ServiceActivity.class);

        TextView startHomework7 = findViewById(R.id.startHomework7);
        startNewActivity(startHomework7, UsersActivity.class);
    }

    private void startNewActivity(TextView textView, final Class newClass) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, newClass);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_open_right_to_left, R.anim.translate_close_right_to_left);
            }
        });
    }
}
