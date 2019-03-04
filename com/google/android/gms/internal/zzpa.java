package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zzf.zzb;
import java.util.List;

public class zzpa implements GeofencingApi {

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

    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzpa zzamN;

            class C13021 implements com.google.android.gms.location.zzf.zza {
                final /* synthetic */ C13031 zzamO;

                C13021(C13031 c13031) {
                    this.zzamO = c13031;
                }

                public void zza(int i, String[] strArr) {
                    this.zzamO.setResult(LocationStatusCodes.zzfr(i));
                }
            }

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(geofencingRequest, pendingIntent, new C13021(this));
            }
        });
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleApiClient, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzpa zzamN;

            class C13041 implements zzb {
                final /* synthetic */ C13052 zzamP;

                C13041(C13052 c13052) {
                    this.zzamP = c13052;
                }

                public void zzb(int i, PendingIntent pendingIntent) {
                    this.zzamP.setResult(LocationStatusCodes.zzfr(i));
                }

                public void zzb(int i, String[] strArr) {
                    Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                }
            }

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(pendingIntent, new C13041(this));
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, final List<String> list) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzpa zzamN;

            class C13061 implements zzb {
                final /* synthetic */ C13073 zzamR;

                C13061(C13073 c13073) {
                    this.zzamR = c13073;
                }

                public void zzb(int i, PendingIntent pendingIntent) {
                    Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                }

                public void zzb(int i, String[] strArr) {
                    this.zzamR.setResult(LocationStatusCodes.zzfr(i));
                }
            }

            protected void zza(zzpf com_google_android_gms_internal_zzpf) {
                com_google_android_gms_internal_zzpf.zza(list, new C13061(this));
            }
        });
    }
}
