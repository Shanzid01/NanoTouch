package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzsn extends IInterface {

    public abstract class zza extends Binder implements zzsn {

        class zza implements zzsn {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzsp com_google_android_gms_internal_zzsp) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (com_google_android_gms_internal_zzsp != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzsp.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzss com_google_android_gms_internal_zzss) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (com_google_android_gms_internal_zzss != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzss.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzsn zzcp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzsn)) ? new zza(iBinder) : (zzsn) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzss com_google_android_gms_internal_zzss = null;
            switch (i) {
                case 1:
                    zzsp com_google_android_gms_internal_zzsp;
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzsp = (zzsp) zzsp.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzsp);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzss = (zzss) zzss.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzss);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzsp com_google_android_gms_internal_zzsp);

    void zza(zzss com_google_android_gms_internal_zzss);
}
