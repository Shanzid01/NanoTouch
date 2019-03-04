package com.slideme.sam.manager.net.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;

public class AdProxyItem implements Parcelable {
    public static final Creator<AdProxyItem> CREATOR = new C18841();
    public static String JSON_FIELD_CLICKURL = "clickURL";
    public static String JSON_FIELD_DESCRIPTION = PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION;
    public static String JSON_FIELD_IMAGE = "imageURL";
    public static String JSON_FIELD_NAME = "displayName";
    public static String JSON_FIELD_NETWORK = "element";
    public static String JSON_FIELD_OFFER_ID = "id";
    public static String JSON_FIELD_PACKAGENAME = "packageName";
    public static String JSON_FIELD_PAYOUT = "payout";
    public static String JSON_FIELD_PLATFORM = "platform";
    public static String JSON_FIELD_RATING = "rating";
    public static String JSON_FIELD_SAMAVAILABLE = "smeAvailable";
    public String clickUrl;
    public String description;
    public String image;
    public String name;
    public String network;
    public String offerId;
    public String packageName;
    public double payout;
    public String platform;
    public double rating;
    public boolean samAvailable;

    class C18841 implements Creator<AdProxyItem> {
        C18841() {
        }

        public AdProxyItem createFromParcel(Parcel parcel) {
            return new AdProxyItem(parcel);
        }

        public AdProxyItem[] newArray(int i) {
            return new AdProxyItem[i];
        }
    }

    public AdProxyItem() {
        this.image = "";
        this.clickUrl = "";
        this.name = "";
        this.description = "";
        this.packageName = "";
        this.offerId = "";
        this.platform = "";
        this.image = "";
        this.clickUrl = "";
        this.name = "";
        this.description = "";
        this.packageName = "";
        this.samAvailable = false;
        this.payout = 0.0d;
        this.offerId = "";
        this.platform = "";
        this.rating = 0.0d;
    }

    public AdProxyItem(Parcel parcel) {
        boolean z = true;
        this.image = "";
        this.clickUrl = "";
        this.name = "";
        this.description = "";
        this.packageName = "";
        this.offerId = "";
        this.platform = "";
        this.image = parcel.readString();
        this.clickUrl = parcel.readString();
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.packageName = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.samAvailable = z;
        this.payout = parcel.readDouble();
        this.offerId = parcel.readString();
        this.platform = parcel.readString();
        this.network = parcel.readString();
        this.rating = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.image);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.samAvailable ? 1 : 0);
        parcel.writeDouble(this.payout);
        parcel.writeString(this.offerId);
        parcel.writeString(this.platform);
        parcel.writeString(this.network);
        parcel.writeDouble(this.rating);
    }
}
