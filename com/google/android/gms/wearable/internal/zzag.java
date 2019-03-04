package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzag extends IInterface {

    public abstract class zza extends Binder implements zzag {

        class zza implements zzag {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(Status status) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaa com_google_android_gms_wearable_internal_zzaa) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzaa != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzaa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzac com_google_android_gms_wearable_internal_zzac) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzac != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzac.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzae com_google_android_gms_wearable_internal_zzae) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzae != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzae.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzas com_google_android_gms_wearable_internal_zzas) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzas != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzas.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaw com_google_android_gms_wearable_internal_zzaw) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzaw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzaw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzaz com_google_android_gms_wearable_internal_zzaz) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzaz != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzaz.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzs com_google_android_gms_wearable_internal_zzs) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzs != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzs.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzu com_google_android_gms_wearable_internal_zzu) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzu.writeToParcel(obtain, 0);
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

            public void zza(zzw com_google_android_gms_wearable_internal_zzw) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzy com_google_android_gms_wearable_internal_zzy) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (com_google_android_gms_wearable_internal_zzy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzac(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public static zzag zzcP(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzag)) ? new zza(iBinder) : (zzag) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzaz com_google_android_gms_wearable_internal_zzaz = null;
            switch (i) {
                case 2:
                    zzu com_google_android_gms_wearable_internal_zzu;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzu = (zzu) zzu.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzu);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    zzas com_google_android_gms_wearable_internal_zzas;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzas = (zzas) zzas.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzas);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    zzaa com_google_android_gms_wearable_internal_zzaa;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzaa = (zzaa) zzaa.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzaa);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    DataHolder zzA;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(parcel);
                    }
                    zzac(zzA);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    zzs com_google_android_gms_wearable_internal_zzs;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzs = (zzs) zzs.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzs);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    zzaw com_google_android_gms_wearable_internal_zzaw;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzaw = (zzaw) zzaw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzaw);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    zzac com_google_android_gms_wearable_internal_zzac;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzac = (zzac) zzac.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzac);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    zzae com_google_android_gms_wearable_internal_zzae;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzae = (zzae) zzae.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzae);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    zzy com_google_android_gms_wearable_internal_zzy;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzy = (zzy) zzy.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzy);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    Status createFromParcel;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(parcel);
                    }
                    zza(createFromParcel);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzaz = (zzaz) zzaz.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzaz);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    zzw com_google_android_gms_wearable_internal_zzw;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzw = (zzw) zzw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_wearable_internal_zzw);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(Status status);

    void zza(zzaa com_google_android_gms_wearable_internal_zzaa);

    void zza(zzac com_google_android_gms_wearable_internal_zzac);

    void zza(zzae com_google_android_gms_wearable_internal_zzae);

    void zza(zzas com_google_android_gms_wearable_internal_zzas);

    void zza(zzaw com_google_android_gms_wearable_internal_zzaw);

    void zza(zzaz com_google_android_gms_wearable_internal_zzaz);

    void zza(zzs com_google_android_gms_wearable_internal_zzs);

    void zza(zzu com_google_android_gms_wearable_internal_zzu);

    void zza(zzw com_google_android_gms_wearable_internal_zzw);

    void zza(zzy com_google_android_gms_wearable_internal_zzy);

    void zzac(DataHolder dataHolder);
}
