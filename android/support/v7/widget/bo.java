package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import java.util.ArrayList;

/* compiled from: StaggeredGridLayoutManager */
class bo {
    int f656a;
    int f657b;
    int f658c;
    final int f659d;
    final /* synthetic */ StaggeredGridLayoutManager f660e;
    private ArrayList<View> f661f;

    int m1712a(int i) {
        if (this.f656a != Integer.MIN_VALUE) {
            return this.f656a;
        }
        if (this.f661f.size() == 0) {
            return i;
        }
        m1713a();
        return this.f656a;
    }

    void m1713a() {
        View view = (View) this.f661f.get(0);
        LayoutParams c = m1719c(view);
        this.f656a = this.f660e.f546a.mo416a(view);
        if (c.f530b) {
            FullSpanItem f = this.f660e.f551f.m1371f(c.getViewPosition());
            if (f != null && f.f532b == -1) {
                this.f656a -= f.m1356a(this.f659d);
            }
        }
    }

    int m1716b() {
        if (this.f656a != Integer.MIN_VALUE) {
            return this.f656a;
        }
        m1713a();
        return this.f656a;
    }

    int m1717b(int i) {
        if (this.f657b != Integer.MIN_VALUE) {
            return this.f657b;
        }
        if (this.f661f.size() == 0) {
            return i;
        }
        m1720c();
        return this.f657b;
    }

    void m1720c() {
        View view = (View) this.f661f.get(this.f661f.size() - 1);
        LayoutParams c = m1719c(view);
        this.f657b = this.f660e.f546a.mo418b(view);
        if (c.f530b) {
            FullSpanItem f = this.f660e.f551f.m1371f(c.getViewPosition());
            if (f != null && f.f532b == 1) {
                this.f657b = f.m1356a(this.f659d) + this.f657b;
            }
        }
    }

    int m1722d() {
        if (this.f657b != Integer.MIN_VALUE) {
            return this.f657b;
        }
        m1720c();
        return this.f657b;
    }

    void m1714a(View view) {
        LayoutParams c = m1719c(view);
        c.f529a = this;
        this.f661f.add(0, view);
        this.f656a = Integer.MIN_VALUE;
        if (this.f661f.size() == 1) {
            this.f657b = Integer.MIN_VALUE;
        }
        if (c.isItemRemoved() || c.isItemChanged()) {
            this.f658c += this.f660e.f546a.mo420c(view);
        }
    }

    void m1718b(View view) {
        LayoutParams c = m1719c(view);
        c.f529a = this;
        this.f661f.add(view);
        this.f657b = Integer.MIN_VALUE;
        if (this.f661f.size() == 1) {
            this.f656a = Integer.MIN_VALUE;
        }
        if (c.isItemRemoved() || c.isItemChanged()) {
            this.f658c += this.f660e.f546a.mo420c(view);
        }
    }

    void m1715a(boolean z, int i) {
        int b;
        if (z) {
            b = m1717b(Integer.MIN_VALUE);
        } else {
            b = m1712a(Integer.MIN_VALUE);
        }
        m1724e();
        if (b != Integer.MIN_VALUE) {
            if (z && b < this.f660e.f546a.mo421d()) {
                return;
            }
            if (z || b <= this.f660e.f546a.mo419c()) {
                if (i != Integer.MIN_VALUE) {
                    b += i;
                }
                this.f657b = b;
                this.f656a = b;
            }
        }
    }

    void m1724e() {
        this.f661f.clear();
        m1725f();
        this.f658c = 0;
    }

    void m1725f() {
        this.f656a = Integer.MIN_VALUE;
        this.f657b = Integer.MIN_VALUE;
    }

    void m1721c(int i) {
        this.f656a = i;
        this.f657b = i;
    }

    void m1726g() {
        int size = this.f661f.size();
        View view = (View) this.f661f.remove(size - 1);
        LayoutParams c = m1719c(view);
        c.f529a = null;
        if (c.isItemRemoved() || c.isItemChanged()) {
            this.f658c -= this.f660e.f546a.mo420c(view);
        }
        if (size == 1) {
            this.f656a = Integer.MIN_VALUE;
        }
        this.f657b = Integer.MIN_VALUE;
    }

    void m1727h() {
        View view = (View) this.f661f.remove(0);
        LayoutParams c = m1719c(view);
        c.f529a = null;
        if (this.f661f.size() == 0) {
            this.f657b = Integer.MIN_VALUE;
        }
        if (c.isItemRemoved() || c.isItemChanged()) {
            this.f658c -= this.f660e.f546a.mo420c(view);
        }
        this.f656a = Integer.MIN_VALUE;
    }

    public int m1728i() {
        return this.f658c;
    }

    LayoutParams m1719c(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    void m1723d(int i) {
        if (this.f656a != Integer.MIN_VALUE) {
            this.f656a += i;
        }
        if (this.f657b != Integer.MIN_VALUE) {
            this.f657b += i;
        }
    }
}
