package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout.SavedState;

/* compiled from: DrawerLayout */
final class C0162q implements Creator<SavedState> {
    C0162q() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1240a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1241a(i);
    }

    public SavedState m1240a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1241a(int i) {
        return new SavedState[i];
    }
}
