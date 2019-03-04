package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzgi
public final class zzdk {
    public final List<zzdj> zzsr;
    public final long zzss;
    public final List<String> zzst;
    public final List<String> zzsu;
    public final List<String> zzsv;
    public final String zzsw;
    public final long zzsx;
    public int zzsy;
    public int zzsz;

    public zzdk(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (zzhx.zzA(2)) {
            zzhx.zzab("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzdj com_google_android_gms_internal_zzdj = new zzdj(jSONArray.getJSONObject(i2));
            arrayList.add(com_google_android_gms_internal_zzdj);
            if (i < 0 && zza(com_google_android_gms_internal_zzdj)) {
                i = i2;
            }
        }
        this.zzsy = i;
        this.zzsz = jSONArray.length();
        this.zzsr = Collections.unmodifiableList(arrayList);
        this.zzsw = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzss = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.zzst = zzab.zzaV().zza(optJSONObject, "click_urls");
            this.zzsu = zzab.zzaV().zza(optJSONObject, "imp_urls");
            this.zzsv = zzab.zzaV().zza(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzsx = optLong > 0 ? optLong * 1000 : -1;
            return;
        }
        this.zzss = -1;
        this.zzst = null;
        this.zzsu = null;
        this.zzsv = null;
        this.zzsx = -1;
    }

    private boolean zza(zzdj com_google_android_gms_internal_zzdj) {
        for (String equals : com_google_android_gms_internal_zzdj.zzsm) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
