package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p003a.C0021a;
import android.support.v4.widget.C0167w;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.actionbarsherlock.view.Menu;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final int[] f151a = new int[]{16842931};
    private static final cq ag = new cq();
    private static final Comparator<cj> f152c = new cf();
    private static final Interpolator f153d = new cg();
    private boolean f154A;
    private boolean f155B;
    private int f156C;
    private int f157D;
    private int f158E;
    private float f159F;
    private float f160G;
    private float f161H;
    private float f162I;
    private int f163J = -1;
    private VelocityTracker f164K;
    private int f165L;
    private int f166M;
    private int f167N;
    private int f168O;
    private boolean f169P;
    private C0167w f170Q;
    private C0167w f171R;
    private boolean f172S = true;
    private boolean f173T = false;
    private boolean f174U;
    private int f175V;
    private cm f176W;
    private cm aa;
    private cl ab;
    private cn ac;
    private Method ad;
    private int ae;
    private ArrayList<View> af;
    private final Runnable ah = new ch(this);
    private int ai = 0;
    private int f177b;
    private final ArrayList<cj> f178e = new ArrayList();
    private final cj f179f = new cj();
    private final Rect f180g = new Rect();
    private aj f181h;
    private int f182i;
    private int f183j = -1;
    private Parcelable f184k = null;
    private ClassLoader f185l = null;
    private Scroller f186m;
    private co f187n;
    private int f188o;
    private Drawable f189p;
    private int f190q;
    private int f191r;
    private float f192s = -3.4028235E38f;
    private float f193t = Float.MAX_VALUE;
    private int f194u;
    private int f195v;
    private boolean f196w;
    private boolean f197x;
    private boolean f198y;
    private int f199z = 1;

    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean f142a;
        public int f143b;
        float f144c = 0.0f;
        boolean f145d;
        int f146e;
        int f147f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f151a);
            this.f143b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0021a.m47a(new cp());
        int f148a;
        Parcelable f149b;
        ClassLoader f150c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f148a);
            parcel.writeParcelable(this.f149b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f148a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f148a = parcel.readInt();
            this.f149b = parcel.readParcelable(classLoader);
            this.f150c = classLoader;
        }
    }

    public ViewPager(Context context) {
        super(context);
        m180a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m180a();
    }

    void m180a() {
        setWillNotDraw(false);
        setDescendantFocusability(Menu.CATEGORY_ALTERNATIVE);
        setFocusable(true);
        Context context = getContext();
        this.f186m = new Scroller(context, f153d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f158E = bq.m774a(viewConfiguration);
        this.f165L = (int) (400.0f * f);
        this.f166M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f170Q = new C0167w(context);
        this.f171R = new C0167w(context);
        this.f167N = (int) (25.0f * f);
        this.f168O = (int) (2.0f * f);
        this.f156C = (int) (16.0f * f);
        ay.m570a((View) this, new ck(this));
        if (ay.m583e(this) == 0) {
            ay.m579c((View) this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.ai != i) {
            this.ai = i;
            if (this.ac != null) {
                m168b(i != 0);
            }
            if (this.f176W != null) {
                this.f176W.mo243b(i);
            }
        }
    }

    public void m186a(aj ajVar) {
        if (this.f181h != null) {
            this.f181h.unregisterDataSetObserver(this.f187n);
            this.f181h.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f178e.size(); i++) {
                cj cjVar = (cj) this.f178e.get(i);
                this.f181h.destroyItem((ViewGroup) this, cjVar.f236b, cjVar.f235a);
            }
            this.f181h.finishUpdate((ViewGroup) this);
            this.f178e.clear();
            m173h();
            this.f182i = 0;
            scrollTo(0, 0);
        }
        aj ajVar2 = this.f181h;
        this.f181h = ajVar;
        this.f177b = 0;
        if (this.f181h != null) {
            if (this.f187n == null) {
                this.f187n = new co();
            }
            this.f181h.registerDataSetObserver(this.f187n);
            this.f198y = false;
            boolean z = this.f172S;
            this.f172S = true;
            this.f177b = this.f181h.getCount();
            if (this.f183j >= 0) {
                this.f181h.restoreState(this.f184k, this.f185l);
                m184a(this.f183j, false, true);
                this.f183j = -1;
                this.f184k = null;
                this.f185l = null;
            } else if (z) {
                requestLayout();
            } else {
                m197d();
            }
        }
        if (this.ab != null && ajVar2 != ajVar) {
            this.ab.mo242a(ajVar2, ajVar);
        }
    }

    private void m173h() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f142a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public aj m191b() {
        return this.f181h;
    }

    void m187a(cl clVar) {
        this.ab = clVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f198y = false;
        if (this.f172S) {
            z = false;
        } else {
            z = true;
        }
        m184a(i, z, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f198y = false;
        m184a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f182i;
    }

    void m184a(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f181h == null || this.f181h.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f182i != i || this.f178e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f181h.getCount()) {
                i = this.f181h.getCount() - 1;
            }
            int i3 = this.f199z;
            if (i > this.f182i + i3 || i < this.f182i - i3) {
                for (int i4 = 0; i4 < this.f178e.size(); i4++) {
                    ((cj) this.f178e.get(i4)).f237c = true;
                }
            }
            if (this.f182i != i) {
                z3 = true;
            }
            if (this.f172S) {
                this.f182i = i;
                if (z3 && this.f176W != null) {
                    this.f176W.mo240a(i);
                }
                if (z3 && this.aa != null) {
                    this.aa.mo240a(i);
                }
                requestLayout();
                return;
            }
            m181a(i);
            m161a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m161a(int i, boolean z, int i2, boolean z2) {
        int max;
        cj b = m192b(i);
        if (b != null) {
            max = (int) (Math.max(this.f192s, Math.min(b.f239e, this.f193t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m183a(max, 0, i2);
            if (z2 && this.f176W != null) {
                this.f176W.mo240a(i);
            }
            if (z2 && this.aa != null) {
                this.aa.mo240a(i);
                return;
            }
            return;
        }
        if (z2 && this.f176W != null) {
            this.f176W.mo240a(i);
        }
        if (z2 && this.aa != null) {
            this.aa.mo240a(i);
        }
        m165a(false);
        scrollTo(max, 0);
        m171d(max);
    }

    public void m188a(cm cmVar) {
        this.f176W = cmVar;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                try {
                    this.ad = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ad.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ae == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.af.get(i2)).getLayoutParams()).f147f;
    }

    cm m194b(cm cmVar) {
        cm cmVar2 = this.aa;
        this.aa = cmVar;
        return cmVar2;
    }

    public int getOffscreenPageLimit() {
        return this.f199z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f199z) {
            this.f199z = i;
            m197d();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f188o;
        this.f188o = i;
        int width = getWidth();
        m160a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f188o;
    }

    public void m185a(Drawable drawable) {
        this.f189p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        m185a(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f189p;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f189p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m177a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m183a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m165a(false);
            m197d();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m177a(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, (((float) Math.abs(i4)) * TextTrackStyle.DEFAULT_FONT_SCALE) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f181h.getPageWidth(this.f182i)) + ((float) this.f188o))) + TextTrackStyle.DEFAULT_FONT_SCALE) * 100.0f);
        }
        this.f186m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        ay.m581d(this);
    }

    cj m178a(int i, int i2) {
        cj cjVar = new cj();
        cjVar.f236b = i;
        cjVar.f235a = this.f181h.instantiateItem((ViewGroup) this, i);
        cjVar.f238d = this.f181h.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f178e.size()) {
            this.f178e.add(cjVar);
        } else {
            this.f178e.add(i2, cjVar);
        }
        return cjVar;
    }

    void m195c() {
        int count = this.f181h.getCount();
        this.f177b = count;
        boolean z = this.f178e.size() < (this.f199z * 2) + 1 && this.f178e.size() < count;
        boolean z2 = false;
        int i = this.f182i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f178e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            cj cjVar = (cj) this.f178e.get(i2);
            int itemPosition = this.f181h.getItemPosition(cjVar.f235a);
            if (itemPosition == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (itemPosition == -2) {
                this.f178e.remove(i2);
                i2--;
                if (!z2) {
                    this.f181h.startUpdate((ViewGroup) this);
                    z2 = true;
                }
                this.f181h.destroyItem((ViewGroup) this, cjVar.f236b, cjVar.f235a);
                if (this.f182i == cjVar.f236b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f182i, count - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (cjVar.f236b != itemPosition) {
                if (cjVar.f236b == this.f182i) {
                    i = itemPosition;
                }
                cjVar.f236b = itemPosition;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f181h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f178e, f152c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.f142a) {
                    layoutParams.f144c = 0.0f;
                }
            }
            m184a(i, false, true);
            requestLayout();
        }
    }

    void m197d() {
        m181a(this.f182i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m181a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f182i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f182i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.f182i;
        r0 = r18;
        r3 = r0.m192b(r3);
        r0 = r19;
        r1 = r18;
        r1.f182i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f181h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m174i();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f198y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m174i();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f181h;
        r0 = r18;
        r2.startUpdate(r0);
        r0 = r18;
        r2 = r0.f199z;
        r5 = 0;
        r0 = r18;
        r6 = r0.f182i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f181h;
        r12 = r5.getCount();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f182i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f177b;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.f177b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.f181h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.cj) r2;
        r7 = r2.f236b;
        r0 = r18;
        r8 = r0.f182i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f236b;
        r0 = r18;
        r8 = r0.f182i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f182i;
        r0 = r18;
        r2 = r0.m178a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.cj) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f182i;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.f238d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.cj) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f182i;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.m163a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f181h;
        r0 = r18;
        r5 = r0.f182i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f235a;
    L_0x018c:
        r0 = r18;
        r4.setPrimaryItem(r0, r5, r2);
        r0 = r18;
        r2 = r0.f181h;
        r0 = r18;
        r2.finishUpdate(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f147f = r4;
        r7 = r2.f142a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f144c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m179a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f238d;
        r2.f144c = r7;
        r6 = r6.f236b;
        r2.f146e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.f238d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f236b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f237c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f178e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f181h;
        r2 = r2.f235a;
        r0 = r18;
        r15.destroyItem(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.cj) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f236b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f238d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.cj) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m178a(r9, r2);
        r2 = r2.f238d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.cj) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.f236b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f237c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f178e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f181h;
        r2 = r2.f235a;
        r0 = r18;
        r11.destroyItem(r0, r9, r2);
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.cj) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.f236b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f238d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.cj) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.m178a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f238d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f178e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.cj) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.m174i();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m193b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f236b;
        r0 = r18;
        r4 = r0.f182i;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.m179a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f236b;
        r0 = r18;
        r6 = r0.f182i;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m174i() {
        if (this.ae != 0) {
            if (this.af == null) {
                this.af = new ArrayList();
            } else {
                this.af.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.af.add(getChildAt(i));
            }
            Collections.sort(this.af, ag);
        }
    }

    private void m163a(cj cjVar, int i, cj cjVar2) {
        float f;
        float f2;
        int i2;
        cj cjVar3;
        int i3;
        int count = this.f181h.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f188o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (cjVar2 != null) {
            clientWidth = cjVar2.f236b;
            int i4;
            if (clientWidth < cjVar.f236b) {
                f2 = (cjVar2.f239e + cjVar2.f238d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= cjVar.f236b && i2 < this.f178e.size()) {
                    cjVar3 = (cj) this.f178e.get(i2);
                    while (i4 > cjVar3.f236b && i2 < this.f178e.size() - 1) {
                        i2++;
                        cjVar3 = (cj) this.f178e.get(i2);
                    }
                    while (i4 < cjVar3.f236b) {
                        f2 += this.f181h.getPageWidth(i4) + f;
                        i4++;
                    }
                    cjVar3.f239e = f2;
                    f2 += cjVar3.f238d + f;
                    i4++;
                }
            } else if (clientWidth > cjVar.f236b) {
                i2 = this.f178e.size() - 1;
                f2 = cjVar2.f239e;
                i4 = clientWidth - 1;
                while (i4 >= cjVar.f236b && i2 >= 0) {
                    cjVar3 = (cj) this.f178e.get(i2);
                    while (i4 < cjVar3.f236b && i2 > 0) {
                        i2--;
                        cjVar3 = (cj) this.f178e.get(i2);
                    }
                    while (i4 > cjVar3.f236b) {
                        f2 -= this.f181h.getPageWidth(i4) + f;
                        i4--;
                    }
                    f2 -= cjVar3.f238d + f;
                    cjVar3.f239e = f2;
                    i4--;
                }
            }
        }
        int size = this.f178e.size();
        float f3 = cjVar.f239e;
        i2 = cjVar.f236b - 1;
        this.f192s = cjVar.f236b == 0 ? cjVar.f239e : -3.4028235E38f;
        this.f193t = cjVar.f236b == count + -1 ? (cjVar.f239e + cjVar.f238d) - TextTrackStyle.DEFAULT_FONT_SCALE : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            cjVar3 = (cj) this.f178e.get(i3);
            f2 = f3;
            while (i2 > cjVar3.f236b) {
                f2 -= this.f181h.getPageWidth(i2) + f;
                i2--;
            }
            f3 = f2 - (cjVar3.f238d + f);
            cjVar3.f239e = f3;
            if (cjVar3.f236b == 0) {
                this.f192s = f3;
            }
            i2--;
        }
        f3 = (cjVar.f239e + cjVar.f238d) + f;
        i2 = cjVar.f236b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            cjVar3 = (cj) this.f178e.get(i3);
            f2 = f3;
            while (i2 < cjVar3.f236b) {
                f2 = (this.f181h.getPageWidth(i2) + f) + f2;
                i2++;
            }
            if (cjVar3.f236b == count - 1) {
                this.f193t = (cjVar3.f238d + f2) - TextTrackStyle.DEFAULT_FONT_SCALE;
            }
            cjVar3.f239e = f2;
            f3 = f2 + (cjVar3.f238d + f);
            i2++;
        }
        this.f173T = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f148a = this.f182i;
        if (this.f181h != null) {
            savedState.f149b = this.f181h.saveState();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f181h != null) {
                this.f181h.restoreState(savedState.f149b, savedState.f150c);
                m184a(savedState.f148a, false, true);
                return;
            }
            this.f183j = savedState.f148a;
            this.f184k = savedState.f149b;
            this.f185l = savedState.f150c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.f142a |= view instanceof ci;
        if (!this.f196w) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.f142a) {
            layoutParams3.f145d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f196w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    cj m179a(View view) {
        for (int i = 0; i < this.f178e.size(); i++) {
            cj cjVar = (cj) this.f178e.get(i);
            if (this.f181h.isViewFromObject(view, cjVar.f235a)) {
                return cjVar;
            }
        }
        return null;
    }

    cj m193b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m179a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    cj m192b(int i) {
        for (int i2 = 0; i2 < this.f178e.size(); i2++) {
            cj cjVar = (cj) this.f178e.get(i2);
            if (cjVar.f236b == i) {
                return cjVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f172S = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f157D = Math.min(measuredWidth / 10, this.f156C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            LayoutParams layoutParams;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f142a) {
                    int i6 = layoutParams.f143b & 7;
                    int i7 = layoutParams.f143b & 112;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i4 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f194u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f195v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f196w = true;
        m197d();
        this.f196w = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.f142a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.f144c * ((float) paddingLeft)), 1073741824), this.f195v);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m160a(i, i3, this.f188o, this.f188o);
        }
    }

    private void m160a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f178e.isEmpty()) {
            cj b = m192b(this.f182i);
            int min = (int) ((b != null ? Math.min(b.f239e, this.f193t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m165a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f186m.isFinished()) {
            this.f186m.startScroll(paddingLeft, 0, (int) (m192b(this.f182i).f239e * ((float) i)), 0, this.f186m.getDuration() - this.f186m.timePassed());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f142a) {
                    int i9 = layoutParams.f143b & 112;
                    switch (layoutParams.f143b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.f142a) {
                    cj a = m179a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f239e * ((float) max))) + paddingLeft;
                        if (layoutParams.f145d) {
                            layoutParams.f145d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.f144c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f190q = paddingTop;
        this.f191r = i6 - paddingBottom;
        this.f175V = i7;
        if (this.f172S) {
            m161a(this.f182i, false, 0, false);
        }
        this.f172S = false;
    }

    public void computeScroll() {
        if (this.f186m.isFinished() || !this.f186m.computeScrollOffset()) {
            m165a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f186m.getCurrX();
        int currY = this.f186m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m171d(currX)) {
                this.f186m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ay.m581d(this);
    }

    private boolean m171d(int i) {
        if (this.f178e.size() == 0) {
            this.f174U = false;
            m182a(0, 0.0f, 0);
            if (this.f174U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        cj j = m175j();
        int clientWidth = getClientWidth();
        int i2 = this.f188o + clientWidth;
        float f = ((float) this.f188o) / ((float) clientWidth);
        int i3 = j.f236b;
        float f2 = ((((float) i) / ((float) clientWidth)) - j.f239e) / (j.f238d + f);
        clientWidth = (int) (((float) i2) * f2);
        this.f174U = false;
        m182a(i3, f2, clientWidth);
        if (this.f174U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    protected void m182a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f175V > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f142a) {
                    int max;
                    switch (layoutParams.f143b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.f176W != null) {
            this.f176W.mo241a(i, f, i2);
        }
        if (this.aa != null) {
            this.aa.mo241a(i, f, i2);
        }
        if (this.ac != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).f142a) {
                    this.ac.m803a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f174U = true;
    }

    private void m165a(boolean z) {
        int scrollX;
        boolean z2 = this.ai == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f186m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f186m.getCurrX();
            int currY = this.f186m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f198y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f178e.size(); scrollX++) {
            cj cjVar = (cj) this.f178e.get(scrollX);
            if (cjVar.f237c) {
                cjVar.f237c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ay.m571a((View) this, this.ah);
        } else {
            this.ah.run();
        }
    }

    private boolean m166a(float f, float f2) {
        return (f < ((float) this.f157D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f157D)) && f2 < 0.0f);
    }

    private void m168b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ay.m568a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f154A = false;
            this.f155B = false;
            this.f163J = -1;
            if (this.f164K == null) {
                return false;
            }
            this.f164K.recycle();
            this.f164K = null;
            return false;
        }
        if (action != 0) {
            if (this.f154A) {
                return true;
            }
            if (this.f155B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f161H = x;
                this.f159F = x;
                x = motionEvent.getY();
                this.f162I = x;
                this.f160G = x;
                this.f163J = ae.m519b(motionEvent, 0);
                this.f155B = false;
                this.f186m.computeScrollOffset();
                if (this.ai == 2 && Math.abs(this.f186m.getFinalX() - this.f186m.getCurrX()) > this.f168O) {
                    this.f186m.abortAnimation();
                    this.f198y = false;
                    m197d();
                    this.f154A = true;
                    m170c(true);
                    setScrollState(1);
                    break;
                }
                m165a(false);
                this.f154A = false;
                break;
                break;
            case 2:
                action = this.f163J;
                if (action != -1) {
                    action = ae.m517a(motionEvent, action);
                    float c = ae.m520c(motionEvent, action);
                    float f = c - this.f159F;
                    float abs = Math.abs(f);
                    float d = ae.m522d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f162I);
                    if (f == 0.0f || m166a(this.f159F, f) || !m190a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f158E) && 0.5f * abs > abs2) {
                            this.f154A = true;
                            m170c(true);
                            setScrollState(1);
                            this.f159F = f > 0.0f ? this.f161H + ((float) this.f158E) : this.f161H - ((float) this.f158E);
                            this.f160G = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f158E)) {
                            this.f155B = true;
                        }
                        if (this.f154A && m169b(c)) {
                            ay.m581d(this);
                            break;
                        }
                    }
                    this.f159F = c;
                    this.f160G = d;
                    this.f155B = true;
                    return false;
                }
                break;
            case 6:
                m164a(motionEvent);
                break;
        }
        if (this.f164K == null) {
            this.f164K = VelocityTracker.obtain();
        }
        this.f164K.addMovement(motionEvent);
        return this.f154A;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f169P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f181h == null || this.f181h.getCount() == 0) {
            return false;
        }
        if (this.f164K == null) {
            this.f164K = VelocityTracker.obtain();
        }
        this.f164K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f186m.abortAnimation();
                this.f198y = false;
                m197d();
                x = motionEvent.getX();
                this.f161H = x;
                this.f159F = x;
                x = motionEvent.getY();
                this.f162I = x;
                this.f160G = x;
                this.f163J = ae.m519b(motionEvent, 0);
                break;
            case 1:
                if (this.f154A) {
                    VelocityTracker velocityTracker = this.f164K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f166M);
                    a = (int) at.m555a(velocityTracker, this.f163J);
                    this.f198y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    cj j = m175j();
                    setCurrentItemInternal(m157a(j.f236b, ((((float) scrollX) / ((float) clientWidth)) - j.f239e) / j.f238d, a, (int) (ae.m520c(motionEvent, ae.m517a(motionEvent, this.f163J)) - this.f161H)), true, true, a);
                    this.f163J = -1;
                    m176k();
                    z = this.f171R.m1268c() | this.f170Q.m1268c();
                    break;
                }
                break;
            case 2:
                if (!this.f154A) {
                    a = ae.m517a(motionEvent, this.f163J);
                    float c = ae.m520c(motionEvent, a);
                    float abs = Math.abs(c - this.f159F);
                    float d = ae.m522d(motionEvent, a);
                    x = Math.abs(d - this.f160G);
                    if (abs > ((float) this.f158E) && abs > x) {
                        this.f154A = true;
                        m170c(true);
                        if (c - this.f161H > 0.0f) {
                            x = this.f161H + ((float) this.f158E);
                        } else {
                            x = this.f161H - ((float) this.f158E);
                        }
                        this.f159F = x;
                        this.f160G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f154A) {
                    z = false | m169b(ae.m520c(motionEvent, ae.m517a(motionEvent, this.f163J)));
                    break;
                }
                break;
            case 3:
                if (this.f154A) {
                    m161a(this.f182i, true, 0, false);
                    this.f163J = -1;
                    m176k();
                    z = this.f171R.m1268c() | this.f170Q.m1268c();
                    break;
                }
                break;
            case 5:
                a = ae.m518b(motionEvent);
                this.f159F = ae.m520c(motionEvent, a);
                this.f163J = ae.m519b(motionEvent, a);
                break;
            case 6:
                m164a(motionEvent);
                this.f159F = ae.m520c(motionEvent, ae.m517a(motionEvent, this.f163J));
                break;
        }
        if (z) {
            ay.m581d(this);
        }
        return true;
    }

    private void m170c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m169b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f159F - f;
        this.f159F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f192s;
        float f5 = ((float) clientWidth) * this.f193t;
        cj cjVar = (cj) this.f178e.get(0);
        cj cjVar2 = (cj) this.f178e.get(this.f178e.size() - 1);
        if (cjVar.f236b != 0) {
            f4 = cjVar.f239e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (cjVar2.f236b != this.f181h.getCount() - 1) {
            f2 = cjVar2.f239e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f170Q.m1264a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f171R.m1264a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f159F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m171d((int) f4);
        return z3;
    }

    private cj m175j() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f188o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        cj cjVar = null;
        while (i2 < this.f178e.size()) {
            int i3;
            cj cjVar2;
            cj cjVar3 = (cj) this.f178e.get(i2);
            cj cjVar4;
            if (obj != null || cjVar3.f236b == i + 1) {
                cjVar4 = cjVar3;
                i3 = i2;
                cjVar2 = cjVar4;
            } else {
                cjVar3 = this.f179f;
                cjVar3.f239e = (f2 + f3) + f;
                cjVar3.f236b = i + 1;
                cjVar3.f238d = this.f181h.getPageWidth(cjVar3.f236b);
                cjVar4 = cjVar3;
                i3 = i2 - 1;
                cjVar2 = cjVar4;
            }
            f2 = cjVar2.f239e;
            f3 = (cjVar2.f238d + f2) + f;
            if (obj == null && scrollX < f2) {
                return cjVar;
            }
            if (scrollX < f3 || i3 == this.f178e.size() - 1) {
                return cjVar2;
            }
            f3 = f2;
            i = cjVar2.f236b;
            obj = null;
            f2 = cjVar2.f238d;
            cjVar = cjVar2;
            i2 = i3 + 1;
        }
        return cjVar;
    }

    private int m157a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f167N || Math.abs(i2) <= this.f165L) {
            i = (int) ((i >= this.f182i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f178e.size() <= 0) {
            return i;
        }
        return Math.max(((cj) this.f178e.get(0)).f236b, Math.min(i, ((cj) this.f178e.get(this.f178e.size() - 1)).f236b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ay.m565a(this);
        if (a == 0 || (a == 1 && this.f181h != null && this.f181h.getCount() > 1)) {
            int height;
            int width;
            if (!this.f170Q.m1263a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f192s * ((float) width));
                this.f170Q.m1262a(height, width);
                i = 0 | this.f170Q.m1266a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f171R.m1263a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f193t + TextTrackStyle.DEFAULT_FONT_SCALE)) * ((float) height));
                this.f171R.m1262a(width, height);
                i |= this.f171R.m1266a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f170Q.m1267b();
            this.f171R.m1267b();
        }
        if (i != 0) {
            ay.m581d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f188o > 0 && this.f189p != null && this.f178e.size() > 0 && this.f181h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f188o) / ((float) width);
            cj cjVar = (cj) this.f178e.get(0);
            float f2 = cjVar.f239e;
            int size = this.f178e.size();
            int i = cjVar.f236b;
            int i2 = ((cj) this.f178e.get(size - 1)).f236b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > cjVar.f236b && i3 < size) {
                    i3++;
                    cjVar = (cj) this.f178e.get(i3);
                }
                if (i4 == cjVar.f236b) {
                    f3 = (cjVar.f239e + cjVar.f238d) * ((float) width);
                    f2 = (cjVar.f239e + cjVar.f238d) + f;
                } else {
                    float pageWidth = this.f181h.getPageWidth(i4);
                    f3 = (f2 + pageWidth) * ((float) width);
                    f2 += pageWidth + f;
                }
                if (((float) this.f188o) + f3 > ((float) scrollX)) {
                    this.f189p.setBounds((int) f3, this.f190q, (int) ((((float) this.f188o) + f3) + 0.5f), this.f191r);
                    this.f189p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void m164a(MotionEvent motionEvent) {
        int b = ae.m518b(motionEvent);
        if (ae.m519b(motionEvent, b) == this.f163J) {
            b = b == 0 ? 1 : 0;
            this.f159F = ae.m520c(motionEvent, b);
            this.f163J = ae.m519b(motionEvent, b);
            if (this.f164K != null) {
                this.f164K.clear();
            }
        }
    }

    private void m176k() {
        this.f154A = false;
        this.f155B = false;
        if (this.f164K != null) {
            this.f164K.recycle();
            this.f164K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f197x != z) {
            this.f197x = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f181h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f192s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f193t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m190a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m190a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ay.m574a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m189a(keyEvent);
    }

    public boolean m189a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m196c(17);
            case 22:
                return m196c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0145x.m921a(keyEvent)) {
                    return m196c(2);
                }
                if (C0145x.m922a(keyEvent, 1)) {
                    return m196c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m196c(int i) {
        View view;
        boolean e;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                e = m198e();
            } else {
                if (i == 66 || i == 2) {
                    e = m199f();
                }
                e = false;
            }
        } else if (i == 17) {
            e = (view == null || m158a(this.f180g, findNextFocus).left < m158a(this.f180g, view).left) ? findNextFocus.requestFocus() : m198e();
        } else {
            if (i == 66) {
                e = (view == null || m158a(this.f180g, findNextFocus).left > m158a(this.f180g, view).left) ? findNextFocus.requestFocus() : m199f();
            }
            e = false;
        }
        if (e) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return e;
    }

    private Rect m158a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean m198e() {
        if (this.f182i <= 0) {
            return false;
        }
        setCurrentItem(this.f182i - 1, true);
        return true;
    }

    boolean m199f() {
        if (this.f181h == null || this.f182i >= this.f181h.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f182i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    cj a = m179a(childAt);
                    if (a != null && a.f236b == this.f182i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == Menu.CATEGORY_ALTERNATIVE && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                cj a = m179a(childAt);
                if (a != null && a.f236b == this.f182i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                cj a = m179a(childAt);
                if (a != null && a.f236b == this.f182i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                cj a = m179a(childAt);
                if (a != null && a.f236b == this.f182i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
