package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.facebook.AppEventsConstants;
import com.mopub.common.p050b.C1479b;
import com.mopub.common.p050b.C1483f;
import java.text.SimpleDateFormat;

/* compiled from: AdUrlGenerator */
public abstract class C1477a extends C1476d {
    private static C1496c f2135h = C1496c.UNKNOWN;
    protected Context f2136a;
    protected TelephonyManager f2137b = ((TelephonyManager) this.f2136a.getSystemService("phone"));
    protected ConnectivityManager f2138c = ((ConnectivityManager) this.f2136a.getSystemService("connectivity"));
    protected String f2139d;
    protected String f2140e;
    protected Location f2141f;
    protected boolean f2142g;

    public C1477a(Context context) {
        this.f2136a = context;
    }

    public C1477a m4029a(String str) {
        this.f2139d = str;
        return this;
    }

    public C1477a m4034b(String str) {
        this.f2140e = str;
        return this;
    }

    public C1477a m4030a(boolean z) {
        this.f2142g = z;
        return this;
    }

    public C1477a m4028a(Location location) {
        this.f2141f = location;
        return this;
    }

    protected void m4039c(String str) {
        m4017b("id", str);
    }

    protected void m4041d(String str) {
        m4017b("nv", str);
    }

    protected void m4043e(String str) {
        m4017b("q", str);
    }

    protected void m4036b(Location location) {
        if (location != null) {
            m4017b("ll", location.getLatitude() + "," + location.getLongitude());
            m4017b("lla", ((int) location.getAccuracy()));
        }
    }

    protected void m4044f(String str) {
        m4017b("z", str);
    }

    protected void m4033a(int i) {
        String str = "u";
        if (i == 1) {
            str = "p";
        } else if (i == 2) {
            str = "l";
        } else if (i == 3) {
            str = "s";
        }
        m4017b("o", str);
    }

    protected void m4032a(float f) {
        m4017b("sc_a", f);
    }

    protected void m4037b(boolean z) {
        if (z) {
            m4017b("mr", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    protected void m4045g(String str) {
        m4017b("mcc", str == null ? "" : str.substring(0, m4027o(str)));
    }

    protected void m4046h(String str) {
        m4017b("mnc", str == null ? "" : str.substring(m4027o(str)));
    }

    protected void m4047i(String str) {
        m4017b("iso", str);
    }

    protected void m4048j(String str) {
        m4017b("cn", str);
    }

    protected void m4035b(int i) {
        switch (i) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                m4025a("ct", C1495b.MOBILE);
                return;
            case 1:
                m4025a("ct", C1495b.WIFI);
                return;
            case 9:
                m4025a("ct", C1495b.ETHERNET);
                return;
            default:
                m4025a("ct", C1495b.UNKNOWN);
                return;
        }
    }

    private void m4025a(String str, C1495b c1495b) {
        m4017b(str, c1495b.toString());
    }

    protected String mo4075a() {
        String networkOperator = this.f2137b.getNetworkOperator();
        if (this.f2137b.getPhoneType() == 2 && this.f2137b.getSimState() == 5) {
            return this.f2137b.getSimOperator();
        }
        return networkOperator;
    }

    private int m4027o(String str) {
        return Math.min(3, str.length());
    }

    protected static String m4026b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Z");
        simpleDateFormat.setTimeZone(C1479b.m4051a());
        return simpleDateFormat.format(C1479b.m4052b());
    }

    protected int m4038c() {
        if (this.f2136a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return 8;
        }
        NetworkInfo activeNetworkInfo = this.f2138c.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return 8;
    }

    protected void m4040d() {
        if (f2135h == C1496c.UNKNOWN) {
            f2135h = m4042e();
        }
        if (f2135h == C1496c.INSTALLED) {
            m4017b("ts", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    public C1496c m4042e() {
        return C1483f.m4062a(this.f2136a) ? C1496c.INSTALLED : C1496c.NOT_INSTALLED;
    }
}
