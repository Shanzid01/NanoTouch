package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class zzj extends zzi {
    private static AdvertisingIdClient zzkN = null;
    private static CountDownLatch zzkO = new CountDownLatch(1);
    private static boolean zzkP;

    class zza {
        private String zzkQ;
        private boolean zzkR;
        final /* synthetic */ zzj zzkS;

        public zza(zzj com_google_android_gms_internal_zzj, String str, boolean z) {
            this.zzkS = com_google_android_gms_internal_zzj;
            this.zzkQ = str;
            this.zzkR = z;
        }

        public String getId() {
            return this.zzkQ;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzkR;
        }
    }

    final class zzb implements Runnable {
        private Context zzkT;

        public zzb(Context context) {
            this.zzkT = context.getApplicationContext();
            if (this.zzkT == null) {
                this.zzkT = context;
            }
        }

        public void run() {
            try {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzkT);
                advertisingIdClient.start();
                synchronized (zzj.class) {
                    if (zzj.zzkN == null) {
                        zzj.zzkN = advertisingIdClient;
                    } else {
                        advertisingIdClient.finish();
                    }
                }
            } catch (GooglePlayServicesNotAvailableException e) {
                zzj.zzkP = true;
            } catch (IOException e2) {
            } catch (GooglePlayServicesRepairableException e3) {
            }
            zzj.zzkO.countDown();
        }
    }

    protected zzj(Context context, zzm com_google_android_gms_internal_zzm, zzn com_google_android_gms_internal_zzn) {
        super(context, com_google_android_gms_internal_zzm, com_google_android_gms_internal_zzn);
    }

    public static zzj zza(String str, Context context) {
        zzm com_google_android_gms_internal_zze = new zze();
        zzi.zza(str, context, com_google_android_gms_internal_zze);
        synchronized (zzj.class) {
            if (zzkN == null) {
                new Thread(new zzb(context)).start();
            }
        }
        return new zzj(context, com_google_android_gms_internal_zze, new zzp(239));
    }

    protected void zzb(Context context) {
        super.zzb(context);
        try {
            if (zzkP) {
                zza(24, zzi.zzd(context));
                return;
            }
            zza zzz = zzz();
            zza(28, zzz.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = zzz.getId();
            if (id != null) {
                zza(26, 5);
                zza(24, id);
            }
        } catch (IOException e) {
        } catch (zza e2) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.google.android.gms.internal.zzj.zza zzz() {
        /*
        r8 = this;
        r7 = 16;
        r0 = 0;
        r1 = com.google.android.gms.internal.zzj.class;
        monitor-enter(r1);
        r2 = zzkO;	 Catch:{ InterruptedException -> 0x001b }
        r4 = 2;
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x001b }
        r2 = r2.await(r4, r3);	 Catch:{ InterruptedException -> 0x001b }
        if (r2 != 0) goto L_0x0028;
    L_0x0012:
        r0 = new com.google.android.gms.internal.zzj$zza;	 Catch:{ InterruptedException -> 0x001b }
        r2 = 0;
        r3 = 0;
        r0.<init>(r8, r2, r3);	 Catch:{ InterruptedException -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = move-exception;
        r0 = new com.google.android.gms.internal.zzj$zza;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        r3 = 0;
        r0.<init>(r8, r2, r3);	 Catch:{ all -> 0x0025 }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        goto L_0x001a;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r2 = zzkN;	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x0035;
    L_0x002c:
        r0 = new com.google.android.gms.internal.zzj$zza;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        r3 = 0;
        r0.<init>(r8, r2, r3);	 Catch:{ all -> 0x0025 }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        goto L_0x001a;
    L_0x0035:
        r2 = zzkN;	 Catch:{ all -> 0x0025 }
        r3 = r2.getInfo();	 Catch:{ all -> 0x0025 }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        r2 = r3.getId();
        if (r2 == 0) goto L_0x0094;
    L_0x0042:
        r1 = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        r1 = r2.matches(r1);
        if (r1 == 0) goto L_0x0094;
    L_0x004a:
        r4 = new byte[r7];
        r1 = r0;
    L_0x004d:
        r5 = r2.length();
        if (r0 >= r5) goto L_0x0082;
    L_0x0053:
        r5 = 8;
        if (r0 == r5) goto L_0x0063;
    L_0x0057:
        r5 = 13;
        if (r0 == r5) goto L_0x0063;
    L_0x005b:
        r5 = 18;
        if (r0 == r5) goto L_0x0063;
    L_0x005f:
        r5 = 23;
        if (r0 != r5) goto L_0x0065;
    L_0x0063:
        r0 = r0 + 1;
    L_0x0065:
        r5 = r2.charAt(r0);
        r5 = java.lang.Character.digit(r5, r7);
        r5 = r5 << 4;
        r6 = r0 + 1;
        r6 = r2.charAt(r6);
        r6 = java.lang.Character.digit(r6, r7);
        r5 = r5 + r6;
        r5 = (byte) r5;
        r4[r1] = r5;
        r1 = r1 + 1;
        r0 = r0 + 2;
        goto L_0x004d;
    L_0x0082:
        r0 = r8.zzkx;
        r1 = 1;
        r0 = r0.zza(r4, r1);
    L_0x0089:
        r1 = new com.google.android.gms.internal.zzj$zza;
        r2 = r3.isLimitAdTrackingEnabled();
        r1.<init>(r8, r0, r2);
        r0 = r1;
        goto L_0x001a;
    L_0x0094:
        r0 = r2;
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzj.zzz():com.google.android.gms.internal.zzj$zza");
    }
}
