package com.slideme.sam.manager.view.touchme;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ReviewListResponse;

/* compiled from: ReviewListView */
class ai extends C1600v {
    final /* synthetic */ ReviewListView f3775a;

    ai(ReviewListView reviewListView) {
        this.f3775a = reviewListView;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        this.f3775a.f3741d = ((ReviewListResponse) baseNetworkResponse).review;
        this.f3775a.m6020b();
        this.f3775a.m6021a();
    }

    public void mo4233a(Throwable th, String str) {
        super.mo4233a(th, str);
    }
}
