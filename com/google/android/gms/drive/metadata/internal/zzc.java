package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, customProperty.zzFG);
        zzb.zza(parcel, 2, customProperty.zzVo, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcw(i);
    }

    public CustomProperty zzbd(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < zzJ) {
            CustomPropertyKey customPropertyKey2;
            int zzg;
            String str2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = zza.zzg(parcel, zzI);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzI, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzI);
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
            }
            i = zzg;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CustomProperty[] zzcw(int i) {
        return new CustomProperty[i];
    }
}
