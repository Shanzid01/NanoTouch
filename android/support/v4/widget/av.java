package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: SlidingPaneLayout */
final class av implements Creator<SavedState> {
    av() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1172a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1173a(i);
    }

    public SavedState m1172a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1173a(int i) {
        return new SavedState[i];
    }
}
