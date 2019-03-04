package com.slideme.sam.manager.controller.activities.test;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: ScorecardActivity */
class C1697c extends C1600v {
    final /* synthetic */ ScorecardActivity f2891a;

    C1697c(ScorecardActivity scorecardActivity) {
        this.f2891a = scorecardActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        if (AuthData.m4806b(this.f2891a)) {
            this.f2891a.m5041i();
            C1920k.m5781a(this.f2891a, (int) R.string.score_sent, 0).show();
        }
    }

    public void mo4233a(Throwable th, String str) {
        C1920k.m5781a(this.f2891a, (int) R.string.score_fail, 0).show();
    }

    public void mo4231a() {
        this.f2891a.setSupportProgressBarIndeterminateVisibility(false);
        this.f2891a.f2883c = false;
        this.f2891a.finish();
    }
}
