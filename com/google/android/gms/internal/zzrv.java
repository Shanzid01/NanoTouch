package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzrv extends IInterface {

    public abstract class zza extends Binder implements zzrv {

        class zza implements zzrv {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzsa com_google_android_gms_internal_zzsa) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_internal_zzsa != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzsa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzsc com_google_android_gms_internal_zzsc) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_internal_zzsc != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzsc.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzse com_google_android_gms_internal_zzse) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_internal_zzse != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzsg com_google_android_gms_internal_zzsg) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (com_google_android_gms_internal_zzsg != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzrv zzcl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrv)) ? new zza(iBinder) : (zzrv) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzsg com_google_android_gms_internal_zzsg = null;
            switch (i) {
                case 1:
                    zzsa com_google_android_gms_internal_zzsa;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzsa = (zzsa) zzsa.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzsa);
                    return true;
                case 2:
                    zzse com_google_android_gms_internal_zzse;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzse = (zzse) zzse.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzse);
                    return true;
                case 3:
                    zzsc com_google_android_gms_internal_zzsc;
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzsc = (zzsc) zzsc.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzsc);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzsg = (zzsg) zzsg.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzsg);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzsa com_google_android_gms_internal_zzsa);

    void zza(zzsc com_google_android_gms_internal_zzsc);

    void zza(zzse com_google_android_gms_internal_zzse);

    void zza(zzsg com_google_android_gms_internal_zzsg);
}
