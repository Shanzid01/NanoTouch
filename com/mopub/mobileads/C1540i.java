package com.mopub.mobileads;

import android.util.Log;
import com.mopub.mobileads.p051a.C1530j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

/* compiled from: AdViewController */
class C1540i implements Runnable {
    final /* synthetic */ AdViewController f2511a;

    C1540i(AdViewController adViewController) {
        this.f2511a = adViewController;
    }

    public void run() {
        if (this.f2511a.f2264h.m4194g() != null) {
            DefaultHttpClient a = C1530j.m4491a();
            try {
                Log.d("MoPub", "Tracking click for: " + this.f2511a.f2264h.m4194g());
                HttpUriRequest httpGet = new HttpGet(this.f2511a.f2264h.m4194g());
                httpGet.addHeader("User-Agent", this.f2511a.f2264h.m4204q());
                a.execute(httpGet);
            } catch (Throwable e) {
                Log.d("MoPub", "Click tracking failed: " + this.f2511a.f2264h.m4194g(), e);
            } finally {
                a.getConnectionManager().shutdown();
            }
        }
    }
}
