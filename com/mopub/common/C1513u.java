package com.mopub.common;

import com.mopub.common.p050b.C1478a;
import com.mopub.common.p050b.C1486i;
import org.apache.http.client.methods.HttpGet;

/* compiled from: HttpClient */
class C1513u implements Runnable {
    private final /* synthetic */ Iterable f2200a;
    private final /* synthetic */ C1507o f2201b;

    C1513u(Iterable iterable, C1507o c1507o) {
        this.f2200a = iterable;
        this.f2201b = c1507o;
    }

    public void run() {
        for (String str : this.f2200a) {
            try {
                HttpGet httpGet = new HttpGet(str);
                C1478a.m4050a(new C1506n(this.f2201b), httpGet);
            } catch (Exception e) {
                C1486i.m4076a("Failed to hit tracking endpoint: " + str);
            }
        }
    }
}
