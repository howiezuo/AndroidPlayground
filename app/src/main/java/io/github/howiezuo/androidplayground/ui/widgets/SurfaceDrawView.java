package io.github.howiezuo.androidplayground.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

import io.github.howiezuo.androidplayground.R;

public class SurfaceDrawView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder mHolder;
    private List<Path> mPathList;
    private Path mPath;
    private Paint mPaint;

    public SurfaceDrawView(Context context) {
        super(context);
    }

    public SurfaceDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SurfaceDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);

        mPathList = new ArrayList<>();

        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.accent_color));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath = new Path();
                mPath.moveTo(event.getX(), event.getY());
                mPathList.add(mPath);
                draw();
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                mPath.lineTo(event.getX(), event.getY());
                draw();
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private void draw() {
        Canvas canvas = mHolder.lockCanvas();

        for (Path path : mPathList) {
            canvas.drawPath(path, mPaint);
        }

        mHolder.unlockCanvasAndPost(canvas);
    }
}
