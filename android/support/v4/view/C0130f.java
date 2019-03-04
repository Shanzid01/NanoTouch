package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p005a.C0098e;
import android.support.v4.view.p005a.C0113t;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
class C0130f implements C0129m {
    final /* synthetic */ C0120a f257a;
    final /* synthetic */ C0128e f258b;

    C0130f(C0128e c0128e, C0120a c0120a) {
        this.f258b = c0128e;
        this.f257a = c0120a;
    }

    public boolean mo322a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f257a.mo361b(view, accessibilityEvent);
    }

    public void mo324b(View view, AccessibilityEvent accessibilityEvent) {
        this.f257a.mo305d(view, accessibilityEvent);
    }

    public void mo320a(View view, Object obj) {
        this.f257a.mo303a(view, new C0098e(obj));
    }

    public void mo325c(View view, AccessibilityEvent accessibilityEvent) {
        this.f257a.m498c(view, accessibilityEvent);
    }

    public boolean mo323a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f257a.mo350a(viewGroup, view, accessibilityEvent);
    }

    public void mo319a(View view, int i) {
        this.f257a.m492a(view, i);
    }

    public void mo326d(View view, AccessibilityEvent accessibilityEvent) {
        this.f257a.m494a(view, accessibilityEvent);
    }

    public Object mo318a(View view) {
        C0113t a = this.f257a.m490a(view);
        return a != null ? a.m475a() : null;
    }

    public boolean mo321a(View view, int i, Bundle bundle) {
        return this.f257a.mo304a(view, i, bundle);
    }
}
