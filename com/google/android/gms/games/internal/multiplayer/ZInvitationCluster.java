package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    private final int zzFG;
    private final ArrayList<InvitationEntity> zzaih;

    ZInvitationCluster(int i, ArrayList<InvitationEntity> arrayList) {
        this.zzFG = i;
        this.zzaih = arrayList;
        zzoy();
    }

    private void zzoy() {
        zzb.zzN(!this.zzaih.isEmpty());
        Invitation invitation = (Invitation) this.zzaih.get(0);
        int size = this.zzaih.size();
        for (int i = 1; i < size; i++) {
            zzb.zza(invitation.getInviter().equals(((Invitation) this.zzaih.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.zzaih.size() != this.zzaih.size()) {
            return false;
        }
        int size = this.zzaih.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.zzaih.get(i)).equals((Invitation) zInvitationCluster.zzaih.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return ((InvitationEntity) this.zzaih.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity) this.zzaih.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaih.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        InvitationClusterCreator.zza(this, parcel, i);
    }

    public ArrayList<Invitation> zzoz() {
        return new ArrayList(this.zzaih);
    }
}
