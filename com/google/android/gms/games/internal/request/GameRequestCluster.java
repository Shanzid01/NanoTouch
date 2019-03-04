package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int zzFG;
    private final ArrayList<GameRequestEntity> zzaiO;

    GameRequestCluster(int i, ArrayList<GameRequestEntity> arrayList) {
        this.zzFG = i;
        this.zzaiO = arrayList;
        zzoy();
    }

    private void zzoy() {
        zzb.zzN(!this.zzaiO.isEmpty());
        GameRequest gameRequest = (GameRequest) this.zzaiO.get(0);
        int size = this.zzaiO.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.zzaiO.get(i);
            zzb.zza(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            zzb.zza(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.zzaiO.size() != this.zzaiO.size()) {
            return false;
        }
        int size = this.zzaiO.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.zzaiO.get(i)).equals((GameRequest) gameRequestCluster.zzaiO.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public /* synthetic */ List getRecipients() {
        return zzoN();
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.zzaiO.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.zzaiO.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity) this.zzaiO.get(0)).getType();
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaiO.toArray());
    }

    public boolean isConsumed(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        GameRequestClusterCreator.zza(this, parcel, i);
    }

    public ArrayList<GameRequest> zzoM() {
        return new ArrayList(this.zzaiO);
    }

    public ArrayList<Player> zzoN() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
}
