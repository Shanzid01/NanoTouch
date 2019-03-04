package com.mopub.mobileads;

import android.util.Log;
import com.mopub.common.p050b.C1478a;
import com.mopub.mobileads.p051a.C1521a;

public class AdFetcher {
    private int f2252a = 10000;
    private AdViewController f2253b;
    private AdFetchTask f2254c;
    private String f2255d;
    private final TaskTracker f2256e;

    public AdFetcher(AdViewController adViewController, String str) {
        this.f2253b = adViewController;
        this.f2255d = str;
        this.f2256e = new TaskTracker();
    }

    public void m4224a(String str) {
        this.f2256e.m4414b();
        Log.i("MoPub", "Fetching ad for task #" + m4221c());
        if (this.f2254c != null) {
            this.f2254c.cancel(true);
        }
        this.f2254c = C1521a.m4473a(this.f2256e, this.f2253b, this.f2255d, this.f2252a);
        try {
            C1478a.m4050a(this.f2254c, str);
        } catch (Throwable e) {
            Log.d("MoPub", "Error executing AdFetchTask", e);
        }
    }

    public void m4222a() {
        if (this.f2254c != null) {
            Log.i("MoPub", "Canceling fetch ad for task #" + m4221c());
            this.f2254c.cancel(true);
        }
    }

    void m4225b() {
        m4222a();
        this.f2253b = null;
        this.f2255d = "";
    }

    protected void m4223a(int i) {
        this.f2252a = i;
    }

    private long m4221c() {
        return this.f2256e.m4412a();
    }
}
