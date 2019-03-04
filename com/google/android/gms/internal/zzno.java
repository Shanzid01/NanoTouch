package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzac;
import com.google.android.gms.fitness.request.zzae;

public interface zzno extends IInterface {

    public abstract class zza extends Binder implements zzno {

        class zza implements zzno {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(DataSourcesRequest dataSourcesRequest) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzac com_google_android_gms_fitness_request_zzac) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (com_google_android_gms_fitness_request_zzac != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzac.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzae com_google_android_gms_fitness_request_zzae) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (com_google_android_gms_fitness_request_zzae != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzae.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzno zzaL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzno)) ? new zza(iBinder) : (zzno) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzae com_google_android_gms_fitness_request_zzae = null;
            switch (i) {
                case 1:
                    DataSourcesRequest dataSourcesRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataSourcesRequest);
                    return true;
                case 2:
                    zzac com_google_android_gms_fitness_request_zzac;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzac = (zzac) zzac.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzac);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzae = (zzae) zzae.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzae);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataSourcesRequest dataSourcesRequest);

    void zza(zzac com_google_android_gms_fitness_request_zzac);

    void zza(zzae com_google_android_gms_fitness_request_zzae);
}
