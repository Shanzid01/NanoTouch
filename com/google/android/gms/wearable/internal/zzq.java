package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<zzp> {
    static void zza(zzp com_google_android_gms_wearable_internal_zzp, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wearable_internal_zzp.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_wearable_internal_zzp.getUri(), i, false);
        zzb.zza(parcel, 4, com_google_android_gms_wearable_internal_zzp.zzuY(), false);
        zzb.zza(parcel, 5, com_google_android_gms_wearable_internal_zzp.getData(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhX(i);
    }

    public zzp zzfx(Parcel parcel) {
        byte[] bArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzJ) {
            Bundle bundle2;
            Uri uri2;
            int zzg;
            byte[] bArr2;
            int zzI = zza.zzI(parcel);
            byte[] bArr3;
            switch (zza.zzaP(zzI)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = zza.zzg(parcel, zzI);
                    bArr2 = bArr3;
                    break;
                case 2:
                    zzg = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    zzg = i;
                    bArr3 = bArr;
                    bundle2 = zza.zzq(parcel, zzI);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = zza.zzr(parcel, zzI);
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzp(i, uri, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzp[] zzhX(int i) {
        return new zzp[i];
    }
}
