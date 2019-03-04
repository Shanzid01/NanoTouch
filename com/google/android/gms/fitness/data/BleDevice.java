package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmn;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR = new zzc();
    private final String mName;
    private final int zzFG;
    private final List<DataType> zzYA;
    private final String zzYy;
    private final List<String> zzYz;

    BleDevice(int i, String str, String str2, List<String> list, List<DataType> list2) {
        this.zzFG = i;
        this.zzYy = str;
        this.mName = str2;
        this.zzYz = Collections.unmodifiableList(list);
        this.zzYA = Collections.unmodifiableList(list2);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzYy.equals(bleDevice.zzYy) && zzmn.zza(bleDevice.zzYz, this.zzYz) && zzmn.zza(this.zzYA, bleDevice.zzYA);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && zza((BleDevice) obj));
    }

    public String getAddress() {
        return this.zzYy;
    }

    public List<DataType> getDataTypes() {
        return this.zzYA;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzYz;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzYy, this.zzYz, this.zzYA);
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).zza("address", this.zzYy).zza("dataTypes", this.zzYA).zza("supportedProfiles", this.zzYz).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
