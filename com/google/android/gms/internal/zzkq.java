package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;

public final class zzkq implements zzkp {

    class zza extends zzkn {
        private final zzb<Status> zzHa;

        public zza(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzaQ(int i) {
            this.zzHa.zzd(new Status(i));
        }
    }

    public PendingResult<Status> zzc(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzkq zzQz;

            protected void zza(zzks com_google_android_gms_internal_zzks) {
                ((zzku) com_google_android_gms_internal_zzks.zzjb()).zza(new zza(this));
            }
        });
    }
}
