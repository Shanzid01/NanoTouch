package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: MaterialProgressDrawable */
class ag {
    private final RectF f416a = new RectF();
    private final Paint f417b = new Paint();
    private final Paint f418c = new Paint();
    private final Callback f419d;
    private float f420e = 0.0f;
    private float f421f = 0.0f;
    private float f422g = 0.0f;
    private float f423h = 5.0f;
    private float f424i = 2.5f;
    private int[] f425j;
    private int f426k;
    private float f427l;
    private float f428m;
    private float f429n;
    private boolean f430o;
    private Path f431p;
    private float f432q;
    private double f433r;
    private int f434s;
    private int f435t;
    private int f436u;
    private final Paint f437v = new Paint();
    private int f438w;

    public ag(Callback callback) {
        this.f419d = callback;
        this.f417b.setStrokeCap(Cap.SQUARE);
        this.f417b.setAntiAlias(true);
        this.f417b.setStyle(Style.STROKE);
        this.f418c.setStyle(Style.FILL);
        this.f418c.setAntiAlias(true);
    }

    public void m1064a(int i) {
        this.f438w = i;
    }

    public void m1063a(float f, float f2) {
        this.f434s = (int) f;
        this.f435t = (int) f2;
    }

    public void m1066a(Canvas canvas, Rect rect) {
        RectF rectF = this.f416a;
        rectF.set(rect);
        rectF.inset(this.f424i, this.f424i);
        float f = (this.f420e + this.f422g) * 360.0f;
        float f2 = ((this.f421f + this.f422g) * 360.0f) - f;
        this.f417b.setColor(this.f425j[this.f426k]);
        canvas.drawArc(rectF, f, f2, false, this.f417b);
        m1058a(canvas, f, f2, rect);
        if (this.f436u < 255) {
            this.f437v.setColor(this.f438w);
            this.f437v.setAlpha(255 - this.f436u);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f437v);
        }
    }

    private void m1058a(Canvas canvas, float f, float f2, Rect rect) {
        if (this.f430o) {
            if (this.f431p == null) {
                this.f431p = new Path();
                this.f431p.setFillType(FillType.EVEN_ODD);
            } else {
                this.f431p.reset();
            }
            float f3 = ((float) (((int) this.f424i) / 2)) * this.f432q;
            float cos = (float) ((this.f433r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
            float sin = (float) ((this.f433r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
            this.f431p.moveTo(0.0f, 0.0f);
            this.f431p.lineTo(((float) this.f434s) * this.f432q, 0.0f);
            this.f431p.lineTo((((float) this.f434s) * this.f432q) / 2.0f, ((float) this.f435t) * this.f432q);
            this.f431p.offset(cos - f3, sin);
            this.f431p.close();
            this.f418c.setColor(this.f425j[this.f426k]);
            canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(this.f431p, this.f418c);
        }
    }

    public void m1069a(int[] iArr) {
        this.f425j = iArr;
        m1072b(0);
    }

    public void m1072b(int i) {
        this.f426k = i;
    }

    public void m1060a() {
        this.f426k = (this.f426k + 1) % this.f425j.length;
    }

    public void m1067a(ColorFilter colorFilter) {
        this.f417b.setColorFilter(colorFilter);
        m1059l();
    }

    public void m1075c(int i) {
        this.f436u = i;
    }

    public int m1070b() {
        return this.f436u;
    }

    public void m1062a(float f) {
        this.f423h = f;
        this.f417b.setStrokeWidth(f);
        m1059l();
    }

    public float m1073c() {
        return this.f423h;
    }

    public void m1071b(float f) {
        this.f420e = f;
        m1059l();
    }

    public float m1076d() {
        return this.f420e;
    }

    public float m1078e() {
        return this.f427l;
    }

    public float m1080f() {
        return this.f428m;
    }

    public void m1074c(float f) {
        this.f421f = f;
        m1059l();
    }

    public float m1081g() {
        return this.f421f;
    }

    public void m1077d(float f) {
        this.f422g = f;
        m1059l();
    }

    public void m1065a(int i, int i2) {
        float min = (float) Math.min(i, i2);
        if (this.f433r <= 0.0d || min < 0.0f) {
            min = (float) Math.ceil((double) (this.f423h / 2.0f));
        } else {
            min = (float) (((double) (min / 2.0f)) - this.f433r);
        }
        this.f424i = min;
    }

    public void m1061a(double d) {
        this.f433r = d;
    }

    public double m1082h() {
        return this.f433r;
    }

    public void m1068a(boolean z) {
        if (this.f430o != z) {
            this.f430o = z;
            m1059l();
        }
    }

    public void m1079e(float f) {
        if (f != this.f432q) {
            this.f432q = f;
            m1059l();
        }
    }

    public float m1083i() {
        return this.f429n;
    }

    public void m1084j() {
        this.f427l = this.f420e;
        this.f428m = this.f421f;
        this.f429n = this.f422g;
    }

    public void m1085k() {
        this.f427l = 0.0f;
        this.f428m = 0.0f;
        this.f429n = 0.0f;
        m1071b(0.0f);
        m1074c(0.0f);
        m1077d(0.0f);
    }

    private void m1059l() {
        this.f419d.invalidateDrawable(null);
    }
}
