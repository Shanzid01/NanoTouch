package com.slideme.sam.manager.view.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MultiselectListPreference */
class C1960b implements Creator<SavedState> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5898a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5899a(i);
    }

    C1960b() {
    }

    public SavedState m5898a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m5899a(int i) {
        return new SavedState[i];
    }
}
