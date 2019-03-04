package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzje.zza;

public class zzjh extends zzk<zzje> {
    public zzjh(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzje zzK(IBinder iBinder) {
        return zza.zzI(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzcG() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public zzje zzgY() {
        return (zzje) zzjb();
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzK(iBinder);
    }
}
