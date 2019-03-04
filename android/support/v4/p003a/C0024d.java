package android.support.v4.p003a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ParcelableCompatHoneycombMR2 */
class C0024d<T> implements ClassLoaderCreator<T> {
    private final C0023c<T> f44a;

    public C0024d(C0023c<T> c0023c) {
        this.f44a = c0023c;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f44a.mo306a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f44a.mo306a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f44a.mo307a(i);
    }
}
