package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
public class at {
    static final aw f224a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f224a = new av();
        } else {
            f224a = new au();
        }
    }

    public static float m555a(VelocityTracker velocityTracker, int i) {
        return f224a.mo245a(velocityTracker, i);
    }

    public static float m556b(VelocityTracker velocityTracker, int i) {
        return f224a.mo246b(velocityTracker, i);
    }
}
