package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;

public abstract class zzmy<T extends IInterface> extends zzk<T> {
    protected zzmy(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, i, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    public boolean zzhc() {
        return !zzmr.zzV(getContext());
    }

    public boolean zzjd() {
        return true;
    }
}
