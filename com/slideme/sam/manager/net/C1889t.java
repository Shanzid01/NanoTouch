package com.slideme.sam.manager.net;

import android.content.Context;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.slideme.sam.manager.util.C1922m;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: NetworkUtils */
class C1889t extends AsyncHttpClient {
    final /* synthetic */ C1867a f3408a;

    private C1889t(C1867a c1867a) {
        this.f3408a = c1867a;
    }

    public void post(Context context, String str, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        super.post(context, str, requestParams, C1867a.m5583b(str, requestParams, asyncHttpResponseHandler));
    }

    public void m5652a(Context context, String str, Object obj, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String a = C1867a.f3351b.m3678a(obj);
        C1922m.m5797b("SAM Network", a);
        try {
            HttpEntity stringEntity = new StringEntity(a);
            stringEntity.setContentType(new BasicHeader("Content-Type", "application/json; charset=utf-8"));
            super.post(context, str, stringEntity, "application/json; charset=utf-8", C1867a.m5583b(str, null, asyncHttpResponseHandler));
        } catch (Throwable e) {
            if (asyncHttpResponseHandler != null) {
                asyncHttpResponseHandler.onFailure(e);
            }
        }
    }

    public void get(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        super.get(str, null, C1867a.m5583b(str, null, asyncHttpResponseHandler));
    }

    public void get(String str, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        super.get(str, requestParams, C1867a.m5583b(str, requestParams, asyncHttpResponseHandler));
    }
}
