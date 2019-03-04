package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: MaterialProgressDrawable */
class ad implements AnimationListener {
    final /* synthetic */ ag f413a;
    final /* synthetic */ ab f414b;

    ad(ab abVar, ag agVar) {
        this.f414b = abVar;
        this.f413a = agVar;
    }

    public void onAnimationStart(Animation animation) {
        this.f414b.f407m = 0.0f;
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
        this.f413a.m1084j();
        this.f413a.m1060a();
        this.f413a.m1071b(this.f413a.m1081g());
        if (this.f414b.f399a) {
            this.f414b.f399a = false;
            animation.setDuration(1333);
            this.f413a.m1068a(false);
            return;
        }
        this.f414b.f407m = (this.f414b.f407m + TextTrackStyle.DEFAULT_FONT_SCALE) % 5.0f;
    }
}
