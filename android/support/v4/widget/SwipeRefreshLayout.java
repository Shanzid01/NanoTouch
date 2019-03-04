package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ae;
import android.support.v4.view.ay;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class SwipeRefreshLayout extends ViewGroup {
    private static final String f358c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] f359r = new int[]{16842766};
    private Animation f360A;
    private float f361B;
    private boolean f362C;
    private int f363D;
    private int f364E;
    private boolean f365F;
    private AnimationListener f366G;
    private final Animation f367H;
    private final Animation f368I;
    protected int f369a;
    protected int f370b;
    private View f371d;
    private bi f372e;
    private boolean f373f;
    private int f374g;
    private float f375h;
    private int f376i;
    private int f377j;
    private boolean f378k;
    private float f379l;
    private boolean f380m;
    private int f381n;
    private boolean f382o;
    private boolean f383p;
    private final DecelerateInterpolator f384q;
    private C0147a f385s;
    private int f386t;
    private float f387u;
    private ab f388v;
    private Animation f389w;
    private Animation f390x;
    private Animation f391y;
    private Animation f392z;

    private void setColorViewAlpha(int i) {
        this.f385s.getBackground().setAlpha(i);
        this.f388v.setAlpha(i);
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.f361B = (float) i;
        this.f382o = z;
        this.f385s.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f363D = i2;
                this.f364E = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f363D = i2;
                this.f364E = i2;
            }
            this.f385s.setImageDrawable(null);
            this.f388v.m1052a(i);
            this.f385s.setImageDrawable(this.f388v);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f373f = false;
        this.f375h = GroundOverlayOptions.NO_DIMENSION;
        this.f378k = false;
        this.f381n = -1;
        this.f386t = -1;
        this.f366G = new ba(this);
        this.f367H = new bf(this);
        this.f368I = new bg(this);
        this.f374g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f376i = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f384q = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f359r);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f363D = (int) (displayMetrics.density * 40.0f);
        this.f364E = (int) (displayMetrics.density * 40.0f);
        m1014b();
        ay.m573a((ViewGroup) this, true);
        this.f361B = displayMetrics.density * 64.0f;
        this.f375h = this.f361B;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f386t < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f386t;
        }
        if (i2 >= this.f386t) {
            return i2 + 1;
        }
        return i2;
    }

    private void m1014b() {
        this.f385s = new C0147a(getContext(), -328966, 20.0f);
        this.f388v = new ab(getContext(), this);
        this.f388v.m1056b(-328966);
        this.f385s.setImageDrawable(this.f388v);
        this.f385s.setVisibility(8);
        addView(this.f385s);
    }

    private boolean m1019c() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f373f == z) {
            setRefreshing(z, false);
            return;
        }
        int i;
        this.f373f = z;
        if (this.f365F) {
            i = (int) this.f361B;
        } else {
            i = (int) (this.f361B + ((float) this.f370b));
        }
        setTargetOffsetTopAndBottom(i - this.f377j, true);
        this.f362C = false;
        m1009a(this.f366G);
    }

    private void m1009a(AnimationListener animationListener) {
        this.f385s.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f388v.setAlpha(255);
        }
        this.f389w = new bb(this);
        this.f389w.setDuration((long) this.f376i);
        if (animationListener != null) {
            this.f385s.m1033a(animationListener);
        }
        this.f385s.clearAnimation();
        this.f385s.startAnimation(this.f389w);
    }

    private void setAnimationProgress(float f) {
        if (m1019c()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ay.m582d(this.f385s, f);
        ay.m584e(this.f385s, f);
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.f373f != z) {
            this.f362C = z2;
            m1025f();
            this.f373f = z;
            if (this.f373f) {
                m1003a(this.f377j, this.f366G);
            } else {
                m1017b(this.f366G);
            }
        }
    }

    private void m1017b(AnimationListener animationListener) {
        this.f390x = new bc(this);
        this.f390x.setDuration(150);
        this.f385s.m1033a(animationListener);
        this.f385s.clearAnimation();
        this.f385s.startAnimation(this.f390x);
    }

    private void m1022d() {
        this.f391y = m1001a(this.f388v.getAlpha(), 76);
    }

    private void m1024e() {
        this.f392z = m1001a(this.f388v.getAlpha(), 255);
    }

    private Animation m1001a(int i, int i2) {
        if (this.f382o && m1019c()) {
            return null;
        }
        Animation bdVar = new bd(this, i, i2);
        bdVar.setDuration(300);
        this.f385s.m1033a(null);
        this.f385s.clearAnimation();
        this.f385s.startAnimation(bdVar);
        return bdVar;
    }

    public void setProgressBackgroundColor(int i) {
        this.f385s.setBackgroundColor(i);
        this.f388v.m1056b(getResources().getColor(i));
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m1025f();
        this.f388v.m1054a(iArr);
    }

    private void m1025f() {
        if (this.f371d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f385s)) {
                    i++;
                } else {
                    this.f371d = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f375h = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f371d == null) {
                m1025f();
            }
            if (this.f371d != null) {
                View view = this.f371d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f385s.getMeasuredWidth();
                this.f385s.layout((measuredWidth / 2) - (measuredHeight / 2), this.f377j, (measuredWidth / 2) + (measuredHeight / 2), this.f377j + this.f385s.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f371d == null) {
            m1025f();
        }
        if (this.f371d != null) {
            int i3;
            this.f371d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f385s.measure(MeasureSpec.makeMeasureSpec(this.f363D, 1073741824), MeasureSpec.makeMeasureSpec(this.f364E, 1073741824));
            if (!(this.f365F || this.f378k)) {
                this.f378k = true;
                i3 = -this.f385s.getMeasuredHeight();
                this.f370b = i3;
                this.f377j = i3;
            }
            this.f386t = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f385s) {
                    this.f386t = i3;
                    return;
                }
            }
        }
    }

    public boolean m1031a() {
        boolean z = true;
        if (VERSION.SDK_INT >= 14) {
            return ay.m577b(this.f371d, -1);
        }
        if (this.f371d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f371d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (this.f371d.getScrollY() <= 0) {
                z = false;
            }
            return z;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m1025f();
        int a = ae.m516a(motionEvent);
        if (this.f383p && a == 0) {
            this.f383p = false;
        }
        if (!isEnabled() || this.f383p || m1031a() || this.f373f) {
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                setTargetOffsetTopAndBottom(this.f370b - this.f385s.getTop(), true);
                this.f381n = ae.m519b(motionEvent, 0);
                this.f380m = false;
                a2 = m1000a(motionEvent, this.f381n);
                if (a2 != GroundOverlayOptions.NO_DIMENSION) {
                    this.f379l = a2;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.f380m = false;
                this.f381n = -1;
                break;
            case 2:
                break;
            case 6:
                m1008a(motionEvent);
                break;
        }
        if (this.f381n == -1) {
            Log.e(f358c, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
        }
        a2 = m1000a(motionEvent, this.f381n);
        if (a2 == GroundOverlayOptions.NO_DIMENSION) {
            return false;
        }
        if (a2 - this.f379l > ((float) this.f374g) && !this.f380m) {
            this.f380m = true;
            this.f388v.setAlpha(76);
        }
        return this.f380m;
    }

    private float m1000a(MotionEvent motionEvent, int i) {
        int a = ae.m517a(motionEvent, i);
        if (a < 0) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        return ae.m522d(motionEvent, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    private boolean m1011a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ae.m516a(motionEvent);
        if (this.f383p && a == 0) {
            this.f383p = false;
        }
        if (!isEnabled() || this.f383p || m1031a()) {
            return false;
        }
        float d;
        switch (a) {
            case 0:
                this.f381n = ae.m519b(motionEvent, 0);
                this.f380m = false;
                break;
            case 1:
            case 3:
                if (this.f381n == -1) {
                    if (a == 1) {
                        Log.e(f358c, "Got ACTION_UP event but don't have an active pointer id.");
                    }
                    return false;
                }
                d = (ae.m522d(motionEvent, ae.m517a(motionEvent, this.f381n)) - this.f379l) * 0.5f;
                this.f380m = false;
                if (d > this.f375h) {
                    setRefreshing(true, true);
                } else {
                    this.f373f = false;
                    this.f388v.m1051a(0.0f, 0.0f);
                    AnimationListener animationListener = null;
                    if (!this.f382o) {
                        animationListener = new be(this);
                    }
                    m1015b(this.f377j, animationListener);
                    this.f388v.m1053a(false);
                }
                this.f381n = -1;
                return false;
            case 2:
                a = ae.m517a(motionEvent, this.f381n);
                if (a >= 0) {
                    float d2 = 0.5f * (ae.m522d(motionEvent, a) - this.f379l);
                    if (this.f380m) {
                        this.f388v.m1053a(true);
                        d = d2 / this.f375h;
                        if (d >= 0.0f) {
                            float min = Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, Math.abs(d));
                            float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                            float abs = Math.abs(d2) - this.f375h;
                            d = this.f365F ? this.f361B - ((float) this.f370b) : this.f361B;
                            abs = Math.max(0.0f, Math.min(abs, 2.0f * d) / d);
                            abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
                            a = ((int) ((d * min) + ((d * abs) * 2.0f))) + this.f370b;
                            if (this.f385s.getVisibility() != 0) {
                                this.f385s.setVisibility(0);
                            }
                            if (!this.f382o) {
                                ay.m582d(this.f385s, TextTrackStyle.DEFAULT_FONT_SCALE);
                                ay.m584e(this.f385s, TextTrackStyle.DEFAULT_FONT_SCALE);
                            }
                            if (d2 < this.f375h) {
                                if (this.f382o) {
                                    setAnimationProgress(d2 / this.f375h);
                                }
                                if (this.f388v.getAlpha() > 76 && !m1011a(this.f391y)) {
                                    m1022d();
                                }
                                this.f388v.m1051a(0.0f, Math.min(0.8f, 0.8f * max));
                                this.f388v.m1050a(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, max));
                            } else if (this.f388v.getAlpha() < 255 && !m1011a(this.f392z)) {
                                m1024e();
                            }
                            this.f388v.m1055b(((-0.25f + (0.4f * max)) + (2.0f * abs)) * 0.5f);
                            setTargetOffsetTopAndBottom(a - this.f377j, true);
                            break;
                        }
                        return false;
                    }
                }
                Log.e(f358c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
                break;
            case 5:
                this.f381n = ae.m519b(motionEvent, ae.m518b(motionEvent));
                break;
            case 6:
                m1008a(motionEvent);
                break;
        }
        return true;
    }

    private void m1003a(int i, AnimationListener animationListener) {
        this.f369a = i;
        this.f367H.reset();
        this.f367H.setDuration(200);
        this.f367H.setInterpolator(this.f384q);
        if (animationListener != null) {
            this.f385s.m1033a(animationListener);
        }
        this.f385s.clearAnimation();
        this.f385s.startAnimation(this.f367H);
    }

    private void m1015b(int i, AnimationListener animationListener) {
        if (this.f382o) {
            m1018c(i, animationListener);
            return;
        }
        this.f369a = i;
        this.f368I.reset();
        this.f368I.setDuration(200);
        this.f368I.setInterpolator(this.f384q);
        if (animationListener != null) {
            this.f385s.m1033a(animationListener);
        }
        this.f385s.clearAnimation();
        this.f385s.startAnimation(this.f368I);
    }

    private void m1002a(float f) {
        setTargetOffsetTopAndBottom((this.f369a + ((int) (((float) (this.f370b - this.f369a)) * f))) - this.f385s.getTop(), false);
    }

    private void m1018c(int i, AnimationListener animationListener) {
        this.f369a = i;
        if (m1019c()) {
            this.f387u = (float) this.f388v.getAlpha();
        } else {
            this.f387u = ay.m598r(this.f385s);
        }
        this.f360A = new bh(this);
        this.f360A.setDuration(150);
        if (animationListener != null) {
            this.f385s.m1033a(animationListener);
        }
        this.f385s.clearAnimation();
        this.f385s.startAnimation(this.f360A);
    }

    private void setTargetOffsetTopAndBottom(int i, boolean z) {
        this.f385s.bringToFront();
        this.f385s.offsetTopAndBottom(i);
        this.f377j = this.f385s.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m1008a(MotionEvent motionEvent) {
        int b = ae.m518b(motionEvent);
        if (ae.m519b(motionEvent, b) == this.f381n) {
            this.f381n = ae.m519b(motionEvent, b == 0 ? 1 : 0);
        }
    }
}
