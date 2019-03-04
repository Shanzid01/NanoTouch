package com.slideme.sam.manager.net.wrappers;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ReviewListResponse;
import java.util.List;

/* compiled from: ReviewLoader */
class C1904q extends C1600v {
    final /* synthetic */ C1903p f3489a;

    C1904q(C1903p c1903p) {
        this.f3489a = c1903p;
    }

    public void mo4234b() {
        this.f3489a.f3483a = true;
    }

    public void mo4231a() {
        this.f3489a.f3483a = false;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        List list = ((ReviewListResponse) baseNetworkResponse).review;
        if (list == null) {
            this.f3489a.f3485c = 0;
            return;
        }
        this.f3489a.f3486d.addAll(list);
        this.f3489a.f3485c = list.size();
        list.clear();
        this.f3489a.f3488f.mo4232a(baseNetworkResponse);
    }
}
