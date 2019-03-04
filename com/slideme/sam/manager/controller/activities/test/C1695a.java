package com.slideme.sam.manager.controller.activities.test;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.cache.helper.TestModeCache;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: ApproveActivity */
class C1695a extends C1600v {
    final /* synthetic */ ApproveActivity f2889a;

    C1695a(ApproveActivity approveActivity) {
        this.f2889a = approveActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        TestModeCache testModeCache = new TestModeCache(this.f2889a);
        testModeCache.add(this.f2889a.f2879b.app.bundleId);
        testModeCache.close();
        C1920k.m5781a(this.f2889a, (int) R.string.post_results, 0).show();
    }

    public void mo4233a(Throwable th, String str) {
        C1920k.m5781a(this.f2889a, (int) R.string.error_occured, 0).show();
    }

    public void mo4231a() {
        this.f2889a.setSupportProgressBarIndeterminateVisibility(false);
        this.f2889a.f2880c = false;
        this.f2889a.finish();
    }
}
