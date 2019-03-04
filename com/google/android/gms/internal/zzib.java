package com.google.android.gms.internal;

import com.google.android.gms.internal.zzia.zzd;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgi
public class zzib<T> implements zzia<T> {
    private final Object zznh = new Object();
    protected int zzrX = 0;
    protected final BlockingQueue<zza> zzzL = new LinkedBlockingQueue();
    protected T zzzM;

    class zza {
        public final zzd<T> zzzN;
        public final com.google.android.gms.internal.zzia.zza zzzO;
        final /* synthetic */ zzib zzzP;

        public zza(zzib com_google_android_gms_internal_zzib, zzd<T> com_google_android_gms_internal_zzia_zzd_T, com.google.android.gms.internal.zzia.zza com_google_android_gms_internal_zzia_zza) {
            this.zzzP = com_google_android_gms_internal_zzib;
            this.zzzN = com_google_android_gms_internal_zzia_zzd_T;
            this.zzzO = com_google_android_gms_internal_zzia_zza;
        }
    }

    public int getStatus() {
        return this.zzrX;
    }

    public void reject() {
        synchronized (this.zznh) {
            if (this.zzrX != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzrX = -1;
            for (zza com_google_android_gms_internal_zzib_zza : this.zzzL) {
                com_google_android_gms_internal_zzib_zza.zzzO.run();
            }
        }
    }

    public void zza(zzd<T> com_google_android_gms_internal_zzia_zzd_T, com.google.android.gms.internal.zzia.zza com_google_android_gms_internal_zzia_zza) {
        synchronized (this.zznh) {
            if (this.zzrX == 1) {
                com_google_android_gms_internal_zzia_zzd_T.zza(this.zzzM);
            } else if (this.zzrX == -1) {
                com_google_android_gms_internal_zzia_zza.run();
            } else if (this.zzrX == 0) {
                this.zzzL.add(new zza(this, com_google_android_gms_internal_zzia_zzd_T, com_google_android_gms_internal_zzia_zza));
            }
        }
    }

    public void zzc(T t) {
        synchronized (this.zznh) {
            if (this.zzrX != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzzM = t;
            this.zzrX = 1;
            for (zza com_google_android_gms_internal_zzib_zza : this.zzzL) {
                com_google_android_gms_internal_zzib_zza.zzzN.zza(t);
            }
        }
    }
}
