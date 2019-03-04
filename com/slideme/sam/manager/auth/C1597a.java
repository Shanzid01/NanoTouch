package com.slideme.sam.manager.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: AuthData */
class C1597a implements Creator<AuthData> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4831a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4832a(i);
    }

    C1597a() {
    }

    public AuthData[] m4832a(int i) {
        return new AuthData[i];
    }

    public AuthData m4831a(Parcel parcel) {
        return new AuthData(parcel);
    }
}
