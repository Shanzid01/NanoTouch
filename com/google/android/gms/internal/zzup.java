package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import java.util.concurrent.Executors;

public final class zzup {
    public static final Api<zzus> API = new Api(zzGS, zzGR, new Scope[0]);
    public static final zzc<zzvc> zzGR = new zzc();
    public static final zzb<zzvc, zzus> zzGS = new C13561();
    public static final zzuq zzawO = new zzvb();

    final class C13561 implements zzb<zzvc, zzus> {
        C13561() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzvc zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzus com_google_android_gms_internal_zzus, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzvc(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzus == null ? zzus.zzawP : com_google_android_gms_internal_zzus, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    }
}
