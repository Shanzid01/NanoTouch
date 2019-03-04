package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzao;

public interface zznp extends IInterface {

    public abstract class zza extends Binder implements zznp {

        class zza implements zznp {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(SessionInsertRequest sessionInsertRequest) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionReadRequest sessionReadRequest) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzai com_google_android_gms_fitness_request_zzai) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzai != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzai.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzak com_google_android_gms_fitness_request_zzak) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzak != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzak.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzam com_google_android_gms_fitness_request_zzam) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzam != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzao com_google_android_gms_fitness_request_zzao) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (com_google_android_gms_fitness_request_zzao != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzao.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznp zzaM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznp)) ? new zza(iBinder) : (zznp) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzao com_google_android_gms_fitness_request_zzao = null;
            switch (i) {
                case 1:
                    zzak com_google_android_gms_fitness_request_zzak;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzak = (zzak) zzak.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzak);
                    return true;
                case 2:
                    zzam com_google_android_gms_fitness_request_zzam;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzam = (zzam) zzam.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzam);
                    return true;
                case 3:
                    SessionInsertRequest sessionInsertRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(sessionInsertRequest);
                    return true;
                case 4:
                    SessionReadRequest sessionReadRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(sessionReadRequest);
                    return true;
                case 5:
                    zzai com_google_android_gms_fitness_request_zzai;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzai = (zzai) zzai.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzai);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzao = (zzao) zzao.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzao);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(SessionInsertRequest sessionInsertRequest);

    void zza(SessionReadRequest sessionReadRequest);

    void zza(zzai com_google_android_gms_fitness_request_zzai);

    void zza(zzak com_google_android_gms_fitness_request_zzak);

    void zza(zzam com_google_android_gms_fitness_request_zzam);

    void zza(zzao com_google_android_gms_fitness_request_zzao);
}
