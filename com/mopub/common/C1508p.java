package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.p049a.C1475a;
import com.mopub.common.p050b.C1478a;
import com.mopub.common.p050b.C1486i;
import com.mopub.common.p050b.C1487j;
import com.mopub.mobileads.AdTypeTranslator.CustomEventType;

/* compiled from: GpsHelper */
public class C1508p {
    private static String f2196a = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static String f2197b = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    public static CustomEventType m4136a(Context context, CustomEventType customEventType) {
        if (customEventType == CustomEventType.ADMOB_BANNER && C1487j.m4081a(CustomEventType.GOOGLE_PLAY_BANNER.toString()) && C1508p.m4141a(context)) {
            return CustomEventType.GOOGLE_PLAY_BANNER;
        }
        if (customEventType == CustomEventType.ADMOB_INTERSTITIAL && C1487j.m4081a(CustomEventType.GOOGLE_PLAY_INTERSTITIAL.toString()) && C1508p.m4141a(context)) {
            return CustomEventType.GOOGLE_PLAY_INTERSTITIAL;
        }
        return customEventType;
    }

    static boolean m4141a(Context context) {
        try {
            Object a = C1475a.m4010a(null, "isGooglePlayServicesAvailable").m4082a(Class.forName(f2196a)).m4083a(Context.class, context).m4084a();
            if (a == null || ((Integer) a).intValue() != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static String m4143b(Context context) {
        if (C1508p.m4141a(context)) {
            return ae.m4049a(context).getString("advertisingId", null);
        }
        return null;
    }

    public static boolean m4145c(Context context) {
        if (C1508p.m4141a(context)) {
            return ae.m4049a(context).getBoolean("isLimitAdTrackingEnabled", false);
        }
        return false;
    }

    static boolean m4146d(Context context) {
        SharedPreferences a = ae.m4049a(context);
        return a.contains("advertisingId") && a.contains("isLimitAdTrackingEnabled");
    }

    public static void m4139a(Context context, C1510r c1510r) {
        if (!C1508p.m4141a(context) || C1508p.m4146d(context)) {
            c1510r.mo4137a();
        } else {
            C1508p.m4144b(context, c1510r);
        }
    }

    public static void m4147e(Context context) {
        C1508p.m4144b(context, null);
    }

    public static void m4144b(Context context, C1510r c1510r) {
        if (C1487j.m4081a(f2197b)) {
            try {
                C1478a.m4050a(new C1509q(context, c1510r), new Void[0]);
            } catch (Throwable e) {
                C1486i.m4077a("Error executing FetchAdvertisingInfoTask", e);
                if (c1510r != null) {
                    c1510r.mo4137a();
                }
            }
        } else if (c1510r != null) {
            c1510r.mo4137a();
        }
    }

    static void m4140a(Context context, Object obj) {
        String a = C1508p.m4138a(obj, null);
        ae.m4049a(context).edit().putString("advertisingId", a).putBoolean("isLimitAdTrackingEnabled", C1508p.m4142a(obj, false)).commit();
    }

    static String m4138a(Object obj, String str) {
        try {
            return (String) C1475a.m4010a(obj, "getId").m4084a();
        } catch (Exception e) {
            return str;
        }
    }

    static boolean m4142a(Object obj, boolean z) {
        try {
            Boolean bool = (Boolean) C1475a.m4010a(obj, "isLimitAdTrackingEnabled").m4084a();
            if (bool != null) {
                z = bool.booleanValue();
            }
        } catch (Exception e) {
        }
        return z;
    }
}
