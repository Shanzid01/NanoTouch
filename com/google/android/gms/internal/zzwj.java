package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzwe.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzwj extends zzg<zzwe> {
    private static zzwj zzaFa;

    protected zzwj() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static zzwb zza(Activity activity, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzwc com_google_android_gms_internal_zzwc) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzwe) zzuU().zzS(activity)).zza(zze.zzn(activity), com_google_android_gms_dynamic_zzc, walletFragmentOptions, com_google_android_gms_internal_zzwc);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static zzwj zzuU() {
        if (zzaFa == null) {
            zzaFa = new zzwj();
        }
        return zzaFa;
    }

    protected zzwe zzcO(IBinder iBinder) {
        return zza.zzcK(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzcO(iBinder);
    }
}
