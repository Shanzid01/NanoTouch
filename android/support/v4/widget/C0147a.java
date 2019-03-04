package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ay;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* compiled from: CircleImageView */
class C0147a extends ImageView {
    private AnimationListener f393a;
    private int f394b;

    public C0147a(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f394b = (int) (3.5f * f2);
        if (m1032a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ay.m586f(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C0150b(this, this.f394b, i2));
            ay.m568a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f394b, (float) i4, (float) i3, 503316480);
            int i5 = this.f394b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean m1032a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m1032a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f394b * 2), getMeasuredHeight() + (this.f394b * 2));
        }
    }

    public void m1033a(AnimationListener animationListener) {
        this.f393a = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f393a != null) {
            this.f393a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f393a != null) {
            this.f393a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(getResources().getColor(i));
        }
    }
}
