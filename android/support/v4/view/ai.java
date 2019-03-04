package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompatEclair */
class ai {
    public static int m539a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m540b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m541c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m542d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m538a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
