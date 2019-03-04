package com.slideme.sam.manager.controller.activities.market.catalog;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

/* compiled from: MainActivity */
class C1669d implements BannerAdListener {
    final /* synthetic */ MainActivity f2823a;
    private final /* synthetic */ MoPubView f2824b;

    C1669d(MainActivity mainActivity, MoPubView moPubView) {
        this.f2823a = mainActivity;
        this.f2824b = moPubView;
    }

    public void onBannerLoaded(MoPubView moPubView) {
        this.f2823a.f2810c.setVisibility(0);
        this.f2824b.setVisibility(0);
    }

    public void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode) {
        this.f2824b.setVisibility(8);
    }

    public void onBannerExpanded(MoPubView moPubView) {
    }

    public void onBannerCollapsed(MoPubView moPubView) {
    }

    public void onBannerClicked(MoPubView moPubView) {
    }
}
