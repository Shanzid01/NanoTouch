package com.mopub.mobileads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.webkit.WebView;
import com.mopub.common.p050b.C1479b;
import com.mopub.common.p050b.C1489l;
import com.mopub.common.p050b.C1492o;
import com.mopub.common.p050b.C1493p;
import com.mopub.mobileads.util.C1558d;
import java.io.Serializable;
import java.util.Map;
import org.apache.http.HttpResponse;

public class AdConfiguration implements Serializable {
    private static final long serialVersionUID = 0;
    private final String f2223a;
    private final String f2224b;
    private final String f2225c;
    private final String f2226d;
    private final String f2227e;
    private final int f2228f;
    private long f2229g;
    private String f2230h;
    private String f2231i;
    private String f2232j;
    private String f2233k;
    private String f2234l;
    private String f2235m;
    private String f2236n;
    private String f2237o;
    private long f2238p;
    private int f2239q;
    private int f2240r;
    private Integer f2241s;
    private int f2242t;
    private String f2243u;

    static AdConfiguration m4181a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("Ad-Configuration");
        return obj instanceof AdConfiguration ? (AdConfiguration) obj : null;
    }

    AdConfiguration(Context context) {
        m4182w();
        if (context != null) {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                string = "";
            }
            this.f2224b = C1492o.m4090a(string);
            this.f2225c = new WebView(context).getSettings().getUserAgentString();
            this.f2226d = context.getResources().getConfiguration().locale.toString();
        } else {
            this.f2224b = null;
            this.f2225c = null;
            this.f2226d = null;
        }
        this.f2229g = C1492o.m4089a();
        this.f2227e = Build.MANUFACTURER + " " + Build.MODEL;
        this.f2228f = C1493p.currentApiLevel().getApiLevel();
        this.f2223a = "2.2";
    }

    void m4183a() {
        m4182w();
    }

    void m4186a(HttpResponse httpResponse) {
        this.f2232j = C1558d.m4662a(httpResponse, C1489l.AD_TYPE);
        this.f2233k = C1558d.m4662a(httpResponse, C1489l.NETWORK_TYPE);
        this.f2234l = C1558d.m4662a(httpResponse, C1489l.REDIRECT_URL);
        this.f2235m = C1558d.m4662a(httpResponse, C1489l.CLICKTHROUGH_URL);
        this.f2236n = C1558d.m4662a(httpResponse, C1489l.FAIL_URL);
        this.f2237o = C1558d.m4662a(httpResponse, C1489l.IMPRESSION_URL);
        this.f2238p = C1479b.m4052b().getTime();
        this.f2239q = C1558d.m4661a(httpResponse, C1489l.WIDTH, 0);
        this.f2240r = C1558d.m4661a(httpResponse, C1489l.HEIGHT, 0);
        this.f2241s = C1558d.m4664b(httpResponse, C1489l.AD_TIMEOUT);
        if (httpResponse.containsHeader(C1489l.REFRESH_TIME.getKey())) {
            this.f2242t = C1558d.m4661a(httpResponse, C1489l.REFRESH_TIME, 0) * 1000;
            this.f2242t = Math.max(this.f2242t, 10000);
        } else {
            this.f2242t = 0;
        }
        this.f2243u = C1558d.m4662a(httpResponse, C1489l.DSP_CREATIVE_ID);
    }

    String m4187b() {
        return this.f2231i;
    }

    void m4185a(String str) {
        this.f2231i = str;
    }

    String m4189c() {
        return this.f2230h;
    }

    void m4188b(String str) {
        this.f2230h = str;
    }

    long m4191d() {
        return this.f2229g;
    }

    String m4192e() {
        return this.f2232j;
    }

    String m4193f() {
        return this.f2233k;
    }

    String m4194g() {
        return this.f2235m;
    }

    String m4195h() {
        return this.f2236n;
    }

    void m4190c(String str) {
        this.f2236n = str;
    }

    String m4196i() {
        return this.f2237o;
    }

    long m4197j() {
        return this.f2238p;
    }

    int m4198k() {
        return this.f2239q;
    }

    int m4199l() {
        return this.f2240r;
    }

    Integer m4200m() {
        return this.f2241s;
    }

    int m4201n() {
        return this.f2242t;
    }

    @Deprecated
    void m4184a(int i) {
        this.f2242t = i;
    }

    String m4202o() {
        return this.f2243u;
    }

    String m4203p() {
        return this.f2224b;
    }

    String m4204q() {
        return this.f2225c;
    }

    String m4205r() {
        return this.f2226d;
    }

    String m4206s() {
        return this.f2227e;
    }

    int m4207t() {
        return this.f2228f;
    }

    String m4208u() {
        return "Android";
    }

    String m4209v() {
        return this.f2223a;
    }

    private void m4182w() {
        this.f2229g = 0;
        this.f2231i = null;
        this.f2230h = null;
        this.f2232j = null;
        this.f2233k = null;
        this.f2234l = null;
        this.f2235m = null;
        this.f2237o = null;
        this.f2238p = C1479b.m4052b().getTime();
        this.f2239q = 0;
        this.f2240r = 0;
        this.f2241s = null;
        this.f2242t = 60000;
        this.f2236n = null;
        this.f2243u = null;
    }
}
