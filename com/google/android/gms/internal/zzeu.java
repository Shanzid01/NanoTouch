package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

@zzgi
public final class zzeu extends zzg<zzew> {
    private static final zzeu zzuL = new zzeu();

    final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzeu() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static zzev zzb(Activity activity) {
        try {
            if (!zzc(activity)) {
                return zzuL.zzd(activity);
            }
            zzhx.zzY("Using AdOverlay from the client jar.");
            return new zzel(activity);
        } catch (zza e) {
            zzhx.zzac(e.getMessage());
            return null;
        }
    }

    private static boolean zzc(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private zzev zzd(Activity activity) {
        try {
            return com.google.android.gms.internal.zzev.zza.zzv(((zzew) zzS(activity)).zzb(zze.zzn(activity)));
        } catch (Throwable e) {
            zzhx.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            zzhx.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzu(iBinder);
    }

    protected zzew zzu(IBinder iBinder) {
        return com.google.android.gms.internal.zzew.zza.zzw(iBinder);
    }
}
