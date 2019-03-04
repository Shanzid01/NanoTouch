package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

public abstract class zzq<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzr> {

    public abstract class zza extends zzq<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    public zzq(GoogleApiClient googleApiClient) {
        super(Drive.zzGR, googleApiClient);
    }
}
