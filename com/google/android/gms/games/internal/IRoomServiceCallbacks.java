package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.location.places.Place;

public interface IRoomServiceCallbacks extends IInterface {

    public abstract class Stub extends Binder implements IRoomServiceCallbacks {

        class Proxy implements IRoomServiceCallbacks {
            private IBinder zzle;

            Proxy(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void onP2PConnected(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_POST_BOX, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_POSTAL_CODE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ParcelFileDescriptor parcelFileDescriptor, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ConnectionInfo connectionInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (connectionInfo != null) {
                        obtain.writeInt(1);
                        connectionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(Place.TYPE_SUBLOCALITY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, byte[] bArr, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.zzle.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_INTERSECTION, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_LOCALITY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzbb(IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(Place.TYPE_STREET_ADDRESS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(int i, int i2, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.zzle.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(String str, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(Place.TYPE_PREMISE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzc(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_NATURAL_FEATURE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcd(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzce(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcf(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_COUNTRY, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzcg(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_FLOOR, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzch(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_GEOCODE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzci(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.zzle.transact(Place.TYPE_ROOM, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzd(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_NEIGHBORHOOD, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zze(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_POLITICAL, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzeG(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_ROUTE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzf(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_POINT_OF_INTEREST, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzg(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.zzle.transact(Place.TYPE_POSTAL_TOWN, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzi(String str, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zznZ() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.zzle.transact(Place.TYPE_POSTAL_CODE_PREFIX, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzoa() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzy(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzle.transact(Place.TYPE_SUBLOCALITY_LEVEL_3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
        }

        public static IRoomServiceCallbacks zzbc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRoomServiceCallbacks)) ? new Proxy(iBinder) : (IRoomServiceCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ParcelFileDescriptor parcelFileDescriptor = null;
            switch (i) {
                case 1001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzc(parcel.readInt(), parcel.readInt(), parcel.readString());
                    return true;
                case 1002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zza(parcel.readString(), parcel.createByteArray(), parcel.readInt());
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzcd(parcel.readString());
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzce(parcel.readString());
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzcf(parcel.readString());
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzcg(parcel.readString());
                    return true;
                case Place.TYPE_GEOCODE /*1007*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzch(parcel.readString());
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zza(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzb(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzc(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzd(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zze(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzf(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PConnected(parcel.readString());
                    return true;
                case Place.TYPE_POSTAL_CODE /*1015*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PDisconnected(parcel.readString());
                    return true;
                case Place.TYPE_POSTAL_CODE_PREFIX /*1016*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zznZ();
                    return true;
                case Place.TYPE_POSTAL_TOWN /*1017*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzg(parcel.readString(), parcel.createStringArray());
                    return true;
                case Place.TYPE_PREMISE /*1018*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzc(parcel.readString(), parcel.createByteArray());
                    return true;
                case Place.TYPE_ROOM /*1019*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzci(parcel.readString());
                    return true;
                case Place.TYPE_ROUTE /*1020*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzeG(parcel.readInt());
                    return true;
                case Place.TYPE_STREET_ADDRESS /*1021*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzbb(parcel.readStrongBinder());
                    return true;
                case Place.TYPE_SUBLOCALITY /*1022*/:
                    ConnectionInfo zzcX;
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        zzcX = ConnectionInfo.CREATOR.zzcX(parcel);
                    }
                    zza(zzcX);
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_1 /*1023*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzoa();
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_2 /*1024*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcel.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                    }
                    zza(parcelFileDescriptor, parcel.readInt());
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_3 /*1025*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzy(parcel.readString(), parcel.readInt());
                    return true;
                case Place.TYPE_SUBLOCALITY_LEVEL_4 /*1026*/:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    zzi(parcel.readString(), parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onP2PConnected(String str);

    void onP2PDisconnected(String str);

    void zza(ParcelFileDescriptor parcelFileDescriptor, int i);

    void zza(ConnectionInfo connectionInfo);

    void zza(String str, byte[] bArr, int i);

    void zza(String str, String[] strArr);

    void zzb(String str, String[] strArr);

    void zzbb(IBinder iBinder);

    void zzc(int i, int i2, String str);

    void zzc(String str, byte[] bArr);

    void zzc(String str, String[] strArr);

    void zzcd(String str);

    void zzce(String str);

    void zzcf(String str);

    void zzcg(String str);

    void zzch(String str);

    void zzci(String str);

    void zzd(String str, String[] strArr);

    void zze(String str, String[] strArr);

    void zzeG(int i);

    void zzf(String str, String[] strArr);

    void zzg(String str, String[] strArr);

    void zzi(String str, boolean z);

    void zznZ();

    void zzoa();

    void zzy(String str, int i);
}
