package com.slideme.sam.manager.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.loopj.android.http.RequestParams;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.p055b.C1703e;
import com.slideme.sam.manager.controller.p055b.C1705g;
import com.slideme.sam.manager.model.p054b.C1829c;
import com.slideme.sam.manager.util.C1913d;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: NetworkUtils */
final class C1888s {
    public static RequestParams m5651a(Context context, int i, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2) {
        String deviceId;
        RequestParams requestParams = new RequestParams();
        requestParams.put("v", "2");
        requestParams.put("ad_slot", str);
        String str6 = "limit";
        if (TextUtils.isEmpty(str2)) {
            str2 = "50";
        }
        requestParams.put(str6, str2);
        requestParams.put("api_level", String.valueOf(C1829c.m5504f()));
        requestParams.put("partner", str4);
        requestParams.put("hasGP", SAM.f2615h.m5512c() ? 1 : 0);
        requestParams.put("hasSM", z ? 1 : 0);
        requestParams.put("sortby", z ? "smeAvailable,payout" : "payout");
        requestParams.put("screen_density", String.valueOf(C1705g.m5081d(context, context.getResources())));
        String[] a = C1705g.m5078a(context, context.getResources());
        requestParams.put("screen_resolution", a[0] + "x" + a[1]);
        if (i > 0) {
            requestParams.put("image_width", i);
        }
        if (str.contains("reward")) {
            requestParams.put("incent", 1);
            requestParams.put("uid", AuthData.m4810f(context));
        }
        requestParams.put("udid", C1913d.m5766c(context));
        requestParams.put("pname", context.getPackageName());
        requestParams.put("device_model", Build.MODEL);
        requestParams.put("device_brand", Build.BRAND);
        Locale locale = context.getResources().getConfiguration().locale;
        requestParams.put("language", locale.getLanguage() + "_" + locale.getCountry());
        requestParams.put("tz", String.valueOf(TimeZone.getDefault().getOffset(new Date().getTime() / 1000) * 60));
        str6 = "aaid";
        if (TextUtils.isEmpty(str5)) {
            str5 = "missing";
        }
        requestParams.put(str6, str5);
        requestParams.put("aaid_limit", z2 ? 1 : 0);
        str6 = Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(str6)) {
            str6 = C1913d.m5757a(context);
            if (TextUtils.isEmpty(str6)) {
                str6 = "123";
            } else {
                str6 = str6.substring(0, str6.indexOf("-"));
            }
        }
        requestParams.put("android_id", str6);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            deviceId = telephonyManager.getDeviceId();
            if (telephonyManager.getSimState() == 5) {
                requestParams.put("carrier_iso", telephonyManager.getSimOperator());
                str6 = deviceId;
            } else {
                str6 = deviceId;
            }
        } catch (SecurityException e) {
            str6 = "";
        }
        if (TextUtils.isEmpty(str6)) {
            str6 = "123";
        }
        requestParams.put("imei", str6);
        deviceId = "wifi";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            Object obj = (networkInfo2 == null || !networkInfo2.isConnectedOrConnecting()) ? null : 1;
            Object obj2 = (networkInfo == null || !networkInfo.isConnectedOrConnecting()) ? null : 1;
            if (obj2 == null || obj != null) {
                str6 = deviceId;
            } else {
                str6 = "simdata";
            }
        } catch (SecurityException e2) {
            str6 = deviceId;
        }
        requestParams.put("connection_type", str6);
        deviceId = "";
        try {
            str6 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (SecurityException e3) {
            str6 = deviceId;
        }
        if (TextUtils.isEmpty(str6)) {
            str6 = "123";
        }
        if (!TextUtils.isEmpty(str6)) {
            str6.replace(":", "");
        }
        requestParams.put("mac", str6);
        if (!(TextUtils.isEmpty(str3) || "all".equals(str3))) {
            requestParams.put("source", str3);
        }
        if (SAM.f2613f.m5443a()) {
            requestParams.put("force_http", 1);
        }
        if (C1703e.m5069b(str)) {
            requestParams.put("platform", "android+ios");
            requestParams.put("api_level", 22);
        } else {
            requestParams.put("platform", "android,ios");
        }
        return requestParams;
    }
}
