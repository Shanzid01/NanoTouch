package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class InvitationRef extends zzd implements Invitation {
    private final Game zzaiU;
    private final ParticipantRef zzajC;
    private final ArrayList<Participant> zzajz;

    InvitationRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaiU = new GameRef(dataHolder, i);
        this.zzajz = new ArrayList(i2);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticipantRef participantRef = new ParticipantRef(this.zzMd, this.zzNQ + i3);
            if (participantRef.getParticipantId().equals(string)) {
                obj = participantRef;
            }
            this.zzajz.add(participantRef);
        }
        this.zzajC = (ParticipantRef) zzx.zzb(obj, (Object) "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.zza(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.zzaiU;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public int getInvitationType() {
        return getInteger("type");
    }

    public Participant getInviter() {
        return this.zzajC;
    }

    public ArrayList<Participant> getParticipants() {
        return this.zzajz;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.zza(this);
    }

    public String toString() {
        return InvitationEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) freeze()).writeToParcel(parcel, i);
    }
}
