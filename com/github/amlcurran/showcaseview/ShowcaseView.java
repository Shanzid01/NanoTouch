package com.github.amlcurran.showcaseview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.github.amlcurran.showcaseview.p042a.C0639a;
import com.google.android.gms.cast.TextTrackStyle;

public class ShowcaseView extends RelativeLayout implements OnTouchListener {
    private static final int f1597a = Color.parseColor("#33B5E5");
    private final Button f1598b;
    private final ac f1599c;
    private final C0643t f1600d;
    private final C0661s f1601e;
    private final C0642a f1602f;
    private final C0660r f1603g;
    private int f1604h;
    private int f1605i;
    private float f1606j;
    private C0667z f1607k;
    private aa f1608l;
    private boolean f1609m;
    private boolean f1610n;
    private boolean f1611o;
    private C0651i f1612p;
    private boolean f1613q;
    private boolean f1614r;
    private boolean f1615s;
    private Bitmap f1616t;
    private Activity f1617u;
    private long f1618v;
    private long f1619w;
    private boolean f1620x;
    private OnClickListener f1621y;

    public ShowcaseView(Context context, boolean z) {
        this(context, null, C0659q.CustomTheme_showcaseViewStyle, z);
        if (context instanceof Activity) {
            this.f1617u = (Activity) context;
        }
    }

