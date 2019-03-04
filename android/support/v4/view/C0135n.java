package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* compiled from: GestureDetectorCompat */
public class C0135n {
    private final C0136o mImpl;

    public C0135n(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public C0135n(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.mImpl = new C0139r(context, onGestureListener, handler);
        } else {
            this.mImpl = new C0137p(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.mo329a();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.mo330a(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.mo328a(z);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.mo327a(onDoubleTapListener);
    }
}
