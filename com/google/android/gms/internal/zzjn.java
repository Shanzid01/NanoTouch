package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface zzjn extends IInterface {

    public abstract class zza extends Binder implements zzjn {

        class zza implements zzjn {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzjm com_google_android_gms_internal_zzjm) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    this.zzle.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjm com_google_android_gms_internal_zzjm, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjm com_google_android_gms_internal_zzjm, int i, String str, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjm com_google_android_gms_internal_zzjm, int i, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjm com_google_android_gms_internal_zzjm) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    this.zzle.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjm com_google_android_gms_internal_zzjm, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzjm com_google_android_gms_internal_zzjm) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjm != null ? com_google_android_gms_internal_zzjm.asBinder() : null);
                    this.zzle.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzhd() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zzle.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzhe() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zzle.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjn zzN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjn)) ? new zza(iBinder) : (zzjn) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int zzhd;
            switch (i) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzhd = zzhd();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzhd);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzhd = zzhe();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzhd);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /*5008*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /*5009*/:
                    parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzc(com.google.android.gms.internal.zzjm.zza.zzM(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzjm com_google_android_gms_internal_zzjm);

    void zza(zzjm com_google_android_gms_internal_zzjm, int i);

    void zza(zzjm com_google_android_gms_internal_zzjm, int i, String str, byte[] bArr);

    void zza(zzjm com_google_android_gms_internal_zzjm, int i, byte[] bArr);

    void zzb(zzjm com_google_android_gms_internal_zzjm);

    void zzb(zzjm com_google_android_gms_internal_zzjm, int i);

    void zzc(zzjm com_google_android_gms_internal_zzjm);

    int zzhd();

    int zzhe();
}
