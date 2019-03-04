package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzgi
public class zzdp {
    public List<String> zza(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzhe com_google_android_gms_internal_zzhe, String str2, boolean z, List<String> list) {
        String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", com_google_android_gms_internal_zzhe.zzyt.zzsw).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzab.zzaP().getSessionId()).replaceAll("@gw_seqnum@", com_google_android_gms_internal_zzhe.zzwq);
            if (com_google_android_gms_internal_zzhe.zzsL != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", com_google_android_gms_internal_zzhe.zzsL.zzsl).replaceAll("@gw_allocid@", com_google_android_gms_internal_zzhe.zzsL.zzsn);
            }
            new zzhu(context, str, replaceAll2).start();
        }
    }
}
