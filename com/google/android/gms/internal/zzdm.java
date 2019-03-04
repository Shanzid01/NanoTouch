package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdt.zza;

@zzgi
public final class zzdm extends zza {
    private final Object zznh = new Object();
    private zzdo.zza zzsA;
    private zzdl zzsB;

    public void onAdClicked() {
        synchronized (this.zznh) {
            if (this.zzsB != null) {
                this.zzsB.zzah();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zznh) {
            if (this.zzsB != null) {
                this.zzsB.zzai();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.zznh) {
            if (this.zzsA != null) {
                this.zzsA.zzm(i == 3 ? 1 : 2);
                this.zzsA = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zznh) {
            if (this.zzsB != null) {
                this.zzsB.zzaj();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.zznh;
        monitor-enter(r1);
        r0 = r3.zzsA;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.zzsA;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zzm(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.zzsA = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.zzsB;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.zzsB;	 Catch:{ all -> 0x001d }
        r0.zzal();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.zznh) {
            if (this.zzsB != null) {
                this.zzsB.zzak();
            }
        }
    }

    public void zza(zzdl com_google_android_gms_internal_zzdl) {
        synchronized (this.zznh) {
            this.zzsB = com_google_android_gms_internal_zzdl;
        }
    }

    public void zza(zzdo.zza com_google_android_gms_internal_zzdo_zza) {
        synchronized (this.zznh) {
            this.zzsA = com_google_android_gms_internal_zzdo_zza;
        }
    }
}
