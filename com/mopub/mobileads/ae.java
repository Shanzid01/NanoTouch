package com.mopub.mobileads;

import android.util.Log;
import com.mopub.mobileads.p051a.C1530j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* compiled from: MoPubConversionTracker */
class ae implements Runnable {
    final /* synthetic */ MoPubConversionTracker f2405a;

    private ae(MoPubConversionTracker moPubConversionTracker) {
        this.f2405a = moPubConversionTracker;
    }

    public void run() {
        String k = new ad(this.f2405a).mo4136k("ads.mopub.com");
        Log.d("MoPub", "Conversion track: " + k);
        try {
            HttpResponse execute = C1530j.m4491a().execute(new HttpGet(k));
            if (execute.getStatusLine().getStatusCode() != 200) {
                Log.d("MoPub", "Conversion track failed: Status code != 200.");
                return;
            }
            HttpEntity entity = execute.getEntity();
            if (entity == null || entity.getContentLength() == 0) {
                Log.d("MoPub", "Conversion track failed: Response was empty.");
                return;
            }
            Log.d("MoPub", "Conversion track successful.");
            this.f2405a.f2324c.edit().putBoolean(this.f2405a.f2323b, true).commit();
        } catch (Exception e) {
            Log.d("MoPub", "Conversion track failed [" + e.getClass().getSimpleName() + "]: " + k);
        }
    }
}
