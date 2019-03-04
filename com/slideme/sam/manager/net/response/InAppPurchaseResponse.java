package com.slideme.sam.manager.net.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.p043a.p044a.C0670c;

public class InAppPurchaseResponse extends BaseNetworkResponse implements Parcelable {
    public String data;
    public String signature;
    public int status;
    @C0670c(a = "url")
    public String webBuyUrl;

    public InAppPurchaseResponse(Parcel parcel) {
        this.status = parcel.readInt();
        this.data = parcel.readString();
        this.webBuyUrl = parcel.readString();
        this.signature = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
        parcel.writeString(this.data);
        parcel.writeString(this.webBuyUrl);
        parcel.writeString(this.signature);
    }
}
