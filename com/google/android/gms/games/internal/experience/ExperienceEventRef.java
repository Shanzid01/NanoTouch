package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends zzd implements ExperienceEvent {
    private final GameRef zzahU;

    public ExperienceEventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        if (zzbc("external_game_id")) {
            this.zzahU = null;
        } else {
            this.zzahU = new GameRef(this.zzMd, this.zzNQ);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
