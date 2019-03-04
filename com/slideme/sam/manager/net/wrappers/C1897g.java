package com.slideme.sam.manager.net.wrappers;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;

/* compiled from: Catalog */
class C1897g implements Creator<Sort> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5719a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5720a(i);
    }

    C1897g() {
    }

    public Sort m5719a(Parcel parcel) {
        return new Sort(parcel);
    }

    public Sort[] m5720a(int i) {
        return new Sort[i];
    }
}
