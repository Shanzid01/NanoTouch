package com.mopub.common;

import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.p050b.C1480c;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* compiled from: HttpClient */
public class C1511s {
    public static AndroidHttpClient m4151a() {
        AndroidHttpClient newInstance = AndroidHttpClient.newInstance(C1480c.m4055a());
        HttpParams params = newInstance.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, 10000);
        HttpClientParams.setRedirecting(params, true);
        return newInstance;
    }

    public static void m4152a(Iterable<String> iterable) {
        if (iterable != null) {
            new Handler(Looper.getMainLooper()).post(new C1513u(iterable, new C1512t()));
        }
    }
}
