package com.gmail.ortuchr.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Lesson1Activity extends Activity implements View.OnClickListener {
    TextView textView1;
    TextView textView2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1);

        View.OnClickListener clickView1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        };
        textView1.setOnClickListener(clickView1);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        });

        button1.setOnClickListener(Lesson1Activity.this);
    }

    @Override
    public void onClick(View v) {
        changeText();
    }

    public void changeText() {
        String str = String.valueOf(textView1.getText());
        textView1.setText(textView2.getText());
        textView2.setText(str);
    }
}
