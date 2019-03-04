package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzgi
public final class zzbs implements SafeParcelable {
    public static final zzbt CREATOR = new zzbt();
    public final int backgroundColor;
    public final int versionCode;
    public final int zzpN;
    public final int zzpO;
    public final int zzpP;
    public final int zzpQ;
    public final int zzpR;
    public final int zzpS;
    public final int zzpT;
    public final String zzpU;
    public final int zzpV;
    public final String zzpW;
    public final int zzpX;
    public final int zzpY;
    public final String zzpZ;

    zzbs(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.zzpN = i2;
        this.backgroundColor = i3;
        this.zzpO = i4;
        this.zzpP = i5;
        this.zzpQ = i6;
        this.zzpR = i7;
        this.zzpS = i8;
        this.zzpT = i9;
        this.zzpU = str;
        this.zzpV = i10;
        this.zzpW = str2;
        this.zzpX = i11;
        this.zzpY = i12;
        this.zzpZ = str3;
    }

    public zzbs(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.zzpN = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zzpO = searchAdRequest.getBackgroundGradientBottom();
        this.zzpP = searchAdRequest.getBackgroundGradientTop();
        this.zzpQ = searchAdRequest.getBorderColor();
        this.zzpR = searchAdRequest.getBorderThickness();
        this.zzpS = searchAdRequest.getBorderType();
        this.zzpT = searchAdRequest.getCallButtonColor();
        this.zzpU = searchAdRequest.getCustomChannels();
        this.zzpV = searchAdRequest.getDescriptionTextColor();
        this.zzpW = searchAdRequest.getFontFace();
        this.zzpX = searchAdRequest.getHeaderTextColor();
        this.zzpY = searchAdRequest.getHeaderTextSize();
        this.zzpZ = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbt.zza(this, parcel, i);
    }
}
