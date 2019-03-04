package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.BaseMraidListener;
import com.mopub.mobileads.MraidView.ViewState;

/* compiled from: MraidActivity */
class ai extends BaseMraidListener {
    final /* synthetic */ MraidActivity f2407a;

    ai(MraidActivity mraidActivity) {
        this.f2407a = mraidActivity;
    }

    public void onReady(MraidView mraidView) {
        this.f2407a.f2347a.loadUrl(C1545o.WEB_VIEW_DID_APPEAR.getUrl());
        this.f2407a.m4325c();
    }

    public void onOpen(MraidView mraidView) {
        C1552s.m4654a(this.f2407a, this.f2407a.m4324b(), "com.mopub.action.interstitial.click");
    }

    public void onClose(MraidView mraidView, ViewState viewState) {
        this.f2407a.f2347a.loadUrl(C1545o.WEB_VIEW_DID_CLOSE.getUrl());
        this.f2407a.finish();
    }
}
