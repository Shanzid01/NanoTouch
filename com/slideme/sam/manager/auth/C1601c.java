package com.slideme.sam.manager.auth;

import android.content.Intent;
import com.facebook.Session;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.aq;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.LoginResponse;

/* compiled from: AuthenticatorActivity */
class C1601c extends C1600v {
    final /* synthetic */ AuthenticatorActivity f2662a;
    private final /* synthetic */ Session f2663b;

    C1601c(AuthenticatorActivity authenticatorActivity, Session session) {
        this.f2662a = authenticatorActivity;
        this.f2663b = session;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        AuthData authData = new AuthData(this.f2663b.getAccessToken(), ((LoginResponse) baseNetworkResponse).user);
        Intent intent = new Intent();
        intent.putExtra("authAccount", authData.f2650a.name);
        intent.putExtra("accountType", "com.slideme.user_account");
        intent.putExtra("authtoken", SAM.f2614g.m5596a());
        intent.putExtra("userdata", authData.m4816a());
        intent.putExtra("com.slideme.sam.manager.EXTRA_PASSWORD", "");
        C0345b.m2427c().m2434a(new aq().m2418a("Facebook").m2419a(true));
        this.f2662a.mo4241a(intent);
    }
}
