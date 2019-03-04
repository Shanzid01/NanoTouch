package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class QuestBuffer extends zzg<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_quest_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzs(i, i2);
    }

    protected Quest zzs(int i, int i2) {
        return new QuestRef(this.zzMd, i, i2);
    }
}
