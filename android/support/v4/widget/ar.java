package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.C0120a;
import android.support.v4.view.ay;
import android.support.v4.view.p005a.C0098e;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: SlidingPaneLayout */
class ar extends C0120a {
    final /* synthetic */ SlidingPaneLayout f441b;
    private final Rect f442c = new Rect();

    ar(SlidingPaneLayout slidingPaneLayout) {
        this.f441b = slidingPaneLayout;
    }

    public void mo303a(View view, C0098e c0098e) {
        C0098e a = C0098e.m235a(c0098e);
        super.mo303a(view, a);
        m1142a(c0098e, a);
        a.m281t();
        c0098e.m249b(SlidingPaneLayout.class.getName());
        c0098e.m242a(view);
        ViewParent i = ay.m589i(view);
        if (i instanceof View) {
            c0098e.m254c((View) i);
        }
        int childCount = this.f441b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f441b.getChildAt(i2);
            if (!m1145b(childAt) && childAt.getVisibility() == 0) {
                ay.m579c(childAt, 1);
                c0098e.m248b(childAt);
            }
        }
    }

    public void mo305d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo305d(view, accessibilityEvent);
        accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }

    public boolean mo350a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (m1145b(view)) {
            return false;
        }
        return super.mo350a(viewGroup, view, accessibilityEvent);
    }

    public boolean m1145b(View view) {
        return this.f441b.m999e(view);
    }

    private void m1142a(C0098e c0098e, C0098e c0098e2) {
        Rect rect = this.f442c;
        c0098e2.m241a(rect);
        c0098e.m247b(rect);
        c0098e2.m253c(rect);
        c0098e.m258d(rect);
        c0098e.m257c(c0098e2.m268h());
        c0098e.m243a(c0098e2.m277p());
        c0098e.m249b(c0098e2.m278q());
        c0098e.m255c(c0098e2.m280s());
        c0098e.m267h(c0098e2.m274m());
        c0098e.m263f(c0098e2.m272k());
        c0098e.m244a(c0098e2.m264f());
        c0098e.m251b(c0098e2.m266g());
        c0098e.m259d(c0098e2.m270i());
        c0098e.m261e(c0098e2.m271j());
        c0098e.m265g(c0098e2.m273l());
        c0098e.m240a(c0098e2.m245b());
        c0098e.m246b(c0098e2.m252c());
    }
}
