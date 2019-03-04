package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public interface zzoo extends IInterface {

    public abstract class zza extends Binder implements zzoo {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            zzom com_google_android_gms_internal_zzom = null;
            switch (i) {
                case 1:
                    zzok com_google_android_gms_internal_zzok;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzok = (zzok) zzok.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzok, com.google.android.gms.internal.zznh.zza.zzaE(parcel.readStrongBinder()));
                    return true;
                case 2:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(fitnessSensorServiceRequest, com.google.android.gms.internal.zznv.zza.zzaS(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_internal_zzom = (zzom) zzom.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_internal_zzom, com.google.android.gms.internal.zznv.zza.zzaS(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zznv com_google_android_gms_internal_zznv);

    void zza(zzok com_google_android_gms_internal_zzok, zznh com_google_android_gms_internal_zznh);

    void zza(zzom com_google_android_gms_internal_zzom, zznv com_google_android_gms_internal_zznv);
}
