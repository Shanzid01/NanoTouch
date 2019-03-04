package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzlw;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
    private final String mName;
    private final int mState;
    private final int zzFG;
    private final int zzJp;
    private final String zzZO;
    private final long zzadi;
    private final GameEntity zzahV;
    private final String zzakn;
    private final long zzako;
    private final Uri zzakp;
    private final String zzakq;
    private final long zzakr;
    private final Uri zzaks;
    private final String zzakt;
    private final long zzaku;
    private final long zzakv;
    private final ArrayList<MilestoneEntity> zzakw;

    QuestEntity(int i, GameEntity gameEntity, String str, long j, Uri uri, String str2, String str3, long j2, long j3, Uri uri2, String str4, String str5, long j4, long j5, int i2, int i3, ArrayList<MilestoneEntity> arrayList) {
        this.zzFG = i;
        this.zzahV = gameEntity;
        this.zzakn = str;
        this.zzako = j;
        this.zzakp = uri;
        this.zzakq = str2;
        this.zzZO = str3;
        this.zzakr = j2;
        this.zzadi = j3;
        this.zzaks = uri2;
        this.zzakt = str4;
        this.mName = str5;
        this.zzaku = j4;
        this.zzakv = j5;
        this.mState = i2;
        this.zzJp = i3;
        this.zzakw = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.zzFG = 2;
        this.zzahV = new GameEntity(quest.getGame());
        this.zzakn = quest.getQuestId();
        this.zzako = quest.getAcceptedTimestamp();
        this.zzZO = quest.getDescription();
        this.zzakp = quest.getBannerImageUri();
        this.zzakq = quest.getBannerImageUrl();
        this.zzakr = quest.getEndTimestamp();
        this.zzaks = quest.getIconImageUri();
        this.zzakt = quest.getIconImageUrl();
        this.zzadi = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzaku = quest.zzpa();
        this.zzakv = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzJp = quest.getType();
        List zzoZ = quest.zzoZ();
        int size = zzoZ.size();
        this.zzakw = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzakw.add((MilestoneEntity) ((Milestone) zzoZ.get(i)).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzw.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzoZ(), quest.getName(), Long.valueOf(quest.zzpa()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzw.equal(quest2.getGame(), quest.getGame()) && zzw.equal(quest2.getQuestId(), quest.getQuestId()) && zzw.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzw.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzw.equal(quest2.getDescription(), quest.getDescription()) && zzw.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzw.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzw.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzw.equal(quest2.zzoZ(), quest.zzoZ()) && zzw.equal(quest2.getName(), quest.getName()) && zzw.equal(Long.valueOf(quest2.zzpa()), Long.valueOf(quest.zzpa())) && zzw.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzw.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzw.zzk(quest).zza("Game", quest.getGame()).zza("QuestId", quest.getQuestId()).zza("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zza("BannerImageUri", quest.getBannerImageUri()).zza("BannerImageUrl", quest.getBannerImageUrl()).zza("Description", quest.getDescription()).zza("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zza("IconImageUri", quest.getIconImageUri()).zza("IconImageUrl", quest.getIconImageUrl()).zza("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zza("Milestones", quest.zzoZ()).zza("Name", quest.getName()).zza("NotifyTimestamp", Long.valueOf(quest.zzpa())).zza("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zza("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.zzako;
    }

    public Uri getBannerImageUri() {
        return this.zzakp;
    }

    public String getBannerImageUrl() {
        return this.zzakq;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzoZ().get(0);
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzZO, charArrayBuffer);
    }

    public long getEndTimestamp() {
        return this.zzakr;
    }

    public Game getGame() {
        return this.zzahV;
    }

    public Uri getIconImageUri() {
        return this.zzaks;
    }

    public String getIconImageUrl() {
        return this.zzakt;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzadi;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.mName, charArrayBuffer);
    }

    public String getQuestId() {
        return this.zzakn;
    }

    public long getStartTimestamp() {
        return this.zzakv;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.zzJp;
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

    public boolean isEndingSoon() {
        return this.zzaku <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        QuestEntityCreator.zza(this, parcel, i);
    }

    public List<Milestone> zzoZ() {
        return new ArrayList(this.zzakw);
    }

    public long zzpa() {
        return this.zzaku;
    }
}
