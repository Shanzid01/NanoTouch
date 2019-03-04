package android.support.v4.view;

import android.support.v4.view.p005a.C0098e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
class C0127c implements C0126j {
    final /* synthetic */ C0120a f232a;
    final /* synthetic */ C0125b f233b;

    C0127c(C0125b c0125b, C0120a c0120a) {
        this.f233b = c0125b;
        this.f232a = c0120a;
    }

    public boolean mo298a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f232a.mo361b(view, accessibilityEvent);
    }

    public void mo300b(View view, AccessibilityEvent accessibilityEvent) {
        this.f232a.mo305d(view, accessibilityEvent);
    }

    public void mo297a(View view, Object obj) {
        this.f232a.mo303a(view, new C0098e(obj));
    }

    public void mo301c(View view, AccessibilityEvent accessibilityEvent) {
        this.f232a.m498c(view, accessibilityEvent);
    }

    public boolean mo299a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f232a.mo350a(viewGroup, view, accessibilityEvent);
    }

    public void mo296a(View view, int i) {
        this.f232a.m492a(view, i);
    }

    public void mo302d(View view, AccessibilityEvent accessibilityEvent) {
        this.f232a.m494a(view, accessibilityEvent);
    }
}
