package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.p003a.C0023c;
import android.support.v4.view.ViewPager.SavedState;

/* compiled from: ViewPager */
final class cp implements C0023c<SavedState> {
    cp() {
    }

    public /* synthetic */ Object mo306a(Parcel parcel, ClassLoader classLoader) {
        return m806b(parcel, classLoader);
    }

    public /* synthetic */ Object[] mo307a(int i) {
        return m807b(i);
    }

    public SavedState m806b(Parcel parcel, ClassLoader classLoader) {
        return new SavedState(parcel, classLoader);
    }

    public SavedState[] m807b(int i) {
        return new SavedState[i];
    }
}
