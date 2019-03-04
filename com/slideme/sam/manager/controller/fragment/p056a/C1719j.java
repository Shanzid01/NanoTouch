package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.view.p064a.C1940j;

/* compiled from: ApplicationListFragment */
class C1719j extends C1600v {
    final /* synthetic */ C1708i f2963a;

    C1719j(C1708i c1708i) {
        this.f2963a = c1708i;
    }

    public void mo4234b() {
        if (this.f2963a.f2910g.m5693i().size() == 0) {
            this.f2963a.mo4260a(false);
        }
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        C1940j c1940j = this.f2963a.f2907d;
        boolean z = !this.f2963a.f2910g.m5668a() && this.f2963a.mo4258a();
        c1940j.m5843a(z);
        this.f2963a.f2907d.notifyDataSetChanged();
    }

    public void mo4231a() {
        this.f2963a.mo4260a(true);
    }
}
