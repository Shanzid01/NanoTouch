package com.slideme.sam.manager.util;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableHelper */
public class C1915f {
    public static Intent m5769a(Intent intent, String str, Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        intent.putExtra(str, obtain.marshall());
        obtain.recycle();
        return intent;
    }

    public static <T extends Parcelable> T m5770a(Intent intent, String str, Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
        obtain.setDataPosition(0);
        return (Parcelable) creator.createFromParcel(obtain);
    }
}
