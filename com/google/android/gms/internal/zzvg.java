package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.zzbf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzvg {
    private final Context mContext;
    private final zzvn zzaBP;
    Map<String, zzc<com.google.android.gms.internal.zzvl.zzc>> zzaBQ;
    private final Map<String, zzvv> zzaBR;
    private String zzaya;
    private final zzlv zzmW;

    public interface zza {
        void zza(zzvk com_google_android_gms_internal_zzvk);
    }

    class zzb extends zzvt {
        final /* synthetic */ zzvg zzaBU;
        private final zza zzaBV;

        zzb(zzvg com_google_android_gms_internal_zzvg, zzvj com_google_android_gms_internal_zzvj, zzvh com_google_android_gms_internal_zzvh, zza com_google_android_gms_internal_zzvg_zza) {
            this.zzaBU = com_google_android_gms_internal_zzvg;
            super(com_google_android_gms_internal_zzvj, com_google_android_gms_internal_zzvh);
            this.zzaBV = com_google_android_gms_internal_zzvg_zza;
        }

        protected com.google.android.gms.internal.zzvt.zzb zza(zzve com_google_android_gms_internal_zzve) {
            return null;
        }

        protected void zza(zzvk com_google_android_gms_internal_zzvk) {
            com.google.android.gms.internal.zzvk.zza zzuo = com_google_android_gms_internal_zzvk.zzuo();
            this.zzaBU.zza(zzuo);
            if (zzuo.getStatus() != Status.zzNo || zzuo.zzup() != com.google.android.gms.internal.zzvk.zza.zza.NETWORK || zzuo.zzuq() == null || zzuo.zzuq().length <= 0) {
                zzbf.zzab("Response status: " + (zzuo.getStatus().isSuccess() ? "SUCCESS" : "FAILURE"));
                if (zzuo.getStatus().isSuccess()) {
                    zzbf.zzab("Response source: " + zzuo.zzup().toString());
                    zzbf.zzab("Response size: " + zzuo.zzuq().length);
                }
                this.zzaBU.zza(zzuo.zzur(), this.zzaBV);
                return;
            }
            this.zzaBU.zzaBP.zzf(zzuo.zzur().zzuj(), zzuo.zzuq());
            zzbf.zzab("Resource successfully load from Network.");
            this.zzaBV.zza(com_google_android_gms_internal_zzvk);
        }
    }

    class zzc<T> {
        private T mData;
        private Status zzHb;
        private long zzaBW;

        public zzc(Status status, T t, long j) {
            this.zzHb = status;
            this.mData = t;
            this.zzaBW = j;
        }

        public void zzD(T t) {
            this.mData = t;
        }

        public void zzJ(long j) {
            this.zzaBW = j;
        }

        public void zzaO(Status status) {
            this.zzHb = status;
        }

        public long zzum() {
            return this.zzaBW;
        }
    }

    public zzvg(Context context) {
        this(context, new HashMap(), new zzvn(context), zzlx.zzkc());
    }

    zzvg(Context context, Map<String, zzvv> map, zzvn com_google_android_gms_internal_zzvn, zzlv com_google_android_gms_internal_zzlv) {
        this.zzaya = null;
        this.zzaBQ = new HashMap();
        this.mContext = context;
        this.zzmW = com_google_android_gms_internal_zzlv;
        this.zzaBP = com_google_android_gms_internal_zzvn;
        this.zzaBR = map;
    }

    private void zza(zzvj com_google_android_gms_internal_zzvj, zza com_google_android_gms_internal_zzvg_zza) {
        boolean z = true;
        List zzun = com_google_android_gms_internal_zzvj.zzun();
        if (zzun.size() != 1) {
            z = false;
        }
        zzx.zzO(z);
        zza((zzve) zzun.get(0), com_google_android_gms_internal_zzvg_zza);
    }

    void zza(final zzve com_google_android_gms_internal_zzve, final zza com_google_android_gms_internal_zzvg_zza) {
        this.zzaBP.zza(com_google_android_gms_internal_zzve.zzuj(), com_google_android_gms_internal_zzve.zzuh(), zzvi.zzaBX, new zzvm(this) {
            final /* synthetic */ zzvg zzaBU;

            public void zza(Status status, Object obj, Integer num, long j) {
                com.google.android.gms.internal.zzvk.zza com_google_android_gms_internal_zzvk_zza;
                if (status.isSuccess()) {
                    com_google_android_gms_internal_zzvk_zza = new com.google.android.gms.internal.zzvk.zza(Status.zzNo, com_google_android_gms_internal_zzve, null, (com.google.android.gms.internal.zzvl.zzc) obj, num == zzvn.zzaCx ? com.google.android.gms.internal.zzvk.zza.zza.DEFAULT : com.google.android.gms.internal.zzvk.zza.zza.DISK, j);
                } else {
                    com_google_android_gms_internal_zzvk_zza = new com.google.android.gms.internal.zzvk.zza(new Status(16, "There is no valid resource for the container: " + com_google_android_gms_internal_zzve.getContainerId()), null, com.google.android.gms.internal.zzvk.zza.zza.DISK);
                }
                com_google_android_gms_internal_zzvg_zza.zza(new zzvk(com_google_android_gms_internal_zzvk_zza));
            }
        });
    }

    void zza(zzvj com_google_android_gms_internal_zzvj, zza com_google_android_gms_internal_zzvg_zza, zzvt com_google_android_gms_internal_zzvt) {
        Object obj = null;
        for (zzve com_google_android_gms_internal_zzve : com_google_android_gms_internal_zzvj.zzun()) {
            zzc com_google_android_gms_internal_zzvg_zzc = (zzc) this.zzaBQ.get(com_google_android_gms_internal_zzve.getContainerId());
            obj = (com_google_android_gms_internal_zzvg_zzc != null ? com_google_android_gms_internal_zzvg_zzc.zzum() : this.zzaBP.zzdD(com_google_android_gms_internal_zzve.getContainerId())) + 900000 < this.zzmW.currentTimeMillis() ? 1 : obj;
        }
        if (obj != null) {
            zzvv com_google_android_gms_internal_zzvv;
            zzvv com_google_android_gms_internal_zzvv2 = (zzvv) this.zzaBR.get(com_google_android_gms_internal_zzvj.getId());
            if (com_google_android_gms_internal_zzvv2 == null) {
                com_google_android_gms_internal_zzvv2 = this.zzaya == null ? new zzvv() : new zzvv(this.zzaya);
                this.zzaBR.put(com_google_android_gms_internal_zzvj.getId(), com_google_android_gms_internal_zzvv2);
                com_google_android_gms_internal_zzvv = com_google_android_gms_internal_zzvv2;
            } else {
                com_google_android_gms_internal_zzvv = com_google_android_gms_internal_zzvv2;
            }
            com_google_android_gms_internal_zzvv.zza(this.mContext, com_google_android_gms_internal_zzvj, 0, com_google_android_gms_internal_zzvt);
            return;
        }
        zza(com_google_android_gms_internal_zzvj, com_google_android_gms_internal_zzvg_zza);
    }

    void zza(com.google.android.gms.internal.zzvk.zza com_google_android_gms_internal_zzvk_zza) {
        String containerId = com_google_android_gms_internal_zzvk_zza.zzur().getContainerId();
        Status status = com_google_android_gms_internal_zzvk_zza.getStatus();
        com.google.android.gms.internal.zzvl.zzc zzus = com_google_android_gms_internal_zzvk_zza.zzus();
        if (this.zzaBQ.containsKey(containerId)) {
            zzc com_google_android_gms_internal_zzvg_zzc = (zzc) this.zzaBQ.get(containerId);
            com_google_android_gms_internal_zzvg_zzc.zzJ(this.zzmW.currentTimeMillis());
            if (status == Status.zzNo) {
                com_google_android_gms_internal_zzvg_zzc.zzaO(status);
                com_google_android_gms_internal_zzvg_zzc.zzD(zzus);
                return;
            }
            return;
        }
        this.zzaBQ.put(containerId, new zzc(status, zzus, this.zzmW.currentTimeMillis()));
    }

    public void zza(String str, Integer num, String str2, zza com_google_android_gms_internal_zzvg_zza) {
        zzvj zzb = new zzvj().zzb(new zzve(str, num, str2, false));
        zza(zzb, com_google_android_gms_internal_zzvg_zza, new zzb(this, zzb, zzvi.zzaBX, com_google_android_gms_internal_zzvg_zza));
    }

    public void zzdx(String str) {
        this.zzaya = str;
    }
}
