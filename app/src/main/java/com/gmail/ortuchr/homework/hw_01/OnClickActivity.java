package com.gmail.ortuchr.homework.hw_01;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.ortuchr.homework.R;

public class OnClickActivity extends Activity implements View.OnClickListener {
    private TextView textView1;
    private TextView textView2;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick);

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

        button1.setOnClickListener(OnClickActivity.this);
    }

    @Override
    public void onClick(View v) {
        changeText();
    }

    public void changeText() {
        String str = String.valueOf(textView1.getText());
        textView1.setText(textView2.getText());
        textView2.setText(str);
        ColorDrawable color = (ColorDrawable)textView1.getBackground();
        textView1.setBackground((ColorDrawable)textView2.getBackground());
        textView2.setBackground(color);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_open_to_full, R.anim.scale_close_to_null);
    }
}
