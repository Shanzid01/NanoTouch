package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.zzat;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.request.zzw;

public interface zznn extends IInterface {

    public abstract class zza extends Binder implements zznn {

        class zza implements zznn {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzat com_google_android_gms_fitness_request_zzat) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (com_google_android_gms_fitness_request_zzat != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzax com_google_android_gms_fitness_request_zzax) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (com_google_android_gms_fitness_request_zzax != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzax.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzw com_google_android_gms_fitness_request_zzw) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (com_google_android_gms_fitness_request_zzw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznn zzaK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznn)) ? new zza(iBinder) : (zznn) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzw com_google_android_gms_fitness_request_zzw = null;
            switch (i) {
                case 1:
                    zzat com_google_android_gms_fitness_request_zzat;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzat = (zzat) zzat.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzat);
                    return true;
                case 2:
                    zzax com_google_android_gms_fitness_request_zzax;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzax = (zzax) zzax.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzax);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzw = (zzw) zzw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzw);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzat com_google_android_gms_fitness_request_zzat);

    void zza(zzax com_google_android_gms_fitness_request_zzax);

    void zza(zzw com_google_android_gms_fitness_request_zzw);
}
