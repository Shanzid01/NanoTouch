package com.slideme.sam.manager.net;

import com.slideme.sam.manager.model.data.test.ScoreCardItem;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.ScorecardResponse;
import com.slideme.sam.manager.util.C1922m;
import java.util.Iterator;

/* compiled from: NetworkUtils */
class C1870d extends C1600v {
    final /* synthetic */ C1869c f3389a;
    private final /* synthetic */ ScorecardResponse f3390b;
    private final /* synthetic */ C1599q f3391c;

    C1870d(C1869c c1869c, ScorecardResponse scorecardResponse, C1599q c1599q) {
        this.f3389a = c1869c;
        this.f3390b = scorecardResponse;
        this.f3391c = c1599q;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        ScorecardResponse scorecardResponse = (ScorecardResponse) baseNetworkResponse;
        if (!C1922m.m5794a(this.f3390b.global)) {
            Iterator it = scorecardResponse.global.iterator();
            while (it.hasNext()) {
                ScoreCardItem scoreCardItem = (ScoreCardItem) it.next();
                ScoreCardItem find = ScorecardResponse.find(this.f3390b.global, scoreCardItem.id);
                if (find != null) {
                    find.answer = scoreCardItem.answer;
                }
            }
        }
        this.f3391c.mo4232a(this.f3390b);
    }

    public void mo4233a(Throwable th, String str) {
        super.mo4233a(th, str);
        this.f3391c.mo4232a(this.f3390b);
    }
}
