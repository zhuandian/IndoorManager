package com.zhuandian.indoormanager.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc :
 * author：xiedong
 * date：2019/3/19
 */
public class PathView extends View {
    private Paint pathPanit;
    private Paint pointPaint;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        pathPanit = new Paint();
        pathPanit.setStyle(Paint.Style.STROKE);
        pathPanit.setAntiAlias(true);

        pathPanit.setStrokeWidth(12);
        pathPanit.setColor(Color.RED);

        pointPaint = new Paint();
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setAntiAlias(true);
        pointPaint.setStrokeWidth(18);
        pointPaint.setTextSize(55);
        pointPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(200, 500);
        path.lineTo(getMeasuredWidth() / 5 * 4, getMeasuredHeight() / 5 * 3);
        canvas.drawPath(path, pathPanit);
        canvas.drawText("A",100, 100, pointPaint);
        canvas.drawText("B",200, 500, pointPaint);
        canvas.drawText("C",getMeasuredWidth() / 5 * 4, getMeasuredHeight() / 5 * 3, pointPaint);

    }
}
