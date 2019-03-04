package android.support.v4.widget;

import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: ViewDragHelper */
final class bk implements Interpolator {
    bk() {
    }

    public float getInterpolation(float f) {
        float f2 = f - TextTrackStyle.DEFAULT_FONT_SCALE;
        return (f2 * (((f2 * f2) * f2) * f2)) + TextTrackStyle.DEFAULT_FONT_SCALE;
    }
}
