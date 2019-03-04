package com.github.amlcurran.showcaseview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: TextDrawer */
class ac {
    private final TextPaint f1630a;
    private final TextPaint f1631b;
    private final Context f1632c;
    private final C0661s f1633d;
    private final float f1634e;
    private final float f1635f;
    private CharSequence f1636g;
    private CharSequence f1637h;
    private float[] f1638i = new float[3];
    private DynamicLayout f1639j;
    private DynamicLayout f1640k;
    private TextAppearanceSpan f1641l;
    private TextAppearanceSpan f1642m;
    private boolean f1643n;

    public ac(Resources resources, C0661s c0661s, Context context) {
        this.f1634e = resources.getDimension(C0655m.text_padding);
        this.f1635f = resources.getDimension(C0655m.action_bar_offset);
        this.f1633d = c0661s;
        this.f1632c = context;
        this.f1630a = new TextPaint();
        this.f1630a.setAntiAlias(true);
        this.f1631b = new TextPaint();
        this.f1631b.setAntiAlias(true);
    }

    public void m3213a(Canvas canvas) {
        if (m3218b()) {
            float[] a = m3215a();
            if (!TextUtils.isEmpty(this.f1636g)) {
                canvas.save();
                if (this.f1643n) {
                    this.f1639j = new DynamicLayout(this.f1636g, this.f1630a, (int) a[2], Alignment.ALIGN_NORMAL, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE, true);
                }
                if (this.f1639j != null) {
                    canvas.translate(a[0], a[1]);
                    this.f1639j.draw(canvas);
                    canvas.restore();
                }
            }
            if (!TextUtils.isEmpty(this.f1637h)) {
                int height;
                canvas.save();
                if (this.f1643n) {
                    this.f1640k = new DynamicLayout(this.f1637h, this.f1631b, (int) a[2], Alignment.ALIGN_NORMAL, 1.2f, TextTrackStyle.DEFAULT_FONT_SCALE, true);
                }
                if (this.f1639j != null) {
                    height = this.f1639j.getHeight();
                } else {
                    height = 0;
                }
                float f = (float) height;
                if (this.f1640k != null) {
                    canvas.translate(a[0], f + a[1]);
                    this.f1640k.draw(canvas);
                    canvas.restore();
                }
            }
        }
        this.f1643n = false;
    }

    public void m3214a(CharSequence charSequence) {
        if (charSequence != null) {
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(this.f1642m, 0, spannableString.length(), 0);
            this.f1637h = spannableString;
        }
    }

    public void m3217b(CharSequence charSequence) {
        if (charSequence != null) {
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(this.f1641l, 0, spannableString.length(), 0);
            this.f1636g = spannableString;
        }
    }

    public void m3212a(int i, int i2, ShowcaseView showcaseView, boolean z) {
        Rect a;
        if (showcaseView.m3185b()) {
            a = this.f1633d.m3242a();
        } else {
            a = new Rect();
        }
        int[] iArr = new int[]{a.left * i2, a.top * i, (i - a.right) * i2, (i2 - a.bottom) * i};
        int i3 = 0;
        for (int i4 = 1; i4 < iArr.length; i4++) {
            if (iArr[i4] > iArr[i3]) {
                i3 = i4;
            }
        }
        switch (i3) {
            case 0:
                this.f1638i[0] = this.f1634e;
                this.f1638i[1] = this.f1634e;
                this.f1638i[2] = ((float) a.left) - (this.f1634e * 2.0f);
                break;
            case 1:
                this.f1638i[0] = this.f1634e;
                this.f1638i[1] = this.f1634e + this.f1635f;
                this.f1638i[2] = ((float) i) - (this.f1634e * 2.0f);
                break;
            case 2:
                this.f1638i[0] = ((float) a.right) + this.f1634e;
                this.f1638i[1] = this.f1634e;
                this.f1638i[2] = ((float) (i - a.right)) - (this.f1634e * 2.0f);
                break;
            case 3:
                this.f1638i[0] = this.f1634e;
                this.f1638i[1] = ((float) a.bottom) + this.f1634e;
                this.f1638i[2] = ((float) i) - (this.f1634e * 2.0f);
                break;
        }
        if (!z) {
            switch (i3) {
                case 0:
                case 2:
                    float[] fArr = this.f1638i;
                    fArr[1] = fArr[1] + this.f1635f;
                    break;
                default:
                    break;
            }
        }
        switch (i3) {
            case 0:
            case 2:
                fArr = this.f1638i;
                fArr[1] = fArr[1] + ((float) (i2 / 4));
                break;
            case 1:
            case 3:
                fArr = this.f1638i;
                fArr[2] = fArr[2] / 2.0f;
                fArr = this.f1638i;
                fArr[0] = fArr[0] + ((float) (i / 4));
                break;
        }
        this.f1643n = true;
    }

    public void m3211a(int i) {
        this.f1641l = new TextAppearanceSpan(this.f1632c, i);
        m3217b(this.f1636g);
    }

    public void m3216b(int i) {
        this.f1642m = new TextAppearanceSpan(this.f1632c, i);
        m3214a(this.f1637h);
    }

    public float[] m3215a() {
        return this.f1638i;
    }

    public boolean m3218b() {
        return (TextUtils.isEmpty(this.f1636g) && TextUtils.isEmpty(this.f1637h)) ? false : true;
    }
}
