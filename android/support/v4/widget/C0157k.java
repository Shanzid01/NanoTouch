package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.C0120a;
import android.support.v4.view.ay;
import android.support.v4.view.p005a.C0098e;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* compiled from: DrawerLayout */
class C0157k extends C0120a {
    final /* synthetic */ DrawerLayout f492b;
    private final Rect f493c = new Rect();

    C0157k(DrawerLayout drawerLayout) {
        this.f492b = drawerLayout;
    }

    public void mo303a(View view, C0098e c0098e) {
        if (DrawerLayout.f304c) {
            super.mo303a(view, c0098e);
        } else {
            C0098e a = C0098e.m235a(c0098e);
            super.mo303a(view, a);
            c0098e.m242a(view);
            ViewParent i = ay.m589i(view);
            if (i instanceof View) {
                c0098e.m254c((View) i);
            }
            m1221a(c0098e, a);
            a.m281t();
            m1222a(c0098e, (ViewGroup) view);
        }
        c0098e.m249b(DrawerLayout.class.getName());
    }

    public void mo305d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo305d(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    public boolean mo361b(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.mo361b(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View a = this.f492b.m937h();
        if (a != null) {
            CharSequence a2 = this.f492b.m943a(this.f492b.m958e(a));
            if (a2 != null) {
                text.add(a2);
            }
        }
        return true;
    }

    public boolean mo350a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.f304c || DrawerLayout.m940n(view)) {
            return super.mo350a(viewGroup, view, accessibilityEvent);
        }
        return false;
    }

    private void m1222a(C0098e c0098e, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (DrawerLayout.m940n(childAt)) {
                c0098e.m248b(childAt);
            }
        }
    }

    private void m1221a(C0098e c0098e, C0098e c0098e2) {
        Rect rect = this.f493c;
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
    }
}
