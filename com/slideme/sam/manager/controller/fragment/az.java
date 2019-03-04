package com.slideme.sam.manager.controller.fragment;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;

/* compiled from: ReviewListFragment */
class az extends C1600v {
    final /* synthetic */ ay f3073a;

    az(ay ayVar) {
        this.f3073a = ayVar;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        this.f3073a.f3072f.m5847a(this.f3073a.m5270a());
        this.f3073a.f3072f.notifyDataSetChanged();
        this.f3073a.setListShown(true);
    }
}
