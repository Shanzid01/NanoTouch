package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbl.zza;
import java.util.Random;

public class zzbf extends zza {
    private Object zznh = new Object();
    private final Random zzpl = new Random();
    private long zzpm;

    public zzbf() {
        zzbG();
    }

    public long getValue() {
        return this.zzpm;
    }

    public void zzbG() {
        synchronized (this.zznh) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.zzpl.nextInt()) + 2147483648L;
                if (j != this.zzpm && j != 0) {
                    break;
                }
            }
            this.zzpm = j;
        }
    }
}
