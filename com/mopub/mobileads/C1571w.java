package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* compiled from: HtmlInterstitialWebView */
class C1571w implements HtmlWebViewListener {
    private final CustomEventInterstitialListener f2593a;

    public C1571w(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f2593a = customEventInterstitialListener;
    }

    public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
        this.f2593a.onInterstitialLoaded();
    }

    public void onFailed(MoPubErrorCode moPubErrorCode) {
        this.f2593a.onInterstitialFailed(moPubErrorCode);
    }

    public void onClicked() {
        this.f2593a.onInterstitialClicked();
    }

    public void onCollapsed() {
    }
}
