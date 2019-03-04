package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zzov implements ActivityRecognitionApi {

    abstract class zza extends com.google.android.gms.location.ActivityRecognition.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzov zzamD;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(pendingIntent);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        final long j2 = j;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzov zzamD;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(j2, pendingIntent2);
                setResult(Status.zzNo);
            }
        });
    }
}
