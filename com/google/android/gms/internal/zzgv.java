package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzgt.zza;
import org.json.JSONObject;

@zzgi
public class zzgv implements zza<zzcm> {
    public /* synthetic */ zzcn.zza zza(zzgt com_google_android_gms_internal_zzgt, JSONObject jSONObject) {
        return zzc(com_google_android_gms_internal_zzgt, jSONObject);
    }

    public zzcm zzc(zzgt com_google_android_gms_internal_zzgt, JSONObject jSONObject) {
        return new zzcm(jSONObject.getString("headline"), (Drawable) com_google_android_gms_internal_zzgt.zza(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) com_google_android_gms_internal_zzgt.zza(jSONObject, "secondary_image", false).get(), jSONObject.getString("call_to_action"), jSONObject.getString("attribution"));
    }
}
