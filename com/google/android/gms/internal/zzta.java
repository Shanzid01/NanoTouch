package com.google.android.gms.internal;

public final class zzta {
    private final String zzFr;
    private final boolean zzatB;
    private final boolean zzatC;
    private final String zzatD;

    public final class zza {
        private String zzFr;
        private boolean zzatB = true;
        private boolean zzatC = false;
        private final String zzatD;

        public zza(String str) {
            this.zzatD = str;
        }

        public zza zzab(boolean z) {
            this.zzatB = z;
            return this;
        }

        public zza zzac(boolean z) {
            this.zzatC = z;
            return this;
        }

        public zza zzcA(String str) {
            this.zzFr = str;
            return this;
        }

        public zzta zzrA() {
            return new zzta();
        }
    }

    private zzta(zza com_google_android_gms_internal_zzta_zza) {
        this.zzatD = com_google_android_gms_internal_zzta_zza.zzatD;
        this.zzatB = com_google_android_gms_internal_zzta_zza.zzatB;
        this.zzatC = com_google_android_gms_internal_zzta_zza.zzatC;
        this.zzFr = com_google_android_gms_internal_zzta_zza.zzFr;
    }

    public String zzgL() {
        return this.zzFr;
    }

    public String zzrx() {
        return this.zzatD;
    }

    public boolean zzry() {
        return this.zzatB;
    }

    public boolean zzrz() {
        return this.zzatC;
    }
}
