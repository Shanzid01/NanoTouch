package com.slideme.sam.manager.controller.activities.access;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.RegisterResponse;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: UpgradeProfileActivity */
class C1653q extends C1600v {
    final /* synthetic */ UpgradeProfileActivity f2782a;

    C1653q(UpgradeProfileActivity upgradeProfileActivity) {
        this.f2782a = upgradeProfileActivity;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        if (((RegisterResponse) baseNetworkResponse).resp.success) {
            AuthData.m4803a(this.f2782a, this.f2782a.f.m6053a().toString());
            AuthData.m4815k(this.f2782a);
            this.f2782a.finish();
            return;
        }
        C1920k.m5781a(this.f2782a, (int) R.string.general_reg_fail, 0).show();
    }

    public void mo4231a() {
        this.f2782a.mo4228a(false);
    }
}
