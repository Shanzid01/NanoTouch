package com.slideme.sam.manager.controller.fragment.p057b;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: WebViewFragment */
class C1749n implements OnKeyListener {
    final /* synthetic */ C1746k f3104a;

    C1749n(C1746k c1746k) {
        this.f3104a = c1746k;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || this.f3104a.f3100b == null || !this.f3104a.f3100b.canGoBack()) {
            return false;
        }
        this.f3104a.f3100b.goBack();
        return true;
    }
}
