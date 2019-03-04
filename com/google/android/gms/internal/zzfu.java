package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

@zzgi
public final class zzfu extends zzg<zzfq> {
    private static final zzfu zzvw = new zzfu();

    final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzfu() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean zzc(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static zzfp zze(Activity activity) {
        try {
            if (!zzc(activity)) {
                return zzvw.zzf(activity);
            }
            zzhx.zzY("Using AdOverlay from the client jar.");
            return new zzff(activity);
        } catch (zza e) {
            zzhx.zzac(e.getMessage());
            return null;
        }
    }

    private zzfp zzf(Activity activity) {
        try {
            return com.google.android.gms.internal.zzfp.zza.zzA(((zzfq) zzS(activity)).zzc(zze.zzn(activity)));
        } catch (Throwable e) {
            zzhx.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            zzhx.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected zzfq zzE(IBinder iBinder) {
        return com.google.android.gms.internal.zzfq.zza.zzB(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzE(iBinder);
    }
}
