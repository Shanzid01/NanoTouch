package com.slideme.sam.manager.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import org.json.JSONObject;

public class Purchase implements Parcelable {
    public static final Creator<Purchase> CREATOR = new C1797n();
    public String f3201a;
    public String f3202b;
    public String f3203c;
    public long f3204d;
    public String f3205e;
    public String f3206f;
    private String f3207g;

    public Purchase(String str) {
        if (str != null) {
            this.f3207g = str;
            JSONObject jSONObject = new JSONObject(str);
            this.f3201a = jSONObject.getString("tid");
            this.f3202b = jSONObject.getString("package_name");
            this.f3205e = jSONObject.getString(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN);
            this.f3206f = jSONObject.getString("developer_payload");
            this.f3203c = jSONObject.getString("product_id");
            this.f3204d = jSONObject.getLong("purchase_time");
        }
    }

    public String toString() {
        return TextUtils.isEmpty(this.f3207g) ? "{}" : this.f3207g;
    }

    protected Purchase(Parcel parcel) {
        this.f3201a = parcel.readString();
        this.f3202b = parcel.readString();
        this.f3203c = parcel.readString();
        this.f3204d = parcel.readLong();
        this.f3205e = parcel.readString();
        this.f3206f = parcel.readString();
        this.f3207g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3201a);
        parcel.writeString(this.f3202b);
        parcel.writeString(this.f3203c);
        parcel.writeLong(this.f3204d);
        parcel.writeString(this.f3205e);
        parcel.writeString(this.f3206f);
        parcel.writeString(this.f3207g);
    }
}
