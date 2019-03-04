package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public class zzbl extends zzc {
    private final zzb<Status> zzHa;

    public zzbl(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
    }

    public void onSuccess() {
        this.zzHa.zzd(Status.zzNo);
    }

    public void zzm(Status status) {
        this.zzHa.zzd(status);
    }
}
