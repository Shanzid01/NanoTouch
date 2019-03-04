package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class zzaw {
    private static String zzayS;
    static Map<String, String> zzayT = new HashMap();

    zzaw() {
    }

    static String zzA(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }

    static void zzdc(String str) {
        synchronized (zzaw.class) {
            zzayS = str;
        }
    }

    static String zzf(Context context, String str, String str2) {
        String str3 = (String) zzayT.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            zzayT.put(str, str3);
        }
        return zzA(str3, str2);
    }

    static void zzh(Context context, String str) {
        zzcu.zza(context, "gtm_install_referrer", "referrer", str);
        zzj(context, str);
    }

    static String zzi(Context context, String str) {
        if (zzayS == null) {
            synchronized (zzaw.class) {
                if (zzayS == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzayS = sharedPreferences.getString("referrer", "");
                    } else {
                        zzayS = "";
                    }
                }
            }
        }
        return zzA(zzayS, str);
    }

    static void zzj(Context context, String str) {
        String zzA = zzA(str, "conv");
        if (zzA != null && zzA.length() > 0) {
            zzayT.put(zzA, str);
            zzcu.zza(context, "gtm_click_referrers", zzA, str);
        }
    }
}
