package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzgi
public final class zzba implements SafeParcelable {
    public static final zzbb CREATOR = new zzbb();
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;
    public final String zzpa;
    public final boolean zzpb;
    public final zzba[] zzpc;

    public zzba() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    zzba(int i, String str, int i2, int i3, boolean z, int i4, int i5, zzba[] com_google_android_gms_internal_zzbaArr) {
        this.versionCode = i;
        this.zzpa = str;
        this.height = i2;
        this.heightPixels = i3;
        this.zzpb = z;
        this.width = i4;
        this.widthPixels = i5;
        this.zzpc = com_google_android_gms_internal_zzbaArr;
    }

    public zzba(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public zzba(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        int i3 = 0;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 2;
        this.zzpb = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        int i4 = this.width == -1 ? 1 : 0;
        int i5 = this.height == -2 ? 1 : 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i4 != 0) {
            this.widthPixels = zza(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            i2 = this.width;
            this.widthPixels = zzbe.zzbD().zza(displayMetrics, this.width);
            i = i2;
        }
        i2 = i5 != 0 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzbe.zzbD().zza(displayMetrics, i2);
        if (i4 == 0 && i5 == 0) {
            this.zzpa = adSize.toString();
        } else {
            this.zzpa = i + "x" + i2 + "_as";
        }
        if (adSizeArr.length > 1) {
            this.zzpc = new zzba[adSizeArr.length];
            while (i3 < adSizeArr.length) {
                this.zzpc[i3] = new zzba(context, adSizeArr[i3]);
                i3++;
            }
            return;
        }
        this.zzpc = null;
    }

    public zzba(zzba com_google_android_gms_internal_zzba, zzba[] com_google_android_gms_internal_zzbaArr) {
        this(2, com_google_android_gms_internal_zzba.zzpa, com_google_android_gms_internal_zzba.height, com_google_android_gms_internal_zzba.heightPixels, com_google_android_gms_internal_zzba.zzpb, com_google_android_gms_internal_zzba.width, com_google_android_gms_internal_zzba.widthPixels, com_google_android_gms_internal_zzbaArr);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return (int) (((float) zzc(displayMetrics)) * displayMetrics.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbb.zza(this, parcel, i);
    }

    public AdSize zzbB() {
        return zza.zza(this.width, this.height, this.zzpa);
    }
}
