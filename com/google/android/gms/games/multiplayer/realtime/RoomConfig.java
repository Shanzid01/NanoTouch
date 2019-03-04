package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {

    public final class Builder {
        int zzajA;
        final RoomUpdateListener zzajL;
        RoomStatusUpdateListener zzajM;
        RealTimeMessageReceivedListener zzajN;
        String zzajO;
        ArrayList<String> zzajP;
        Bundle zzajQ;

        private Builder(RoomUpdateListener roomUpdateListener) {
            this.zzajO = null;
            this.zzajA = -1;
            this.zzajP = new ArrayList();
            this.zzajL = (RoomUpdateListener) zzx.zzb((Object) roomUpdateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> arrayList) {
            zzx.zzl(arrayList);
            this.zzajP.addAll(arrayList);
            return this;
        }

        public Builder addPlayersToInvite(String... strArr) {
            zzx.zzl(strArr);
            this.zzajP.addAll(Arrays.asList(strArr));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzajQ = bundle;
            return this;
        }

        public Builder setInvitationIdToAccept(String str) {
            zzx.zzl(str);
            this.zzajO = str;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.zzajN = realTimeMessageReceivedListener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.zzajM = roomStatusUpdateListener;
            return this;
        }

        public Builder setVariant(int i) {
            boolean z = i == -1 || i > 0;
            zzx.zzb(z, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzajA = i;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(roomUpdateListener);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();
}
