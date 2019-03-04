package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzi;
import com.google.android.gms.location.places.zzi.zza;
import com.google.android.gms.location.places.zzi.zzc;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzpr implements GeoDataApi {
    private static final String TAG = zzpr.class.getSimpleName();

    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, final AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new zzc<zzps>(this, Places.zzanT, googleApiClient) {
            final /* synthetic */ zzpr zzaol;

            protected void zza(zzps com_google_android_gms_internal_zzps) {
                com_google_android_gms_internal_zzps.zza(new zzi((zzc) this, com_google_android_gms_internal_zzps.getContext()), addPlaceRequest);
            }
        });
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        final String str2 = str;
        final LatLngBounds latLngBounds2 = latLngBounds;
        final AutocompleteFilter autocompleteFilter2 = autocompleteFilter;
        return googleApiClient.zza(new zza<zzps>(this, Places.zzanT, googleApiClient) {
            final /* synthetic */ zzpr zzaol;

            protected void zza(zzps com_google_android_gms_internal_zzps) {
                com_google_android_gms_internal_zzps.zza(new zzi((zza) this), str2, latLngBounds2, autocompleteFilter2);
            }
        });
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient googleApiClient, final String... strArr) {
        boolean z = true;
        if (strArr == null || strArr.length < 1) {
            z = false;
        }
        zzx.zzO(z);
        return googleApiClient.zza(new zzc<zzps>(this, Places.zzanT, googleApiClient) {
            final /* synthetic */ zzpr zzaol;

            protected void zza(zzps com_google_android_gms_internal_zzps) {
                com_google_android_gms_internal_zzps.zza(new zzi((zzc) this, com_google_android_gms_internal_zzps.getContext()), Arrays.asList(strArr));
            }
        });
    }
}
