package com.mopub.mobileads.util.vast;

import com.mopub.mobileads.VastVideoDownloadTask.VastVideoDownloadTaskListener;

/* compiled from: VastManager */
class C1564b implements VastVideoDownloadTaskListener {
    final /* synthetic */ VastManager f2573a;
    private final /* synthetic */ C1565c f2574b;

    C1564b(VastManager vastManager, C1565c c1565c) {
        this.f2573a = vastManager;
        this.f2574b = c1565c;
    }

    public void onComplete(boolean z) {
        if (z && this.f2573a.m4677a(this.f2574b)) {
            if (this.f2573a.f2562c != null) {
                this.f2573a.f2562c.onVastVideoConfigurationPrepared(this.f2574b);
            }
        } else if (this.f2573a.f2562c != null) {
            this.f2573a.f2562c.onVastVideoConfigurationPrepared(null);
        }
    }
}
