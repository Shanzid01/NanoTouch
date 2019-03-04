package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzsv.zza;

public class zzsx extends zzk<zzsv> {
    public zzsx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 3, connectionCallbacks, onConnectionFailedListener);
    }

    protected String zzcF() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public zzsv zzct(IBinder iBinder) {
        return zza.zzcs(iBinder);
    }

    public /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzct(iBinder);
    }
}
