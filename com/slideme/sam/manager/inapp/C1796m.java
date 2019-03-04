package com.slideme.sam.manager.inapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.util.Locale;

/* compiled from: MissingSAMDialog */
class C1796m implements OnClickListener {
    private final /* synthetic */ boolean f3228a;
    private final /* synthetic */ Activity f3229b;

    C1796m(boolean z, Activity activity) {
        this.f3228a = z;
        this.f3229b = activity;
    }

    @SuppressLint({"NewApi"})
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3228a) {
            try {
                Intent launchIntentForPackage = this.f3229b.getPackageManager().getLaunchIntentForPackage("com.slideme.sam.manager");
                if (launchIntentForPackage != null) {
                    this.f3229b.startActivity(launchIntentForPackage);
                    return;
                }
                return;
            } catch (ActivityNotFoundException e) {
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://slideme.org/iapsam");
        stringBuilder.append("?board=");
        stringBuilder.append(Build.BOARD);
        stringBuilder.append("&cpu_abi=");
        stringBuilder.append(Build.CPU_ABI);
        if (VERSION.SDK_INT >= 8) {
            stringBuilder.append("&cpu_abi2=");
            stringBuilder.append(Build.CPU_ABI2);
        }
        stringBuilder.append("&android_id=");
        stringBuilder.append(Secure.getString(this.f3229b.getContentResolver(), "android_id"));
        stringBuilder.append("&api_level=");
        stringBuilder.append(VERSION.SDK_INT);
        if (VERSION.SDK_INT >= 9) {
            stringBuilder.append("&build_serial=");
            stringBuilder.append(Build.SERIAL);
        }
        Locale locale = this.f3229b.getResources().getConfiguration().locale;
        stringBuilder.append("&language_iso=");
        stringBuilder.append(locale.getLanguage());
        stringBuilder.append("&country_iso=");
        stringBuilder.append(locale.getCountry());
        stringBuilder.append("&model=");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("&manufacturer=");
        stringBuilder.append(Build.MANUFACTURER);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f3229b.getSystemService("phone");
            stringBuilder.append("&software_version=");
            stringBuilder.append(telephonyManager.getDeviceSoftwareVersion());
            stringBuilder.append("&imei=");
            stringBuilder.append(telephonyManager.getDeviceId());
            stringBuilder.append("&network_iso=");
            stringBuilder.append(telephonyManager.getNetworkCountryIso());
            stringBuilder.append("&network_op=");
            stringBuilder.append(telephonyManager.getNetworkOperator());
            stringBuilder.append("&network_op_name=");
            stringBuilder.append(telephonyManager.getNetworkOperatorName());
            stringBuilder.append("&sim_iso=");
            stringBuilder.append(telephonyManager.getSimCountryIso());
            stringBuilder.append("&sim_serial=");
            stringBuilder.append(telephonyManager.getSimSerialNumber());
            stringBuilder.append("&sim_op=");
            stringBuilder.append(telephonyManager.getSimOperator());
            stringBuilder.append("&subscriber_id=");
            stringBuilder.append(telephonyManager.getSubscriberId());
        } catch (SecurityException e2) {
        }
        try {
            WifiManager wifiManager = (WifiManager) this.f3229b.getSystemService("wifi");
            stringBuilder.append("&mac=");
            stringBuilder.append(wifiManager.getConnectionInfo().getMacAddress());
        } catch (SecurityException e3) {
        }
        this.f3229b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString())));
    }
}
