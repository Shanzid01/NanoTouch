package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends zzd implements ExtendedGame {
    private final int zzadF;
    private final GameRef zzahU;
    private final SnapshotMetadataRef zzaig;

    ExtendedGameRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzahU = new GameRef(dataHolder, i);
        this.zzadF = i2;
        if (!zzba("external_snapshot_id") || zzbc("external_snapshot_id")) {
            this.zzaig = null;
        } else {
            this.zzaig = new SnapshotMetadataRef(dataHolder, i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ExtendedGameEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzos();
    }

    public Game getGame() {
        return this.zzahU;
    }

    public int hashCode() {
        return ExtendedGameEntity.zza(this);
    }

    public String toString() {
        return ExtendedGameEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((ExtendedGameEntity) zzos()).writeToParcel(parcel, i);
    }

    public ArrayList<GameBadge> zzoh() {
        int i = 0;
        if (this.zzMd.zzc("badge_title", this.zzNQ, this.zzMd.zzax(this.zzNQ)) == null) {
            return new ArrayList(0);
        }
        ArrayList<GameBadge> arrayList = new ArrayList(this.zzadF);
        while (i < this.zzadF) {
            arrayList.add(new GameBadgeRef(this.zzMd, this.zzNQ + i));
            i++;
        }
        return arrayList;
    }

    public int zzoi() {
        return getInteger("availability");
    }

    public boolean zzoj() {
        return getBoolean("owned");
    }

    public int zzok() {
        return getInteger("achievement_unlocked_count");
    }

    public long zzol() {
        return getLong("last_played_server_time");
    }

    public long zzom() {
        return getLong("price_micros");
    }

    public String zzon() {
        return getString("formatted_price");
    }

    public long zzoo() {
        return getLong("full_price_micros");
    }

    public String zzop() {
        return getString("formatted_full_price");
    }

    public SnapshotMetadata zzoq() {
        return this.zzaig;
    }

    public ExtendedGame zzos() {
        return new ExtendedGameEntity(this);
    }
}
