package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoq;

public final class Address {
    public static final Api<AddressOptions> API = new Api(zzGS, zzGR, new Scope[0]);
    static final zzc<zzoq> zzGR = new zzc();
    private static final zzb<zzoq, AddressOptions> zzGS = new C11361();

    final class C11361 implements zzb<zzoq, AddressOptions> {
        C11361() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzoq zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzoq((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf.getAccountName(), addressOptions.theme);
        }
    }

    abstract class zza extends com.google.android.gms.common.api.zza.zza<Status, zzoq> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzGR, googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    final class C11372 extends zza {
        final /* synthetic */ UserAddressRequest zzalp;
        final /* synthetic */ int zzalq;

        C11372(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
            this.zzalp = userAddressRequest;
            this.zzalq = i;
            super(googleApiClient);
        }

        protected void zza(zzoq com_google_android_gms_internal_zzoq) {
            com_google_android_gms_internal_zzoq.zza(this.zzalp, this.zzalq);
            setResult(Status.zzNo);
        }
    }

    public final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int i) {
            this.theme = i;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
        googleApiClient.zza(new C11372(googleApiClient, userAddressRequest, i));
    }
}
