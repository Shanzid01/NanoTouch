package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzl;
import com.google.android.gms.fitness.request.zzp;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzob implements ConfigApi {

    class zza extends com.google.android.gms.internal.zzni.zza {
        private final zzb<DataTypeResult> zzHa;

        private zza(zzb<DataTypeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzHa.zzd(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient googleApiClient, final DataTypeCreateRequest dataTypeCreateRequest) {
        return googleApiClient.zzb(new zza<DataTypeResult>(this, googleApiClient) {
            final /* synthetic */ zzob zzaaf;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzv(status);
            }

            protected void zza(zzna com_google_android_gms_internal_zzna) {
                ((zznk) com_google_android_gms_internal_zzna.zzjb()).zza(new DataTypeCreateRequest(dataTypeCreateRequest, new zza(this), com_google_android_gms_internal_zzna.getContext().getPackageName()));
            }

            protected DataTypeResult zzv(Status status) {
                return DataTypeResult.zzD(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzob zzaaf;

            protected void zza(zzna com_google_android_gms_internal_zzna) {
                ((zznk) com_google_android_gms_internal_zzna.zzjb()).zza(new zzp(new zzoh(this), com_google_android_gms_internal_zzna.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zza<DataTypeResult>(this, googleApiClient) {
            final /* synthetic */ zzob zzaaf;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzv(status);
            }

            protected void zza(zzna com_google_android_gms_internal_zzna) {
                ((zznk) com_google_android_gms_internal_zzna.zzjb()).zza(new zzl(str, new zza(this), com_google_android_gms_internal_zzna.getContext().getPackageName()));
            }

            protected DataTypeResult zzv(Status status) {
                return DataTypeResult.zzD(status);
            }
        });
    }
}
