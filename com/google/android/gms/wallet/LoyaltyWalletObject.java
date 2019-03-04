package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.zzd;
import com.google.android.gms.wallet.wobs.zzf;
import com.google.android.gms.wallet.wobs.zzj;
import com.google.android.gms.wallet.wobs.zzl;
import com.google.android.gms.wallet.wobs.zzn;
import com.google.android.gms.wallet.wobs.zzp;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new zzk();
    int state;
    private final int zzFG;
    String zzaDA;
    String zzaDB;
    String zzaDC;
    String zzaDD;
    String zzaDE;
    ArrayList<zzp> zzaDF;
    zzl zzaDG;
    ArrayList<LatLng> zzaDH;
    String zzaDI;
    String zzaDJ;
    ArrayList<zzd> zzaDK;
    boolean zzaDL;
    ArrayList<zzn> zzaDM;
    ArrayList<zzj> zzaDN;
    ArrayList<zzn> zzaDO;
    zzf zzaDP;
    String zzaDx;
    String zzaDy;
    String zzaDz;
    String zzapd;
    String zzfl;

    LoyaltyWalletObject() {
        this.zzFG = 4;
        this.zzaDF = zzls.zzkb();
        this.zzaDH = zzls.zzkb();
        this.zzaDK = zzls.zzkb();
        this.zzaDM = zzls.zzkb();
        this.zzaDN = zzls.zzkb();
        this.zzaDO = zzls.zzkb();
    }

    LoyaltyWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, ArrayList<zzp> arrayList, zzl com_google_android_gms_wallet_wobs_zzl, ArrayList<LatLng> arrayList2, String str11, String str12, ArrayList<zzd> arrayList3, boolean z, ArrayList<zzn> arrayList4, ArrayList<zzj> arrayList5, ArrayList<zzn> arrayList6, zzf com_google_android_gms_wallet_wobs_zzf) {
        this.zzFG = i;
        this.zzfl = str;
        this.zzaDx = str2;
        this.zzaDy = str3;
        this.zzaDz = str4;
        this.zzapd = str5;
        this.zzaDA = str6;
        this.zzaDB = str7;
        this.zzaDC = str8;
        this.zzaDD = str9;
        this.zzaDE = str10;
        this.state = i2;
        this.zzaDF = arrayList;
        this.zzaDG = com_google_android_gms_wallet_wobs_zzl;
        this.zzaDH = arrayList2;
        this.zzaDI = str11;
        this.zzaDJ = str12;
        this.zzaDK = arrayList3;
        this.zzaDL = z;
        this.zzaDM = arrayList4;
        this.zzaDN = arrayList5;
        this.zzaDO = arrayList6;
        this.zzaDP = com_google_android_gms_wallet_wobs_zzf;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.zzaDx;
    }

    public String getAccountName() {
        return this.zzapd;
    }

    public String getBarcodeAlternateText() {
        return this.zzaDA;
    }

    public String getBarcodeType() {
        return this.zzaDB;
    }

    public String getBarcodeValue() {
        return this.zzaDC;
    }

    public String getId() {
        return this.zzfl;
    }

    public String getIssuerName() {
        return this.zzaDy;
    }

    public String getProgramName() {
        return this.zzaDz;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
