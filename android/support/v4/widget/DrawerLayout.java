package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.C0028a;
import android.support.v4.view.C0140s;
import android.support.v4.view.C0145x;
import android.support.v4.view.ay;
import android.support.v4.view.bx;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.actionbarsherlock.view.Menu;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.places.Place;

public class DrawerLayout extends ViewGroup implements C0146v {
    static final C0159m f302a;
    private static final int[] f303b = new int[]{16842931};
    private static final boolean f304c;
    private CharSequence f305A;
    private Object f306B;
    private boolean f307C;
    private final C0158l f308d;
    private int f309e;
    private int f310f;
    private float f311g;
    private Paint f312h;
    private final bj f313i;
    private final bj f314j;
    private final C0163r f315k;
    private final C0163r f316l;
    private int f317m;
    private boolean f318n;
    private boolean f319o;
    private int f320p;
    private int f321q;
    private boolean f322r;
    private boolean f323s;
    private C0027p f324t;
    private float f325u;
    private float f326v;
    private Drawable f327w;
    private Drawable f328x;
    private Drawable f329y;
    private CharSequence f330z;

    public class LayoutParams extends MarginLayoutParams {
        public int f295a = 0;
        float f296b;
        boolean f297c;
        boolean f298d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f303b);
            this.f295a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f295a = layoutParams.f295a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0162q();
        int f299a = 0;
        int f300b = 0;
        int f301c = 0;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f299a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f299a);
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 19) {
            z = false;
        }
        f304c = z;
        if (VERSION.SDK_INT >= 21) {
            f302a = new C0160n();
        } else {
            f302a = new C0161o();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f308d = new C0158l(this);
        this.f310f = -1728053248;
        this.f312h = new Paint();
        this.f319o = true;
        setDescendantFocusability(Menu.CATEGORY_ALTERNATIVE);
        float f = getResources().getDisplayMetrics().density;
        this.f309e = (int) ((64.0f * f) + 0.5f);
        f *= 400.0f;
        this.f315k = new C0163r(this, 3);
        this.f316l = new C0163r(this, 5);
        this.f313i = bj.m1182a((ViewGroup) this, (float) TextTrackStyle.DEFAULT_FONT_SCALE, this.f315k);
        this.f313i.m1201a(1);
        this.f313i.m1200a(f);
        this.f315k.m1250a(this.f313i);
        this.f314j = bj.m1182a((ViewGroup) this, (float) TextTrackStyle.DEFAULT_FONT_SCALE, this.f316l);
        this.f314j.m1201a(2);
        this.f314j.m1200a(f);
        this.f316l.m1250a(this.f314j);
        setFocusableInTouchMode(true);
        ay.m579c((View) this, 1);
        ay.m570a((View) this, new C0157k(this));
        bx.m779a(this, false);
        if (ay.m599s(this)) {
            f302a.mo363a((View) this);
        }
    }

    public void mo332a(Object obj, boolean z) {
        this.f306B = obj;
        this.f307C = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void m945a(Drawable drawable, int i) {
        int a = C0140s.m916a(i, ay.m588h(this));
        if ((a & 3) == 3) {
            this.f327w = drawable;
            invalidate();
        }
        if ((a & 5) == 5) {
            this.f328x = drawable;
            invalidate();
        }
    }

    public void setDrawerShadow(int i, int i2) {
        m945a(getResources().getDrawable(i), i2);
    }

    public void setScrimColor(int i) {
        this.f310f = i;
        invalidate();
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int a = C0140s.m916a(i2, ay.m588h(this));
        if (a == 3) {
            this.f320p = i;
        } else if (a == 5) {
            this.f321q = i;
        }
        if (i != 0) {
            (a == 3 ? this.f313i : this.f314j).m1219e();
        }
        View b;
        switch (i) {
            case 1:
                b = m950b(a);
                if (b != null) {
                    m965i(b);
                    return;
                }
                return;
            case 2:
                b = m950b(a);
                if (b != null) {
                    m964h(b);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int m941a(View view) {
        int e = m958e(view);
        if (e == 3) {
            return this.f320p;
        }
        if (e == 5) {
            return this.f321q;
        }
        return 0;
    }

    public CharSequence m943a(int i) {
        int a = C0140s.m916a(i, ay.m588h(this));
        if (a == 3) {
            return this.f330z;
        }
        if (a == 5) {
            return this.f305A;
        }
        return null;
    }

    void m944a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f313i.m1199a();
        int a2 = this.f314j.m1199a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f296b == 0.0f) {
                m952b(view);
            } else if (layoutParams.f296b == TextTrackStyle.DEFAULT_FONT_SCALE) {
                m955c(view);
            }
        }
        if (i3 != this.f317m) {
            this.f317m = i3;
            if (this.f324t != null) {
                this.f324t.onDrawerStateChanged(i3);
            }
        }
    }

    void m952b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f298d) {
            layoutParams.f298d = false;
            if (this.f324t != null) {
                this.f324t.onDrawerClosed(view);
            }
            m931a(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m955c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f298d) {
            layoutParams.f298d = true;
            if (this.f324t != null) {
                this.f324t.onDrawerOpened(view);
            }
            m931a(view, true);
            view.requestFocus();
        }
    }

    private void m931a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m963g(childAt)) && !(z && childAt == view)) {
                ay.m579c(childAt, 4);
            } else {
                ay.m579c(childAt, 1);
            }
        }
    }

    void m946a(View view, float f) {
        if (this.f324t != null) {
            this.f324t.onDrawerSlide(view, f);
        }
    }

    void m953b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f296b) {
            layoutParams.f296b = f;
            m946a(view, f);
        }
    }

    float m956d(View view) {
        return ((LayoutParams) view.getLayoutParams()).f296b;
    }

    int m958e(View view) {
        return C0140s.m916a(((LayoutParams) view.getLayoutParams()).f295a, ay.m588h(this));
    }

    boolean m949a(View view, int i) {
        return (m958e(view) & i) == i;
    }

    View m942a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f298d) {
                return childAt;
            }
        }
        return null;
    }

    View m950b(int i) {
        int a = C0140s.m916a(i, ay.m588h(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m958e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    static String m932c(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f319o = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f319o = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r14, int r15) {
        /*
        r13 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = 0;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r14);
        r5 = android.view.View.MeasureSpec.getMode(r15);
        r2 = android.view.View.MeasureSpec.getSize(r14);
        r0 = android.view.View.MeasureSpec.getSize(r15);
        if (r3 != r12) goto L_0x001b;
    L_0x0019:
        if (r5 == r12) goto L_0x0056;
    L_0x001b:
        r6 = r13.isInEditMode();
        if (r6 == 0) goto L_0x0058;
    L_0x0021:
        if (r3 != r7) goto L_0x0050;
    L_0x0023:
        if (r5 != r7) goto L_0x0054;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r13.setMeasuredDimension(r2, r1);
        r0 = r13.f306B;
        if (r0 == 0) goto L_0x0060;
    L_0x002d:
        r0 = android.support.v4.view.ay.m599s(r13);
        if (r0 == 0) goto L_0x0060;
    L_0x0033:
        r0 = 1;
        r3 = r0;
    L_0x0035:
        r6 = android.support.v4.view.ay.m588h(r13);
        r7 = r13.getChildCount();
        r5 = r4;
    L_0x003e:
        if (r5 >= r7) goto L_0x0138;
    L_0x0040:
        r8 = r13.getChildAt(r5);
        r0 = r8.getVisibility();
        r9 = 8;
        if (r0 != r9) goto L_0x0062;
    L_0x004c:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x003e;
    L_0x0050:
        if (r3 != 0) goto L_0x0023;
    L_0x0052:
        r2 = r1;
        goto L_0x0023;
    L_0x0054:
        if (r5 == 0) goto L_0x0026;
    L_0x0056:
        r1 = r0;
        goto L_0x0026;
    L_0x0058:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        r3 = r4;
        goto L_0x0035;
    L_0x0062:
        r0 = r8.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        if (r3 == 0) goto L_0x007d;
    L_0x006a:
        r9 = r0.f295a;
        r9 = android.support.v4.view.C0140s.m916a(r9, r6);
        r10 = android.support.v4.view.ay.m599s(r8);
        if (r10 == 0) goto L_0x009e;
    L_0x0076:
        r10 = f302a;
        r11 = r13.f306B;
        r10.mo364a(r8, r11, r9);
    L_0x007d:
        r9 = r13.m961f(r8);
        if (r9 == 0) goto L_0x00a6;
    L_0x0083:
        r9 = r0.leftMargin;
        r9 = r2 - r9;
        r10 = r0.rightMargin;
        r9 = r9 - r10;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12);
        r10 = r0.topMargin;
        r10 = r1 - r10;
        r0 = r0.bottomMargin;
        r0 = r10 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x009e:
        r10 = f302a;
        r11 = r13.f306B;
        r10.mo365a(r0, r11, r9);
        goto L_0x007d;
    L_0x00a6:
        r9 = r13.m963g(r8);
        if (r9 == 0) goto L_0x0109;
    L_0x00ac:
        r9 = r13.m958e(r8);
        r9 = r9 & 7;
        r10 = r4 & r9;
        if (r10 == 0) goto L_0x00eb;
    L_0x00b6:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = m932c(r9);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00eb:
        r9 = r13.f309e;
        r10 = r0.leftMargin;
        r9 = r9 + r10;
        r10 = r0.rightMargin;
        r9 = r9 + r10;
        r10 = r0.width;
        r9 = getChildMeasureSpec(r14, r9, r10);
        r10 = r0.topMargin;
        r11 = r0.bottomMargin;
        r10 = r10 + r11;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r15, r10, r0);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x0109:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0138:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f318n = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m961f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m949a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.f296b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.f296b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.f296b ? 1 : null;
                    int i8;
                    switch (layoutParams.f295a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m953b(childAt, f);
                    }
                    int i10 = layoutParams.f296b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f318n = false;
        this.f319o = false;
    }

    public void requestLayout() {
        if (!this.f318n) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f296b);
        }
        this.f311g = f;
        if ((this.f313i.m1206a(true) | this.f314j.m1206a(true)) != 0) {
            ay.m581d(this);
        }
    }

    private static boolean m939m(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(int i) {
        this.f329y = i != 0 ? C0028a.getDrawable(getContext(), i) : null;
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f329y = new ColorDrawable(i);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f307C && this.f329y != null) {
            int a = f302a.mo362a(this.f306B);
            if (a > 0) {
                this.f329y.setBounds(0, 0, getWidth(), a);
                this.f329y.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m961f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m939m(childAt) && m963g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m949a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f311g > 0.0f && f) {
            this.f312h.setColor((((int) (((float) ((this.f310f & -16777216) >>> 24)) * this.f311g)) << 24) | (this.f310f & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f312h);
        } else if (this.f327w != null && m949a(view, 3)) {
            i = this.f327w.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f313i.m1207b()), TextTrackStyle.DEFAULT_FONT_SCALE));
            this.f327w.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f327w.setAlpha((int) (255.0f * r2));
            this.f327w.draw(canvas);
        } else if (this.f328x != null && m949a(view, 5)) {
            i = this.f328x.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f314j.m1207b()), TextTrackStyle.DEFAULT_FONT_SCALE));
            this.f328x.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f328x.setAlpha((int) (255.0f * r2));
            this.f328x.draw(canvas);
        }
        return drawChild;
    }

    boolean m961f(View view) {
        return ((LayoutParams) view.getLayoutParams()).f295a == 0;
    }

    boolean m963g(View view) {
        return (C0140s.m916a(((LayoutParams) view.getLayoutParams()).f295a, ay.m588h(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.ae.m516a(r8);
        r3 = r7.f313i;
        r3 = r3.m1204a(r8);
        r4 = r7.f314j;
        r4 = r4.m1204a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m935f();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f323s;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f325u = r0;
        r7.f326v = r4;
        r5 = r7.f311g;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.f313i;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m1217d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.m961f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.f322r = r2;
        r7.f323s = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.f313i;
        r4 = 3;
        r0 = r0.m1218d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.f315k;
        r0.m1247a();
        r0 = r7.f316l;
        r0.m1247a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.m948a(r1);
        r7.f322r = r2;
        r7.f323s = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f313i.m1208b(motionEvent);
        this.f314j.m1208b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f325u = x;
                this.f326v = y;
                this.f322r = false;
                this.f323s = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f313i.m1217d((int) x, (int) y);
                if (d != null && m961f(d)) {
                    x -= this.f325u;
                    y -= this.f326v;
                    int d2 = this.f313i.m1216d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m942a();
                        if (a != null) {
                            z = m941a(a) == 2;
                            m948a(z);
                            this.f322r = false;
                            break;
                        }
                    }
                }
                z = true;
                m948a(z);
                this.f322r = false;
            case 3:
                m948a(true);
                this.f322r = false;
                this.f323s = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f322r = z;
        if (z) {
            m948a(true);
        }
    }

    public void m951b() {
        m948a(false);
    }

    void m948a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m963g(childAt) && (!z || layoutParams.f297c)) {
                int width = childAt.getWidth();
                if (m949a(childAt, 3)) {
                    i |= this.f313i.m1205a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f314j.m1205a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f297c = false;
            }
        }
        this.f315k.m1247a();
        this.f316l.m1247a();
        if (i != 0) {
            invalidate();
        }
    }

    public void m964h(View view) {
        if (m963g(view)) {
            if (this.f319o) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f296b = TextTrackStyle.DEFAULT_FONT_SCALE;
                layoutParams.f298d = true;
                m931a(view, true);
            } else if (m949a(view, 3)) {
                this.f313i.m1205a(view, 0, view.getTop());
            } else {
                this.f314j.m1205a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m957d(int i) {
        View b = m950b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m932c(i));
        }
        m964h(b);
    }

    public void m965i(View view) {
        if (m963g(view)) {
            if (this.f319o) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f296b = 0.0f;
                layoutParams.f298d = false;
            } else if (m949a(view, 3)) {
                this.f313i.m1205a(view, -view.getWidth(), view.getTop());
            } else {
                this.f314j.m1205a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m959e(int i) {
        View b = m950b(i);
        if (b == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m932c(i));
        }
        m965i(b);
    }

    public boolean m966j(View view) {
        if (m963g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f298d;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean m960f(int i) {
        View b = m950b(i);
        if (b != null) {
            return m966j(b);
        }
        return false;
    }

    public boolean m967k(View view) {
        if (m963g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f296b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean m962g(int i) {
        View b = m950b(i);
        if (b != null) {
            return m967k(b);
        }
        return false;
    }

    private boolean m935f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f297c) {
                return true;
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private boolean m936g() {
        return m937h() != null;
    }

    private View m937h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m963g(childAt) && m967k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void m954c() {
        int i = 0;
        if (!this.f323s) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.f323s = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m936g()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0145x.m923b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View h = m937h();
        if (h != null && m941a(h) == 0) {
            m951b();
        }
        return h != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f299a != 0) {
            View b = m950b(savedState.f299a);
            if (b != null) {
                m964h(b);
            }
        }
        setDrawerLockMode(savedState.f300b, 3);
        setDrawerLockMode(savedState.f301c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View a = m942a();
        if (a != null) {
            savedState.f299a = ((LayoutParams) a.getLayoutParams()).f295a;
        }
        savedState.f300b = this.f320p;
        savedState.f301c = this.f321q;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m942a() != null || m963g(view)) {
            ay.m579c(view, 4);
        } else {
            ay.m579c(view, 1);
        }
        if (!f304c) {
            ay.m570a(view, this.f308d);
        }
    }

    private static boolean m940n(View view) {
        return (ay.m583e(view) == 4 || ay.m583e(view) == 2) ? false : true;
    }
}
