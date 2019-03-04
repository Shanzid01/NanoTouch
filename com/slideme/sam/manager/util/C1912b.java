package com.slideme.sam.manager.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

/* compiled from: AAIDHelper */
class C1912b implements Runnable {
    private final /* synthetic */ Context f3491a;
    private final /* synthetic */ C1871c f3492b;

    C1912b(Context context, C1871c c1871c) {
        this.f3491a = context;
        this.f3492b = c1871c;
    }

    public void run() {
        String id;
        String str = "";
        boolean z = false;
        if (VERSION.SDK_INT > 8) {
            try {
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f3491a);
                id = advertisingIdInfo.getId();
                z = advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (Exception e) {
                C1922m.m5797b("AAIDHelper", e.getMessage());
                id = C1913d.m5763b(this.f3491a);
            }
        } else {
            id = C1913d.m5763b(this.f3491a);
        }
        this.f3492b.mo4310a(id, z);
    }
}
