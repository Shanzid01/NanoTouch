package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* compiled from: MoPubActivity */
class C1574z extends WebViewClient {
    private final /* synthetic */ CustomEventInterstitialListener f2600a;

    C1574z(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f2600a = customEventInterstitialListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.equals("mopub://finishLoad")) {
            this.f2600a.onInterstitialLoaded();
        } else if (str.equals("mopub://failLoad")) {
            this.f2600a.onInterstitialFailed(null);
        }
        return true;
    }
}
