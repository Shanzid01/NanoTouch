package com.slideme.sam.manager.net;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.slideme.sam.manager.util.C1922m;
import org.apache.http.Header;

/* compiled from: NetworkUtils */
class C1868b extends AsyncHttpResponseHandler {
    String f3382a;
    String f3383b = "";
    String f3384c = "";
    int f3385d = 200;
    private final /* synthetic */ AsyncHttpResponseHandler f3386e;

    C1868b(String str, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.f3386e = asyncHttpResponseHandler;
        this.f3382a = AsyncHttpClient.getUrlWithQueryString(str, requestParams);
    }

    public void onSuccess(String str) {
        this.f3383b = str;
        this.f3386e.onSuccess(str);
    }

    public void onSuccess(int i, String str) {
        this.f3385d = i;
        this.f3383b = str;
        this.f3386e.onSuccess(i, str);
    }

    public void onSuccess(int i, Header[] headerArr, String str) {
        this.f3385d = i;
        this.f3383b = str;
        this.f3386e.onSuccess(i, headerArr, str);
    }

    @Deprecated
    public void onFailure(Throwable th) {
        this.f3384c = th.toString();
        this.f3386e.onFailure(th);
    }

    public void onFailure(Throwable th, String str) {
        this.f3384c = th.toString();
        this.f3383b = str;
        this.f3386e.onFailure(th, str);
    }

    public void onFinish() {
        if (TextUtils.isEmpty(this.f3384c)) {
            C1922m.m5797b("SAM Network", this.f3382a);
            C1922m.m5797b("SAM Network", this.f3383b);
        } else {
            C1922m.m5797b("SAM Network", this.f3382a);
            C1922m.m5797b("SAM Network", this.f3383b);
            C1922m.m5797b("SAM Network", this.f3384c);
        }
        this.f3386e.onFinish();
    }
}
