package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: GoogleAnalytics */
public class ao implements bp {
    private static ao f1997j;
    private boolean f1998a;
    private C0758j f1999b;
    private Context f2000c;
    private bm f2001d;
    private C0757a f2002e;
    private volatile String f2003f;
    private volatile Boolean f2004g;
    private final Map<String, bm> f2005h;
    private String f2006i;

    @VisibleForTesting
    ao() {
        this.f2005h = new HashMap();
    }

    private ao(Context context) {
        this(context, ah.m3753a(context));
    }

    private ao(Context context, C0758j c0758j) {
        this.f2005h = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.f2000c = context.getApplicationContext();
        this.f1999b = c0758j;
        this.f2002e = new C0757a();
        this.f1999b.mo1182a(new ap(this));
        this.f1999b.mo1183a(new aq(this));
    }

    public static ao m3792a(Context context) {
        ao aoVar;
        synchronized (ao.class) {
            if (f1997j == null) {
                f1997j = new ao(context);
            }
            aoVar = f1997j;
        }
        return aoVar;
    }

    public void m3797a(boolean z) {
        am.m3786a().m3787a(an.SET_DEBUG);
        this.f1998a = z;
        av.m3813a(z);
    }

    public bm m3795a(String str) {
        bm bmVar;
        synchronized (this) {
            if (str == null) {
                throw new IllegalArgumentException("trackingId cannot be null");
            }
            bmVar = (bm) this.f2005h.get(str);
            if (bmVar == null) {
                bmVar = new bm(str, this);
                this.f2005h.put(str, bmVar);
                if (this.f2001d == null) {
                    this.f2001d = bmVar;
                }
            }
            am.m3786a().m3787a(an.GET_TRACKER);
        }
        return bmVar;
    }

    public void mo1187a(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            map.put("language", bq.m3909a(Locale.getDefault()));
            map.put("adSenseAdMobHitId", Integer.toString(this.f2002e.m3742a()));
            map.put("screenResolution", this.f2000c.getResources().getDisplayMetrics().widthPixels + "x" + this.f2000c.getResources().getDisplayMetrics().heightPixels);
            map.put("usage", am.m3786a().m3790c());
            am.m3786a().m3789b();
            this.f1999b.mo1184a((Map) map);
            this.f2006i = (String) map.get("trackingId");
        }
    }
}
