package com.slideme.sam.manager.net;

import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ScorecardResponse;

/* compiled from: NetworkUtils */
class C1869c extends C1600v {
    final /* synthetic */ C1867a f3387a;
    private final /* synthetic */ C1599q f3388b;

    C1869c(C1867a c1867a, C1599q c1599q) {
        this.f3387a = c1867a;
        this.f3388b = c1599q;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        ScorecardResponse scorecardResponse = (ScorecardResponse) baseNetworkResponse;
        this.f3387a.m5642d(scorecardResponse.id, new C1870d(this, scorecardResponse, this.f3388b));
    }
}
