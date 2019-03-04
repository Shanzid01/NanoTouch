package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzpc.zza;

public class zzow extends zzk<zzpc> {
    private final String zzamE;
    protected final zzpm<zzpc> zzamz = new C12941(this);

    class C12941 implements zzpm<zzpc> {
        final /* synthetic */ zzow zzamF;

        C12941(zzow com_google_android_gms_internal_zzow) {
            this.zzamF = com_google_android_gms_internal_zzow;
        }

        public void zzfc() {
            this.zzamF.zzfc();
        }

        public /* synthetic */ IInterface zzjb() {
            return zzpu();
        }

        public zzpc zzpu() {
            return (zzpc) this.zzamF.zzjb();
        }
    }

    public zzow(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, looper, 23, connectionCallbacks, onConnectionFailedListener);
        this.zzamE = str;
    }

    protected zzpc zzbi(IBinder iBinder) {
        return zza.zzbk(iBinder);
    }

    protected String zzcF() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle zzhq() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzamE);
        return bundle;
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzbi(iBinder);
    }
}
