package android.support.v4.widget;

import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

/* compiled from: DrawerLayout */
class C0163r extends bm {
    final /* synthetic */ DrawerLayout f495a;
    private final int f496b;
    private bj f497c;
    private final Runnable f498d = new C0164s(this);

    public C0163r(DrawerLayout drawerLayout, int i) {
        this.f495a = drawerLayout;
        this.f496b = i;
    }

    public void m1250a(bj bjVar) {
        this.f497c = bjVar;
    }

    public void m1247a() {
        this.f495a.removeCallbacks(this.f498d);
    }

    public boolean mo356a(View view, int i) {
        return this.f495a.m963g(view) && this.f495a.m949a(view, this.f496b) && this.f495a.m941a(view) == 0;
    }

    public void mo353a(int i) {
        this.f495a.m944a(this.f496b, i, this.f497c.m1213c());
    }

    public void mo355a(View view, int i, int i2, int i3, int i4) {
        float f;
        int width = view.getWidth();
        if (this.f495a.m949a(view, 3)) {
            f = ((float) (width + i)) / ((float) width);
        } else {
            f = ((float) (this.f495a.getWidth() - i)) / ((float) width);
        }
        this.f495a.m953b(view, f);
        view.setVisibility(f == 0.0f ? 4 : 0);
        this.f495a.invalidate();
    }

    public void mo359b(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).f297c = false;
        m1243b();
    }

    private void m1243b() {
        int i = 3;
        if (this.f496b == 3) {
            i = 5;
        }
        View b = this.f495a.m950b(i);
        if (b != null) {
            this.f495a.m965i(b);
        }
    }

    public void mo354a(View view, float f, float f2) {
        int i;
        float d = this.f495a.m956d(view);
        int width = view.getWidth();
        if (this.f495a.m949a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.f495a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.f497c.m1203a(i, view.getTop());
        this.f495a.invalidate();
    }

    public void mo366a(int i, int i2) {
        this.f495a.postDelayed(this.f498d, 160);
    }

    private void m1244c() {
        View view;
        int i;
        int i2 = 0;
        int b = this.f497c.m1207b();
        boolean z = this.f496b == 3;
        if (z) {
            View b2 = this.f495a.m950b(3);
            if (b2 != null) {
                i2 = -b2.getWidth();
            }
            i2 += b;
            view = b2;
            i = i2;
        } else {
            i2 = this.f495a.getWidth() - b;
            view = this.f495a.m950b(5);
            i = i2;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f495a.m941a(view) == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f497c.m1205a(view, i, view.getTop());
            layoutParams.f297c = true;
            this.f495a.invalidate();
            m1243b();
            this.f495a.m954c();
        }
    }

    public boolean mo367b(int i) {
        return false;
    }

    public void mo358b(int i, int i2) {
        View b;
        if ((i & 1) == 1) {
            b = this.f495a.m950b(3);
        } else {
            b = this.f495a.m950b(5);
        }
        if (b != null && this.f495a.m941a(b) == 0) {
            this.f497c.m1202a(b, i2);
        }
    }

    public int mo351a(View view) {
        return this.f495a.m963g(view) ? view.getWidth() : 0;
    }

    public int mo352a(View view, int i, int i2) {
        if (this.f495a.m949a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f495a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public int mo357b(View view, int i, int i2) {
        return view.getTop();
    }
}
