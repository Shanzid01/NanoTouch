package com.slideme.sam.manager.inapp;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IInAppService */
public abstract class C1786c extends Binder implements C1785b {
    public C1786c() {
        attachInterface(this, "com.slideme.sam.manager.inapp.IInAppService");
    }

    public static C1785b m5352a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.slideme.sam.manager.inapp.IInAppService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1785b)) {
            return new C1787d(iBinder);
        }
        return (C1785b) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.slideme.sam.manager.inapp.IInAppService");
                a = mo4276a(parcel.readInt(), parcel.createStringArrayList(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                parcel.enforceInterface("com.slideme.sam.manager.inapp.IInAppService");
                a = mo4275a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 3:
                parcel.enforceInterface("com.slideme.sam.manager.inapp.IInAppService");
                a = mo4274a(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 4:
                parcel.enforceInterface("com.slideme.sam.manager.inapp.IInAppService");
                a = mo4277b(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.slideme.sam.manager.inapp.IInAppService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
