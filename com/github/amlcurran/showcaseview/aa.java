package com.github.amlcurran.showcaseview;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ShowcaseView */
class aa implements OnGlobalLayoutListener {
    final /* synthetic */ ShowcaseView f1624a;

    private aa(ShowcaseView showcaseView) {
        this.f1624a = showcaseView;
    }

    public void onGlobalLayout() {
        if (!this.f1624a.f1603g.m3239a()) {
            this.f1624a.m3173g();
        }
    }
}
