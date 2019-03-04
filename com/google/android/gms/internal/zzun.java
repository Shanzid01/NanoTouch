package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzul.zza;

public class zzun extends zzk<zzul> {
    public zzun(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzuk com_google_android_gms_internal_zzuk, byte[] bArr) {
        ((zzul) zzjb()).zza(com_google_android_gms_internal_zzuk, bArr);
    }

    protected zzul zzcD(IBinder iBinder) {
        return zza.zzcC(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.gms.safetynet.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcD(iBinder);
    }
}
