package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new zzo();
    private final int zzFG;
    CommonWalletObject zzaDk;
    String zzaEh;
    String zzfl;

    OfferWalletObject() {
        this.zzFG = 3;
    }

    OfferWalletObject(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.zzFG = i;
        this.zzaEh = str2;
        if (i < 3) {
            this.zzaDk = CommonWalletObject.zzuV().zzdJ(str).zzuW();
        } else {
            this.zzaDk = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaDk.getId();
    }

    public String getRedemptionCode() {
        return this.zzaEh;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
