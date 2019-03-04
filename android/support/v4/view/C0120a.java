package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p005a.C0098e;
import android.support.v4.view.p005a.C0113t;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
public class C0120a {
    private static final C0123d f215b;
    private static final Object f216c = f215b.mo284a();
    final Object f217a = f215b.mo285a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            f215b = new C0128e();
        } else if (VERSION.SDK_INT >= 14) {
            f215b = new C0125b();
        } else {
            f215b = new C0124g();
        }
    }

    Object m491a() {
        return this.f217a;
    }

    public void m492a(View view, int i) {
        f215b.mo286a(f216c, view, i);
    }

    public void m494a(View view, AccessibilityEvent accessibilityEvent) {
        f215b.mo293d(f216c, view, accessibilityEvent);
    }

    public boolean mo361b(View view, AccessibilityEvent accessibilityEvent) {
        return f215b.mo289a(f216c, view, accessibilityEvent);
    }

    public void m498c(View view, AccessibilityEvent accessibilityEvent) {
        f215b.mo292c(f216c, view, accessibilityEvent);
    }

    public void mo305d(View view, AccessibilityEvent accessibilityEvent) {
        f215b.mo291b(f216c, view, accessibilityEvent);
    }

    public void mo303a(View view, C0098e c0098e) {
        f215b.mo287a(f216c, view, c0098e);
    }

    public boolean mo350a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f215b.mo290a(f216c, viewGroup, view, accessibilityEvent);
    }

    public C0113t m490a(View view) {
        return f215b.mo283a(f216c, view);
    }

    public boolean mo304a(View view, int i, Bundle bundle) {
        return f215b.mo288a(f216c, view, i, bundle);
    }
}
