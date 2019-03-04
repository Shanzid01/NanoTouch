package com.mopub.mobileads;

import com.mopub.common.C1510r;

/* compiled from: MoPubConversionTracker */
class ac implements C1510r {
    final /* synthetic */ MoPubConversionTracker f2403a;

    ac(MoPubConversionTracker moPubConversionTracker) {
        this.f2403a = moPubConversionTracker;
    }

    public void mo4137a() {
        new Thread(new ae(this.f2403a)).start();
    }
}
