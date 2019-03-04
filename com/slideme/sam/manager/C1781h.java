package com.slideme.sam.manager;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.model.p054b.C1829c;
import javax.net.ssl.SSLException;

/* compiled from: SAM */
class C1781h extends AsyncHttpResponseHandler {
    final /* synthetic */ SAM f3176a;

    C1781h(SAM sam) {
        this.f3176a = sam;
    }

    public void onSuccess(String str) {
        SAM.f2613f.m5442a(false);
        C0345b.m2427c().m2437a((C0359q) ((C0359q) ((C0359q) ((C0359q) new C0359q("SSL Check OK").m2364a("Model", C1829c.m5499a())).m2364a("Board", C1829c.m5502d())).m2364a("Manufacturer", C1829c.m5503e())).m2364a("Brand", C1829c.m5500b()));
    }

    public void onFailure(Throwable th, String str) {
        if (th.getCause() instanceof SSLException) {
            SAM.f2613f.m5442a(true);
            C0345b.m2427c().m2437a((C0359q) ((C0359q) ((C0359q) ((C0359q) new C0359q("SSL Check FAIL").m2364a("Model", C1829c.m5499a())).m2364a("Board", C1829c.m5502d())).m2364a("Manufacturer", C1829c.m5503e())).m2364a("Brand", C1829c.m5500b()));
        }
    }
}
