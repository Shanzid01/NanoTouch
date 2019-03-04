package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzu;

public interface zznj extends IInterface {

    public abstract class zza extends Binder implements zznj {

        class zza implements zznj {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(StartBleScanRequest startBleScanRequest) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_fitness_request_zzar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzar != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_fitness_request_zzav) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzav != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzav.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_fitness_request_zzb) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzb != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzb.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzu com_google_android_gms_fitness_request_zzu) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzu.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznj zzaG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznj)) ? new zza(iBinder) : (zznj) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzu com_google_android_gms_fitness_request_zzu = null;
            switch (i) {
                case 1:
                    StartBleScanRequest startBleScanRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(startBleScanRequest);
                    return true;
                case 2:
                    zzar com_google_android_gms_fitness_request_zzar;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzar = (zzar) zzar.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzar);
                    return true;
                case 3:
                    zzb com_google_android_gms_fitness_request_zzb;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzb = (zzb) zzb.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzb);
                    return true;
                case 4:
                    zzav com_google_android_gms_fitness_request_zzav;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzav = (zzav) zzav.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzav);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzu = (zzu) zzu.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzu);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(StartBleScanRequest startBleScanRequest);

    void zza(zzar com_google_android_gms_fitness_request_zzar);

    void zza(zzav com_google_android_gms_fitness_request_zzav);

    void zza(zzb com_google_android_gms_fitness_request_zzb);

    void zza(zzu com_google_android_gms_fitness_request_zzu);
}
