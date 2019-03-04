package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzoi implements BleApi {
    private static final Status zzaaH = new Status(FitnessStatusCodes.UNSUPPORTED_PLATFORM);

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, String str) {
        return new zznx(zzaaH);
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return new zznx(BleDevicesResult.zzB(zzaaH));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return new zznx(zzaaH);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, String str) {
        return new zznx(zzaaH);
    }
}
