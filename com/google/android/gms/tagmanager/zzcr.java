package com.google.android.gms.tagmanager;

class zzcr implements zzcc {
    private final long zzEI;
    private final int zzEJ;
    private double zzEK;
    private final Object zzEM;
    private long zzaAu;

    public zzcr() {
        this(60, 2000);
    }

    public zzcr(int i, long j) {
        this.zzEM = new Object();
        this.zzEJ = i;
        this.zzEK = (double) this.zzEJ;
        this.zzEI = j;
    }

    public boolean zzgv() {
        boolean z;
        synchronized (this.zzEM) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzEK < ((double) this.zzEJ)) {
                double d = ((double) (currentTimeMillis - this.zzaAu)) / ((double) this.zzEI);
                if (d > 0.0d) {
                    this.zzEK = Math.min((double) this.zzEJ, d + this.zzEK);
                }
            }
            this.zzaAu = currentTimeMillis;
            if (this.zzEK >= 1.0d) {
                this.zzEK -= 1.0d;
                z = true;
            } else {
                zzbf.zzac("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
