package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zziv.zzb;
import java.util.List;

public class zzix implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_internal_zziv_zzb, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, com_google_android_gms_internal_zziv_zzb.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, com_google_android_gms_internal_zziv_zzb.zzGc, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, com_google_android_gms_internal_zziv_zzb.zzGd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, com_google_android_gms_internal_zziv_zzb.zzGe, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzU(i);
    }

    public zzb[] zzU(int i) {
        return new zzb[i];
    }

    public zzb zzq(Parcel parcel) {
        String[] strArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzI = zza.zzI(parcel);
            String[] strArr3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) zza.zza(parcel, zzI, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case 2:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = zza.zzc(parcel, zzI, zzjb.CREATOR);
                    strArr2 = strArr3;
                    break;
                case 3:
                    strArr2 = zza.zzA(parcel, zzI);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzI);
                    strArr2 = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzb(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
