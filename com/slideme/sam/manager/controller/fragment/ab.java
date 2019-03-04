package com.slideme.sam.manager.controller.fragment;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;

/* compiled from: CategoryListFragment */
class ab extends C1600v {
    final /* synthetic */ aa f3023a;

    ab(aa aaVar) {
        this.f3023a = aaVar;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        if (this.f3023a.f3016b != null) {
            this.f3023a.f3018d.m5840a(this.f3023a.f3019e.m5692h());
            this.f3023a.f3018d.m5839a(this.f3023a.f3016b);
            this.f3023a.f3016b.setAdapter(this.f3023a.f3018d);
            this.f3023a.f3015a = false;
        }
    }
}
