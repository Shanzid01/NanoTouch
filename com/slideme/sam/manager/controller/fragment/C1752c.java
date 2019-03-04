package com.slideme.sam.manager.controller.fragment;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

/* compiled from: ApplicationDetailsFragment */
class C1752c implements BannerAdListener {
    final /* synthetic */ C1735a f3121a;
    private final /* synthetic */ MoPubView f3122b;

    C1752c(C1735a c1735a, MoPubView moPubView) {
        this.f3121a = c1735a;
        this.f3122b = moPubView;
    }

    public void onBannerLoaded(MoPubView moPubView) {
        if (this.f3121a.f2977A != null) {
            this.f3121a.f2977A.setVisibility(0);
        }
        this.f3122b.setVisibility(0);
    }

    public void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode) {
        this.f3122b.setVisibility(8);
    }

    public void onBannerExpanded(MoPubView moPubView) {
    }

    public void onBannerCollapsed(MoPubView moPubView) {
    }

    public void onBannerClicked(MoPubView moPubView) {
    }
}
