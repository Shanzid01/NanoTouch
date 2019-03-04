package com.slideme.sam.manager.net.wrappers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Catalog */
class C1894c implements Creator<Catalog> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5715a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5716a(i);
    }

    C1894c() {
    }

    public Catalog m5715a(Parcel parcel) {
        return new Catalog(parcel);
    }

    public Catalog[] m5716a(int i) {
        return new Catalog[i];
    }
}
