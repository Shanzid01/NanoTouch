package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzvl.zzc;

public class zzvk implements Result {
    private final zza zzaBZ;

    public class zza {
        private final Status zzHb;
        private final zza zzaCa;
        private final byte[] zzaCb;
        private final long zzaCc;
        private final zzve zzaCd;
        private final zzc zzaCe;

        public enum zza {
            NETWORK,
            DISK,
            DEFAULT
        }

        public zza(Status status, zzve com_google_android_gms_internal_zzve, zza com_google_android_gms_internal_zzvk_zza_zza) {
            this(status, com_google_android_gms_internal_zzve, null, null, com_google_android_gms_internal_zzvk_zza_zza, 0);
        }

        public zza(Status status, zzve com_google_android_gms_internal_zzve, byte[] bArr, zzc com_google_android_gms_internal_zzvl_zzc, zza com_google_android_gms_internal_zzvk_zza_zza, long j) {
            this.zzHb = status;
            this.zzaCd = com_google_android_gms_internal_zzve;
            this.zzaCb = bArr;
            this.zzaCe = com_google_android_gms_internal_zzvl_zzc;
            this.zzaCa = com_google_android_gms_internal_zzvk_zza_zza;
            this.zzaCc = j;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public zza zzup() {
            return this.zzaCa;
        }

        public byte[] zzuq() {
            return this.zzaCb;
        }

        public zzve zzur() {
            return this.zzaCd;
        }

        public zzc zzus() {
            return this.zzaCe;
        }

        public long zzut() {
            return this.zzaCc;
        }
    }

    public zzvk(zza com_google_android_gms_internal_zzvk_zza) {
        this.zzaBZ = com_google_android_gms_internal_zzvk_zza;
    }

    public Status getStatus() {
        return this.zzaBZ.getStatus();
    }

    public zza zzuo() {
        return this.zzaBZ;
    }
}
