package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.zziz.zza;
import com.google.android.gms.internal.zzop.zzb;
import com.google.android.gms.internal.zzop.zzc;
import com.google.android.gms.internal.zzop.zzd;
import java.util.ArrayList;
import java.util.List;

public class zzji {
    private static zzir zza(String str, zzc com_google_android_gms_internal_zzop_zzc) {
        return new zzir(zzwy.zzf(com_google_android_gms_internal_zzop_zzc), new zza(str).zzI(true).zzaA(str).zzaz("blob").zzgX());
    }

    public static zzjb zza(Action action, long j, String str, int i) {
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzgZ());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzjj.zza(str, Uri.parse(bundle2.getString("url")));
        zzin.zza zza2 = zzjb.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(zzir.zzd(bundle.getByteArray(".private:ssbContext")));
            action.zzgZ().remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zza(new Account(bundle.getString(".private:accountName"), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            action.zzgZ().remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i = 4;
            action.zzgZ().remove(".private:isContextOnly");
        }
        int i2 = i;
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            action.zzgZ().remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzh(action.zzgZ())));
        return new zzjb(zzjb.zza(str, zza), j, i2, null, zza2.zzgU(), z, -1);
    }

    static zzc zzh(Bundle bundle) {
        zzc com_google_android_gms_internal_zzop_zzc = new zzc();
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            zzb com_google_android_gms_internal_zzop_zzb = new zzb();
            com_google_android_gms_internal_zzop_zzb.name = str;
            com_google_android_gms_internal_zzop_zzb.zzalj = new zzd();
            if (obj instanceof String) {
                com_google_android_gms_internal_zzop_zzb.zzalj.zzQN = (String) obj;
            } else if (obj instanceof Bundle) {
                com_google_android_gms_internal_zzop_zzb.zzalj.zzalo = zzh((Bundle) obj);
            } else {
                Log.e("AppDataSearchClient", "Unsupported value: " + obj);
            }
            arrayList.add(com_google_android_gms_internal_zzop_zzb);
        }
        if (bundle.containsKey("type")) {
            com_google_android_gms_internal_zzop_zzc.type = bundle.getString("type");
        }
        com_google_android_gms_internal_zzop_zzc.zzalk = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return com_google_android_gms_internal_zzop_zzc;
    }
}
