package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzsn.zza;

class zzso extends zzk<zzsn> {
    public zzso(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 49, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    protected String zzcF() {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }

    protected zzsn zzcq(IBinder iBinder) {
        return zza.zzcp(iBinder);
    }

    public boolean zzjd() {
        return true;
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcq(iBinder);
    }
}
