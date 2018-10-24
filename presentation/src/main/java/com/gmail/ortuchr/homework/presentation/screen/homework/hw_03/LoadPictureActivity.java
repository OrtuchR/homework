package com.gmail.ortuchr.homework.presentation.screen.homework.hw_03;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.gmail.ortuchr.homework.R;

public class LoadPictureActivity extends Activity {
    private ProgressBar progressBar;
    private EditText editText;
    private ImageView imageView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_loadpicture);

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);
        Button buttonURL = findViewById(R.id.buttonURL);
        progressBar = findViewById(R.id.progressBar);
        animation = AnimationUtils.loadAnimation(this, R.anim.load_button_animation);

        //Set default URL
        buttonURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation);
                editText.setText(R.string.loadURL);
            }
        });

        //Load Picture
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation);
                progressBar.setVisibility(View.VISIBLE);
                if (String.valueOf(editText.getText()).isEmpty()) {
                    editText.setText(R.string.loadURL);
                }
                String path = String.valueOf(editText.getText());

                Glide.with(getApplicationContext()).
                        load(path).
                        listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                Toast.makeText(getApplicationContext(), R.string.loadError, Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                progressBar.setVisibility(View.GONE);
                                return false;
                            }
                        }).
                        apply(RequestOptions.circleCropTransform()).
                        into(imageView);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}
