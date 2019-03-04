package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final String zzFA;
    private final int zzFG;
    private final String zzSy;
    private final String zzZO;
    private final ArrayList<AppContentConditionEntity> zzadk;
    private final String zzadl;
    private final ArrayList<AppContentAnnotationEntity> zzadu;
    private final int zzadv;
    private final String zzadw;
    private final int zzadx;
    private final String zzxV;

    AppContentCardEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i2, String str2, Bundle bundle, String str3, String str4, int i3, String str5, String str6) {
        this.zzFG = i;
        this.mActions = arrayList;
        this.zzadu = arrayList2;
        this.zzadk = arrayList3;
        this.zzadl = str;
        this.zzadv = i2;
        this.zzZO = str2;
        this.mExtras = bundle;
        this.zzFA = str6;
        this.zzadw = str3;
        this.zzSy = str4;
        this.zzadx = i3;
        this.zzxV = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        int i;
        int i2 = 0;
        this.zzFG = 4;
        this.zzadl = appContentCard.zzmJ();
        this.zzadv = appContentCard.zzmU();
        this.zzZO = appContentCard.getDescription();
        this.mExtras = appContentCard.getExtras();
        this.zzFA = appContentCard.getId();
        this.zzSy = appContentCard.getTitle();
        this.zzadw = appContentCard.zzmV();
        this.zzadx = appContentCard.zzmW();
        this.zzxV = appContentCard.getType();
        List actions = appContentCard.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = appContentCard.zzmT();
        size = actions.size();
        this.zzadu = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzadu.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zzmI = appContentCard.zzmI();
        int size2 = zzmI.size();
        this.zzadk = new ArrayList(size2);
        while (i2 < size2) {
            this.zzadk.add((AppContentConditionEntity) ((AppContentCondition) zzmI.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzmT(), appContentCard.zzmI(), appContentCard.zzmJ(), Integer.valueOf(appContentCard.zzmU()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzmV(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzmW()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zzmT(), appContentCard.zzmT()) && zzw.equal(appContentCard2.zzmI(), appContentCard.zzmI()) && zzw.equal(appContentCard2.zzmJ(), appContentCard.zzmJ()) && zzw.equal(Integer.valueOf(appContentCard2.zzmU()), Integer.valueOf(appContentCard.zzmU())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zzmV(), appContentCard.zzmV()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzmW()), Integer.valueOf(appContentCard.zzmW())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzk(appContentCard).zza("Actions", appContentCard.getActions()).zza("Annotations", appContentCard.zzmT()).zza("Conditions", appContentCard.zzmI()).zza("ContentDescription", appContentCard.zzmJ()).zza("CurrentSteps", Integer.valueOf(appContentCard.zzmU())).zza("Description", appContentCard.getDescription()).zza("Extras", appContentCard.getExtras()).zza("Id", appContentCard.getId()).zza("Subtitle", appContentCard.zzmV()).zza(LayoutTagTable.TITLE, appContentCard.getTitle()).zza("TotalSteps", Integer.valueOf(appContentCard.zzmW())).zza("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzmX();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzZO;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public String getType() {
        return this.zzxV;
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    public List<AppContentCondition> zzmI() {
        return new ArrayList(this.zzadk);
    }

    public String zzmJ() {
        return this.zzadl;
    }

    public List<AppContentAnnotation> zzmT() {
        return new ArrayList(this.zzadu);
    }

    public int zzmU() {
        return this.zzadv;
    }

    public String zzmV() {
        return this.zzadw;
    }

    public int zzmW() {
        return this.zzadx;
    }

    public AppContentCard zzmX() {
        return this;
    }
}
