package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzu implements Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, 1000, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzlL());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzbY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzdw(i);
    }

    public Value zzbY(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzI);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzI);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new Value(i2, i, z, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public Value[] zzdw(int i) {
        return new Value[i];
    }
}
