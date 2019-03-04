package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: StaggeredGridLayoutManager */
final class bn implements Creator<SavedState> {
    bn() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1709a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1710a(i);
    }

    public SavedState m1709a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1710a(int i) {
        return new SavedState[i];
    }
}
