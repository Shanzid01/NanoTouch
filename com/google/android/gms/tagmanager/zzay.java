package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd.zza;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class zzay {
    public static zzc zzdd(String str) {
        zza zzq = zzq(new JSONObject(str));
        zzd zzux = zzc.zzux();
        for (int i = 0; i < zzq.zzgx.length; i++) {
            zzux.zzc(zzvl.zza.zzuu().zzb(zzb.INSTANCE_NAME.toString(), zzq.zzgx[i]).zzb(zzb.FUNCTION.toString(), zzde.zzdo(zzm.zzsG())).zzb(zzm.zzsH(), zzq.zzgy[i]).zzuw());
        }
        return zzux.zzuA();
    }

    private static zza zzq(Object obj) {
        return zzde.zzx(zzr(obj));
    }

    static Object zzr(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, zzr(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
