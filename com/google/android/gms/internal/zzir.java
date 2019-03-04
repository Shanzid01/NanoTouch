package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zziz.zza;

public class zzir implements SafeParcelable {
    public static final zzis CREATOR = new zzis();
    public static final int zzFR = Integer.parseInt("-1");
    private static final zziz zzFS = new zza("SsbContext").zzI(true).zzaz("blob").zzgX();
    final int zzFG;
    public final String zzFT;
    final zziz zzFU;
    public final int zzFV;
    public final byte[] zzFW;

    zzir(int i, String str, zziz com_google_android_gms_internal_zziz, int i2, byte[] bArr) {
        boolean z = i2 == zzFR || zziy.zzV(i2) != null;
        zzx.zzb(z, "Invalid section type " + i2);
        this.zzFG = i;
        this.zzFT = str;
        this.zzFU = com_google_android_gms_internal_zziz;
        this.zzFV = i2;
        this.zzFW = bArr;
        String zzgV = zzgV();
        if (zzgV != null) {
            throw new IllegalArgumentException(zzgV);
        }
    }

    public zzir(String str, zziz com_google_android_gms_internal_zziz) {
        this(1, str, com_google_android_gms_internal_zziz, zzFR, null);
    }

    public zzir(String str, zziz com_google_android_gms_internal_zziz, String str2) {
        this(1, str, com_google_android_gms_internal_zziz, zziy.zzay(str2), null);
    }

    public zzir(byte[] bArr, zziz com_google_android_gms_internal_zziz) {
        this(1, null, com_google_android_gms_internal_zziz, zzFR, bArr);
    }

    public static zzir zzd(byte[] bArr) {
        return new zzir(bArr, zzFS);
    }

    public int describeContents() {
        zzis com_google_android_gms_internal_zzis = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzis com_google_android_gms_internal_zzis = CREATOR;
        zzis.zza(this, parcel, i);
    }

    public String zzgV() {
        return (this.zzFV == zzFR || zziy.zzV(this.zzFV) != null) ? (this.zzFT == null || this.zzFW == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzFV;
    }
}
