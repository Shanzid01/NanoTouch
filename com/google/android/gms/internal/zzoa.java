package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzu;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzoa implements BleApi {

    class zza extends com.google.android.gms.internal.zzoj.zza {
        private final zzb<BleDevicesResult> zzHa;

        private zza(zzb<BleDevicesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzHa.zzd(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, final BleDevice bleDevice) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz com_google_android_gms_internal_zzmz) {
                ((zznj) com_google_android_gms_internal_zzmz.zzjb()).zza(new com.google.android.gms.fitness.request.zzb(bleDevice.getAddress(), bleDevice, new zzoh(this), com_google_android_gms_internal_zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz com_google_android_gms_internal_zzmz) {
                ((zznj) com_google_android_gms_internal_zzmz.zzjb()).zza(new com.google.android.gms.fitness.request.zzb(str, null, new zzoh(this), com_google_android_gms_internal_zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza<BleDevicesResult>(this, googleApiClient) {
            final /* synthetic */ zzoa zzaaa;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzu(status);
            }

            protected void zza(zzmz com_google_android_gms_internal_zzmz) {
                ((zznj) com_google_android_gms_internal_zzmz.zzjb()).zza(new zzu(new zza(this), com_google_android_gms_internal_zzmz.getContext().getPackageName()));
            }

            protected BleDevicesResult zzu(Status status) {
                return BleDevicesResult.zzB(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, final StartBleScanRequest startBleScanRequest) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz com_google_android_gms_internal_zzmz) {
                ((zznj) com_google_android_gms_internal_zzmz.zzjb()).zza(new StartBleScanRequest(startBleScanRequest, new zzoh(this), com_google_android_gms_internal_zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, final BleScanCallback bleScanCallback) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz com_google_android_gms_internal_zzmz) {
                ((zznj) com_google_android_gms_internal_zzmz.zzjb()).zza(new zzar(bleScanCallback, new zzoh(this), com_google_android_gms_internal_zzmz.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzoa zzaaa;

            protected void zza(zzmz com_google_android_gms_internal_zzmz) {
                ((zznj) com_google_android_gms_internal_zzmz.zzjb()).zza(new zzav(str, new zzoh(this), com_google_android_gms_internal_zzmz.getContext().getPackageName()));
            }
        });
    }
}
