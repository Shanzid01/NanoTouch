package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final String zzaek;
    private final int zzajA;
    private final RoomUpdateListener zzajL;
    private final RoomStatusUpdateListener zzajM;
    private final RealTimeMessageReceivedListener zzajN;
    private final Bundle zzajQ;
    private final String[] zzajR;

    RoomConfigImpl(Builder builder) {
        this.zzajL = builder.zzajL;
        this.zzajM = builder.zzajM;
        this.zzajN = builder.zzajN;
        this.zzaek = builder.zzajO;
        this.zzajA = builder.zzajA;
        this.zzajQ = builder.zzajQ;
        this.zzajR = (String[]) builder.zzajP.toArray(new String[builder.zzajP.size()]);
        zzx.zzb(this.zzajN, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzajQ;
    }

    public String getInvitationId() {
        return this.zzaek;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzajR;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzajN;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzajM;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzajL;
    }

    public int getVariant() {
        return this.zzajA;
    }
}
