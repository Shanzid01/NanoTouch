package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 0, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzmX();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzMd, this.zzadC, "card_actions", this.zzNQ);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzMd, this.zzadC, "card_data", this.zzNQ);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentCardEntity) zzmX()).writeToParcel(parcel, i);
    }

    public List<AppContentCondition> zzmI() {
        return AppContentUtils.zzc(this.zzMd, this.zzadC, "card_conditions", this.zzNQ);
    }

    public String zzmJ() {
        return getString("card_content_description");
    }

    public List<AppContentAnnotation> zzmT() {
        return AppContentUtils.zzb(this.zzMd, this.zzadC, "card_annotations", this.zzNQ);
    }

    public int zzmU() {
        return getInteger("card_current_steps");
    }

    public String zzmV() {
        return getString("card_subtitle");
    }

    public int zzmW() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zzmX() {
        return new AppContentCardEntity(this);
    }
}
