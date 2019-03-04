package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
    private final int zzFG;
    private final int zzJp;
    private final GameEntity zzahV;
    private final long zzajw;
    private final Bundle zzakA;
    private final byte[] zzakd;
    private final PlayerEntity zzakx;
    private final ArrayList<PlayerEntity> zzaky;
    private final long zzakz;
    private final int zzrX;
    private final String zzxv;

    GameRequestEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, byte[] bArr, String str, ArrayList<PlayerEntity> arrayList, int i2, long j, long j2, Bundle bundle, int i3) {
        this.zzFG = i;
        this.zzahV = gameEntity;
        this.zzakx = playerEntity;
        this.zzakd = bArr;
        this.zzxv = str;
        this.zzaky = arrayList;
        this.zzJp = i2;
        this.zzajw = j;
        this.zzakz = j2;
        this.zzakA = bundle;
        this.zzrX = i3;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.zzFG = 2;
        this.zzahV = new GameEntity(gameRequest.getGame());
        this.zzakx = new PlayerEntity(gameRequest.getSender());
        this.zzxv = gameRequest.getRequestId();
        this.zzJp = gameRequest.getType();
        this.zzajw = gameRequest.getCreationTimestamp();
        this.zzakz = gameRequest.getExpirationTimestamp();
        this.zzrX = gameRequest.getStatus();
        Object data = gameRequest.getData();
        if (data == null) {
            this.zzakd = null;
        } else {
            this.zzakd = new byte[data.length];
            System.arraycopy(data, 0, this.zzakd, 0, data.length);
        }
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.zzaky = new ArrayList(size);
        this.zzakA = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzaky.add((PlayerEntity) player);
            this.zzakA.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzk(gameRequest).zza("Game", gameRequest.getGame()).zza("Sender", gameRequest.getSender()).zza("Recipients", gameRequest.getRecipients()).zza("Data", gameRequest.getData()).zza("RequestId", gameRequest.getRequestId()).zza("Type", Integer.valueOf(gameRequest.getType())).zza("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zza("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzajw;
    }

    public byte[] getData() {
        return this.zzakd;
    }

    public long getExpirationTimestamp() {
        return this.zzakz;
    }

    public Game getGame() {
        return this.zzahV;
    }

    public int getRecipientStatus(String str) {
        return this.zzakA.getInt(str, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzaky);
    }

    public String getRequestId() {
        return this.zzxv;
    }

    public Player getSender() {
        return this.zzakx;
    }

    public int getStatus() {
        return this.zzrX;
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

    public boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        GameRequestEntityCreator.zza(this, parcel, i);
    }

    public Bundle zzpb() {
        return this.zzakA;
    }
}
