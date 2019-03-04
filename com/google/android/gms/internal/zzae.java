package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

@zzgi
public class zzae implements zzag {
    private final Object zznh = new Object();
    private final WeakHashMap<zzhe, zzaf> zzni = new WeakHashMap();
    private final ArrayList<zzaf> zznj = new ArrayList();
    private final Context zznk;
    private final zzhy zznl;
    private final zzdf zznm;

    public zzae(Context context, zzhy com_google_android_gms_internal_zzhy, zzdf com_google_android_gms_internal_zzdf) {
        this.zznk = context.getApplicationContext();
        this.zznl = com_google_android_gms_internal_zzhy;
        this.zznm = com_google_android_gms_internal_zzdf;
    }

    public zzaf zza(zzba com_google_android_gms_internal_zzba, zzhe com_google_android_gms_internal_zzhe) {
        return zza(com_google_android_gms_internal_zzba, com_google_android_gms_internal_zzhe, com_google_android_gms_internal_zzhe.zzuq.getWebView());
    }

    public zzaf zza(zzba com_google_android_gms_internal_zzba, zzhe com_google_android_gms_internal_zzhe, View view) {
        zzaf com_google_android_gms_internal_zzaf;
        synchronized (this.zznh) {
            if (zzc(com_google_android_gms_internal_zzhe)) {
                com_google_android_gms_internal_zzaf = (zzaf) this.zzni.get(com_google_android_gms_internal_zzhe);
            } else {
                com_google_android_gms_internal_zzaf = new zzaf(com_google_android_gms_internal_zzba, com_google_android_gms_internal_zzhe, this.zznl, view, this.zznm);
                com_google_android_gms_internal_zzaf.zza((zzag) this);
                this.zzni.put(com_google_android_gms_internal_zzhe, com_google_android_gms_internal_zzaf);
                this.zznj.add(com_google_android_gms_internal_zzaf);
            }
        }
        return com_google_android_gms_internal_zzaf;
    }

    public void zza(zzaf com_google_android_gms_internal_zzaf) {
        synchronized (this.zznh) {
            if (!com_google_android_gms_internal_zzaf.zzbf()) {
                this.zznj.remove(com_google_android_gms_internal_zzaf);
            }
        }
    }

    public boolean zzc(zzhe com_google_android_gms_internal_zzhe) {
        boolean z;
        synchronized (this.zznh) {
            zzaf com_google_android_gms_internal_zzaf = (zzaf) this.zzni.get(com_google_android_gms_internal_zzhe);
            z = com_google_android_gms_internal_zzaf != null && com_google_android_gms_internal_zzaf.zzbf();
        }
        return z;
    }

    public void zzd(zzhe com_google_android_gms_internal_zzhe) {
        synchronized (this.zznh) {
            zzaf com_google_android_gms_internal_zzaf = (zzaf) this.zzni.get(com_google_android_gms_internal_zzhe);
            if (com_google_android_gms_internal_zzaf != null) {
                com_google_android_gms_internal_zzaf.zzbd();
            }
        }
    }

    public void zze(zzhe com_google_android_gms_internal_zzhe) {
        synchronized (this.zznh) {
            zzaf com_google_android_gms_internal_zzaf = (zzaf) this.zzni.get(com_google_android_gms_internal_zzhe);
            if (com_google_android_gms_internal_zzaf != null) {
                com_google_android_gms_internal_zzaf.stop();
            }
        }
    }

    public void zzf(zzhe com_google_android_gms_internal_zzhe) {
        synchronized (this.zznh) {
            zzaf com_google_android_gms_internal_zzaf = (zzaf) this.zzni.get(com_google_android_gms_internal_zzhe);
            if (com_google_android_gms_internal_zzaf != null) {
                com_google_android_gms_internal_zzaf.pause();
            }
        }
    }

    public void zzg(zzhe com_google_android_gms_internal_zzhe) {
        synchronized (this.zznh) {
            zzaf com_google_android_gms_internal_zzaf = (zzaf) this.zzni.get(com_google_android_gms_internal_zzhe);
            if (com_google_android_gms_internal_zzaf != null) {
                com_google_android_gms_internal_zzaf.resume();
            }
        }
    }
}
