package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    private static <L> zze<L> zza(GoogleApiClient googleApiClient, L l) {
        return l == null ? null : googleApiClient.zzf(l);
    }

    public void create(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zza(googleApiClient.zzf(roomConfig.getRoomUpdateListener()), zza(googleApiClient, roomConfig.getRoomStatusUpdateListener()), zza(googleApiClient, roomConfig.getMessageReceivedListener()), roomConfig);
        }
    }

    public void declineInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzr(str, 0);
        }
    }

    public void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzq(str, 0);
        }
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zzd(googleApiClient).zzb(i, i2, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zzd(googleApiClient).zzb(i, i2, z);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient googleApiClient, Room room, int i) {
        return Games.zzd(googleApiClient).zza(room, i);
    }

    public void join(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzb(googleApiClient.zzf(roomConfig.getRoomUpdateListener()), zza(googleApiClient, roomConfig.getRoomStatusUpdateListener()), zza(googleApiClient, roomConfig.getMessageReceivedListener()), roomConfig);
        }
    }

    public void leave(GoogleApiClient googleApiClient, RoomUpdateListener roomUpdateListener, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zza(googleApiClient.zzf(roomUpdateListener), str);
        }
    }

    public int sendReliableMessage(GoogleApiClient googleApiClient, ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        return Games.zzd(googleApiClient).zza(zza(googleApiClient, reliableMessageSentCallback), bArr, str, str2);
    }

    public int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, String str2) {
        return Games.zzd(googleApiClient).zza(bArr, str, new String[]{str2});
    }

    public int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, List<String> list) {
        return Games.zzd(googleApiClient).zza(bArr, str, (String[]) list.toArray(new String[list.size()]));
    }

    public int sendUnreliableMessageToOthers(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return Games.zzd(googleApiClient).zzd(bArr, str);
    }
}
