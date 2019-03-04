package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.tagmanager.zzbf;

public abstract class zzvt {
    private zzvj zzaCG;
    private zzvh zzaCH;
    private zzlv zzmW;

    public enum zza {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    public class zzb {
        private final Object zzaCM;
        private final com.google.android.gms.internal.zzvk.zza.zza zzaCa;
        private final long zzaCc;

        public Object zzuP() {
            return this.zzaCM;
        }

        public com.google.android.gms.internal.zzvk.zza.zza zzup() {
            return this.zzaCa;
        }

        public long zzut() {
            return this.zzaCc;
        }
    }

    public zzvt(zzvj com_google_android_gms_internal_zzvj, zzvh com_google_android_gms_internal_zzvh) {
        this(com_google_android_gms_internal_zzvj, com_google_android_gms_internal_zzvh, zzlx.zzkc());
    }

    public zzvt(zzvj com_google_android_gms_internal_zzvj, zzvh com_google_android_gms_internal_zzvh, zzlv com_google_android_gms_internal_zzlv) {
        boolean z = true;
        if (com_google_android_gms_internal_zzvj.zzun().size() != 1) {
            z = false;
        }
        zzx.zzO(z);
        this.zzaCG = com_google_android_gms_internal_zzvj;
        this.zzaCH = com_google_android_gms_internal_zzvh;
        this.zzmW = com_google_android_gms_internal_zzlv;
    }

    protected abstract zzb zza(zzve com_google_android_gms_internal_zzve);

    protected abstract void zza(zzvk com_google_android_gms_internal_zzvk);

    public void zza(zza com_google_android_gms_internal_zzvt_zza) {
        zzbf.zzZ("ResourceManager: Failed to download a resource: " + com_google_android_gms_internal_zzvt_zza.name());
        zzve com_google_android_gms_internal_zzve = (zzve) this.zzaCG.zzun().get(0);
        zzb zza = zza(com_google_android_gms_internal_zzve);
        com.google.android.gms.internal.zzvk.zza com_google_android_gms_internal_zzvk_zza = (zza == null || !(zza.zzuP() instanceof zzc)) ? new com.google.android.gms.internal.zzvk.zza(Status.zzNq, com_google_android_gms_internal_zzve, com.google.android.gms.internal.zzvk.zza.zza.NETWORK) : new com.google.android.gms.internal.zzvk.zza(Status.zzNo, com_google_android_gms_internal_zzve, null, (zzc) zza.zzuP(), zza.zzup(), zza.zzut());
        zza(new zzvk(com_google_android_gms_internal_zzvk_zza));
    }

    public void zzo(byte[] bArr) {
        long j;
        com.google.android.gms.internal.zzvk.zza.zza com_google_android_gms_internal_zzvk_zza_zza;
        Object obj;
        com.google.android.gms.internal.zzvk.zza com_google_android_gms_internal_zzvk_zza;
        zzbf.zzab("ResourceManager: Resource downloaded from Network: " + this.zzaCG.getId());
        zzve com_google_android_gms_internal_zzve = (zzve) this.zzaCG.zzun().get(0);
        com.google.android.gms.internal.zzvk.zza.zza com_google_android_gms_internal_zzvk_zza_zza2 = com.google.android.gms.internal.zzvk.zza.zza.NETWORK;
        Object zzn;
        zzb zza;
        try {
            zzn = this.zzaCH.zzn(bArr);
            long currentTimeMillis = this.zzmW.currentTimeMillis();
            if (zzn == null) {
                zzbf.zzaa("Parsed resource from network is null");
                zza = zza(com_google_android_gms_internal_zzve);
                if (zza != null) {
                    zzn = zza.zzuP();
                    com_google_android_gms_internal_zzvk_zza_zza2 = zza.zzup();
                    currentTimeMillis = zza.zzut();
                }
            }
            j = currentTimeMillis;
            com_google_android_gms_internal_zzvk_zza_zza = com_google_android_gms_internal_zzvk_zza_zza2;
            obj = zzn;
        } catch (zzg e) {
            zzbf.zzaa("Resource from network is corrupted");
            zza = zza(com_google_android_gms_internal_zzve);
            if (zza != null) {
                zzn = zza.zzuP();
                j = 0;
                com_google_android_gms_internal_zzvk_zza_zza = zza.zzup();
                obj = zzn;
            } else {
                j = 0;
                com_google_android_gms_internal_zzvk_zza_zza = com_google_android_gms_internal_zzvk_zza_zza2;
                obj = null;
            }
        }
        if (obj != null) {
            com_google_android_gms_internal_zzvk_zza = new com.google.android.gms.internal.zzvk.zza(Status.zzNo, com_google_android_gms_internal_zzve, bArr, (zzc) obj, com_google_android_gms_internal_zzvk_zza_zza, j);
        } else {
            com_google_android_gms_internal_zzvk_zza = new com.google.android.gms.internal.zzvk.zza(Status.zzNq, com_google_android_gms_internal_zzve, com.google.android.gms.internal.zzvk.zza.zza.NETWORK);
        }
        zza(new zzvk(com_google_android_gms_internal_zzvk_zza));
    }
}
