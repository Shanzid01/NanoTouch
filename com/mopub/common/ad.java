package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MoPubBrowser */
class ad implements OnClickListener {
    final /* synthetic */ MoPubBrowser f2146a;

    ad(MoPubBrowser moPubBrowser) {
        this.f2146a = moPubBrowser;
    }

    public void onClick(View view) {
        this.f2146a.finish();
    }
}
