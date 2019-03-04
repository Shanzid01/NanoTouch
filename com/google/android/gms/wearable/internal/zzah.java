package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

public interface zzah extends IInterface {

    public abstract class zza extends Binder implements zzah {

        class zza implements zzah {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzal com_google_android_gms_wearable_internal_zzal) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (com_google_android_gms_wearable_internal_zzal != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzao com_google_android_gms_wearable_internal_zzao) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (com_google_android_gms_wearable_internal_zzao != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzao.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zze com_google_android_gms_wearable_internal_zze) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (com_google_android_gms_wearable_internal_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzab(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(zzao com_google_android_gms_wearable_internal_zzao) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (com_google_android_gms_wearable_internal_zzao != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzao.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static zzah zzcQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzah)) ? new zza(iBinder) : (zzah) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zze com_google_android_gms_wearable_internal_zze = null;
            zzao com_google_android_gms_wearable_internal_zzao;
            switch (i) {
                case 1:
                    DataHolder zzA;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(parcel);
                    }
                    zzab(zzA);
                    return true;
                case 2:
                    zzal com_google_android_gms_wearable_internal_zzal;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzal = (zzal) zzal.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzal);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzao = (zzao) zzao.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzao);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzao = (zzao) zzao.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_wearable_internal_zzao);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zze = (zze) zze.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zze);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzal com_google_android_gms_wearable_internal_zzal);

    void zza(zzao com_google_android_gms_wearable_internal_zzao);

    void zza(zze com_google_android_gms_wearable_internal_zze);

    void zzab(DataHolder dataHolder);

    void zzb(zzao com_google_android_gms_wearable_internal_zzao);
}
