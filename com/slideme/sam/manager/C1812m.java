package com.slideme.sam.manager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.WalletResponse;

/* compiled from: SAM */
class C1812m extends C1600v {
    private final /* synthetic */ Context f3243a;

    C1812m(Context context) {
        this.f3243a = context;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        AuthData.m4802a(this.f3243a, ((WalletResponse) baseNetworkResponse).balance);
        C0090q.m145a(this.f3243a).m150a(new Intent("com.slideme.sam.manager.ACTION_WALLET_REFRESH_FINISHED"));
    }
}
