package com.slideme.sam.manager.model.data.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.util.C1922m;
import org.json.JSONObject;

public class InAppProduct implements Parcelable {
    public static final Creator<InAppProduct> CREATOR = new C18521();
    public String description;
    public float price;
    @C0670c(a = "product_id")
    public String productId;
    public String title;
    public String type;

    class C18521 implements Creator<InAppProduct> {
        C18521() {
        }

        public InAppProduct[] newArray(int i) {
            return new InAppProduct[i];
        }

        public InAppProduct createFromParcel(Parcel parcel) {
            return new InAppProduct(parcel);
        }
    }

    public InAppProduct(Parcel parcel) {
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.price = parcel.readFloat();
        this.productId = parcel.readString();
        this.type = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeFloat(this.price);
        parcel.writeString(this.productId);
        parcel.writeString(this.type);
    }

    public int describeContents() {
        return 0;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.title);
            jSONObject.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.description);
            jSONObject.put("price", (double) this.price);
            jSONObject.put("iapId", this.productId);
            jSONObject.put("type", this.type);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
        return jSONObject.toString();
    }
}
