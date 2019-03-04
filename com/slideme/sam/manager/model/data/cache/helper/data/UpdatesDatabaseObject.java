package com.slideme.sam.manager.model.data.cache.helper.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UpdatesDatabaseObject implements Parcelable {
    public static final Creator<UpdatesDatabaseObject> CREATOR = new C18451();
    public String bundleId;
    public String token;

    class C18451 implements Creator<UpdatesDatabaseObject> {
        C18451() {
        }

        public UpdatesDatabaseObject createFromParcel(Parcel parcel) {
            return new UpdatesDatabaseObject(parcel);
        }

        public UpdatesDatabaseObject[] newArray(int i) {
            return new UpdatesDatabaseObject[i];
        }
    }

    public UpdatesDatabaseObject(String str) {
        this.bundleId = "";
        this.token = "";
        this.bundleId = str;
    }

    public UpdatesDatabaseObject(String str, String str2) {
        this.bundleId = "";
        this.token = "";
        this.bundleId = str;
        this.token = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bundleId);
        parcel.writeString(this.token);
    }

    private UpdatesDatabaseObject(Parcel parcel) {
        this.bundleId = "";
        this.token = "";
        this.bundleId = parcel.readString();
        this.token = parcel.readString();
    }
}
