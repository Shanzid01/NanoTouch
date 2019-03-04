package com.mopub.common;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: MoPubBrowser */
class C1518z extends WebChromeClient {
    final /* synthetic */ MoPubBrowser f2203a;

    C1518z(MoPubBrowser moPubBrowser) {
        this.f2203a = moPubBrowser;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.f2203a.setTitle("Loading...");
        this.f2203a.setProgress(i * 100);
        if (i == 100) {
            this.f2203a.setTitle(webView.getUrl());
        }
    }
}
