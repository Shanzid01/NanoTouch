package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LinearLayoutManager */
final class C0196y implements Creator<SavedState> {
    C0196y() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1814a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1815a(i);
    }

    public SavedState m1814a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1815a(int i) {
        return new SavedState[i];
    }
}
