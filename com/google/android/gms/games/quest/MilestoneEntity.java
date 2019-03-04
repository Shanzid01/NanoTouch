package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
    private final int mState;
    private final int zzFG;
    private final String zzadJ;
    private final String zzaeR;
    private final long zzakk;
    private final long zzakl;
    private final byte[] zzakm;

    MilestoneEntity(int i, String str, long j, long j2, byte[] bArr, int i2, String str2) {
        this.zzFG = i;
        this.zzaeR = str;
        this.zzakk = j;
        this.zzakl = j2;
        this.zzakm = bArr;
        this.mState = i2;
        this.zzadJ = str2;
    }

    public MilestoneEntity(Milestone milestone) {
        this.zzFG = 4;
        this.zzaeR = milestone.getMilestoneId();
        this.zzakk = milestone.getCurrentProgress();
        this.zzakl = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzadJ = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzakm = null;
            return;
        }
        this.zzakm = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.zzakm, 0, completionRewardData.length);
    }

    static int zza(Milestone milestone) {
        return zzw.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzw.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzw.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzw.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzw.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzw.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzw.zzk(milestone).zza("MilestoneId", milestone.getMilestoneId()).zza("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zza("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zza("State", Integer.valueOf(milestone.getState())).zza("CompletionRewardData", milestone.getCompletionRewardData()).zza("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.zzakm;
    }

    public long getCurrentProgress() {
        return this.zzakk;
    }

    public String getEventId() {
        return this.zzadJ;
    }

    public String getMilestoneId() {
        return this.zzaeR;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.zzakl;
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
        MilestoneEntityCreator.zza(this, parcel, i);
    }
}
