package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzpn implements SettingsApi {
    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest) {
        return zza(googleApiClient, locationSettingsRequest, null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new zza<LocationSettingsResult>(this, googleApiClient) {
            final /* synthetic */ zzpn zzans;

            public /* synthetic */ Result createFailedResult(Status status) {
                return zzax(status);
            }

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(locationSettingsRequest, (zzb) this, str);
            }

            public LocationSettingsResult zzax(Status status) {
                return new LocationSettingsResult(status);
            }
        });
    }
}
