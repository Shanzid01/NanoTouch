package android.support.v4.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: MaterialProgressDrawable */
class ah extends AccelerateDecelerateInterpolator {
    private ah() {
    }

    public float getInterpolation(float f) {
        return super.getInterpolation(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, 2.0f * f));
    }
}
