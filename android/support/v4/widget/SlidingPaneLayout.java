package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ay;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final aw f337a;
    private int f338b;
    private int f339c;
    private Drawable f340d;
    private Drawable f341e;
    private final int f342f;
    private boolean f343g;
    private View f344h;
    private float f345i;
    private float f346j;
    private int f347k;
    private boolean f348l;
    private int f349m;
    private float f350n;
    private float f351o;
    private au f352p;
    private final bj f353q;
    private boolean f354r;
    private boolean f355s;
    private final Rect f356t;
    private final ArrayList<as> f357u;

    public class LayoutParams extends MarginLayoutParams {
        private static final int[] f331e = new int[]{16843137};
        public float f332a = 0.0f;
        boolean f333b;
        boolean f334c;
        Paint f335d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f331e);
            this.f332a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new av();
        boolean f336a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f336a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f336a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f337a = new az();
        } else if (i >= 16) {
            f337a = new ay();
        } else {
            f337a = new ax();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f338b = -858993460;
        this.f355s = true;
        this.f356t = new Rect();
        this.f357u = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.f342f = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ay.m570a((View) this, new ar(this));
        ay.m579c((View) this, 1);
        this.f353q = bj.m1182a((ViewGroup) this, 0.5f, new at());
        this.f353q.m1200a(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.f349m = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f349m;
    }

    public void setSliderFadeColor(int i) {
        this.f338b = i;
    }

    public int getSliderFadeColor() {
        return this.f338b;
    }

    public void setCoveredFadeColor(int i) {
        this.f339c = i;
    }

    public int getCoveredFadeColor() {
        return this.f339c;
    }

    void m988a(View view) {
        if (this.f352p != null) {
            this.f352p.m1170a(view, this.f345i);
        }
    }

    void m991b(View view) {
        if (this.f352p != null) {
            this.f352p.m1169a(view);
        }
        sendAccessibilityEvent(32);
    }

    void m994c(View view) {
        if (this.f352p != null) {
            this.f352p.m1171b(view);
        }
        sendAccessibilityEvent(32);
    }

    void m996d(View view) {
        int paddingLeft;
        int i;
        boolean f = m982f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (f) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int i2;
        int i3;
        int i4;
        if (view == null || !m983f(view)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6;
                if (f) {
                    i6 = paddingLeft;
                } else {
                    i6 = width;
                }
                int max = Math.max(i6, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (f) {
                    i6 = width;
                } else {
                    i6 = paddingLeft;
                }
                i6 = Math.min(i6, childAt.getRight());
                int min = Math.min(height, childAt.getBottom());
                if (max < i || max2 < r3 || i6 > r4 || min > r2) {
                    i6 = 0;
                } else {
                    i6 = 4;
                }
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    void m986a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean m983f(View view) {
        if (ay.m590j(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f355s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f355s = true;
        int size = this.f357u.size();
        for (int i = 0; i < size; i++) {
            ((as) this.f357u.get(i)).run();
        }
        this.f357u.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f344h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i8;
            boolean z2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f334c = false;
                size2 = i6;
                f2 = f;
                i8 = i7;
                z2 = z;
            } else {
                if (layoutParams.f332a > 0.0f) {
                    f += layoutParams.f332a;
                    if (layoutParams.width == 0) {
                        size2 = i6;
                        f2 = f;
                        i8 = i7;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                } else {
                    i8 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, i8);
                mode = childAt.getMeasuredWidth();
                i8 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i8 > i7) {
                    i7 = Math.min(i8, mode2);
                }
                i8 = i6 - mode;
                boolean z3 = i8 < 0;
                layoutParams.f333b = z3;
                z3 |= z;
                if (layoutParams.f333b) {
                    this.f344h = childAt;
                }
                size2 = i8;
                i8 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i7 = i8;
            f = f2;
            i6 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f342f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.f332a <= 0.0f) ? null : 1;
                        i8 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f344h) {
                            if (layoutParams.f332a > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i8 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.f332a * ((float) Math.max(0, i6))) / f)) + i8, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i8 > i9 || layoutParams.f332a > 0.0f)) {
                            if (obj == null) {
                                size2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            } else {
                                size2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.f343g = z;
        if (this.f353q.m1199a() != 0 && !z) {
            this.f353q.m1220f();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean f = m982f();
        if (f) {
            this.f353q.m1201a(2);
        } else {
            this.f353q.m1201a(1);
        }
        int i5 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f355s) {
            float f2 = (this.f343g && this.f354r) ? TextTrackStyle.DEFAULT_FONT_SCALE : 0.0f;
            this.f345i = f2;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = paddingRight;
                i9 = i7;
            } else {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f333b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f342f) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f347k = min;
                    i9 = f ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f334c = ((i7 + i9) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i8 = (int) (((float) min) * this.f345i);
                    i10 = i7 + (i9 + i8);
                    this.f345i = ((float) i8) / ((float) this.f347k);
                    i8 = 0;
                } else if (!this.f343g || this.f349m == 0) {
                    i8 = 0;
                    i10 = paddingRight;
                } else {
                    i8 = (int) ((TextTrackStyle.DEFAULT_FONT_SCALE - this.f345i) * ((float) this.f349m));
                    i10 = paddingRight;
                }
                if (f) {
                    i9 = (i5 - i10) + i8;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i10 - i8;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i8 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i6++;
            paddingRight = i8;
            i7 = i9;
        }
        if (this.f355s) {
            if (this.f343g) {
                if (this.f349m != 0) {
                    m968a(this.f345i);
                }
                if (((LayoutParams) this.f344h.getLayoutParams()).f334c) {
                    m972a(this.f344h, this.f345i, this.f338b);
                }
            } else {
                for (i8 = 0; i8 < childCount; i8++) {
                    m972a(getChildAt(i8), 0.0f, this.f338b);
                }
            }
            m996d(this.f344h);
        }
        this.f355s = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f355s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f343g) {
            this.f354r = view == this.f344h;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.ae.m516a(r8);
        r0 = r7.f343g;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.f353q;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.m1212b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.f354r = r0;
    L_0x002d:
        r0 = r7.f343g;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.f348l;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.f353q;
        r0.m1219e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.f353q;
        r0.m1219e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.f353q;
        r3 = r3.m1204a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.f348l = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.f350n = r0;
        r7.f351o = r3;
        r4 = r7.f353q;
        r5 = r7.f344h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.m1212b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.f344h;
        r0 = r7.m999e(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.f350n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.f351o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.f353q;
        r4 = r4.m1216d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.f353q;
        r0.m1219e();
        r7.f348l = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f343g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f353q.m1208b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f350n = x;
                this.f351o = y;
                return true;
            case 1:
                if (!m999e(this.f344h)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.f350n;
                float f2 = y - this.f351o;
                int d = this.f353q.m1216d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.f353q.m1212b(this.f344h, (int) x, (int) y)) {
                    return true;
                }
                m975a(this.f344h, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean m975a(View view, int i) {
        if (!this.f355s && !m989a(0.0f, i)) {
            return false;
        }
        this.f354r = false;
        return true;
    }

    private boolean m977b(View view, int i) {
        if (!this.f355s && !m989a((float) TextTrackStyle.DEFAULT_FONT_SCALE, i)) {
            return false;
        }
        this.f354r = true;
        return true;
    }

    public boolean m992b() {
        return m977b(this.f344h, 0);
    }

    public boolean m995c() {
        return m975a(this.f344h, 0);
    }

    public boolean m997d() {
        return !this.f343g || this.f345i == TextTrackStyle.DEFAULT_FONT_SCALE;
    }

    public boolean m998e() {
        return this.f343g;
    }

    private void m969a(int i) {
        if (this.f344h == null) {
            this.f345i = 0.0f;
            return;
        }
        boolean f = m982f();
        LayoutParams layoutParams = (LayoutParams) this.f344h.getLayoutParams();
        int width = this.f344h.getWidth();
        if (f) {
            i = (getWidth() - i) - width;
        }
        this.f345i = ((float) (i - ((f ? layoutParams.rightMargin : layoutParams.leftMargin) + (f ? getPaddingRight() : getPaddingLeft())))) / ((float) this.f347k);
        if (this.f349m != 0) {
            m968a(this.f345i);
        }
        if (layoutParams.f334c) {
            m972a(this.f344h, this.f345i, this.f338b);
        }
        m988a(this.f344h);
    }

    private void m972a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.f335d == null) {
                layoutParams.f335d = new Paint();
            }
            layoutParams.f335d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ay.m587g(view) != 2) {
                ay.m568a(view, 2, layoutParams.f335d);
            }
            m985g(view);
        } else if (ay.m587g(view) != 0) {
            if (layoutParams.f335d != null) {
                layoutParams.f335d.setColorFilter(null);
            }
            Runnable asVar = new as(this, view);
            this.f357u.add(asVar);
            ay.m571a((View) this, asVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f343g || layoutParams.f333b || this.f344h == null)) {
            canvas.getClipBounds(this.f356t);
            if (m982f()) {
                this.f356t.left = Math.max(this.f356t.left, this.f344h.getRight());
            } else {
                this.f356t.right = Math.min(this.f356t.right, this.f344h.getLeft());
            }
            canvas.clipRect(this.f356t);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.f334c || this.f345i <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.f335d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    private void m985g(View view) {
        f337a.mo360a(this, view);
    }

    boolean m989a(float f, int i) {
        if (!this.f343g) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.f344h.getLayoutParams();
        if (m982f()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.f347k) * f)) + ((float) this.f344h.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.f347k) * f));
        }
        if (!this.f353q.m1205a(this.f344h, width, this.f344h.getTop())) {
            return false;
        }
        m986a();
        ay.m581d(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f353q.m1206a(true)) {
            return;
        }
        if (this.f343g) {
            ay.m581d(this);
        } else {
            this.f353q.m1220f();
        }
    }

    @Deprecated
    public void m987a(Drawable drawable) {
        m990b(drawable);
    }

    public void m990b(Drawable drawable) {
        this.f340d = drawable;
    }

    public void m993c(Drawable drawable) {
        this.f341e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        m987a(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        m990b(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        m993c(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (m982f()) {
            drawable = this.f341e;
        } else {
            drawable = this.f340d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m982f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void m968a(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean f2 = m982f();
        LayoutParams layoutParams = (LayoutParams) this.f344h.getLayoutParams();
        if (layoutParams.f334c) {
            if ((f2 ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.f344h) {
                        i2 = (int) ((TextTrackStyle.DEFAULT_FONT_SCALE - this.f346j) * ((float) this.f349m));
                        this.f346j = f;
                        i2 -= (int) ((TextTrackStyle.DEFAULT_FONT_SCALE - f) * ((float) this.f349m));
                        if (f2) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            m972a(childAt, f2 ? this.f346j - TextTrackStyle.DEFAULT_FONT_SCALE : TextTrackStyle.DEFAULT_FONT_SCALE - this.f346j, this.f339c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.f344h) {
                i2 = (int) ((TextTrackStyle.DEFAULT_FONT_SCALE - this.f346j) * ((float) this.f349m));
                this.f346j = f;
                i2 -= (int) ((TextTrackStyle.DEFAULT_FONT_SCALE - f) * ((float) this.f349m));
                if (f2) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (f2) {
                    }
                    m972a(childAt, f2 ? this.f346j - TextTrackStyle.DEFAULT_FONT_SCALE : TextTrackStyle.DEFAULT_FONT_SCALE - this.f346j, this.f339c);
                }
            }
        }
    }

    boolean m999e(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.f343g && ((LayoutParams) view.getLayoutParams()).f334c && this.f345i > 0.0f;
        return z;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f336a = m998e() ? m997d() : this.f354r;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f336a) {
            m992b();
        } else {
            m995c();
        }
        this.f354r = savedState.f336a;
    }

    private boolean m982f() {
        return ay.m588h(this) == 1;
    }
}
