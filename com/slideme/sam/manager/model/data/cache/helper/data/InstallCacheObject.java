package com.slideme.sam.manager.model.data.cache.helper.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InstallCacheObject implements Parcelable {
    public static final Creator<InstallCacheObject> CREATOR = new C18431();
    public String bundleId;
    public int versionCode;

    class C18431 implements Creator<InstallCacheObject> {
        C18431() {
        }

        public InstallCacheObject createFromParcel(Parcel parcel) {
            return new InstallCacheObject(parcel);
        }

        public InstallCacheObject[] newArray(int i) {
            return new InstallCacheObject[i];
        }
    }

    public InstallCacheObject(String str) {
        this.bundleId = "";
        this.versionCode = 0;
        this.bundleId = str;
    }

    public InstallCacheObject(String str, int i) {
        this.bundleId = "";
        this.versionCode = 0;
        this.bundleId = str;
        this.versionCode = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bundleId);
        parcel.writeInt(this.versionCode);
    }

    private InstallCacheObject(Parcel parcel) {
        this.bundleId = "";
        this.versionCode = 0;
        this.bundleId = parcel.readString();
        this.versionCode = parcel.readInt();
    }
}
