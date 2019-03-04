package com.slideme.sam.manager.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: NetworkUtils */
class C1890u extends SyncHttpClient {
    final /* synthetic */ C1867a f3409a;

    private C1890u(C1867a c1867a) {
        this.f3409a = c1867a;
    }

    public String post(String str, RequestParams requestParams) {
        C1922m.m5797b("SAM Network", AsyncHttpClient.getUrlWithQueryString(str, requestParams));
        return super.post(str, requestParams);
    }

    public String get(String str, RequestParams requestParams) {
        C1922m.m5797b("SAM Network", AsyncHttpClient.getUrlWithQueryString(str, requestParams));
        return super.get(str, requestParams);
    }

    public String onRequestFailed(Throwable th, String str) {
        C1922m.m5797b("SAM Network", str);
        this.f3409a.m5582a(th, str);
        return str;
    }
}
