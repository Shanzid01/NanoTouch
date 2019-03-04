package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: StaggeredGridLayoutManager */
final class bm implements Creator<FullSpanItem> {
    bm() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1707a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1708a(i);
    }

    public FullSpanItem m1707a(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public FullSpanItem[] m1708a(int i) {
        return new FullSpanItem[i];
    }
}
