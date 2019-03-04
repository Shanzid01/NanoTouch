package com.google.android.gms.internal;

import java.io.IOException;

class zzp implements zzn {
    private zzwr zzlb;
    private byte[] zzlc;
    private final int zzld;

    public zzp(int i) {
        this.zzld = i;
        reset();
    }

    public void reset() {
        this.zzlc = new byte[this.zzld];
        this.zzlb = zzwr.zzu(this.zzlc);
    }

    public byte[] zzD() {
        int zzvJ = this.zzlb.zzvJ();
        if (zzvJ < 0) {
            throw new IOException();
        } else if (zzvJ == 0) {
            return this.zzlc;
        } else {
            Object obj = new byte[(this.zzlc.length - zzvJ)];
            System.arraycopy(this.zzlc, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void zzb(int i, long j) {
        this.zzlb.zzb(i, j);
    }

    public void zzb(int i, String str) {
        this.zzlb.zzb(i, str);
    }
}
