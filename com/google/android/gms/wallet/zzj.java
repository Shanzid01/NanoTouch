package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<LineItem> {
    static void zza(LineItem lineItem, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, lineItem.getVersionCode());
        zzb.zza(parcel, 2, lineItem.description, false);
        zzb.zza(parcel, 3, lineItem.zzaDt, false);
        zzb.zza(parcel, 4, lineItem.zzaDu, false);
        zzb.zza(parcel, 5, lineItem.zzaCR, false);
        zzb.zzc(parcel, 6, lineItem.zzaDv);
        zzb.zza(parcel, 7, lineItem.zzaCS, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeW(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzht(i);
    }

    public LineItem zzeW(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzJ = zza.zzJ(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LineItem[] zzht(int i) {
        return new LineItem[i];
    }
}
