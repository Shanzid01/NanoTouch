package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

public class zzb implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, completionEvent.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, completionEvent.zzRX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, completionEvent.zzHg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, completionEvent.zzSP, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, completionEvent.zzSQ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, completionEvent.zzSR, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 7, completionEvent.zzSS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, completionEvent.zzrX);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, completionEvent.zzST, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzae(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbr(i);
    }

    public CompletionEvent zzae(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case 1:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzI);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    break;
                case 7:
                    list = zza.zzC(parcel, zzI);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzI);
                    break;
                case 9:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CompletionEvent[] zzbr(int i) {
        return new CompletionEvent[i];
    }
}
