package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.zzdc.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@zzgi
public class zzbz implements zzb {
    private boolean zzmE = false;
    private final Object zznh = new Object();
    private final zzhq<Bundle> zzqh = new zzhq();
    private final List<Runnable> zzqi = new ArrayList();
    private boolean zzqj = false;

    public void zza(Runnable runnable) {
        synchronized (this.zznh) {
            if (this.zzqj) {
                runnable.run();
                return;
            }
            this.zzqi.add(runnable);
        }
    }

    public Future<Bundle> zzcc() {
        return this.zzqh;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zze(android.os.Bundle r3) {
        /*
        r2 = this;
        r1 = r2.zznh;
        monitor-enter(r1);
        r0 = r2.zzqj;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = 1;
        r2.zzqj = r0;	 Catch:{ all -> 0x0028 }
        r0 = r2.zzqh;	 Catch:{ all -> 0x0028 }
        r0.zzb(r3);	 Catch:{ all -> 0x0028 }
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        r0 = r2.zzqi;
        r1 = r0.iterator();
    L_0x0018:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x002b;
    L_0x001e:
        r0 = r1.next();
        r0 = (java.lang.Runnable) r0;
        r0.run();
        goto L_0x0018;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r0 = r2.zzqi;
        r0.clear();
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbz.zze(android.os.Bundle):void");
    }

    public void zzl(Context context) {
        synchronized (this.zznh) {
            if (this.zzmE) {
                return;
            }
            zzdc.zza(context, this);
            this.zzmE = true;
        }
    }
}
