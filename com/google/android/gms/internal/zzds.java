package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public interface zzds extends IInterface {

    public abstract class zza extends Binder implements zzds {

        class zza implements zzds {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void destroy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd getView() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (com_google_android_gms_internal_zzax != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzax.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzdt != null) {
                        iBinder = com_google_android_gms_internal_zzdt.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (com_google_android_gms_internal_zzax != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzax.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (com_google_android_gms_internal_zzdt != null) {
                        iBinder = com_google_android_gms_internal_zzdt.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (com_google_android_gms_internal_zzba != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzba.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzax != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzax.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzdt != null) {
                        iBinder = com_google_android_gms_internal_zzdt.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (com_google_android_gms_internal_zzba != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzba.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzax != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzax.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (com_google_android_gms_internal_zzdt != null) {
                        iBinder = com_google_android_gms_internal_zzdt.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static zzds zzs(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzds)) ? new zza(iBinder) : (zzds) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzax com_google_android_gms_internal_zzax = null;
            zzd view;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzau(parcel.readStrongBinder()), parcel.readInt() != 0 ? zzba.CREATOR.zzc(parcel) : null, parcel.readInt() != 0 ? zzax.CREATOR.zzb(parcel) : null, parcel.readString(), com.google.android.gms.internal.zzdt.zza.zzt(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    IBinder asBinder;
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    parcel2.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = com.google.android.gms.dynamic.zzd.zza.zzau(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzax = zzax.CREATOR.zzb(parcel);
                    }
                    zza(view, com_google_android_gms_internal_zzax, parcel.readString(), com.google.android.gms.internal.zzdt.zza.zzt(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzau(parcel.readStrongBinder()), parcel.readInt() != 0 ? zzba.CREATOR.zzc(parcel) : null, parcel.readInt() != 0 ? zzax.CREATOR.zzb(parcel) : null, parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzdt.zza.zzt(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzau(parcel.readStrongBinder()), parcel.readInt() != 0 ? zzax.CREATOR.zzb(parcel) : null, parcel.readString(), parcel.readString(), com.google.android.gms.internal.zzdt.zza.zzt(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    resume();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void destroy();

    zzd getView();

    void pause();

    void resume();

    void showInterstitial();

    void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt);

    void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt);

    void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt);

    void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt);
}
