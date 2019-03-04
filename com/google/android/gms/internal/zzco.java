package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public interface zzco extends IInterface {

    public abstract class zza extends Binder implements zzco {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            String zzcw;
            zzd zzcx;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzl(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    recordImpression();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcw = zzcw();
                    parcel2.writeNoException();
                    parcel2.writeString(zzcw);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcx = zzcx();
                    parcel2.writeNoException();
                    if (zzcx != null) {
                        iBinder = zzcx.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcw = getBody();
                    parcel2.writeNoException();
                    parcel2.writeString(zzcw);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcx = zzcy();
                    parcel2.writeNoException();
                    if (zzcx != null) {
                        iBinder = zzcx.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcw = zzcz();
                    parcel2.writeNoException();
                    parcel2.writeString(zzcw);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double zzcA = zzcA();
                    parcel2.writeNoException();
                    parcel2.writeDouble(zzcA);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcw = zzcB();
                    parcel2.writeNoException();
                    parcel2.writeString(zzcw);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzcw = zzcC();
                    parcel2.writeNoException();
                    parcel2.writeString(zzcw);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getBody();

    void recordImpression();

    double zzcA();

    String zzcB();

    String zzcC();

    String zzcw();

    zzd zzcx();

    zzd zzcy();

    String zzcz();

    void zzl(int i);
}
