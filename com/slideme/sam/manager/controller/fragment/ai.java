package com.slideme.sam.manager.controller.fragment;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.DynamicContainerResponse;

/* compiled from: DynamicLayoutFragment */
class ai extends C1600v {
    final /* synthetic */ ae f3043a;

    ai(ae aeVar) {
        this.f3043a = aeVar;
    }

    public void mo4234b() {
        this.f3043a.m5230a(true);
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        this.f3043a.f3031e = ((DynamicContainerResponse) baseNetworkResponse).layout;
        new al(this.f3043a).execute(new Void[0]);
    }
}
