package com.slideme.sam.manager.inapp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;

public class PurchaseResult implements Parcelable {
    public static final Creator<PurchaseResult> CREATOR = new C1798o();
    public int f3208a;
    public Purchase f3209b;
    public String f3210c;
    public String f3211d;

    public PurchaseResult(Bundle bundle) {
        this.f3208a = bundle.getInt("com.slideme.sam.manager.inapp.BUNDLE_STATUS");
        this.f3210c = bundle.getString("com.slideme.sam.manager.inapp.BUNDLE_PURCHASE_DATA");
        try {
            this.f3209b = new Purchase(this.f3210c);
        } catch (JSONException e) {
            if (C1807p.f3239a) {
                e.printStackTrace();
            }
        }
        this.f3211d = bundle.getString("com.slideme.sam.manager.inapp.BUNDLE_SIGNATURE");
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append(" { ").append("status: ").append(String.valueOf(this.f3208a)).append(",").append("purchaseData: ").append(this.f3209b.toString()).append(",").append("signedPurchaseData: ").append(this.f3210c).append(",").append("signature: ").append(this.f3211d).append(" }").toString();
    }

    protected PurchaseResult(Parcel parcel) {
        this.f3208a = parcel.readInt();
        this.f3209b = (Purchase) parcel.readValue(Purchase.class.getClassLoader());
        this.f3210c = parcel.readString();
        this.f3211d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3208a);
        parcel.writeValue(this.f3209b);
        parcel.writeString(this.f3210c);
        parcel.writeString(this.f3211d);
    }
}
