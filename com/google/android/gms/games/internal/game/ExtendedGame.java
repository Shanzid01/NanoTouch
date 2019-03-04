package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable<ExtendedGame> {
    Game getGame();

    ArrayList<GameBadge> zzoh();

    int zzoi();

    boolean zzoj();

    int zzok();

    long zzol();

    long zzom();

    String zzon();

    long zzoo();

    String zzop();

    SnapshotMetadata zzoq();
}
