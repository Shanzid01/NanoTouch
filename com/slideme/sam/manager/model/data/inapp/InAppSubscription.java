package com.slideme.sam.manager.model.data.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InAppSubscription extends InAppProduct implements Parcelable {
    public static final Creator<InAppSubscription> CREATOR = new C18531();
    protected int renewalDays;

    class C18531 implements Creator<InAppSubscription> {
        C18531() {
        }

        public InAppSubscription[] newArray(int i) {
            return new InAppSubscription[i];
        }

        public InAppSubscription createFromParcel(Parcel parcel) {
            return new InAppSubscription(parcel);
        }
    }

    public int describeContents() {
        return super.describeContents();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.renewalDays);
    }

    protected InAppSubscription(Parcel parcel) {
        super(parcel);
        this.renewalDays = parcel.readInt();
    }

    public int getRenewalDays() {
        return this.renewalDays;
    }
}
