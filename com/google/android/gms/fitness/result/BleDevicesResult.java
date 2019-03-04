package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR = new zza();
    private final int zzFG;
    private final Status zzHb;
    private final List<BleDevice> zzabL;

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.zzFG = i;
        this.zzabL = Collections.unmodifiableList(list);
        this.zzHb = status;
    }

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.zzFG = 3;
        this.zzabL = Collections.unmodifiableList(list);
        this.zzHb = status;
    }

    public static BleDevicesResult zzB(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzHb.equals(bleDevicesResult.zzHb) && zzw.equal(this.zzabL, bleDevicesResult.zzabL);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && zzb((BleDevicesResult) obj));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzabL;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzabL) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzHb;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzHb, this.zzabL);
    }

    public String toString() {
        return zzw.zzk(this).zza("status", this.zzHb).zza("bleDevices", this.zzabL).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
