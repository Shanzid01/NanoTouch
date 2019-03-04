package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;

@zzgi
public class zzu {
    private zza zzmq;
    private boolean zzmr;
    private boolean zzms;

    public interface zza {
        void zze(String str);
    }

    @zzgi
    public class zzb implements zza {
        private final com.google.android.gms.internal.zzhe.zza zzmt;
        private final zzic zzmu;

        public zzb(com.google.android.gms.internal.zzhe.zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic) {
            this.zzmt = com_google_android_gms_internal_zzhe_zza;
            this.zzmu = com_google_android_gms_internal_zzic;
        }

        public void zze(String str) {
            zzhx.zzY("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.zzmt == null || this.zzmt.zzyz == null || TextUtils.isEmpty(this.zzmt.zzyz.zzwN))) {
                builder.appendQueryParameter("debugDialog", this.zzmt.zzyz.zzwN);
            }
            zzab.zzaM().zzc(this.zzmu.getContext(), this.zzmu.zzeJ().zzzH, builder.toString());
        }
    }

    public zzu() {
        this.zzms = ((Boolean) zzca.zzqq.get()).booleanValue();
    }

    public zzu(boolean z) {
        this.zzms = z;
    }

    public void recordClick() {
        this.zzmr = true;
    }

    public void zza(zza com_google_android_gms_internal_zzu_zza) {
        this.zzmq = com_google_android_gms_internal_zzu_zza;
    }

    public boolean zzaB() {
        return !this.zzms || this.zzmr;
    }

    public void zzd(String str) {
        zzhx.zzY("Action was blocked because no click was detected.");
        if (this.zzmq != null) {
            this.zzmq.zze(str);
        }
    }
}
