package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zze;

public interface zzai extends IInterface {

    public abstract class zza extends Binder implements zzai {

        class zza implements zzai {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, Asset asset) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, PutDataRequest putDataRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, zzau com_google_android_gms_wearable_internal_zzau) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzau != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzau.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, zzb com_google_android_gms_wearable_internal_zzb) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzb != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zzb.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, zze com_google_android_gms_wearable_internal_zze) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_internal_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, zze com_google_android_gms_wearable_zze) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (com_google_android_gms_wearable_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzag com_google_android_gms_wearable_internal_zzag, String str, String str2, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag com_google_android_gms_wearable_internal_zzag, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzle.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag com_google_android_gms_wearable_internal_zzag, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zzb(zzag com_google_android_gms_wearable_internal_zzag, zze com_google_android_gms_wearable_zze) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (com_google_android_gms_wearable_zze != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_wearable_zze.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzag com_google_android_gms_wearable_internal_zzag, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzag com_google_android_gms_wearable_internal_zzag, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzag com_google_android_gms_wearable_internal_zzag, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzag com_google_android_gms_wearable_internal_zzag) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzag != null ? com_google_android_gms_wearable_internal_zzag.asBinder() : null);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzai zzcR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzai)) ? new zza(iBinder) : (zzai) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zze com_google_android_gms_wearable_zze = null;
            zzag zzcP;
            Uri uri;
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_zze = (zze) zze.CREATOR.createFromParcel(parcel);
                    }
                    zzb(zzcP, com_google_android_gms_wearable_zze);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    PutDataRequest putDataRequest;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, putDataRequest);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, uri);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zzb(zzcP, uri);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    }
                    zzc(zzcP, uri);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    Asset asset;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, asset);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    zzb com_google_android_gms_wearable_internal_zzb;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzb = (zzb) zzb.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, com_google_android_gms_wearable_internal_zzb);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    zzau com_google_android_gms_wearable_internal_zzau;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zzau = (zzau) zzau.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, com_google_android_gms_wearable_internal_zzau);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_zze = (zze) zze.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, com_google_android_gms_wearable_zze);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zze com_google_android_gms_wearable_internal_zze;
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzcP = com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_wearable_internal_zze = (zze) zze.CREATOR.createFromParcel(parcel);
                    }
                    zza(zzcP, com_google_android_gms_wearable_internal_zze);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzag.zza.zzcP(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzag com_google_android_gms_wearable_internal_zzag);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, int i);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, Uri uri);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, Asset asset);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, PutDataRequest putDataRequest);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, zzau com_google_android_gms_wearable_internal_zzau);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, zzb com_google_android_gms_wearable_internal_zzb);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, zze com_google_android_gms_wearable_internal_zze);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, zze com_google_android_gms_wearable_zze);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, String str);

    void zza(zzag com_google_android_gms_wearable_internal_zzag, String str, String str2, byte[] bArr);

    void zzb(zzag com_google_android_gms_wearable_internal_zzag);

    void zzb(zzag com_google_android_gms_wearable_internal_zzag, int i);

    void zzb(zzag com_google_android_gms_wearable_internal_zzag, Uri uri);

    void zzb(zzag com_google_android_gms_wearable_internal_zzag, zze com_google_android_gms_wearable_zze);

    void zzb(zzag com_google_android_gms_wearable_internal_zzag, String str);

    void zzc(zzag com_google_android_gms_wearable_internal_zzag);

    void zzc(zzag com_google_android_gms_wearable_internal_zzag, Uri uri);

    void zzc(zzag com_google_android_gms_wearable_internal_zzag, String str);

    void zzd(zzag com_google_android_gms_wearable_internal_zzag);

    void zze(zzag com_google_android_gms_wearable_internal_zzag);

    void zzf(zzag com_google_android_gms_wearable_internal_zzag);

    void zzg(zzag com_google_android_gms_wearable_internal_zzag);

    void zzh(zzag com_google_android_gms_wearable_internal_zzag);

    void zzi(zzag com_google_android_gms_wearable_internal_zzag);

    void zzj(zzag com_google_android_gms_wearable_internal_zzag);

    void zzk(zzag com_google_android_gms_wearable_internal_zzag);

    void zzl(zzag com_google_android_gms_wearable_internal_zzag);
}
