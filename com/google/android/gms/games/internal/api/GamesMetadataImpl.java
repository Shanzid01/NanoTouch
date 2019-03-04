package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzO(status);
        }

        public LoadExtendedGamesResult zzO(final Status status) {
            return new LoadExtendedGamesResult(this) {
                final /* synthetic */ LoadExtendedGamesImpl zzafY;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, false, true, false, this.zzafU);
        }
    }

    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc(this, this.zzafA, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzc(this, this.zzafA, this.zzafT, true, false);
        }
    }

    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzafA, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd(this, this.zzafA, this.zzafT, true, false);
        }
    }

    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, true, false, this.zzafy, this.zzafU);
        }
    }

    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, true, true, false, this.zzafU);
        }
    }

    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzafV;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zze(this, this.zzafV, this.zzafT, false, this.zzafy);
        }
    }

    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ String zzafV;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zze(this, this.zzafV, this.zzafT, true, false);
        }
    }

    abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzQ(status);
        }

        public LoadGameSearchSuggestionsResult zzQ(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl zzaga;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzafV;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzl(this, this.zzafV);
        }
    }

    abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzR(status);
        }

        public LoadGamesResult zzR(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl zzagb;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C10292 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafB;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzj(this, this.zzafB);
        }
    }

    abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzP(status);
        }

        public LoadGameInstancesResult zzP(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl zzafZ;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C10303 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzafB;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzk(this, this.zzafB);
        }
    }

    class C10314 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, null, this.zzafT, false, this.zzafy);
        }
    }

    class C10325 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, null, this.zzafT, true, false);
        }
    }

    class C10336 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, this.zzafA, this.zzafT, false, this.zzafy);
        }
    }

    class C10347 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ int zzafT;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb(this, this.zzafA, this.zzafT, true, false);
        }
    }

    class C10358 extends LoadExtendedGamesImpl {
        final /* synthetic */ int zzafT;
        final /* synthetic */ int zzafW;
        final /* synthetic */ boolean zzafX;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafT, this.zzafW, this.zzafX, this.zzafy);
        }
    }

    class C10369 extends LoadExtendedGamesImpl {
        final /* synthetic */ String zzafS;
        final /* synthetic */ int zzafT;
        final /* synthetic */ boolean zzafU;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafS, this.zzafT, false, false, this.zzafy, this.zzafU);
        }
    }

    public Game getCurrentGame(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zzns();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new LoadGamesImpl(this, googleApiClient) {
            final /* synthetic */ GamesMetadataImpl zzafR;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzf((zzb) this);
            }
        });
    }
}
