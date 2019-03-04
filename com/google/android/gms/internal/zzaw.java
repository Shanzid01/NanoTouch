package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzbi.zza;

@zzgi
public class zzaw extends zzg<zzbj> {
    public zzaw() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzbi zzb(Context context, zzba com_google_android_gms_internal_zzba, String str, zzdq com_google_android_gms_internal_zzdq) {
        try {
            return zza.zzg(((zzbj) zzS(context)).zza(zze.zzn(context), com_google_android_gms_internal_zzba, str, com_google_android_gms_internal_zzdq, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            zzhx.zzd("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            zzhx.zzd("Could not create remote AdManager.", e2);
            return null;
        }
    }

    public zzbi zza(Context context, zzba com_google_android_gms_internal_zzba, String str, zzdq com_google_android_gms_internal_zzdq) {
        if (zzbe.zzbD().zzA(context)) {
            zzbi zzb = zzb(context, com_google_android_gms_internal_zzba, str, com_google_android_gms_internal_zzdq);
            if (zzb != null) {
                return zzb;
            }
        }
        zzhx.zzY("Using AdManager from the client jar.");
        return new zzt(context, com_google_android_gms_internal_zzba, str, com_google_android_gms_internal_zzdq, new zzhy(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    protected zzbj zzc(IBinder iBinder) {
        return zzbj.zza.zzh(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzc(iBinder);
    }
}
