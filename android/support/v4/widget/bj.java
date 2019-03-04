package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ae;
import android.support.v4.view.at;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.Arrays;

/* compiled from: ViewDragHelper */
public class bj {
    private static final Interpolator f463v = new bk();
    private int f464a;
    private int f465b;
    private int f466c = -1;
    private float[] f467d;
    private float[] f468e;
    private float[] f469f;
    private float[] f470g;
    private int[] f471h;
    private int[] f472i;
    private int[] f473j;
    private int f474k;
    private VelocityTracker f475l;
    private float f476m;
    private float f477n;
    private int f478o;
    private int f479p;
    private aj f480q;
    private final bm f481r;
    private View f482s;
    private boolean f483t;
    private final ViewGroup f484u;
    private final Runnable f485w = new bl(this);

    public static bj m1183a(ViewGroup viewGroup, bm bmVar) {
        return new bj(viewGroup.getContext(), viewGroup, bmVar);
    }

    public static bj m1182a(ViewGroup viewGroup, float f, bm bmVar) {
        bj a = m1183a(viewGroup, bmVar);
        a.f465b = (int) (((float) a.f465b) * (TextTrackStyle.DEFAULT_FONT_SCALE / f));
        return a;
    }

    private bj(Context context, ViewGroup viewGroup, bm bmVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (bmVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f484u = viewGroup;
            this.f481r = bmVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f478o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f465b = viewConfiguration.getScaledTouchSlop();
            this.f476m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f477n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f480q = aj.m1086a(context, f463v);
        }
    }

    public void m1200a(float f) {
        this.f477n = f;
    }

    public int m1199a() {
        return this.f464a;
    }

    public void m1201a(int i) {
        this.f479p = i;
    }

    public int m1207b() {
        return this.f478o;
    }

