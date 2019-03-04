package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* compiled from: HtmlInterstitialWebView */
class C1554u implements MoPubUriJavascriptFireFinishLoadListener {
    final /* synthetic */ HtmlInterstitialWebView f2545a;
    private final /* synthetic */ CustomEventInterstitialListener f2546b;

    C1554u(HtmlInterstitialWebView htmlInterstitialWebView, CustomEventInterstitialListener customEventInterstitialListener) {
        this.f2545a = htmlInterstitialWebView;
        this.f2546b = customEventInterstitialListener;
    }

    public void onInterstitialLoaded() {
        if (!this.f2545a.a) {
            this.f2546b.onInterstitialLoaded();
        }
    }
}
