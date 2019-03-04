package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* compiled from: MoPubActivity */
class aa implements CustomEventInterstitialListener {
    final /* synthetic */ MoPubActivity f2400a;

    aa(MoPubActivity moPubActivity) {
        this.f2400a = moPubActivity;
    }

    public void onInterstitialLoaded() {
        this.f2400a.f2321a.loadUrl(C1545o.WEB_VIEW_DID_APPEAR.getUrl());
    }

    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        C1552s.m4654a(this.f2400a, this.f2400a.m4324b(), "com.mopub.action.interstitial.fail");
        this.f2400a.finish();
    }

    public void onInterstitialShown() {
    }

    public void onInterstitialClicked() {
        C1552s.m4654a(this.f2400a, this.f2400a.m4324b(), "com.mopub.action.interstitial.click");
    }

    public void onLeaveApplication() {
    }

    public void onInterstitialDismissed() {
    }
}
