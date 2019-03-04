package com.google.android.gms.analytics;

class zzad implements zzah {
    private final long zzEI;
    private final int zzEJ;
    private double zzEK;
    private long zzEL;
    private final Object zzEM;
    private final String zzrc;

    public zzad(int i, long j, String str) {
        this.zzEM = new Object();
        this.zzEJ = i;
        this.zzEK = (double) this.zzEJ;
        this.zzEI = j;
        this.zzrc = str;
    }

    public zzad(String str) {
        this(60, 2000, str);
    }

    public boolean zzgv() {
        boolean z;
        synchronized (this.zzEM) {
            long currentTimeMillis = System.currentTimeMillis();
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
                zzae.zzac("Excessive " + this.zzrc + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