    public ShowcaseView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        this.f1604h = -1;
        this.f1605i = -1;
        this.f1606j = TextTrackStyle.DEFAULT_FONT_SCALE;
        this.f1607k = null;
        this.f1608l = null;
        this.f1609m = false;
        this.f1610n = true;
        this.f1611o = false;
        this.f1612p = C0651i.f1651a;
        this.f1613q = false;
        this.f1614r = false;
        this.f1617u = null;
        this.f1621y = new C0662u(this);
        if (context instanceof Activity) {
            this.f1617u = (Activity) context;
        }
        C0649g c0649g = new C0649g();
        this.f1602f = new C0646d();
        this.f1601e = new C0661s();
        this.f1603g = new C0660r(context);
        c0649g.m3224a((View) this);
        this.f1607k = new C0667z();
        getViewTreeObserver().addOnPreDrawListener(this.f1607k);
        this.f1608l = new aa();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1608l);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0659q.ShowcaseView, C0654l.showcaseViewStyle, C0658p.ShowcaseView);
        this.f1618v = (long) getResources().getInteger(17694721);
        this.f1619w = (long) getResources().getInteger(17694721);
        this.f1598b = (Button) LayoutInflater.from(context).inflate(C0657o.showcase_button, null);
        if (z) {
            this.f1600d = new C0650h(getResources());
        } else {
            this.f1600d = new ab(getResources());
        }
        this.f1599c = new ac(getResources(), this.f1601e, getContext());
        m3163a(obtainStyledAttributes, false);
        m3172f();
    }

    private void m3172f() {
        setOnTouchListener(this);
        if (this.f1598b.getParent() == null) {
            int dimension = (int) getResources().getDimension(C0655m.button_margin);
            LayoutParams layoutParams = (LayoutParams) generateDefaultLayoutParams();
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            this.f1598b.setLayoutParams(layoutParams);
            this.f1598b.setText(17039370);
            if (!this.f1609m) {
                this.f1598b.setOnClickListener(this.f1621y);
            }
            addView(this.f1598b);
        }
    }

    public boolean m3183a() {
        return this.f1603g.m3239a();
    }

    void m3179a(Point point) {
        setShowcasePosition(point.x, point.y);
    }

    void setShowcasePosition(int i, int i2) {
        if (!this.f1603g.m3239a()) {
            this.f1604h = i;
            this.f1605i = i2;
            invalidate();
        }
    }

    public void m3180a(C0639a c0639a) {
        m3181a(c0639a, false);
    }

    public void m3181a(C0639a c0639a, boolean z) {
        postDelayed(new C0663v(this, c0639a, z), 100);
    }

    private void m3173g() {
        if (this.f1616t == null || m3174h()) {
            if (this.f1616t != null) {
                this.f1616t.recycle();
                this.f1616t = null;
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                this.f1616t = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            }
        }
    }

    private boolean m3174h() {
        return (getMeasuredWidth() == this.f1616t.getWidth() && getMeasuredHeight() == this.f1616t.getHeight()) ? false : true;
    }

    public boolean m3185b() {
        return (this.f1604h == 1000000 || this.f1605i == 1000000 || this.f1614r) ? false : true;
    }

    public void setShowcaseX(int i) {
        setShowcasePosition(i, this.f1605i);
    }

    public void setShowcaseY(int i) {
        setShowcasePosition(this.f1604h, i);
    }

    public int getShowcaseX() {
        return this.f1604h;
    }

    public int getShowcaseY() {
        return this.f1605i;
    }

    private void m3175i() {
        boolean z = this.f1601e.m3243a((float) this.f1604h, (float) this.f1605i, this.f1600d) || this.f1613q;
        if (z) {
            this.f1599c.m3212a(getMeasuredWidth(), getMeasuredHeight(), this, this.f1615s);
        }
        this.f1613q = false;
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f1604h < 0 || this.f1605i < 0 || this.f1603g.m3239a() || this.f1616t == null) {
            super.dispatchDraw(canvas);
            return;
        }
        this.f1600d.mo1093a(this.f1616t);
        if (!this.f1614r) {
            this.f1600d.mo1094a(this.f1616t, (float) this.f1604h, (float) this.f1605i, this.f1606j);
            this.f1600d.mo1095a(canvas, this.f1616t);
        }
        this.f1599c.m3213a(canvas);
        super.dispatchDraw(canvas);
    }

    @SuppressLint({"NewApi"})
    public void m3186c() {
        m3176j();
        this.f1603g.m3241c();
        this.f1612p.mo1106a(this);
        m3177k();
        getViewTreeObserver().removeOnPreDrawListener(this.f1607k);
        if (VERSION.SDK_INT > 15) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f1608l);
        } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f1608l);
        }
        ((ViewGroup) this.f1617u.getWindow().getDecorView()).removeView(this);
    }

    private void m3176j() {
        if (this.f1616t != null && !this.f1616t.isRecycled()) {
            this.f1616t.recycle();
            this.f1616t = null;
        }
    }

    private void m3177k() {
        this.f1602f.mo1099a((View) this, this.f1619w, new C0664w(this));
    }

    public void m3187d() {
        this.f1620x = true;
        this.f1612p.mo1108c(this);
        m3178l();
    }

    private void m3178l() {
        this.f1602f.mo1100a((View) this, this.f1618v, new C0665x(this));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getRawX() - ((float) this.f1604h));
        float abs2 = Math.abs(motionEvent.getRawY() - ((float) this.f1605i));
        double sqrt = Math.sqrt(Math.pow((double) abs2, 2.0d) + Math.pow((double) abs, 2.0d));
        if (1 == motionEvent.getAction() && this.f1611o && sqrt > ((double) this.f1600d.mo1098c())) {
            m3186c();
            return true;
        } else if (!this.f1610n || sqrt <= ((double) this.f1600d.mo1098c())) {
            return false;
        } else {
            return true;
        }
    }

    private static void m3167b(ShowcaseView showcaseView, Activity activity) {
        ((ViewGroup) activity.getWindow().getDecorView()).addView(showcaseView);
        if (showcaseView.m3183a()) {
            showcaseView.m3186c();
        } else {
            showcaseView.m3187d();
        }
    }

    public void m3182a(CharSequence charSequence) {
        this.f1599c.m3217b(charSequence);
    }

    public void m3184b(CharSequence charSequence) {
        this.f1599c.m3214a(charSequence);
    }

    private void setScaleMultiplier(float f) {
        this.f1606j = f;
    }

    public void setShouldCentreText(boolean z) {
        this.f1615s = z;
        this.f1613q = true;
        invalidate();
    }

    public void setSingleShot(long j) {
        this.f1603g.m3238a(j);
    }

    private void setFadeDurations(long j, long j2) {
        this.f1618v = j;
        this.f1619w = j2;
    }

    public void setHideOnTouchOutside(boolean z) {
        this.f1611o = z;
    }

    public void setBlocksTouches(boolean z) {
        this.f1610n = z;
    }

    public void setStyle(int i) {
        m3163a(getContext().obtainStyledAttributes(i, C0659q.ShowcaseView), true);
    }

    public boolean m3188e() {
        return this.f1620x;
    }

    private void m3163a(TypedArray typedArray, boolean z) {
        int color = typedArray.getColor(C0659q.ShowcaseView_sv_backgroundColor, Color.argb(128, 80, 80, 80));
        int color2 = typedArray.getColor(C0659q.ShowcaseView_sv_showcaseColor, f1597a);
        CharSequence string = typedArray.getString(C0659q.ShowcaseView_sv_buttonText);
        if (TextUtils.isEmpty(string)) {
            string = getResources().getString(17039370);
        }
        boolean z2 = typedArray.getBoolean(C0659q.ShowcaseView_sv_tintButtonColor, true);
        int resourceId = typedArray.getResourceId(C0659q.ShowcaseView_sv_titleTextAppearance, C0658p.TextAppearance_ShowcaseView_Title);
        int resourceId2 = typedArray.getResourceId(C0659q.ShowcaseView_sv_detailTextAppearance, C0658p.TextAppearance_ShowcaseView_Detail);
        typedArray.recycle();
        this.f1600d.mo1092a(color2);
        this.f1600d.mo1097b(color);
        m3162a(color2, z2);
        this.f1598b.setText(string);
        this.f1599c.m3211a(resourceId);
        this.f1599c.m3216b(resourceId2);
        this.f1613q = true;
        if (z) {
            invalidate();
        }
    }

    private void m3162a(int i, boolean z) {
        if (z) {
            this.f1598b.getBackground().setColorFilter(i, Mode.MULTIPLY);
        } else {
            this.f1598b.getBackground().setColorFilter(f1597a, Mode.MULTIPLY);
        }
    }
}
