package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;

public interface IRoomService extends IInterface {

    public abstract class Stub extends Binder implements IRoomService {

        class Proxy implements IRoomService {
            private IBinder zzle;

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zzV(boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_INTERSECTION, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.zzle.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_FLOOR, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(byte[] bArr, String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_LOCALITY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(byte[] bArr, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_NATURAL_FEATURE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcb(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_POINT_OF_INTEREST, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcc(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_POST_BOX, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zze(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzle.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznV() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznW() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznX() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(Place.TYPE_COUNTRY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznY() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.zzle.transact(Place.TYPE_GEOCODE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzw(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_NEIGHBORHOOD, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzx(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_POLITICAL, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            switch (i) {
                case 1001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zza(parcel.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.zzbc(parcel.readStrongBinder()));
                    return true;
                case 1002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznV();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznW();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zze(parcel.readString(), parcel.readString(), parcel.readString());
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznX();
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder zzA = parcel.readInt() != 0 ? DataHolder.CREATOR.zzA(parcel) : null;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(zzA, z);
                    return true;
                case Place.TYPE_GEOCODE /*1007*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zznY();
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzV(z);
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zza(parcel.createByteArray(), parcel.readString(), parcel.readInt());
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zza(parcel.createByteArray(), parcel.createStringArray());
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzw(parcel.readString(), parcel.readInt());
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzx(parcel.readString(), parcel.readInt());
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzcb(parcel.readString());
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    zzcc(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzV(boolean z);

    void zza(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks);

    void zza(DataHolder dataHolder, boolean z);

    void zza(byte[] bArr, String str, int i);

    void zza(byte[] bArr, String[] strArr);

    void zzcb(String str);

    void zzcc(String str);

    void zze(String str, String str2, String str3);

    void zznV();

    void zznW();

    void zznX();

    void zznY();

    void zzw(String str, int i);

    void zzx(String str, int i);
}
