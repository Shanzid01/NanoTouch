package com.google.android.gms.analytics;

import android.content.Context;

class zzal extends zzn<zzam> {

    class zza implements com.google.android.gms.analytics.zzn.zza<zzam> {
        private final zzam zzFq = new zzam();

        public void zzc(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzFq.zzFt = i;
            } else {
                zzae.zzac("int configuration name not recognized:  " + str);
            }
        }

        public void zzd(String str, boolean z) {
            int i = 1;
            zzam com_google_android_gms_analytics_zzam;
            if ("ga_autoActivityTracking".equals(str)) {
                com_google_android_gms_analytics_zzam = this.zzFq;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_zzam.zzFu = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                com_google_android_gms_analytics_zzam = this.zzFq;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_zzam.zzFv = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                com_google_android_gms_analytics_zzam = this.zzFq;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_zzam.zzFw = i;
            } else {
                zzae.zzac("bool configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ zzm zzfB() {
            return zzgJ();
        }

        public zzam zzgJ() {
            return this.zzFq;
        }

        public void zzi(String str, String str2) {
            this.zzFq.zzFx.put(str, str2);
        }

        public void zzj(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzFq.zzFr = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.zzFq.zzFs = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzae.zzZ("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                zzae.zzac("string configuration name not recognized:  " + str);
            }
        }
    }

    public zzal(Context context) {
        super(context, new zza());
    }
}
