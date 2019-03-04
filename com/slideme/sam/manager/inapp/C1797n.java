package com.slideme.sam.manager.inapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Purchase */
class C1797n implements Creator<Purchase> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5377a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5378a(i);
    }

    C1797n() {
    }

    public Purchase m5377a(Parcel parcel) {
        return new Purchase(parcel);
    }

    public Purchase[] m5378a(int i) {
        return new Purchase[i];
    }
}
