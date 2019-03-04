package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzws;
import com.google.android.gms.internal.zzwy;

public final class zzam extends zzws<zzam> {
    public int versionCode;
    public long zzUF;
    public long zzUG;
    public long zzUH;

    public zzam() {
        zzkJ();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzam)) {
            return false;
        }
        zzam com_google_android_gms_drive_internal_zzam = (zzam) obj;
        return (this.versionCode == com_google_android_gms_drive_internal_zzam.versionCode && this.zzUF == com_google_android_gms_drive_internal_zzam.zzUF && this.zzUG == com_google_android_gms_drive_internal_zzam.zzUG && this.zzUH == com_google_android_gms_drive_internal_zzam.zzUH) ? zza((zzws) com_google_android_gms_drive_internal_zzam) : false;
    }

    public int hashCode() {
        return ((((((((this.versionCode + 527) * 31) + ((int) (this.zzUF ^ (this.zzUF >>> 32)))) * 31) + ((int) (this.zzUG ^ (this.zzUG >>> 32)))) * 31) + ((int) (this.zzUH ^ (this.zzUH >>> 32)))) * 31) + zzvL();
    }

    public void zza(zzwr com_google_android_gms_internal_zzwr) {
        com_google_android_gms_internal_zzwr.zzy(1, this.versionCode);
        com_google_android_gms_internal_zzwr.zzc(2, this.zzUF);
        com_google_android_gms_internal_zzwr.zzc(3, this.zzUG);
        com_google_android_gms_internal_zzwr.zzc(4, this.zzUH);
        super.zza(com_google_android_gms_internal_zzwr);
    }

    public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
        return zzm(com_google_android_gms_internal_zzwq);
    }

    protected int zzc() {
        return (((super.zzc() + zzwr.zzA(1, this.versionCode)) + zzwr.zze(2, this.zzUF)) + zzwr.zze(3, this.zzUG)) + zzwr.zze(4, this.zzUH);
    }

    public zzam zzkJ() {
        this.versionCode = 1;
        this.zzUF = -1;
        this.zzUG = -1;
        this.zzUH = -1;
        this.zzaHB = null;
        this.zzaHM = -1;
        return this;
    }

    public zzam zzm(zzwq com_google_android_gms_internal_zzwq) {
        while (true) {
            int zzvu = com_google_android_gms_internal_zzwq.zzvu();
            switch (zzvu) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzwq.zzvx();
                    continue;
                case 16:
                    this.zzUF = com_google_android_gms_internal_zzwq.zzvA();
                    continue;
                case 24:
                    this.zzUG = com_google_android_gms_internal_zzwq.zzvA();
                    continue;
                case 32:
                    this.zzUH = com_google_android_gms_internal_zzwq.zzvA();
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
