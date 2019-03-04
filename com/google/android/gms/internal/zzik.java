package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzik implements Parcelable {
    @Deprecated
    public static final Creator<zzik> CREATOR = new C12471();
    private String mValue;
    private String zzFA;
    private String zzFB;

    final class C12471 implements Creator<zzik> {
        C12471() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzk(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzO(i);
        }

        @Deprecated
        public zzik[] zzO(int i) {
            return new zzik[i];
        }

        @Deprecated
        public zzik zzk(Parcel parcel) {
            return new zzik(parcel);
        }
    }

    @Deprecated
    zzik(Parcel parcel) {
        readFromParcel(parcel);
    }

    public zzik(String str, String str2, String str3) {
        this.zzFA = str;
        this.zzFB = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.zzFA = parcel.readString();
        this.zzFB = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzFA);
        parcel.writeString(this.zzFB);
        parcel.writeString(this.mValue);
    }
}
