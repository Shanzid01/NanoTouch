package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzat;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zzoe implements RecordingApi {

    class zza extends com.google.android.gms.internal.zznq.zza {
        private final zzb<ListSubscriptionsResult> zzHa;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzHa.zzd(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoe zzaao;

            protected void zza(zznd com_google_android_gms_internal_zznd) {
                ((zznn) com_google_android_gms_internal_zznd.zzjb()).zza(new zzat(subscription, false, new zzoh(this), com_google_android_gms_internal_zznd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza<ListSubscriptionsResult>(this, googleApiClient) {
            final /* synthetic */ zzoe zzaao;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzx(status);
            }

            protected void zza(zznd com_google_android_gms_internal_zznd) {
                ((zznn) com_google_android_gms_internal_zznd.zzjb()).zza(new zzw(null, new zza(this), com_google_android_gms_internal_zznd.getContext().getPackageName()));
            }

            protected ListSubscriptionsResult zzx(Status status) {
                return ListSubscriptionsResult.zzE(status);
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zza(new zza<ListSubscriptionsResult>(this, googleApiClient) {
            final /* synthetic */ zzoe zzaao;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzx(status);
            }

            protected void zza(zznd com_google_android_gms_internal_zznd) {
                ((zznn) com_google_android_gms_internal_zznd.zzjb()).zza(new zzw(dataType, new zza(this), com_google_android_gms_internal_zznd.getContext().getPackageName()));
            }

            protected ListSubscriptionsResult zzx(Status status) {
                return ListSubscriptionsResult.zzE(status);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return zza(googleApiClient, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzlK());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzlK());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final DataSource dataSource) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoe zzaao;

            protected void zza(zznd com_google_android_gms_internal_zznd) {
                ((zznn) com_google_android_gms_internal_zznd.zzjb()).zza(new zzax(null, dataSource, new zzoh(this), com_google_android_gms_internal_zznd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoe zzaao;

            protected void zza(zznd com_google_android_gms_internal_zznd) {
                ((zznn) com_google_android_gms_internal_zznd.zzjb()).zza(new zzax(dataType, null, new zzoh(this), com_google_android_gms_internal_zznd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(googleApiClient, subscription.getDataSource()) : unsubscribe(googleApiClient, subscription.getDataType());
    }
}
