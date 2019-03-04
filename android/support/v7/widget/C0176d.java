package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChildHelper */
class C0176d {
    final C0172f f665a;
    final C0177e f666b = new C0177e();
    final List<View> f667c = new ArrayList();

    C0176d(C0172f c0172f) {
        this.f665a = c0172f;
    }

    void m1737a(View view, boolean z) {
        m1736a(view, -1, z);
    }

    void m1736a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.f665a.mo426a();
        } else {
            a = m1730e(i);
        }
        this.f665a.mo429a(view, a);
        this.f666b.m1750a(a, z);
        if (z) {
            this.f667c.add(view);
        }
    }

    private int m1730e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f665a.mo426a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f666b.m1754e(i2));
            if (e == 0) {
                while (this.f666b.m1752c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void m1734a(View view) {
        int a = this.f665a.mo427a(view);
        if (a >= 0) {
            this.f665a.mo428a(a);
            if (this.f666b.m1753d(a)) {
                this.f667c.remove(view);
            }
        }
    }

    void m1733a(int i) {
        int e = m1730e(i);
        View b = this.f665a.mo432b(e);
        if (b != null) {
            this.f665a.mo428a(e);
            if (this.f666b.m1753d(e)) {
                this.f667c.remove(b);
            }
        }
    }

    View m1740b(int i) {
        return this.f665a.mo432b(m1730e(i));
    }

    void m1732a() {
        this.f665a.mo433b();
        this.f666b.m1748a();
        this.f667c.clear();
    }

    View m1731a(int i, int i2) {
        int size = this.f667c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f667c.get(i3);
            bg b = this.f665a.mo431b(view);
            if (b.m1678d() == i && !b.m1687m() && (i2 == -1 || b.m1680f() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m1735a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.f665a.mo426a();
        } else {
            a = m1730e(i);
        }
        this.f665a.mo430a(view, a, layoutParams);
        this.f666b.m1750a(a, z);
        if (z) {
            this.f667c.add(view);
        }
    }

    int m1738b() {
        return this.f665a.mo426a() - this.f667c.size();
    }

    int m1741c() {
        return this.f665a.mo426a();
    }

    View m1742c(int i) {
        return this.f665a.mo432b(i);
    }

    void m1744d(int i) {
        int e = m1730e(i);
        this.f665a.mo434c(e);
        this.f666b.m1753d(e);
    }

    int m1739b(View view) {
        int a = this.f665a.mo427a(view);
        if (a == -1 || this.f666b.m1752c(a)) {
            return -1;
        }
        return a - this.f666b.m1754e(a);
    }

    boolean m1743c(View view) {
        return this.f667c.contains(view);
    }

    void m1745d(View view) {
        int a = this.f665a.mo427a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f666b.m1749a(a);
        this.f667c.add(view);
    }

    public String toString() {
        return this.f666b.toString() + ", hidden list:" + this.f667c.size();
    }

    boolean m1746e(View view) {
        int a = this.f665a.mo427a(view);
        if (a == -1) {
            return this.f667c.remove(view) ? true : true;
        } else {
            if (!this.f666b.m1752c(a)) {
                return false;
            }
            this.f666b.m1753d(a);
            this.f665a.mo428a(a);
            return !this.f667c.remove(view) ? true : true;
        }
    }
}
