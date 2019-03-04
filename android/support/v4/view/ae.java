package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public class ae {
    static final ah f218a;

    static {
        if (VERSION.SDK_INT >= 5) {
            f218a = new ag();
        } else {
            f218a = new af();
        }
    }

    public static int m516a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m518b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m517a(MotionEvent motionEvent, int i) {
        return f218a.mo236a(motionEvent, i);
    }

    public static int m519b(MotionEvent motionEvent, int i) {
        return f218a.mo237b(motionEvent, i);
    }

    public static float m520c(MotionEvent motionEvent, int i) {
        return f218a.mo238c(motionEvent, i);
    }

    public static float m522d(MotionEvent motionEvent, int i) {
        return f218a.mo239d(motionEvent, i);
    }

    public static int m521c(MotionEvent motionEvent) {
        return f218a.mo235a(motionEvent);
    }
}
