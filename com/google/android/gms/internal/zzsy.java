package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzsy implements PanoramaResult {
    private final Status zzHb;
    private final Intent zzatA;

    public zzsy(Status status, Intent intent) {
        this.zzHb = (Status) zzx.zzl(status);
        this.zzatA = intent;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    public Intent getViewerIntent() {
        return this.zzatA;
    }
}
