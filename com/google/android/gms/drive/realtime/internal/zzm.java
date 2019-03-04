package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

public interface zzm extends IInterface {

    public abstract class zza extends Binder implements zzm {

        class zza implements zzm {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(int i, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ParcelableIndexReference parcelableIndexReference, zzn com_google_android_gms_drive_realtime_internal_zzn) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzn != null ? com_google_android_gms_drive_realtime_internal_zzn.asBinder() : null);
                    this.zzle.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzc com_google_android_gms_drive_realtime_internal_zzc) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzc != null ? com_google_android_gms_drive_realtime_internal_zzc.asBinder() : null);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_drive_realtime_internal_zzd) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzd != null ? com_google_android_gms_drive_realtime_internal_zzd.asBinder() : null);
                    this.zzle.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zze com_google_android_gms_drive_realtime_internal_zze) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zze != null ? com_google_android_gms_drive_realtime_internal_zze.asBinder() : null);
                    this.zzle.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh com_google_android_gms_drive_realtime_internal_zzh) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzh != null ? com_google_android_gms_drive_realtime_internal_zzh.asBinder() : null);
                    this.zzle.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzi com_google_android_gms_drive_realtime_internal_zzi) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzi != null ? com_google_android_gms_drive_realtime_internal_zzi.asBinder() : null);
                    this.zzle.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzl com_google_android_gms_drive_realtime_internal_zzl) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzl != null ? com_google_android_gms_drive_realtime_internal_zzl.asBinder() : null);
                    this.zzle.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzg com_google_android_gms_drive_realtime_internal_zzg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzg != null ? com_google_android_gms_drive_realtime_internal_zzg.asBinder() : null);
                    this.zzle.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzg com_google_android_gms_drive_realtime_internal_zzg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzg != null ? com_google_android_gms_drive_realtime_internal_zzg.asBinder() : null);
                    this.zzle.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, int i2, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, DataHolder dataHolder, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzf com_google_android_gms_drive_realtime_internal_zzf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzf != null ? com_google_android_gms_drive_realtime_internal_zzf.asBinder() : null);
                    this.zzle.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzk com_google_android_gms_drive_realtime_internal_zzk) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzk != null ? com_google_android_gms_drive_realtime_internal_zzk.asBinder() : null);
                    this.zzle.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzl com_google_android_gms_drive_realtime_internal_zzl) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzl != null ? com_google_android_gms_drive_realtime_internal_zzl.asBinder() : null);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzn com_google_android_gms_drive_realtime_internal_zzn) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzn != null ? com_google_android_gms_drive_realtime_internal_zzn.asBinder() : null);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, DataHolder dataHolder, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzf com_google_android_gms_drive_realtime_internal_zzf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzf != null ? com_google_android_gms_drive_realtime_internal_zzf.asBinder() : null);
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzg com_google_android_gms_drive_realtime_internal_zzg) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzg != null ? com_google_android_gms_drive_realtime_internal_zzg.asBinder() : null);
                    this.zzle.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzc com_google_android_gms_drive_realtime_internal_zzc) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzc != null ? com_google_android_gms_drive_realtime_internal_zzc.asBinder() : null);
                    this.zzle.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzj com_google_android_gms_drive_realtime_internal_zzj) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzj != null ? com_google_android_gms_drive_realtime_internal_zzj.asBinder() : null);
                    this.zzle.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzl com_google_android_gms_drive_realtime_internal_zzl) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzl != null ? com_google_android_gms_drive_realtime_internal_zzl.asBinder() : null);
                    this.zzle.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzf com_google_android_gms_drive_realtime_internal_zzf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzf != null ? com_google_android_gms_drive_realtime_internal_zzf.asBinder() : null);
                    this.zzle.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzl com_google_android_gms_drive_realtime_internal_zzl) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzl != null ? com_google_android_gms_drive_realtime_internal_zzl.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzn com_google_android_gms_drive_realtime_internal_zzn) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzn != null ? com_google_android_gms_drive_realtime_internal_zzn.asBinder() : null);
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzo com_google_android_gms_drive_realtime_internal_zzo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzo != null ? com_google_android_gms_drive_realtime_internal_zzo.asBinder() : null);
                    this.zzle.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzf com_google_android_gms_drive_realtime_internal_zzf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzf != null ? com_google_android_gms_drive_realtime_internal_zzf.asBinder() : null);
                    this.zzle.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzc com_google_android_gms_drive_realtime_internal_zzc) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzc != null ? com_google_android_gms_drive_realtime_internal_zzc.asBinder() : null);
                    this.zzle.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzl com_google_android_gms_drive_realtime_internal_zzl) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzl != null ? com_google_android_gms_drive_realtime_internal_zzl.asBinder() : null);
                    this.zzle.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzc com_google_android_gms_drive_realtime_internal_zzc) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_realtime_internal_zzc != null ? com_google_android_gms_drive_realtime_internal_zzc.asBinder() : null);
                    this.zzle.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzm zzaq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new zza(iBinder) : (zzm) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            EndCompoundOperationRequest endCompoundOperationRequest = null;
            String readString;
            DataHolder zzA;
            int readInt;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzn.zza.zzar(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzc.zza.zzag(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.drive.realtime.internal.zzf.zza.zzaj(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzl.zza.zzap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(parcel);
                    }
                    zza(readString, zzA, com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzl.zza.zzap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzn.zza.zzar(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readString(), com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt(), com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzf.zza.zzaj(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzl.zza.zzap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(parcel);
                    }
                    zza(readString, readInt, zzA, com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(parcel);
                    }
                    zza(readString, readInt, zzA, com.google.android.gms.drive.realtime.internal.zzg.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt(), com.google.android.gms.drive.realtime.internal.zzg.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    BeginCompoundOperationRequest beginCompoundOperationRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        beginCompoundOperationRequest = (BeginCompoundOperationRequest) BeginCompoundOperationRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(beginCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        endCompoundOperationRequest = (EndCompoundOperationRequest) EndCompoundOperationRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(endCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzf.zza.zzaj(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), com.google.android.gms.drive.realtime.internal.zzg.zza.zzak(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(com.google.android.gms.drive.realtime.internal.zzc.zza.zzag(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzd(com.google.android.gms.drive.realtime.internal.zzc.zza.zzag(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    ParcelableIndexReference parcelableIndexReference;
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        parcelableIndexReference = (ParcelableIndexReference) ParcelableIndexReference.CREATOR.createFromParcel(parcel);
                    }
                    zza(parcelableIndexReference, com.google.android.gms.drive.realtime.internal.zzn.zza.zzar(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzk.zza.zzao(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.drive.realtime.internal.zzl.zza.zzap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt(), com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zze.zza.zzai(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzd.zza.zzah(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.drive.realtime.internal.zzc.zza.zzag(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzi.zza.zzam(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzh.zza.zzal(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), com.google.android.gms.drive.realtime.internal.zzo.zza.zzas(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(com.google.android.gms.drive.realtime.internal.zzl.zza.zzap(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcel.readInt() != 0) {
                        endCompoundOperationRequest = (EndCompoundOperationRequest) EndCompoundOperationRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(endCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), parcel.readString(), com.google.android.gms.drive.realtime.internal.zzf.zza.zzaj(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        zzA = DataHolder.CREATOR.zzA(parcel);
                    }
                    zza(readString, readString2, zzA, com.google.android.gms.drive.realtime.internal.zzj.zza.zzan(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(int i, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zza(ParcelableIndexReference parcelableIndexReference, zzn com_google_android_gms_drive_realtime_internal_zzn);

    void zza(zzc com_google_android_gms_drive_realtime_internal_zzc);

    void zza(zzd com_google_android_gms_drive_realtime_internal_zzd);

    void zza(zze com_google_android_gms_drive_realtime_internal_zze);

    void zza(zzh com_google_android_gms_drive_realtime_internal_zzh);

    void zza(zzi com_google_android_gms_drive_realtime_internal_zzi);

    void zza(zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(zzl com_google_android_gms_drive_realtime_internal_zzl);

    void zza(zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zza(String str, int i, int i2, zzg com_google_android_gms_drive_realtime_internal_zzg);

    void zza(String str, int i, int i2, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, int i, DataHolder dataHolder, zzg com_google_android_gms_drive_realtime_internal_zzg);

    void zza(String str, int i, DataHolder dataHolder, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, int i, zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zza(String str, int i, String str2, int i2, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, int i, String str2, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, DataHolder dataHolder, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, zzf com_google_android_gms_drive_realtime_internal_zzf);

    void zza(String str, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, zzk com_google_android_gms_drive_realtime_internal_zzk);

    void zza(String str, zzl com_google_android_gms_drive_realtime_internal_zzl);

    void zza(String str, zzn com_google_android_gms_drive_realtime_internal_zzn);

    void zza(String str, zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zza(String str, String str2, DataHolder dataHolder, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zza(String str, String str2, zzf com_google_android_gms_drive_realtime_internal_zzf);

    void zza(String str, String str2, zzg com_google_android_gms_drive_realtime_internal_zzg);

    void zza(String str, String str2, zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zzb(zzc com_google_android_gms_drive_realtime_internal_zzc);

    void zzb(zzj com_google_android_gms_drive_realtime_internal_zzj);

    void zzb(zzl com_google_android_gms_drive_realtime_internal_zzl);

    void zzb(zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zzb(String str, zzf com_google_android_gms_drive_realtime_internal_zzf);

    void zzb(String str, zzl com_google_android_gms_drive_realtime_internal_zzl);

    void zzb(String str, zzn com_google_android_gms_drive_realtime_internal_zzn);

    void zzb(String str, zzo com_google_android_gms_drive_realtime_internal_zzo);

    void zzb(String str, String str2, zzf com_google_android_gms_drive_realtime_internal_zzf);

    void zzc(zzc com_google_android_gms_drive_realtime_internal_zzc);

    void zzc(String str, zzl com_google_android_gms_drive_realtime_internal_zzl);

    void zzd(zzc com_google_android_gms_drive_realtime_internal_zzc);
}
