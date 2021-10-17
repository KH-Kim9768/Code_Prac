package com.example.cardtest;


import android.graphics.PointF;
import android.graphics.Matrix;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// https://judepereira.com/blog/multi-touch-in-android-translate-scale-and-rotate/

public class MyTouchListener implements View.OnTouchListener {
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();

    // 3가지 상태
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;

    // Zoom 모드 시 필요한 자원
    private PointF start = new PointF();
    private PointF mid = new PointF();
    private float oldDist;
    private float newDist;


    float oldX;
    float oldY;


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView = (ImageView) view;

        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
//                start.set(motionEvent.getX(), motionEvent.getY());
                mode = DRAG;


                // test
                oldX = motionEvent.getX();
                oldY = motionEvent.getY();

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
//                oldDist = spacing(motionEvent);
                oldDist = getDistance(motionEvent);
                mode = ZOOM;

//                if (oldDist > 10){
//                    midPoint(mid, motionEvent);
//                    mode = ZOOM;
//                }
                break;

            // 손 떼는 동작
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;

            // 움직이는 동작
            case MotionEvent.ACTION_MOVE:
                if(mode == DRAG){

                    imageView.setX(motionEvent.getRawX() - oldX);
                    imageView.setY(motionEvent.getRawY() - oldY);

                } else if (mode == ZOOM) {
                    newDist = getDistance(motionEvent);
                    float scale = (newDist / oldDist);
                    imageView.setScaleX(scale);
                    imageView.setScaleY(scale);


                }
                break;
        }

        return true;
    }

    private float spacing(MotionEvent event){
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);

        return (float) (Math.sqrt(x*x + y*y));
    }

    private float getDistance(MotionEvent e){
        float dx = e.getX(1) - e.getX(0);
        float dy = e.getY(1) - e.getY(0);

        return (float) (Math.sqrt(dx * dx + dy * dy));
    }

    private void midPoint(PointF point, MotionEvent event){
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        point.set(x/2, y/2);
    }
}
