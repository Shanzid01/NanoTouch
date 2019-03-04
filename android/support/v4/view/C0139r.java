package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* compiled from: GestureDetectorCompat */
class C0139r implements C0136o {
    private final GestureDetector f286a;

    public C0139r(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.f286a = new GestureDetector(context, onGestureListener, handler);
    }

    public boolean mo329a() {
        return this.f286a.isLongpressEnabled();
    }

    public boolean mo330a(MotionEvent motionEvent) {
        return this.f286a.onTouchEvent(motionEvent);
    }

    public void mo328a(boolean z) {
        this.f286a.setIsLongpressEnabled(z);
    }

    public void mo327a(OnDoubleTapListener onDoubleTapListener) {
        this.f286a.setOnDoubleTapListener(onDoubleTapListener);
    }
}
