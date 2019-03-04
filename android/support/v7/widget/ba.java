package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RecyclerView */
final class ba implements Creator<SavedState> {
    ba() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1628a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1629a(i);
    }

    public SavedState m1628a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1629a(int i) {
        return new SavedState[i];
    }
}
