package com.google.android.gms.internal;

import android.content.Context;

@zzgi
public final class zzdi {
    private final Context mContext;
    private final zzdr zzlD;
    private final Object zznh = new Object();
    private final zzgo zzse;
    private final zzdk zzsf;
    private boolean zzsg = false;
    private zzdn zzsh;

    public zzdi(Context context, zzgo com_google_android_gms_internal_zzgo, zzdr com_google_android_gms_internal_zzdr, zzdk com_google_android_gms_internal_zzdk) {
        this.mContext = context;
        this.zzse = com_google_android_gms_internal_zzgo;
        this.zzlD = com_google_android_gms_internal_zzdr;
        this.zzsf = com_google_android_gms_internal_zzdk;
    }

    public void cancel() {
        synchronized (this.zznh) {
            this.zzsg = true;
            if (this.zzsh != null) {
                this.zzsh.cancel();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzdo zza(long r18, long r20) {
        /*
        r17 = this;
        r4 = "Starting mediation.";
        com.google.android.gms.internal.zzhx.zzY(r4);
        r0 = r17;
        r4 = r0.zzsf;
        r4 = r4.zzsr;
        r13 = r4.iterator();
    L_0x000f:
        r4 = r13.hasNext();
        if (r4 == 0) goto L_0x00aa;
    L_0x0015:
        r9 = r13.next();
        r9 = (com.google.android.gms.internal.zzdj) r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Trying mediation network: ";
        r4 = r4.append(r5);
        r5 = r9.zzsl;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.internal.zzhx.zzaa(r4);
        r4 = r9.zzsm;
        r14 = r4.iterator();
    L_0x0039:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x000f;
    L_0x003f:
        r6 = r14.next();
        r6 = (java.lang.String) r6;
        r0 = r17;
        r15 = r0.zznh;
        monitor-enter(r15);
        r0 = r17;
        r4 = r0.zzsg;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0058;
    L_0x0050:
        r4 = new com.google.android.gms.internal.zzdo;	 Catch:{ all -> 0x0096 }
        r5 = -1;
        r4.<init>(r5);	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = new com.google.android.gms.internal.zzdn;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r5 = r0.mContext;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r7 = r0.zzlD;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r8 = r0.zzsf;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r10 = r0.zzse;	 Catch:{ all -> 0x0096 }
        r10 = r10.zzwn;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r11 = r0.zzse;	 Catch:{ all -> 0x0096 }
        r11 = r11.zzlV;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r12 = r0.zzse;	 Catch:{ all -> 0x0096 }
        r12 = r12.zzlP;	 Catch:{ all -> 0x0096 }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r0.zzsh = r4;	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r4 = r0.zzsh;
        r0 = r18;
        r2 = r20;
        r4 = r4.zzb(r0, r2);
        r5 = r4.zzsK;
        if (r5 != 0) goto L_0x0099;
    L_0x0090:
        r5 = "Adapter succeeded.";
        com.google.android.gms.internal.zzhx.zzY(r5);
        goto L_0x0057;
    L_0x0096:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        throw r4;
    L_0x0099:
        r5 = r4.zzsM;
        if (r5 == 0) goto L_0x0039;
    L_0x009d:
        r5 = com.google.android.gms.internal.zzhw.zzzG;
        r6 = new com.google.android.gms.internal.zzdi$1;
        r0 = r17;
        r6.<init>(r0, r4);
        r5.post(r6);
        goto L_0x0039;
    L_0x00aa:
        r4 = new com.google.android.gms.internal.zzdo;
        r5 = 1;
        r4.<init>(r5);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdi.zza(long, long):com.google.android.gms.internal.zzdo");
    }
}
