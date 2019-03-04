package com.google.android.gms.analytics;

import android.content.Context;

class zzz extends zzn<zzaa> {

    class zza implements com.google.android.gms.analytics.zzn.zza<zzaa> {
        private final zzaa zzEh = new zzaa();

        public void zzc(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.zzEh.zzEj = i;
            } else {
                zzae.zzac("int configuration name not recognized:  " + str);
            }
        }

        public void zzd(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.zzEh.zzEk = z ? 1 : 0;
                return;
            }
            zzae.zzac("bool configuration name not recognized:  " + str);
        }

        public /* synthetic */ zzm zzfB() {
            return zzfY();
        }

        public zzaa zzfY() {
            return this.zzEh;
        }

        public void zzi(String str, String str2) {
        }

        public void zzj(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.zzEh.zzBa = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.zzEh.zzBb = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.zzEh.zzEi = str2;
            } else {
                zzae.zzac("string configuration name not recognized:  " + str);
            }
        }
    }

    public zzz(Context context) {
        super(context, new zza());
    }
}
