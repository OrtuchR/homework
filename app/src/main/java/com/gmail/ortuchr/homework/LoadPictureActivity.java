package com.gmail.ortuchr.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LoadPictureActivity extends Activity {
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_loadpicture);

        final EditText editText = findViewById(R.id.editText);
        final ImageView imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(R.string.loadURL);
                String path = String.valueOf(editText.getText());

                Picasso.get().load(path).into(imageView);
            }
        });
    }
}
