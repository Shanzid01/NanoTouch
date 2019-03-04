package com.mopub.mobileads;

import android.util.Log;
import com.mopub.mobileads.p051a.C1530j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

/* compiled from: AdViewController */
class C1539h implements Runnable {
    final /* synthetic */ AdViewController f2510a;

    C1539h(AdViewController adViewController) {
        this.f2510a = adViewController;
    }

    public void run() {
        if (this.f2510a.f2264h.m4196i() != null) {
            DefaultHttpClient a = C1530j.m4491a();
            try {
                HttpUriRequest httpGet = new HttpGet(this.f2510a.f2264h.m4196i());
                httpGet.addHeader("User-Agent", this.f2510a.f2264h.m4204q());
                a.execute(httpGet);
            } catch (Throwable e) {
                Log.d("MoPub", "Impression tracking failed : " + this.f2510a.f2264h.m4196i(), e);
            } finally {
                a.getConnectionManager().shutdown();
            }
        }
    }
}
