package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzrt extends IInterface {

    public abstract class zza extends Binder implements zzrt {

        class zza implements zzrt {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzrw com_google_android_gms_internal_zzrw) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (com_google_android_gms_internal_zzrw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzrw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzrw com_google_android_gms_internal_zzrw) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (com_google_android_gms_internal_zzrw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzrw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzrt zzcj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrt)) ? new zza(iBinder) : (zzrt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzrw com_google_android_gms_internal_zzrw = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzrw = zzrw.CREATOR.zzen(parcel);
                    }
                    zza(com_google_android_gms_internal_zzrw);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzrw = zzrw.CREATOR.zzen(parcel);
                    }
                    zzb(com_google_android_gms_internal_zzrw);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzrw com_google_android_gms_internal_zzrw);

    void zzb(zzrw com_google_android_gms_internal_zzrw);
}
