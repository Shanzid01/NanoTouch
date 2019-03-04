package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.location.places.PlacesStatusCodes;

public interface IGamesSignInService extends IInterface {

    public abstract class Stub extends Binder implements IGamesSignInService {

        class Proxy implements IGamesSignInService {
            private IBinder zzle;

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(14001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzle.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzle.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String str4, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String[] strArr, String str4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str4);
                    this.zzle.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzle.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzbZ(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    this.zzle.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzca(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    this.zzle.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzh(String str, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzx(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzle.transact(PlacesStatusCodes.USAGE_LIMIT_EXCEEDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String zzbZ;
            switch (i) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zzbZ = zzbZ(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(zzbZ);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zzbZ = zzca(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(zzbZ);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zza(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zza(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zza(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zza(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zzb(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /*5008*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zza(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /*5009*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zzbZ = zzh(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeString(zzbZ);
                    return true;
                case PlacesStatusCodes.USAGE_LIMIT_EXCEEDED /*9001*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zzx(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    zza(com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.zzba(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IGamesSignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str);

    void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2);

    void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3);

    void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String str4, String[] strArr);

    void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String[] strArr);

    void zza(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String[] strArr, String str4);

    void zzb(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3);

    String zzbZ(String str);

    String zzca(String str);

    String zzh(String str, boolean z);

    void zzx(String str, String str2);
}
