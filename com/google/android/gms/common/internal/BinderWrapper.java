package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C08421();
    private IBinder zzPp;

    final class C08421 implements Creator<BinderWrapper> {
        C08421() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzD(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzaG(i);
        }

        public BinderWrapper zzD(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public BinderWrapper[] zzaG(int i) {
            return new BinderWrapper[i];
        }
    }

    public BinderWrapper() {
        this.zzPp = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzPp = null;
        this.zzPp = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzPp = null;
        this.zzPp = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzPp);
    }
}
