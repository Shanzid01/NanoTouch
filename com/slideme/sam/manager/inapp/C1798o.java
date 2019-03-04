package com.slideme.sam.manager.inapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PurchaseResult */
class C1798o implements Creator<PurchaseResult> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5379a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5380a(i);
    }

    C1798o() {
    }

    public PurchaseResult m5379a(Parcel parcel) {
        return new PurchaseResult(parcel);
    }

    public PurchaseResult[] m5380a(int i) {
        return new PurchaseResult[i];
    }
}
