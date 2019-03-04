package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzws;
import com.google.android.gms.internal.zzwy;

public final class zzan extends zzws<zzan> {
    public int versionCode;
    public long zzUG;
    public String zzUI;
    public long zzUJ;
    public int zzUK;

    public zzan() {
        zzkK();
    }

    public static zzan zzh(byte[] bArr) {
        return (zzan) zzwy.zza(new zzan(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzan)) {
            return false;
        }
        zzan com_google_android_gms_drive_internal_zzan = (zzan) obj;
        if (this.versionCode != com_google_android_gms_drive_internal_zzan.versionCode) {
            return false;
        }
        if (this.zzUI == null) {
            if (com_google_android_gms_drive_internal_zzan.zzUI != null) {
                return false;
            }
        } else if (!this.zzUI.equals(com_google_android_gms_drive_internal_zzan.zzUI)) {
            return false;
        }
        return (this.zzUJ == com_google_android_gms_drive_internal_zzan.zzUJ && this.zzUG == com_google_android_gms_drive_internal_zzan.zzUG && this.zzUK == com_google_android_gms_drive_internal_zzan.zzUK) ? zza((zzws) com_google_android_gms_drive_internal_zzan) : false;
    }

    public int hashCode() {
        return (((((((((this.zzUI == null ? 0 : this.zzUI.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.zzUJ ^ (this.zzUJ >>> 32)))) * 31) + ((int) (this.zzUG ^ (this.zzUG >>> 32)))) * 31) + this.zzUK) * 31) + zzvL();
    }

    public void zza(zzwr com_google_android_gms_internal_zzwr) {
        com_google_android_gms_internal_zzwr.zzy(1, this.versionCode);
        com_google_android_gms_internal_zzwr.zzb(2, this.zzUI);
        com_google_android_gms_internal_zzwr.zzc(3, this.zzUJ);
        com_google_android_gms_internal_zzwr.zzc(4, this.zzUG);
        if (this.zzUK != -1) {
            com_google_android_gms_internal_zzwr.zzy(5, this.zzUK);
        }
        super.zza(com_google_android_gms_internal_zzwr);
    }

    public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
        return zzn(com_google_android_gms_internal_zzwq);
    }

    protected int zzc() {
        int zzc = (((super.zzc() + zzwr.zzA(1, this.versionCode)) + zzwr.zzj(2, this.zzUI)) + zzwr.zze(3, this.zzUJ)) + zzwr.zze(4, this.zzUG);
        return this.zzUK != -1 ? zzc + zzwr.zzA(5, this.zzUK) : zzc;
    }

    public zzan zzkK() {
        this.versionCode = 1;
        this.zzUI = "";
        this.zzUJ = -1;
        this.zzUG = -1;
        this.zzUK = -1;
        this.zzaHB = null;
        this.zzaHM = -1;
        return this;
    }

    public zzan zzn(zzwq com_google_android_gms_internal_zzwq) {
        while (true) {
            int zzvu = com_google_android_gms_internal_zzwq.zzvu();
            switch (zzvu) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzwq.zzvx();
                    continue;
                case 18:
                    this.zzUI = com_google_android_gms_internal_zzwq.readString();
                    continue;
                case 24:
                    this.zzUJ = com_google_android_gms_internal_zzwq.zzvA();
                    continue;
                case 32:
                    this.zzUG = com_google_android_gms_internal_zzwq.zzvA();
                    continue;
                case 40:
                    this.zzUK = com_google_android_gms_internal_zzwq.zzvx();
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