    public void m1202a(View view, int i) {
        if (view.getParent() != this.f484u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f484u + ")");
        }
        this.f482s = view;
        this.f466c = i;
        this.f481r.mo359b(view, i);
        m1214c(1);
    }

    public View m1213c() {
        return this.f482s;
    }

    public int m1216d() {
        return this.f465b;
    }

    public void m1219e() {
        this.f466c = -1;
        m1197g();
        if (this.f475l != null) {
            this.f475l.recycle();
            this.f475l = null;
        }
    }

    public void m1220f() {
        m1219e();
        if (this.f464a == 2) {
            int b = this.f480q.m1090b();
            int c = this.f480q.m1091c();
            this.f480q.m1096h();
            int b2 = this.f480q.m1090b();
            int c2 = this.f480q.m1091c();
            this.f481r.mo355a(this.f482s, b2, c2, b2 - b, c2 - c);
        }
        m1214c(0);
    }

    public boolean m1205a(View view, int i, int i2) {
        this.f482s = view;
        this.f466c = -1;
        boolean a = m1187a(i, i2, 0, 0);
        if (!(a || this.f464a != 0 || this.f482s == null)) {
            this.f482s = null;
        }
        return a;
    }

    public boolean m1203a(int i, int i2) {
        if (this.f483t) {
            return m1187a(i, i2, (int) at.m555a(this.f475l, this.f466c), (int) at.m556b(this.f475l, this.f466c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m1187a(int i, int i2, int i3, int i4) {
        int left = this.f482s.getLeft();
        int top = this.f482s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f480q.m1096h();
            m1214c(0);
            return false;
        }
        this.f480q.m1087a(left, top, i5, i6, m1181a(this.f482s, i5, i6, i3, i4));
        m1214c(2);
        return true;
    }

    private int m1181a(View view, int i, int i2, int i3, int i4) {
        int b = m1190b(i3, (int) this.f477n, (int) this.f476m);
        int b2 = m1190b(i4, (int) this.f477n, (int) this.f476m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m1180a(i2, b2, this.f481r.m1154b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m1180a(i, b, this.f481r.mo351a(view)))));
    }

    private int m1180a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f484u.getWidth();
        int i4 = width / 2;
        float b = (m1189b(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + TextTrackStyle.DEFAULT_FONT_SCALE) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m1190b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m1179a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m1189b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m1206a(boolean z) {
        if (this.f464a == 2) {
            int i;
            boolean g = this.f480q.m1095g();
            int b = this.f480q.m1090b();
            int c = this.f480q.m1091c();
            int left = b - this.f482s.getLeft();
            int top = c - this.f482s.getTop();
            if (left != 0) {
                this.f482s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f482s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f481r.mo355a(this.f482s, b, c, left, top);
            }
            if (g && b == this.f480q.m1092d() && c == this.f480q.m1093e()) {
                this.f480q.m1096h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f484u.post(this.f485w);
                } else {
                    m1214c(0);
                }
            }
        }
        return this.f464a == 2;
    }

    private void m1184a(float f, float f2) {
        this.f483t = true;
        this.f481r.mo354a(this.f482s, f, f2);
        this.f483t = false;
        if (this.f464a == 1) {
            m1214c(0);
        }
    }

    private void m1197g() {
        if (this.f467d != null) {
            Arrays.fill(this.f467d, 0.0f);
            Arrays.fill(this.f468e, 0.0f);
            Arrays.fill(this.f469f, 0.0f);
            Arrays.fill(this.f470g, 0.0f);
            Arrays.fill(this.f471h, 0);
            Arrays.fill(this.f472i, 0);
            Arrays.fill(this.f473j, 0);
            this.f474k = 0;
        }
    }

    private void m1195e(int i) {
        if (this.f467d != null) {
            this.f467d[i] = 0.0f;
            this.f468e[i] = 0.0f;
            this.f469f[i] = 0.0f;
            this.f470g[i] = 0.0f;
            this.f471h[i] = 0;
            this.f472i[i] = 0;
            this.f473j[i] = 0;
            this.f474k &= (1 << i) ^ -1;
        }
    }

    private void m1196f(int i) {
        if (this.f467d == null || this.f467d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f467d != null) {
                System.arraycopy(this.f467d, 0, obj, 0, this.f467d.length);
                System.arraycopy(this.f468e, 0, obj2, 0, this.f468e.length);
                System.arraycopy(this.f469f, 0, obj3, 0, this.f469f.length);
                System.arraycopy(this.f470g, 0, obj4, 0, this.f470g.length);
                System.arraycopy(this.f471h, 0, obj5, 0, this.f471h.length);
                System.arraycopy(this.f472i, 0, obj6, 0, this.f472i.length);
                System.arraycopy(this.f473j, 0, obj7, 0, this.f473j.length);
            }
            this.f467d = obj;
            this.f468e = obj2;
            this.f469f = obj3;
            this.f470g = obj4;
            this.f471h = obj5;
            this.f472i = obj6;
            this.f473j = obj7;
        }
    }

    private void m1185a(float f, float f2, int i) {
        m1196f(i);
        float[] fArr = this.f467d;
        this.f469f[i] = f;
        fArr[i] = f;
        fArr = this.f468e;
        this.f470g[i] = f2;
        fArr[i] = f2;
        this.f471h[i] = m1194e((int) f, (int) f2);
        this.f474k |= 1 << i;
    }

    private void m1193c(MotionEvent motionEvent) {
        int c = ae.m521c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = ae.m519b(motionEvent, i);
            float c2 = ae.m520c(motionEvent, i);
            float d = ae.m522d(motionEvent, i);
            this.f469f[b] = c2;
            this.f470g[b] = d;
        }
    }

    public boolean m1209b(int i) {
        return (this.f474k & (1 << i)) != 0;
    }

    void m1214c(int i) {
        if (this.f464a != i) {
            this.f464a = i;
            this.f481r.mo353a(i);
            if (this.f464a == 0) {
                this.f482s = null;
            }
        }
    }

    boolean m1211b(View view, int i) {
        if (view == this.f482s && this.f466c == i) {
            return true;
        }
        if (view == null || !this.f481r.mo356a(view, i)) {
            return false;
        }
        this.f466c = i;
        m1202a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1204a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.ae.m516a(r14);
        r1 = android.support.v4.view.ae.m518b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m1219e();
    L_0x000d:
        r2 = r13.f475l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f475l = r2;
    L_0x0017:
        r2 = r13.f475l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0119;
            case 2: goto L_0x0092;
            case 3: goto L_0x0119;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x0110;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f464a;
        r1 = 1;
        if (r0 != r1) goto L_0x011e;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.ae.m519b(r14, r2);
        r13.m1185a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m1217d(r0, r1);
        r1 = r13.f482s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f464a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m1211b(r0, r2);
    L_0x0048:
        r0 = r13.f471h;
        r0 = r0[r2];
        r1 = r13.f479p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f481r;
        r3 = r13.f479p;
        r0 = r0 & r3;
        r1.mo366a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.ae.m519b(r14, r1);
        r2 = android.support.v4.view.ae.m520c(r14, r1);
        r1 = android.support.v4.view.ae.m522d(r14, r1);
        r13.m1185a(r2, r1, r0);
        r3 = r13.f464a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f471h;
        r1 = r1[r0];
        r2 = r13.f479p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f481r;
        r3 = r13.f479p;
        r1 = r1 & r3;
        r2.mo366a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f464a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m1217d(r2, r1);
        r2 = r13.f482s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m1211b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r2 = android.support.v4.view.ae.m521c(r14);
        r0 = 0;
        r1 = r0;
    L_0x0098:
        if (r1 >= r2) goto L_0x00f5;
    L_0x009a:
        r3 = android.support.v4.view.ae.m519b(r14, r1);
        r0 = android.support.v4.view.ae.m520c(r14, r1);
        r4 = android.support.v4.view.ae.m522d(r14, r1);
        r5 = r13.f467d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f468e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m1217d(r0, r4);
        if (r4 == 0) goto L_0x00fa;
    L_0x00ba:
        r0 = r13.m1188a(r4, r5, r6);
        if (r0 == 0) goto L_0x00fa;
    L_0x00c0:
        r0 = 1;
    L_0x00c1:
        if (r0 == 0) goto L_0x00fc;
    L_0x00c3:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f481r;
        r10 = (int) r5;
        r8 = r9.mo352a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f481r;
        r12 = (int) r6;
        r10 = r11.mo357b(r4, r10, r12);
        r11 = r13.f481r;
        r11 = r11.mo351a(r4);
        r12 = r13.f481r;
        r12 = r12.m1154b(r4);
        if (r11 == 0) goto L_0x00ef;
    L_0x00eb:
        if (r11 <= 0) goto L_0x00fc;
    L_0x00ed:
        if (r8 != r7) goto L_0x00fc;
    L_0x00ef:
        if (r12 == 0) goto L_0x00f5;
    L_0x00f1:
        if (r12 <= 0) goto L_0x00fc;
    L_0x00f3:
        if (r10 != r9) goto L_0x00fc;
    L_0x00f5:
        r13.m1193c(r14);
        goto L_0x001f;
    L_0x00fa:
        r0 = 0;
        goto L_0x00c1;
    L_0x00fc:
        r13.m1191b(r5, r6, r3);
        r5 = r13.f464a;
        r6 = 1;
        if (r5 == r6) goto L_0x00f5;
    L_0x0104:
        if (r0 == 0) goto L_0x010c;
    L_0x0106:
        r0 = r13.m1211b(r4, r3);
        if (r0 != 0) goto L_0x00f5;
    L_0x010c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0098;
    L_0x0110:
        r0 = android.support.v4.view.ae.m519b(r14, r1);
        r13.m1195e(r0);
        goto L_0x001f;
    L_0x0119:
        r13.m1219e();
        goto L_0x001f;
    L_0x011e:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.bj.a(android.view.MotionEvent):boolean");
    }

    public void m1208b(MotionEvent motionEvent) {
        int i = 0;
        int a = ae.m516a(motionEvent);
        int b = ae.m518b(motionEvent);
        if (a == 0) {
            m1219e();
        }
        if (this.f475l == null) {
            this.f475l = VelocityTracker.obtain();
        }
        this.f475l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = ae.m519b(motionEvent, 0);
                d = m1217d((int) x, (int) y);
                m1185a(x, y, i);
                m1211b(d, i);
                i2 = this.f471h[i];
                if ((this.f479p & i2) != 0) {
                    this.f481r.mo366a(i2 & this.f479p, i);
                    return;
                }
                return;
            case 1:
                if (this.f464a == 1) {
                    m1198h();
                }
                m1219e();
                return;
            case 2:
                if (this.f464a == 1) {
                    i = ae.m517a(motionEvent, this.f466c);
                    x = ae.m520c(motionEvent, i);
                    i2 = (int) (x - this.f469f[this.f466c]);
                    i = (int) (ae.m522d(motionEvent, i) - this.f470g[this.f466c]);
                    m1192b(this.f482s.getLeft() + i2, this.f482s.getTop() + i, i2, i);
                    m1193c(motionEvent);
                    return;
                }
                i2 = ae.m521c(motionEvent);
                while (i < i2) {
                    a = ae.m519b(motionEvent, i);
                    float c = ae.m520c(motionEvent, i);
                    float d2 = ae.m522d(motionEvent, i);
                    float f = c - this.f467d[a];
                    float f2 = d2 - this.f468e[a];
                    m1191b(f, f2, a);
                    if (this.f464a != 1) {
                        d = m1217d((int) c, (int) d2);
                        if (!m1188a(d, f, f2) || !m1211b(d, a)) {
                            i++;
                        }
                    }
                    m1193c(motionEvent);
                    return;
                }
                m1193c(motionEvent);
                return;
            case 3:
                if (this.f464a == 1) {
                    m1184a(0.0f, 0.0f);
                }
                m1219e();
                return;
            case 5:
                i = ae.m519b(motionEvent, b);
                x = ae.m520c(motionEvent, b);
                y = ae.m522d(motionEvent, b);
                m1185a(x, y, i);
                if (this.f464a == 0) {
                    m1211b(m1217d((int) x, (int) y), i);
                    i2 = this.f471h[i];
                    if ((this.f479p & i2) != 0) {
                        this.f481r.mo366a(i2 & this.f479p, i);
                        return;
                    }
                    return;
                } else if (m1215c((int) x, (int) y)) {
                    m1211b(this.f482s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = ae.m519b(motionEvent, b);
                if (this.f464a == 1 && a == this.f466c) {
                    b = ae.m521c(motionEvent);
                    while (i < b) {
                        int b2 = ae.m519b(motionEvent, i);
                        if (b2 != this.f466c) {
                            if (m1217d((int) ae.m520c(motionEvent, i), (int) ae.m522d(motionEvent, i)) == this.f482s && m1211b(this.f482s, b2)) {
                                i = this.f466c;
                                if (i == -1) {
                                    m1198h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m1198h();
                    }
                }
                m1195e(a);
                return;
            default:
                return;
        }
    }

    private void m1191b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1186a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1186a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1186a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1186a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f472i;
            iArr[i] = iArr[i] | i2;
            this.f481r.mo358b(i2, i);
        }
    }

    private boolean m1186a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f471h[i] & i2) != i2 || (this.f479p & i2) == 0 || (this.f473j[i] & i2) == i2 || (this.f472i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f465b) && abs2 <= ((float) this.f465b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f481r.mo367b(i2)) {
            int[] iArr = this.f473j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f472i[i] & i2) != 0 || abs <= ((float) this.f465b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m1188a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f481r.mo351a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f481r.m1154b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f465b * this.f465b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f465b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f465b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m1218d(int i) {
        int length = this.f467d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m1210b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m1210b(int i, int i2) {
        if (!m1209b(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f469f[i2] - this.f467d[i2];
        float f2 = this.f470g[i2] - this.f468e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f465b * this.f465b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f465b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f465b)) {
                return false;
            }
            return true;
        }
    }

    private void m1198h() {
        this.f475l.computeCurrentVelocity(1000, this.f476m);
        m1184a(m1179a(at.m555a(this.f475l, this.f466c), this.f477n, this.f476m), m1179a(at.m556b(this.f475l, this.f466c), this.f477n, this.f476m));
    }

    private void m1192b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f482s.getLeft();
        int top = this.f482s.getTop();
        if (i3 != 0) {
            a = this.f481r.mo352a(this.f482s, i, i3);
            this.f482s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f481r.mo357b(this.f482s, i2, i4);
            this.f482s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f481r.mo355a(this.f482s, a, b, a - left, b - top);
        }
    }

    public boolean m1215c(int i, int i2) {
        return m1212b(this.f482s, i, i2);
    }

    public boolean m1212b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m1217d(int i, int i2) {
        for (int childCount = this.f484u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f484u.getChildAt(this.f481r.m1159c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m1194e(int i, int i2) {
        int i3 = 0;
        if (i < this.f484u.getLeft() + this.f478o) {
            i3 = 1;
        }
        if (i2 < this.f484u.getTop() + this.f478o) {
            i3 |= 4;
        }
        if (i > this.f484u.getRight() - this.f478o) {
            i3 |= 2;
        }
        if (i2 > this.f484u.getBottom() - this.f478o) {
            return i3 | 8;
        }
        return i3;
    }
}
