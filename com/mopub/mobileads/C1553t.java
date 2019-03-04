package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;

/* compiled from: HtmlBannerWebView */
class C1553t implements HtmlWebViewListener {
    private final CustomEventBannerListener f2544a;

    public C1553t(CustomEventBannerListener customEventBannerListener) {
        this.f2544a = customEventBannerListener;
    }

    public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
        this.f2544a.onBannerLoaded(baseHtmlWebView);
    }

    public void onFailed(MoPubErrorCode moPubErrorCode) {
        this.f2544a.onBannerFailed(moPubErrorCode);
    }

    public void onClicked() {
        this.f2544a.onBannerClicked();
    }

    public void onCollapsed() {
        this.f2544a.onBannerCollapsed();
    }
}
