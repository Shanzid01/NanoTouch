package com.slideme.sam.manager.controller.fragment.p056a;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.util.C1922m;
import java.util.Iterator;

/* compiled from: AdProxyApplicationsListFragment */
class C1715e extends AsyncHttpResponseHandler {
    final /* synthetic */ C1709a f2949a;
    private final /* synthetic */ Catalog f2950b;

    C1715e(C1709a c1709a, Catalog catalog) {
        this.f2949a = c1709a;
        this.f2950b = catalog;
    }

    public void onSuccess(String str) {
        this.f2949a.m5101a(str);
        if (!C1922m.m5794a(this.f2949a.f2918i)) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f2949a.f2918i.iterator();
            while (it.hasNext()) {
                stringBuilder.append(new StringBuilder(String.valueOf(((AdProxyItem) it.next()).packageName)).append(",").toString());
            }
            this.f2950b.m5680d(true);
            this.f2950b.m5673c();
            this.f2950b.m5671b("pname:" + stringBuilder);
            this.f2950b.m5670b(this.f2949a.f2918i.size());
            this.f2950b.m5685f();
        }
        this.f2950b.m5671b("pname:somethinginvalidtoshownoapps");
        this.f2950b.m5670b(this.f2949a.f2918i.size());
        this.f2950b.m5685f();
    }

    public void onFailure(Throwable th, String str) {
        C1922m.m5790a(new Exception(str, th));
        this.f2949a.mo4260a(true);
    }
}
