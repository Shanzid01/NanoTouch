package com.slideme.sam.manager.controller.activities.access;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.RegisterResponse;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: SimpleRegisterActivity */
class C1650n extends C1600v {
    final /* synthetic */ C1649m f2775a;

    C1650n(C1649m c1649m) {
        this.f2775a = c1649m;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        RegisterResponse registerResponse = (RegisterResponse) baseNetworkResponse;
        if (registerResponse.resp.success) {
            this.f2775a.f2774a.m4819a(this.f2775a.f2774a.f2757f.m6053a().toString(), registerResponse.resp.password);
        } else {
            C1920k.m5781a(this.f2775a.f2774a, (int) R.string.general_reg_fail, 0).show();
        }
    }

    public void mo4231a() {
        this.f2775a.f2774a.m4926c(false);
    }
}
