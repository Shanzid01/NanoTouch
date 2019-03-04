package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;

public final class zzim {
    public static final zzc<zzjh> zzFC = new zzc();
    private static final zzb<zzjh, NoOptions> zzFD = new C12481();
    public static final Api<NoOptions> zzFE = new Api(zzFD, zzFC, new Scope[0]);
    public static final zzjd zzFF = new zzjj();

    final class C12481 implements zzb<zzjh, NoOptions> {
        C12481() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzjh zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjh(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }
}
