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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzac(status);
        }

        public LoadPlayersResult zzac(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl zzagI;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzafB, this.zzafT, true, false);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzafB, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzafB, this.zzafT, true, false);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zzb) this, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zzb) this, this.zzafT, true, false);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc((zzb) this, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc((zzb) this, this.zzafT, true, false);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzafT, true, false);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzafV;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzf(this, this.zzafV, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzafV;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzf(this, this.zzafV, this.zzafT, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;
        final /* synthetic */ String zzagC;
        final /* synthetic */ String zzagt;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zzb) this, this.zzagC, this.zzagt, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzagC;
        final /* synthetic */ String zzagt;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zzb) this, this.zzagC, this.zzagt, this.zzafT, true, false);
        }
    }

    abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzab(status);
        }

        public LoadOwnerCoverPhotoUrisResult zzab(final Status status) {
            return new LoadOwnerCoverPhotoUrisResult(this) {
                final /* synthetic */ LoadOwnerCoverPhotoUrisImpl zzagH;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzg(this);
        }
    }

    abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzae(status);
        }

        public LoadXpForGameCategoriesResult zzae(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl zzagK;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzagD;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzm(this, this.zzagD);
        }
    }

    abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzaf(status);
        }

        public LoadXpStreamResult zzaf(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl zzagL;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzagD;
        final /* synthetic */ int zzagE;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc((zzb) this, this.zzagD, this.zzagE);
        }
    }

    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzagD;
        final /* synthetic */ int zzagE;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd((zzb) this, this.zzagD, this.zzagE);
        }
    }

    abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzad(status);
        }

        protected LoadProfileSettingsResult zzad(final Status status) {
            return new LoadProfileSettingsResult(this) {
                final /* synthetic */ LoadProfileSettingsResultImpl zzagJ;

                public Status getStatus() {
                    return status;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }
    }

    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzf((zzb) this, this.zzafy);
        }
    }

    abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzagF;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzg((zzb) this, this.zzagF);
        }
    }

    class C10713 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzagG;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzagG);
        }
    }

    class C10779 extends LoadPlayersImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzafB, this.zzafT, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zzd(googleApiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznr();
    }

    public String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznq();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznB();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, z);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, final int i, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, i, false, z);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, i, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, "played_with", i, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, str, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, final String str, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, str, z);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, final int i, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            final /* synthetic */ PlayersImpl zzagB;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, "played_with", i, false, z);
            }
        });
    }
}
