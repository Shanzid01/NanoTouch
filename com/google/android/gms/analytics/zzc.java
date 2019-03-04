package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzlo;
import java.util.List;
import java.util.Map;

class zzc implements zzb {
    private Context mContext;
    private ServiceConnection zzAT;
    private zzb zzAU;
    private zzc zzAV;
    private zzil zzAW;

    final class zza implements ServiceConnection {
        final /* synthetic */ zzc zzAX;

        zza(zzc com_google_android_gms_analytics_zzc) {
            this.zzAX = com_google_android_gms_analytics_zzc;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzae.zzab("service connected, binder: " + iBinder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(iBinder.getInterfaceDescriptor())) {
                    zzae.zzab("bound to service");
                    this.zzAX.zzAW = com.google.android.gms.internal.zzil.zza.zzH(iBinder);
                    this.zzAX.zzfd();
                    return;
                }
            } catch (RemoteException e) {
            }
            try {
                zzlo.zzka().zza(this.zzAX.mContext, this);
            } catch (IllegalArgumentException e2) {
            }
            this.zzAX.zzAT = null;
            this.zzAX.zzAV.zza(2, null);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            zzae.zzab("service disconnected: " + componentName);
            this.zzAX.zzAT = null;
            this.zzAX.zzAU.onDisconnected();
        }
    }

    public interface zzb {
        void onConnected();

        void onDisconnected();
    }

    public interface zzc {
        void zza(int i, Intent intent);
    }

    public zzc(Context context, zzb com_google_android_gms_analytics_zzc_zzb, zzc com_google_android_gms_analytics_zzc_zzc) {
        this.mContext = context;
        if (com_google_android_gms_analytics_zzc_zzb == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.zzAU = com_google_android_gms_analytics_zzc_zzb;
        if (com_google_android_gms_analytics_zzc_zzc == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.zzAV = com_google_android_gms_analytics_zzc_zzc;
    }

    private zzil zzfb() {
        zzfc();
        return this.zzAW;
    }

    private void zzfd() {
        zzfe();
    }

    private void zzfe() {
        this.zzAU.onConnected();
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.zzAT != null) {
            zzae.zzZ("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.zzAT = new zza(this);
        boolean zza = zzlo.zzka().zza(this.mContext, intent, this.zzAT, 129);
        zzae.zzab("connect: bindService returned " + zza + " for " + intent);
        if (!zza) {
            this.zzAT = null;
            this.zzAV.zza(1, null);
        }
    }

    public void disconnect() {
        this.zzAW = null;
        if (this.zzAT != null) {
            try {
                zzlo.zzka().zza(this.mContext, this.zzAT);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.zzAT = null;
            this.zzAU.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.zzAW != null;
    }

    public void zza(Map<String, String> map, long j, String str, List<zzik> list) {
        try {
            zzfb().zza(map, j, str, list);
        } catch (RemoteException e) {
            zzae.zzZ("sendHit failed: " + e);
        }
    }

    public void zzfa() {
        try {
            zzfb().zzfa();
        } catch (RemoteException e) {
            zzae.zzZ("clear hits failed: " + e);
        }
    }

    protected void zzfc() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
}
