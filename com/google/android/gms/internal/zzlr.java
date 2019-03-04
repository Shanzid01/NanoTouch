package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.v4.p004b.C0058q;
import android.util.Log;

public class zzlr {
    private final long zzRK;
    private final int zzRL;
    private final C0058q<Long, Long> zzRM;

    public zzlr() {
        this.zzRK = 60000;
        this.zzRL = 10;
        this.zzRM = new C0058q(10);
    }

    public zzlr(int i, long j) {
        this.zzRK = j;
        this.zzRL = i;
        this.zzRM = new C0058q();
    }

    private void zzc(long j, long j2) {
        for (int size = this.zzRM.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.zzRM.m60c(size)).longValue() > j) {
                this.zzRM.m61d(size);
            }
        }
    }

    public Long zza(Long l) {
        Long l2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzRK;
        synchronized (this) {
            while (this.zzRM.size() >= this.zzRL) {
                zzc(j, elapsedRealtime);
                j /= 2;
                Log.w("PassiveTimedConnectionMap", "The max capacity " + this.zzRL + " is not enough. Current durationThreshold is: " + j);
            }
            l2 = (Long) this.zzRM.put(l, Long.valueOf(elapsedRealtime));
        }
        return l2;
    }

    public boolean zzr(long j) {
        boolean z;
        synchronized (this) {
            z = this.zzRM.remove(Long.valueOf(j)) != null;
        }
        return z;
    }
}
