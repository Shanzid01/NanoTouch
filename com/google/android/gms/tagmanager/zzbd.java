package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzlv;

class zzbd implements zzcc {
    private final long zzEI;
    private final int zzEJ;
    private double zzEK;
    private long zzEL;
    private final Object zzEM = new Object();
    private final long zzazf;
    private final zzlv zzmW;
    private final String zzrc;

    public zzbd(int i, long j, long j2, String str, zzlv com_google_android_gms_internal_zzlv) {
        this.zzEJ = i;
        this.zzEK = (double) this.zzEJ;
        this.zzEI = j;
        this.zzazf = j2;
        this.zzrc = str;
        this.zzmW = com_google_android_gms_internal_zzlv;
    }

    public boolean zzgv() {
        boolean z = false;
        synchronized (this.zzEM) {
            long currentTimeMillis = this.zzmW.currentTimeMillis();
            if (currentTimeMillis - this.zzEL < this.zzazf) {
                zzbf.zzac("Excessive " + this.zzrc + " detected; call ignored.");
            } else {
                if (this.zzEK < ((double) this.zzEJ)) {
                    double d = ((double) (currentTimeMillis - this.zzEL)) / ((double) this.zzEI);
                    if (d > 0.0d) {
                        this.zzEK = Math.min((double) this.zzEJ, d + this.zzEK);
                    }
                }
                this.zzEL = currentTimeMillis;
                if (this.zzEK >= 1.0d) {
                    this.zzEK -= 1.0d;
                    z = true;
                } else {
                    zzbf.zzac("Excessive " + this.zzrc + " detected; call ignored.");
                }
            }
        }
        return z;
    }
}
