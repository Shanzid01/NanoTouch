package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzgi
public final class zzdj {
    public final String zzsk;
    public final String zzsl;
    public final List<String> zzsm;
    public final String zzsn;
    public final String zzso;
    public final List<String> zzsp;
    public final String zzsq;

    public zzdj(JSONObject jSONObject) {
        String str = null;
        this.zzsl = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzsm = Collections.unmodifiableList(arrayList);
        this.zzsn = jSONObject.optString("allocation_id", null);
        this.zzsp = zzab.zzaV().zza(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.zzsk = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzsq = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            str = optJSONObject2.optString("class_name");
        }
        this.zzso = str;
    }
}
