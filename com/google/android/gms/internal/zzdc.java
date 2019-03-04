package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@zzgi
public final class zzdc {

    public interface zzb {
        void zze(Bundle bundle);
    }

    public final class zza implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object zznh;
        private final zzb zzrO;
        private final zzdd zzrP;

        public zza(Context context, zzb com_google_android_gms_internal_zzdc_zzb) {
            this(context, com_google_android_gms_internal_zzdc_zzb, false);
        }

        zza(Context context, zzb com_google_android_gms_internal_zzdc_zzb, boolean z) {
            this.zznh = new Object();
            this.zzrO = com_google_android_gms_internal_zzdc_zzb;
            this.zzrP = new zzdd(context, this, this, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (!z) {
                this.zzrP.connect();
            }
        }

        public void onConnected(Bundle bundle) {
            Bundle zzcI;
            Bundle bundle2 = new Bundle();
            synchronized (this.zznh) {
                try {
                    zzde zzcH = this.zzrP.zzcH();
                    zzcI = zzcH != null ? zzcH.zzcI() : bundle2;
                    if (this.zzrP.isConnected() || this.zzrP.isConnecting()) {
                        this.zzrP.disconnect();
                    }
                } catch (Throwable e) {
                    zzhx.zzd("Error when get Gservice values", e);
                    if (this.zzrP.isConnected() || this.zzrP.isConnecting()) {
                        this.zzrP.disconnect();
                        zzcI = bundle2;
                    }
                    zzcI = bundle2;
                } catch (Throwable e2) {
                    zzhx.zzd("Error when get Gservice values", e2);
                    if (this.zzrP.isConnected() || this.zzrP.isConnecting()) {
                        this.zzrP.disconnect();
                        zzcI = bundle2;
                    }
                    zzcI = bundle2;
                } catch (Throwable th) {
                    if (this.zzrP.isConnected() || this.zzrP.isConnecting()) {
                        this.zzrP.disconnect();
                    }
                }
            }
            this.zzrO.zze(zzcI);
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.zzrO.zze(new Bundle());
        }

        public void onConnectionSuspended(int i) {
            zzhx.zzY("Disconnected from remote ad request service.");
        }
    }

    public static void zza(Context context, zzb com_google_android_gms_internal_zzdc_zzb) {
        if (zzbe.zzbD().zzA(context)) {
            zza com_google_android_gms_internal_zzdc_zza = new zza(context, com_google_android_gms_internal_zzdc_zzb);
        } else {
            com_google_android_gms_internal_zzdc_zzb.zze(new Bundle());
        }
    }
}
