package com.gmail.ortuchr.homework.presentation.screen.homework.hw_05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class AnalogCloak extends View {
    private Paint paint;

    public AnalogCloak(Context context) {
        super(context);
        init();
    }

    public AnalogCloak(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnalogCloak(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AnalogCloak(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        float radius = Math.min(getWidth(), getHeight()) * 0.4f;
        float xLine = getWidth() / 2;
        float yStartLine = getHeight() / 2 - radius;
        float yEndLine = getHeight() / 2 - radius * 0.9f;
        float yHalfLine = getHeight() / 2 - radius * 0.95f;

        float stepHour = 360 / 12;
        float stepMinute = 360 / 60;
        float stepSecond = 360 / 60;

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
        canvas.save();
        for (int i = 0; i < 12; i++) {
            canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paint);
            canvas.rotate(stepHour, getWidth() / 2, getHeight() / 2);
        }
        canvas.restore();

        paint.setStrokeWidth(10);
        canvas.save();
        canvas.rotate(stepHour * hours + stepHour / 60 * minutes, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(xLine, getHeight() / 2, xLine, getHeight() / 2 - radius * 0.55f, paint);
        canvas.restore();

        canvas.save();
        canvas.rotate(stepMinute * minutes + stepMinute / 60 * seconds, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(xLine, getHeight() / 2, xLine, getHeight() / 2 - radius * 0.75f, paint);
        canvas.restore();

        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        canvas.save();
        canvas.rotate(stepSecond * seconds, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(xLine, getHeight() / 2 + radius * 0.2f, xLine, getHeight() / 2 - radius * 0.89f, paint);
        canvas.restore();

        canvas.save();
        for (int i = 0; i < 60; i++) {
            if (i % 5 != 0) {
                canvas.drawLine(xLine, yStartLine, xLine, yHalfLine, paint);
            }
            canvas.rotate(stepMinute, getWidth() / 2, getHeight() / 2);
        }
        canvas.restore();

        float textSize = radius * 0.2f;
        paint.setTextSize(textSize);
        Rect bounds = new Rect();
        paint.getTextBounds("1", 0, 1, bounds);
        float textHeight = bounds.height();
        float clockPadding = radius * 0.05f;

        canvas.drawText("12", xLine - paint.measureText("12") / 2, getHeight() / 2 - radius - clockPadding, paint);
        canvas.drawText("3", getWidth() / 2 + radius + clockPadding, getHeight() / 2 + textHeight / 2, paint);
        canvas.drawText("6", xLine - paint.measureText("6") / 2, getHeight() / 2 + radius + textHeight + clockPadding, paint);
        canvas.drawText("9", getWidth() / 2 - radius - paint.measureText("9") - clockPadding, getHeight() / 2 + textHeight / 2, paint);
    }
}
