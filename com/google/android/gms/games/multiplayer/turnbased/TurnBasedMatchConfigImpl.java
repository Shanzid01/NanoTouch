package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzajA;
    private final Bundle zzajQ;
    private final String[] zzajR;
    private final int zzajZ;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzajA = builder.zzajA;
        this.zzajZ = builder.zzajZ;
        this.zzajQ = builder.zzajQ;
        this.zzajR = (String[]) builder.zzajP.toArray(new String[builder.zzajP.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzajQ;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzajR;
    }

    public int getVariant() {
        return this.zzajA;
    }

    public int zzoX() {
        return this.zzajZ;
    }
}
