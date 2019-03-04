package com.google.android.gms.internal;

import android.os.Binder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzgi
public class zzby {
    Collection<zzbw> zzqf = new ArrayList();
    Collection<zzbx<String>> zzqg = new ArrayList();

    public void zza(zzbw com_google_android_gms_internal_zzbw) {
        this.zzqf.add(com_google_android_gms_internal_zzbw);
    }

    public void zza(zzbx<String> com_google_android_gms_internal_zzbx_java_lang_String) {
        this.zzqg.add(com_google_android_gms_internal_zzbx_java_lang_String);
    }

    public List<String> zzca() {
        List<String> arrayList = new ArrayList();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            for (zzbx zzbZ : this.zzqg) {
                String str = (String) zzbZ.zzbZ().get();
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public List<String> zzcb() {
        List<String> arrayList = new ArrayList();
        for (zzbx com_google_android_gms_internal_zzbx : this.zzqg) {
            String str = (String) com_google_android_gms_internal_zzbx.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
