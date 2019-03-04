package com.slideme.sam.manager.model.data.cache.helper.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InstallReferrerCacheObject implements Parcelable {
    public static final Creator<InstallReferrerCacheObject> CREATOR = new C18441();
    public static int STATE_DONE = 3;
    public static int STATE_INSTALLED = 2;
    public static int STATE_NEW = 1;
    public String packageName;
    public String referrer;
    public int state;

    class C18441 implements Creator<InstallReferrerCacheObject> {
        C18441() {
        }

        public InstallReferrerCacheObject createFromParcel(Parcel parcel) {
            return new InstallReferrerCacheObject(parcel);
        }

        public InstallReferrerCacheObject[] newArray(int i) {
            return new InstallReferrerCacheObject[i];
        }
    }

    public InstallReferrerCacheObject(String str, String str2, int i) {
        this.packageName = str;
        this.referrer = str2;
        this.state = i;
    }

    protected InstallReferrerCacheObject(Parcel parcel) {
        this.referrer = parcel.readString();
        this.state = parcel.readInt();
        this.packageName = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.referrer);
        parcel.writeInt(this.state);
        parcel.writeString(this.packageName);
    }
}
