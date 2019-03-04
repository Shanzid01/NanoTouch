package com.slideme.sam.manager.controller.activities.common;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: FlipperFragmentActivity */
class C1664i extends C1600v {
    final /* synthetic */ C1663h f2795a;

    C1664i(C1663h c1663h) {
        this.f2795a = c1663h;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        C1922m.m5797b("Connect", "Device specs updated!");
        this.f2795a.f2794a.f2793a.f2646a.setDisplayedChild(C1665j.CONTENT.ordinal());
    }
}
