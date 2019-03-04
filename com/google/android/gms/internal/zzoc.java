package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.fitness.result.DataReadResult;

public class zzoc implements HistoryApi {

    class zza extends com.google.android.gms.internal.zzng.zza {
        private final zzb<DataReadResult> zzHa;
        private int zzaam;
        private DataReadResult zzaan;

        private zza(zzb<DataReadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzaam = 0;
            this.zzaan = null;
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.zzaan == null) {
                    this.zzaan = dataReadResult;
                } else {
                    this.zzaan.zzb(dataReadResult);
                }
                this.zzaam++;
                if (this.zzaam == this.zzaan.zzmn()) {
                    this.zzHa.zzd(this.zzaan);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzx.zzb((Object) dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzlz(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoc zzaaj;

            protected void zza(zznb com_google_android_gms_internal_zznb) {
                ((zznl) com_google_android_gms_internal_zznb.zzjb()).zza(new zze(dataSet, new zzoh(this), com_google_android_gms_internal_zznb.getContext().getPackageName(), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient googleApiClient, final DataDeleteRequest dataDeleteRequest) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoc zzaaj;

            protected void zza(zznb com_google_android_gms_internal_zznb) {
                ((zznl) com_google_android_gms_internal_zznb.zzjb()).zza(new DataDeleteRequest(dataDeleteRequest, new zzoh(this), com_google_android_gms_internal_zznb.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet) {
        return zza(googleApiClient, dataSet, false);
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, final DataReadRequest dataReadRequest) {
        return googleApiClient.zza(new zza<DataReadResult>(this, googleApiClient) {
            final /* synthetic */ zzoc zzaaj;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzw(status);
            }

            protected void zza(zznb com_google_android_gms_internal_zznb) {
                ((zznl) com_google_android_gms_internal_zznb.zzjb()).zza(new DataReadRequest(dataReadRequest, new zza(this), com_google_android_gms_internal_zznb.getContext().getPackageName()));
            }

            protected DataReadResult zzw(Status status) {
                return DataReadResult.zza(status, dataReadRequest);
            }
        });
    }
}
