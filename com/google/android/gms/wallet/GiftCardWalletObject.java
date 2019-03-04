package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
    public static final Creator<GiftCardWalletObject> CREATOR = new zzh();
    String pin;
    final int zzFG;
    CommonWalletObject zzaDk;
    String zzaDl;
    String zzaDm;
    long zzaDn;
    String zzaDo;
    long zzaDp;
    String zzaDq;

    GiftCardWalletObject() {
        this.zzaDk = CommonWalletObject.zzuV().zzuW();
        this.zzFG = 1;
    }

    GiftCardWalletObject(int i, CommonWalletObject commonWalletObject, String str, String str2, String str3, long j, String str4, long j2, String str5) {
        this.zzaDk = CommonWalletObject.zzuV().zzuW();
        this.zzFG = i;
        this.zzaDk = commonWalletObject;
        this.zzaDl = str;
        this.pin = str2;
        this.zzaDn = j;
        this.zzaDo = str4;
        this.zzaDp = j2;
        this.zzaDq = str5;
        this.zzaDm = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaDk.getId();
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
