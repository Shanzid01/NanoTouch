package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zze<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zzNS = new String[]{"data"};
    private final Creator<T> zzNT;

    public zze(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zzNT = creator;
    }

    public /* synthetic */ Object get(int i) {
        return zzaw(i);
    }

    public T zzaw(int i) {
        byte[] zzf = this.zzMd.zzf("data", i, this.zzMd.zzax(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzf, 0, zzf.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zzNT.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
