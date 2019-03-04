package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;

public interface zzka extends IInterface {

    public abstract class zza extends Binder implements zzka {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            zzjw com_google_android_gms_internal_zzjw = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzai(parcel.readInt());
                    return true;
                case 2:
                    ApplicationMetadata applicationMetadata;
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(parcel);
                    }
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(applicationMetadata, readString, readString2, z);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzaj(parcel.readInt());
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = parcel.readString();
                    double readDouble = parcel.readDouble();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zza(readString3, readDouble, z);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzn(parcel.readString(), parcel.readString());
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzb(parcel.readString(), parcel.createByteArray());
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzal(parcel.readInt());
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zzak(parcel.readInt());
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zza(parcel.readString(), parcel.readLong(), parcel.readInt());
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    zza(parcel.readString(), parcel.readLong());
                    return true;
                case 12:
                    zzjp com_google_android_gms_internal_zzjp;
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzjp = (zzjp) zzjp.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_internal_zzjp);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzjw = (zzjw) zzjw.CREATOR.createFromParcel(parcel);
                    }
                    zzb(com_google_android_gms_internal_zzjw);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onApplicationDisconnected(int i);

    void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z);

    void zza(String str, double d, boolean z);

    void zza(String str, long j);

    void zza(String str, long j, int i);

    void zzai(int i);

    void zzaj(int i);

    void zzak(int i);

    void zzal(int i);

    void zzb(zzjp com_google_android_gms_internal_zzjp);

    void zzb(zzjw com_google_android_gms_internal_zzjw);

    void zzb(String str, byte[] bArr);

    void zzn(String str, String str2);
}
