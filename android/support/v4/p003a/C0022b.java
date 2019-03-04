package android.support.v4.p003a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableCompat */
class C0022b<T> implements Creator<T> {
    final C0023c<T> f43a;

    public C0022b(C0023c<T> c0023c) {
        this.f43a = c0023c;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f43a.mo306a(parcel, null);
    }

    public T[] newArray(int i) {
        return this.f43a.mo307a(i);
    }
}
