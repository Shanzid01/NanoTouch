package com.slideme.sam.manager.view.touchme;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ReviewChartResponse;

/* compiled from: ReviewChartView */
class ab extends C1600v {
    final /* synthetic */ ReviewChartView f3770a;

    ab(ReviewChartView reviewChartView) {
        this.f3770a = reviewChartView;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        ReviewChartResponse reviewChartResponse = (ReviewChartResponse) baseNetworkResponse;
        if (reviewChartResponse != null) {
            this.f3770a.f3727b = reviewChartResponse.breakdown;
            this.f3770a.m6010d();
        }
    }
}
