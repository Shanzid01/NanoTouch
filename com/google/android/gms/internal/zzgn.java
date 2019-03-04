package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzgs.zza;

@zzgi
public class zzgn extends zzk<zzgs> {
    final int zzrQ;

    public zzgn(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), 8, connectionCallbacks, onConnectionFailedListener);
        this.zzrQ = i;
    }

    protected zzgs zzF(IBinder iBinder) {
        return zza.zzG(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public zzgs zzdL() {
        return (zzgs) super.zzjb();
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzF(iBinder);
    }
}
