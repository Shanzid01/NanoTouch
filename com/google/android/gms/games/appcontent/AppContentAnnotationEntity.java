package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final String zzFA;
    private final int zzFG;
    private final String zzSy;
    private final String zzZO;
    private final Uri zzado;
    private final String zzadp;
    private final String zzadq;
    private final int zzadr;
    private final int zzads;
    private final Bundle zzadt;

    AppContentAnnotationEntity(int i, String str, Uri uri, String str2, String str3, String str4, String str5, int i2, int i3, Bundle bundle) {
        this.zzFG = i;
        this.zzZO = str;
        this.zzFA = str3;
        this.zzadq = str5;
        this.zzadr = i2;
        this.zzado = uri;
        this.zzads = i3;
        this.zzadp = str4;
        this.zzadt = bundle;
        this.zzSy = str2;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appContentAnnotation) {
        this.zzFG = 4;
        this.zzZO = appContentAnnotation.getDescription();
        this.zzFA = appContentAnnotation.getId();
        this.zzadq = appContentAnnotation.zzmM();
        this.zzadr = appContentAnnotation.zzmN();
        this.zzado = appContentAnnotation.zzmO();
        this.zzads = appContentAnnotation.zzmQ();
        this.zzadp = appContentAnnotation.zzmR();
        this.zzadt = appContentAnnotation.zzmP();
        this.zzSy = appContentAnnotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzw.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzmM(), Integer.valueOf(appContentAnnotation.zzmN()), appContentAnnotation.zzmO(), Integer.valueOf(appContentAnnotation.zzmQ()), appContentAnnotation.zzmR(), appContentAnnotation.zzmP(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzw.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzw.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzw.equal(appContentAnnotation2.zzmM(), appContentAnnotation.zzmM()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzmN()), Integer.valueOf(appContentAnnotation.zzmN())) && zzw.equal(appContentAnnotation2.zzmO(), appContentAnnotation.zzmO()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzmQ()), Integer.valueOf(appContentAnnotation.zzmQ())) && zzw.equal(appContentAnnotation2.zzmR(), appContentAnnotation.zzmR()) && zzw.equal(appContentAnnotation2.zzmP(), appContentAnnotation.zzmP()) && zzw.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzw.zzk(appContentAnnotation).zza("Description", appContentAnnotation.getDescription()).zza("Id", appContentAnnotation.getId()).zza("ImageDefaultId", appContentAnnotation.zzmM()).zza("ImageHeight", Integer.valueOf(appContentAnnotation.zzmN())).zza("ImageUri", appContentAnnotation.zzmO()).zza("ImageWidth", Integer.valueOf(appContentAnnotation.zzmQ())).zza("LayoutSlot", appContentAnnotation.zzmR()).zza("Modifiers", appContentAnnotation.zzmP()).zza(LayoutTagTable.TITLE, appContentAnnotation.getTitle()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzmS();
    }

    public String getDescription() {
        return this.zzZO;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppContentAnnotationEntityCreator.zza(this, parcel, i);
    }

    public String zzmM() {
        return this.zzadq;
    }

    public int zzmN() {
        return this.zzadr;
    }

    public Uri zzmO() {
        return this.zzado;
    }

    public Bundle zzmP() {
        return this.zzadt;
    }

    public int zzmQ() {
        return this.zzads;
    }

    public String zzmR() {
        return this.zzadp;
    }

    public AppContentAnnotation zzmS() {
        return this;
    }
}
