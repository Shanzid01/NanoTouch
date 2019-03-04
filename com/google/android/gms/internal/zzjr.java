package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zza;

public abstract class zzjr<R extends Result> extends zza<R, zzju> {
    public zzjr(GoogleApiClient googleApiClient) {
        super(zzkb.zzGR, googleApiClient);
    }

    public void zzah(int i) {
        setResult(createFailedResult(new Status(i)));
    }

    public void zzd(int i, String str) {
        setResult(createFailedResult(new Status(i, str, null)));
    }
}
