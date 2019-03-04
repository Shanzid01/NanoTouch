package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p005a.C0113t;
import android.view.View;

/* compiled from: AccessibilityDelegateCompat */
class C0128e extends C0125b {
    C0128e() {
    }

    public Object mo285a(C0120a c0120a) {
        return C0133k.m890a(new C0130f(this, c0120a));
    }

    public C0113t mo283a(Object obj, View view) {
        Object a = C0133k.m891a(obj, view);
        if (a != null) {
            return new C0113t(a);
        }
        return null;
    }

    public boolean mo288a(Object obj, View view, int i, Bundle bundle) {
        return C0133k.m892a(obj, view, i, bundle);
    }
}
