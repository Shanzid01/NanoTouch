package com.slideme.sam.manager.model.p054b;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;

/* compiled from: NetworkChangeNotifier */
public class C1832f {
    private static String f3278a = "network_data_store";
    private static String f3279b = "netiso";
    private static String f3280c = "netopname";
    private static String f3281d = "simiso";
    private static String f3282e = "netop";
    private static String f3283f = "simop";
    private static String f3284g = "userid";
    private Context f3285h;
    private C1810g f3286i;

    public C1832f(C1810g c1810g, Context context) {
        this.f3286i = c1810g;
        this.f3285h = context;
    }

    public void m5514a(String str) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f3285h.getSystemService("phone");
        SharedPreferences sharedPreferences = this.f3285h.getSharedPreferences(f3278a, 0);
        String networkCountryIso = telephonyManager.getNetworkCountryIso();
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        String simCountryIso = telephonyManager.getSimCountryIso();
        String networkOperator = telephonyManager.getNetworkOperator();
        String simOperator = telephonyManager.getSimOperator();
        int i = (str.equals(sharedPreferences.getString(f3284g, "")) && networkCountryIso.equals(sharedPreferences.getString(f3279b, "")) && networkOperatorName.equals(sharedPreferences.getString(f3280c, "")) && simCountryIso.equals(sharedPreferences.getString(f3281d, "")) && networkOperator.equals(sharedPreferences.getString(f3282e, "")) && simOperator.equals(sharedPreferences.getString(f3283f, ""))) ? 0 : 1;
        if (!((i | 0) == 0 || this.f3286i == null)) {
            this.f3286i.mo4294a(telephonyManager);
        }
        sharedPreferences.edit().putString(f3279b, networkCountryIso).putString(f3282e, networkOperator).putString(f3280c, networkOperatorName).putString(f3281d, simCountryIso).putString(f3283f, simOperator).putString(f3284g, str).commit();
    }
}
