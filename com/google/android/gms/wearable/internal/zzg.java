package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.wearable.Wearable;

abstract class zzg<R extends Result> extends zza<R, zzbd> {
    public zzg(GoogleApiClient googleApiClient) {
        super(Wearable.zzGR, googleApiClient);
    }
}
