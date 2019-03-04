package org.p059a.p060a;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: IOpenAppstore */
public abstract class C1804b extends Binder implements C1803a {
    public C1804b() {
        attachInterface(this, "org.onepf.oms.IOpenAppstore");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean a;
        Intent b;
        switch (i) {
            case 1:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                String a2 = mo4285a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case 2:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                a = mo4286a(parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                a = mo4288b(parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                i3 = mo4289c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                b = mo4287b();
                parcel2.writeNoException();
                if (b != null) {
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 6:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                b = mo4291d(parcel.readString());
                parcel2.writeNoException();
                if (b != null) {
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 7:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                b = mo4292e(parcel.readString());
                parcel2.writeNoException();
                if (b != null) {
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 8:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                b = mo4293f(parcel.readString());
                parcel2.writeNoException();
                if (b != null) {
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 9:
                parcel.enforceInterface("org.onepf.oms.IOpenAppstore");
                a = mo4290c();
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 1598968902:
                parcel2.writeString("org.onepf.oms.IOpenAppstore");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
