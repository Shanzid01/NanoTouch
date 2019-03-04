package com.slideme.sam.manager;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.cache.CacheItem;
import com.slideme.sam.manager.util.cache.PreferenceCache;
import java.net.SocketTimeoutException;
import java.util.Hashtable;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: SAM */
class C1779f extends AsyncHttpResponseHandler {
    final /* synthetic */ SAM f3167a;
    private final /* synthetic */ PreferenceCache f3168b;
    private final /* synthetic */ C1700p f3169c;

    C1779f(SAM sam, PreferenceCache preferenceCache, C1700p c1700p) {
        this.f3167a = sam;
        this.f3168b = preferenceCache;
        this.f3169c = c1700p;
    }

    public void onSuccess(String str) {
        super.onSuccess(str);
        if (this.f3167a.f2632w == null) {
            this.f3167a.f2632w = new Hashtable();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f3168b.put(new CacheItem("offers_everypage", str));
            this.f3167a.m4767a("everypage", str, this.f3169c);
        } else if (this.f3169c != null) {
            this.f3169c.mo4255a(new Hashtable(), false);
        }
    }

    public void onFailure(Throwable th, String str) {
        super.onFailure(th, str);
        if (this.f3169c != null) {
            this.f3169c.mo4255a(new Hashtable(), false);
        }
        if ((th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException)) {
            this.f3167a.f2633x = System.currentTimeMillis();
        }
    }
}
