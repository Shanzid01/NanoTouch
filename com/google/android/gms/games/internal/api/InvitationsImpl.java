package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzS(status);
        }

        public LoadInvitationsResult zzS(final Status status) {
            return new LoadInvitationsResult(this) {
                final /* synthetic */ LoadInvitationsImpl zzagf;

                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C10422 extends LoadInvitationsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ int zzagc;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zze(this, this.zzafB, this.zzagc);
        }
    }

    class C10433 extends LoadInvitationsImpl {
        final /* synthetic */ String zzage;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzn(this, this.zzage);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznw();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadInvitationsImpl(this, googleApiClient) {
            final /* synthetic */ InvitationsImpl zzagd;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzc((zzb) this, i);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zza(googleApiClient.zzf(onInvitationReceivedListener));
        }
    }

    public void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zznx();
        }
    }
}
