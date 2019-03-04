package android.support.v4.view;

import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: ViewPager */
final class cg implements Interpolator {
    cg() {
    }

    public float getInterpolation(float f) {
        float f2 = f - TextTrackStyle.DEFAULT_FONT_SCALE;
        return (f2 * (((f2 * f2) * f2) * f2)) + TextTrackStyle.DEFAULT_FONT_SCALE;
    }
}
