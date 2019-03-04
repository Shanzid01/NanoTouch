package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzajV;
    private final TurnBasedMatchBuffer zzajW;
    private final TurnBasedMatchBuffer zzajX;
    private final TurnBasedMatchBuffer zzajY;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder zza = zza(bundle, 0);
        if (zza != null) {
            this.zzajV = new InvitationBuffer(zza);
        } else {
            this.zzajV = null;
        }
        zza = zza(bundle, 1);
        if (zza != null) {
            this.zzajW = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzajW = null;
        }
        zza = zza(bundle, 2);
        if (zza != null) {
            this.zzajX = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzajX = null;
        }
        zza = zza(bundle, 3);
        if (zza != null) {
            this.zzajY = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzajY = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzeJ = TurnBasedMatchTurnStatus.zzeJ(i);
        return !bundle.containsKey(zzeJ) ? null : (DataHolder) bundle.getParcelable(zzeJ);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzajY;
    }

    public InvitationBuffer getInvitations() {
        return this.zzajV;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzajW;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzajX;
    }

    public boolean hasData() {
        return (this.zzajV == null || this.zzajV.getCount() <= 0) ? (this.zzajW == null || this.zzajW.getCount() <= 0) ? (this.zzajX == null || this.zzajX.getCount() <= 0) ? this.zzajY != null && this.zzajY.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzajV != null) {
            this.zzajV.release();
        }
        if (this.zzajW != null) {
            this.zzajW.release();
        }
        if (this.zzajX != null) {
            this.zzajX.release();
        }
        if (this.zzajY != null) {
            this.zzajY.release();
        }
    }
}
