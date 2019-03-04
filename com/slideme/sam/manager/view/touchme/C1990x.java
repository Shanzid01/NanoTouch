package com.slideme.sam.manager.view.touchme;

import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ReviewResponse;

/* compiled from: MyReview */
class C1990x extends C1600v {
    final /* synthetic */ MyReview f3853a;

    C1990x(MyReview myReview) {
        this.f3853a = myReview;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        this.f3853a.f3718e = ((ReviewResponse) baseNetworkResponse).getReview();
    }

    public void mo4231a() {
        if (this.f3853a.f3718e == null) {
            this.f3853a.f3718e = new Review();
        }
        this.f3853a.m5989c();
    }
}
