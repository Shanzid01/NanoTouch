package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zzaa;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.fitness.request.zzr;
import com.google.android.gms.fitness.request.zzy;

public interface zznl extends IInterface {

    public abstract class zza extends Binder implements zznl {

        class zza implements zznl {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(DataDeleteRequest dataDeleteRequest) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataReadRequest dataReadRequest) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzaa com_google_android_gms_fitness_request_zzaa) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzaa != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzaa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zze com_google_android_gms_fitness_request_zze) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzr com_google_android_gms_fitness_request_zzr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzr != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzr.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzy com_google_android_gms_fitness_request_zzy) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (com_google_android_gms_fitness_request_zzy != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznl zzaI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznl)) ? new zza(iBinder) : (zznl) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzy com_google_android_gms_fitness_request_zzy = null;
            switch (i) {
                case 1:
                    DataReadRequest dataReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataReadRequest);
                    return true;
                case 2:
                    zze com_google_android_gms_fitness_request_zze;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zze = (zze) zze.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zze);
                    return true;
                case 3:
                    DataDeleteRequest dataDeleteRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataDeleteRequest);
                    return true;
                case 4:
                    zzr com_google_android_gms_fitness_request_zzr;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzr = (zzr) zzr.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzr);
                    return true;
                case 5:
                    zzaa com_google_android_gms_fitness_request_zzaa;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzaa = (zzaa) zzaa.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzaa);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzy = (zzy) zzy.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzy);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataDeleteRequest dataDeleteRequest);

    void zza(DataReadRequest dataReadRequest);

    void zza(zzaa com_google_android_gms_fitness_request_zzaa);

    void zza(zze com_google_android_gms_fitness_request_zze);

    void zza(zzr com_google_android_gms_fitness_request_zzr);

    void zza(zzy com_google_android_gms_fitness_request_zzy);
}
