package com.slideme.sam.manager.controller.activities.access;

import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.aq;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.RegisterResponse;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: RegisterActivity */
class C1646j extends C1600v {
    final /* synthetic */ RegisterActivity f2771a;

    C1646j(RegisterActivity registerActivity) {
        this.f2771a = registerActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        if (((RegisterResponse) baseNetworkResponse).resp.success) {
            C0345b.m2427c().m2434a(new aq().m2418a("SlideME").m2419a(true));
            this.f2771a.m4819a(this.f2771a.f2748f.m6053a().toString(), this.f2771a.f2749g.m6053a().toString());
            return;
        }
        C1920k.m5781a(this.f2771a, (int) R.string.general_reg_fail, 0).show();
    }

    public void mo4233a(Throwable th, String str) {
        super.mo4233a(th, str);
        this.f2771a.mo4228a(false);
    }
}
