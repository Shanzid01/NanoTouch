package com.slideme.sam.manager.net.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BreakdownTag implements Parcelable {
    public static final Creator<BreakdownTag> CREATOR = new C18851();
    public float average;
    public int count;
    public int[] ratings;

    class C18851 implements Creator<BreakdownTag> {
        C18851() {
        }

        public BreakdownTag createFromParcel(Parcel parcel) {
            return new BreakdownTag(parcel);
        }

        public BreakdownTag[] newArray(int i) {
            return new BreakdownTag[i];
        }
    }

    public BreakdownTag() {
        this.ratings = new int[5];
        this.average = 0.0f;
        this.count = 0;
    }

    public BreakdownTag(int[] iArr) {
        this.ratings = new int[5];
        this.average = 0.0f;
        this.count = 0;
        this.ratings = iArr;
    }

    protected BreakdownTag(Parcel parcel) {
        this.ratings = new int[5];
        this.average = 0.0f;
        this.count = 0;
        parcel.readIntArray(this.ratings);
        this.average = parcel.readFloat();
        this.count = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.ratings);
        parcel.writeFloat(this.average);
        parcel.writeInt(this.count);
    }

    public float getAverageIn5() {
        return this.average * 0.05f;
    }

    public int getNumReviews() {
        return this.count;
    }
}
