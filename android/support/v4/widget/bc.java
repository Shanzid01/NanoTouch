package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: SwipeRefreshLayout */
class bc extends Animation {
    final /* synthetic */ SwipeRefreshLayout f455a;

    bc(SwipeRefreshLayout swipeRefreshLayout) {
        this.f455a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f455a.setAnimationProgress(TextTrackStyle.DEFAULT_FONT_SCALE - f);
    }
}
