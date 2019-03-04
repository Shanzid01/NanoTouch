package com.slideme.sam.manager.view.touchme;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;

/* compiled from: ApplicationListView */
class C1968a extends C1600v {
    final /* synthetic */ ApplicationListView f3769a;

    C1968a(ApplicationListView applicationListView) {
        this.f3769a = applicationListView;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        if (this.f3769a.f3648c != null) {
            if (this.f3769a.f3648c.m5668a()) {
                this.f3769a.m5906a();
            } else {
                this.f3769a.f3648c.m5685f();
            }
        }
    }
}
