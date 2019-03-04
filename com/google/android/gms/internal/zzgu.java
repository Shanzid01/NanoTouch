package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzgt.zza;
import org.json.JSONObject;

@zzgi
public class zzgu implements zza<zzcl> {
    public /* synthetic */ zzcn.zza zza(zzgt com_google_android_gms_internal_zzgt, JSONObject jSONObject) {
        return zzb(com_google_android_gms_internal_zzgt, jSONObject);
    }

    public zzcl zzb(zzgt com_google_android_gms_internal_zzgt, JSONObject jSONObject) {
        return new zzcl(jSONObject.getString("headline"), (Drawable) com_google_android_gms_internal_zzgt.zza(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) com_google_android_gms_internal_zzgt.zza(jSONObject, "app_icon", true).get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"));
    }
}
