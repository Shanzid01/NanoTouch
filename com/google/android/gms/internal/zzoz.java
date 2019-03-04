package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzoz implements FusedLocationProviderApi {

    abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zze(googleApiClient).zzpx();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zzd(pendingIntent);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, final LocationListener locationListener) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(locationListener);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, final LocationRequest locationRequest, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zzb(locationRequest, pendingIntent);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, final LocationRequest locationRequest, final LocationListener locationListener) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(locationRequest, locationListener, null);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        final LocationRequest locationRequest2 = locationRequest;
        final LocationListener locationListener2 = locationListener;
        final Looper looper2 = looper;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(locationRequest2, locationListener2, looper2);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, final Location location) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zzb(location);
                setResult(Status.zzNo);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzoz zzamI;

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zzW(z);
                setResult(Status.zzNo);
            }
        });
    }
}
