package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MoPubBrowser */
class ab implements OnClickListener {
    final /* synthetic */ MoPubBrowser f2144a;

    ab(MoPubBrowser moPubBrowser) {
        this.f2144a = moPubBrowser;
    }

    public void onClick(View view) {
        if (this.f2144a.f2127a.canGoForward()) {
            this.f2144a.f2127a.goForward();
        }
    }
}
