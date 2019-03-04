package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* compiled from: MaterialProgressDrawable */
class ab extends Drawable implements Animatable {
    private static final Interpolator f395b = new LinearInterpolator();
    private static final Interpolator f396c = new af();
    private static final Interpolator f397d = new ah();
    private static final Interpolator f398e = new AccelerateDecelerateInterpolator();
    boolean f399a;
    private final int[] f400f = new int[]{-16777216};
    private final ArrayList<Animation> f401g = new ArrayList();
    private final ag f402h;
    private float f403i;
    private Resources f404j;
    private View f405k;
    private Animation f406l;
    private float f407m;
    private double f408n;
    private double f409o;
    private final Callback f410p = new ae(this);

    public ab(Context context, View view) {
        this.f405k = view;
        this.f404j = context.getResources();
        this.f402h = new ag(this.f410p);
        this.f402h.m1069a(this.f400f);
        m1052a(1);
        m1049c();
    }

    private void m1045a(double d, double d2, double d3, double d4, float f, float f2) {
        ag agVar = this.f402h;
        float f3 = this.f404j.getDisplayMetrics().density;
        this.f408n = ((double) f3) * d;
        this.f409o = ((double) f3) * d2;
        agVar.m1062a(((float) d4) * f3);
        agVar.m1061a(((double) f3) * d3);
        agVar.m1072b(0);
        agVar.m1063a(f * f3, f3 * f2);
        agVar.m1065a((int) this.f408n, (int) this.f409o);
    }

    public void m1052a(int i) {
        if (i == 0) {
            m1045a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m1045a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m1053a(boolean z) {
        this.f402h.m1068a(z);
    }

    public void m1050a(float f) {
        this.f402h.m1079e(f);
    }

    public void m1051a(float f, float f2) {
        this.f402h.m1071b(f);
        this.f402h.m1074c(f2);
    }

    public void m1055b(float f) {
        this.f402h.m1077d(f);
    }

    public void m1056b(int i) {
        this.f402h.m1064a(i);
    }

    public void m1054a(int... iArr) {
        this.f402h.m1069a(iArr);
        this.f402h.m1072b(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f409o;
    }

    public int getIntrinsicWidth() {
        return (int) this.f408n;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f403i, bounds.exactCenterX(), bounds.exactCenterY());
        this.f402h.m1066a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f402h.m1075c(i);
    }

    public int getAlpha() {
        return this.f402h.m1070b();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f402h.m1067a(colorFilter);
    }

    void m1057c(float f) {
        this.f403i = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f401g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f406l.reset();
        this.f402h.m1084j();
        if (this.f402h.m1081g() != this.f402h.m1076d()) {
            this.f399a = true;
            this.f406l.setDuration(666);
            this.f405k.startAnimation(this.f406l);
            return;
        }
        this.f402h.m1072b(0);
        this.f402h.m1085k();
        this.f406l.setDuration(1333);
        this.f405k.startAnimation(this.f406l);
    }

    public void stop() {
        this.f405k.clearAnimation();
        m1057c(0.0f);
        this.f402h.m1068a(false);
        this.f402h.m1072b(0);
        this.f402h.m1085k();
    }

    private void m1046a(float f, ag agVar) {
        float floor = (float) (Math.floor((double) (agVar.m1083i() / 0.8f)) + 1.0d);
        agVar.m1071b(agVar.m1078e() + ((agVar.m1080f() - agVar.m1078e()) * f));
        agVar.m1077d(((floor - agVar.m1083i()) * f) + agVar.m1083i());
    }

    private void m1049c() {
        ag agVar = this.f402h;
        Animation acVar = new ac(this, agVar);
        acVar.setRepeatCount(-1);
        acVar.setRepeatMode(1);
        acVar.setInterpolator(f395b);
        acVar.setAnimationListener(new ad(this, agVar));
        this.f406l = acVar;
    }
}
