package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new zza();
    String name;
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
    String zzaDy;
    String zzfl;

    public final class zza {
        final /* synthetic */ CommonWalletObject zzaFb;

        private zza(CommonWalletObject commonWalletObject) {
            this.zzaFb = commonWalletObject;
        }

        public zza zzdJ(String str) {
            this.zzaFb.zzfl = str;
            return this;
        }

        public CommonWalletObject zzuW() {
            return this.zzaFb;
        }
    }

    CommonWalletObject() {
        this.zzFG = 1;
        this.zzaDF = zzls.zzkb();
        this.zzaDH = zzls.zzkb();
        this.zzaDK = zzls.zzkb();
        this.zzaDM = zzls.zzkb();
        this.zzaDN = zzls.zzkb();
        this.zzaDO = zzls.zzkb();
    }

    CommonWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, ArrayList<zzp> arrayList, zzl com_google_android_gms_wallet_wobs_zzl, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<zzd> arrayList3, boolean z, ArrayList<zzn> arrayList4, ArrayList<zzj> arrayList5, ArrayList<zzn> arrayList6) {
        this.zzFG = i;
        this.zzfl = str;
        this.zzaDE = str2;
        this.name = str3;
        this.zzaDy = str4;
        this.zzaDA = str5;
        this.zzaDB = str6;
        this.zzaDC = str7;
        this.zzaDD = str8;
        this.state = i2;
        this.zzaDF = arrayList;
        this.zzaDG = com_google_android_gms_wallet_wobs_zzl;
        this.zzaDH = arrayList2;
        this.zzaDI = str9;
        this.zzaDJ = str10;
        this.zzaDK = arrayList3;
        this.zzaDL = z;
        this.zzaDM = arrayList4;
        this.zzaDN = arrayList5;
        this.zzaDO = arrayList6;
    }

    public static zza zzuV() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzfl;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
