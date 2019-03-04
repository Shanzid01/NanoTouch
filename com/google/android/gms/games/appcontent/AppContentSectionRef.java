package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzadF;

    AppContentSectionRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList, 0, i);
        this.zzadF = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zznf();
    }

    public /* synthetic */ List getActions() {
        return zzng();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzMd, this.zzadC, "section_data", this.zzNQ);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentSectionEntity) zznf()).writeToParcel(parcel, i);
    }

    public String zzmJ() {
        return getString("section_content_description");
    }

    public /* synthetic */ List zzmT() {
        return zznh();
    }

    public String zzmV() {
        return getString("section_subtitle");
    }

    public /* synthetic */ List zznd() {
        return zzni();
    }

    public String zzne() {
        return getString("section_card_type");
    }

    public AppContentSection zznf() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzng() {
        return AppContentUtils.zza(this.zzMd, this.zzadC, "section_actions", this.zzNQ);
    }

    public ArrayList<AppContentAnnotation> zznh() {
        return AppContentUtils.zzb(this.zzMd, this.zzadC, "section_annotations", this.zzNQ);
    }

    public ArrayList<AppContentCard> zzni() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzadF);
        for (int i = 0; i < this.zzadF; i++) {
            arrayList.add(new AppContentCardRef(this.zzadC, this.zzNQ + i));
        }
        return arrayList;
    }
}
