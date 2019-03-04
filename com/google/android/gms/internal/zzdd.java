package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzde.zza;

@zzgi
public class zzdd extends zzk<zzde> {
    final int zzrQ;

    public zzdd(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), 46, connectionCallbacks, onConnectionFailedListener);
        this.zzrQ = i;
    }

    protected String zzcF() {
        return "com.google.android.gms.ads.gservice.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
    }

    public zzde zzcH() {
        return (zzde) super.zzjb();
    }

    protected zzde zzo(IBinder iBinder) {
        return zza.zzq(iBinder);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzo(iBinder);
    }
}
