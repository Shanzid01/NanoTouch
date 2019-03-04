package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzac;
import com.google.android.gms.fitness.request.zzae;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzof implements SensorsApi {

    interface zza {
        void zzlN();
    }

    class zzb extends com.google.android.gms.internal.zznh.zza {
        private final com.google.android.gms.common.api.zza.zzb<DataSourcesResult> zzHa;

        private zzb(com.google.android.gms.common.api.zza.zzb<DataSourcesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataSourcesResult;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzHa.zzd(dataSourcesResult);
        }
    }

    class zzc extends com.google.android.gms.internal.zznv.zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;
        private final zza zzaaB;

        private zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzof_zza) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
            this.zzaaB = com_google_android_gms_internal_zzof_zza;
        }

        public void zzi(Status status) {
            if (this.zzaaB != null && status.isSuccess()) {
                this.zzaaB.zzlN();
            }
            this.zzHa.zzd(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent, zza com_google_android_gms_internal_zzof_zza) {
        final zza com_google_android_gms_internal_zzof_zza2 = com_google_android_gms_internal_zzof_zza;
        final zzk com_google_android_gms_fitness_data_zzk2 = com_google_android_gms_fitness_data_zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzof zzaat;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzb(status);
            }

            protected void zza(zzne com_google_android_gms_internal_zzne) {
                ((zzno) com_google_android_gms_internal_zzne.zzjb()).zza(new zzae(com_google_android_gms_fitness_data_zzk2, pendingIntent2, new zzc(this, com_google_android_gms_internal_zzof_zza2), com_google_android_gms_internal_zzne.getContext().getPackageName()));
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzk com_google_android_gms_fitness_data_zzk2 = com_google_android_gms_fitness_data_zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzof zzaat;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzb(status);
            }

            protected void zza(zzne com_google_android_gms_internal_zzne) {
                ((zzno) com_google_android_gms_internal_zzne.zzjb()).zza(new zzac(sensorRequest2, com_google_android_gms_fitness_data_zzk2, pendingIntent2, new zzoh(this), com_google_android_gms_internal_zzne.getContext().getPackageName()));
            }

            protected Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, null, pendingIntent);
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, com.google.android.gms.fitness.data.zzl.zza.zzlG().zza(onDataPointListener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, final DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.zza(new zza<DataSourcesResult>(this, googleApiClient) {
            final /* synthetic */ zzof zzaat;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzy(status);
            }

            protected void zza(zzne com_google_android_gms_internal_zzne) {
                ((zzno) com_google_android_gms_internal_zzne.zzjb()).zza(new DataSourcesRequest(dataSourcesRequest, new zzb(this), com_google_android_gms_internal_zzne.getContext().getPackageName()));
            }

            protected DataSourcesResult zzy(Status status) {
                return DataSourcesResult.zzC(status);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final OnDataPointListener onDataPointListener) {
        zzk zzb = com.google.android.gms.fitness.data.zzl.zza.zzlG().zzb(onDataPointListener);
        return zzb == null ? new zznx(Status.zzNo) : zza(googleApiClient, zzb, null, new zza(this) {
            final /* synthetic */ zzof zzaat;

            public void zzlN() {
                com.google.android.gms.fitness.data.zzl.zza.zzlG().zzc(onDataPointListener);
            }
        });
    }
}
