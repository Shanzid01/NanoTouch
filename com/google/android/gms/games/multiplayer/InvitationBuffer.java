package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class InvitationBuffer extends zzg<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_invitation_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzp(i, i2);
    }

    protected Invitation zzp(int i, int i2) {
        return new InvitationRef(this.zzMd, i, i2);
    }
}
