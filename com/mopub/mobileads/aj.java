package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.OnCloseButtonStateChangeListener;

/* compiled from: MraidActivity */
class aj implements OnCloseButtonStateChangeListener {
    final /* synthetic */ MraidActivity f2408a;

    aj(MraidActivity mraidActivity) {
        this.f2408a = mraidActivity;
    }

    public void onCloseButtonStateChange(MraidView mraidView, boolean z) {
        if (z) {
            this.f2408a.m4325c();
        } else {
            this.f2408a.m4326d();
        }
    }
}
