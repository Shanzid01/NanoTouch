package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: MaterialProgressDrawable */
class ac extends Animation {
    final /* synthetic */ ag f411a;
    final /* synthetic */ ab f412b;

    ac(ab abVar, ag agVar) {
        this.f412b = abVar;
        this.f411a = agVar;
    }

    public void applyTransformation(float f, Transformation transformation) {
        if (this.f412b.f399a) {
            this.f412b.m1046a(f, this.f411a);
            return;
        }
        float toRadians = (float) Math.toRadians(((double) this.f411a.m1073c()) / (6.283185307179586d * this.f411a.m1082h()));
        float f2 = this.f411a.m1080f();
        float e = this.f411a.m1078e();
        float i = this.f411a.m1083i();
        this.f411a.m1074c(((0.8f - toRadians) * ab.f397d.getInterpolation(f)) + f2);
        this.f411a.m1071b((ab.f396c.getInterpolation(f) * 0.8f) + e);
        this.f411a.m1077d((0.25f * f) + i);
        this.f412b.m1057c((144.0f * f) + (720.0f * (this.f412b.f407m / 5.0f)));
    }
}
