package com.slideme.sam.manager.controller.fragment.p057b;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: WebBuyFragment */
class C1745j implements OnKeyListener {
    final /* synthetic */ C1742g f3098a;

    C1745j(C1742g c1742g) {
        this.f3098a = c1742g;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || this.f3098a.f3093b == null || !this.f3098a.f3093b.canGoBack()) {
            return false;
        }
        this.f3098a.f3093b.goBack();
        return true;
    }
}
