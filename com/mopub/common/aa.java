package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MoPubBrowser */
class aa implements OnClickListener {
    final /* synthetic */ MoPubBrowser f2143a;

    aa(MoPubBrowser moPubBrowser) {
        this.f2143a = moPubBrowser;
    }

    public void onClick(View view) {
        if (this.f2143a.f2127a.canGoBack()) {
            this.f2143a.f2127a.goBack();
        }
    }
}
