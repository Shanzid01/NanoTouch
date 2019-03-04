package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzi;
import com.google.android.gms.location.places.zzi.zzd;
import com.google.android.gms.location.places.zzi.zzg;

public class zzpw implements PlaceDetectionApi {
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient googleApiClient, final PlaceFilter placeFilter) {
        return googleApiClient.zza(new zzd<zzpx>(this, Places.zzanU, googleApiClient) {
            final /* synthetic */ zzpw zzaou;

            protected void zza(zzpx com_google_android_gms_internal_zzpx) {
                com_google_android_gms_internal_zzpx.zza(new zzi((zzd) this, com_google_android_gms_internal_zzpx.getContext()), placeFilter);
            }
        });
    }

    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient googleApiClient, final PlaceReport placeReport) {
        return googleApiClient.zzb(new zzg<zzpx>(this, Places.zzanU, googleApiClient) {
            final /* synthetic */ zzpw zzaou;

            protected void zza(zzpx com_google_android_gms_internal_zzpx) {
                com_google_android_gms_internal_zzpx.zza(new zzi((zzg) this), placeReport);
            }
        });
    }
}
