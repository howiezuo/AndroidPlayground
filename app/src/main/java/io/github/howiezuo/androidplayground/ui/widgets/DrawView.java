package io.github.howiezuo.androidplayground.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.github.howiezuo.androidplayground.R;

public class DrawView extends View {

    private List<Path> mPathList;
    private Path mPath;
    private Paint mPaint;

    public DrawView(Context context) {
        super(context);

        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPathList = new ArrayList<>();

        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.accent_color));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Path path : mPathList) {
            canvas.drawPath(path, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath = new Path();
                mPath.moveTo(event.getX(), event.getY());
                mPathList.add(mPath);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                mPath.lineTo(event.getX(), event.getY());
                invalidate();
                return true;
        }
        return super.onTouchEvent(event);
    }
}
