package com.slideme.sam.manager.controller.activities.test;

import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ScorecardResponse;

/* compiled from: ScorecardActivity */
class C1696b extends C1600v {
    final /* synthetic */ ScorecardActivity f2890a;

    C1696b(ScorecardActivity scorecardActivity) {
        this.f2890a = scorecardActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        ScorecardResponse scorecardResponse = (ScorecardResponse) baseNetworkResponse;
        this.f2890a.f2885e = scorecardResponse.global;
        this.f2890a.f2886f = scorecardResponse.developer;
        this.f2890a.f2887g = scorecardResponse.tester;
        this.f2890a.f2888h = scorecardResponse.id;
        this.f2890a.m5040h();
    }
}
