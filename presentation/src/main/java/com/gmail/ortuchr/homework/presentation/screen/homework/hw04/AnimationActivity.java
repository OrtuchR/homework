package com.gmail.ortuchr.homework.presentation.screen.homework.hw04;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.gmail.ortuchr.homework.R;

public class AnimationActivity extends Activity {
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ImageView imageView = findViewById(R.id.animImageView);
        imageView.setBackgroundResource(R.drawable.picture_animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animationDrawable.isRunning()) {
                    animationDrawable.start();
                } else {
                    animationDrawable.stop();
                }
            }
        });

        final EditText editText = findViewById(R.id.animEditText);
        final Diagram diagram = findViewById(R.id.myDiagram);
        Button button = findViewById(R.id.animButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diagram.setNumbers(String.valueOf(editText.getText()));
                diagram.invalidate();
                diagram.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}
