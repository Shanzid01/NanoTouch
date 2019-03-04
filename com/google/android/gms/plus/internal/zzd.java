package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzlk;
import java.util.List;

public interface zzd extends IInterface {

    public abstract class zza extends Binder implements zzd {

        class zza implements zzd {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public String getAccountName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICancelToken zza(zzb com_google_android_gms_plus_internal_zzb, int i, int i2, int i3, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.zzle.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    ICancelToken zzS = com.google.android.gms.common.internal.ICancelToken.zza.zzS(obtain2.readStrongBinder());
                    return zzS;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzlk com_google_android_gms_internal_zzlk) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (com_google_android_gms_internal_zzlk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzlk.writeToParcel(obtain, 0);
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

            public void zza(zzb com_google_android_gms_plus_internal_zzb) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, int i, String str, Uri uri, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzle.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void zza(zzb com_google_android_gms_plus_internal_zzb, zzlk com_google_android_gms_internal_zzlk) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    if (com_google_android_gms_internal_zzlk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzlk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, List<String> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeStringList(list);
                    this.zzle.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzkw com_google_android_gms_internal_zzkw, zzkw com_google_android_gms_internal_zzkw2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzkw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzkw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzkw2 != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzkw2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb com_google_android_gms_plus_internal_zzb) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    this.zzle.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb com_google_android_gms_plus_internal_zzb, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzb com_google_android_gms_plus_internal_zzb, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzcE(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    this.zzle.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzb com_google_android_gms_plus_internal_zzb, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzb com_google_android_gms_plus_internal_zzb, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzrK() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzrL() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzrM() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzrN() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzd zzcy(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzkw com_google_android_gms_internal_zzkw = null;
            String accountName;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(parcel.readInt() != 0 ? zzlk.CREATOR.zzT(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    parcel2.writeNoException();
                    parcel2.writeString(accountName);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzrK();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    ICancelToken zza = zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (zza != null) {
                        asBinder = zza.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzcE(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzc(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzd(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = zzrL();
                    parcel2.writeNoException();
                    parcel2.writeString(accountName);
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean zzrM = zzrM();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzrM ? 1 : 0);
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = zzrN();
                    parcel2.writeNoException();
                    parcel2.writeString(accountName);
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zze(com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    zzlk zzT;
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb zzcw = com.google.android.gms.plus.internal.zzb.zza.zzcw(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        zzT = zzlk.CREATOR.zzT(parcel);
                    }
                    zza(zzcw, zzT);
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    String readString = parcel.readString();
                    zzkw zzL = parcel.readInt() != 0 ? zzkw.CREATOR.zzL(parcel) : null;
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzkw = zzkw.CREATOR.zzL(parcel);
                    }
                    zza(readString, zzL, com_google_android_gms_internal_zzkw);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getAccountName();

    ICancelToken zza(zzb com_google_android_gms_plus_internal_zzb, int i, int i2, int i3, String str);

    void zza(zzlk com_google_android_gms_internal_zzlk);

    void zza(zzb com_google_android_gms_plus_internal_zzb);

    void zza(zzb com_google_android_gms_plus_internal_zzb, int i, String str, Uri uri, String str2, String str3);

    void zza(zzb com_google_android_gms_plus_internal_zzb, Uri uri, Bundle bundle);

    void zza(zzb com_google_android_gms_plus_internal_zzb, zzlk com_google_android_gms_internal_zzlk);

    void zza(zzb com_google_android_gms_plus_internal_zzb, String str);

    void zza(zzb com_google_android_gms_plus_internal_zzb, String str, String str2);

    void zza(zzb com_google_android_gms_plus_internal_zzb, List<String> list);

    void zza(String str, zzkw com_google_android_gms_internal_zzkw, zzkw com_google_android_gms_internal_zzkw2);

    void zzb(zzb com_google_android_gms_plus_internal_zzb);

    void zzb(zzb com_google_android_gms_plus_internal_zzb, String str);

    void zzc(zzb com_google_android_gms_plus_internal_zzb, String str);

    void zzcE(String str);

    void zzd(zzb com_google_android_gms_plus_internal_zzb, String str);

    void zze(zzb com_google_android_gms_plus_internal_zzb, String str);

    void zzrK();

    String zzrL();

    boolean zzrM();

    String zzrN();
}
