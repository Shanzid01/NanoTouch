package com.mopub.mobileads.p051a;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* compiled from: HttpClientFactory */
public class C1530j {
    private static C1530j f2398a = new C1530j();

    public static DefaultHttpClient m4492a(int i) {
        return f2398a.m4493b(i);
    }

    public static DefaultHttpClient m4491a() {
        return f2398a.m4493b(0);
    }

    protected DefaultHttpClient m4493b(int i) {
        HttpParams basicHttpParams = new BasicHttpParams();
        if (i > 0) {
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
            HttpConnectionParams.setSoTimeout(basicHttpParams, i);
        }
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        return new DefaultHttpClient(basicHttpParams);
    }
}
