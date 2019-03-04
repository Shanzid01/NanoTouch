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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzH(status);
        }

        public LoadAchievementsResult zzH(final Status status) {
            return new LoadAchievementsResult(this) {
                final /* synthetic */ LoadImpl zzafE;

                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ String zzafA;
        final /* synthetic */ String zzafB;
        final /* synthetic */ boolean zzafy;

        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((zzb) this, this.zzafA, this.zzafB, this.zzafy);
        }
    }

    abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String zzFA;

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzFA = str;
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzI(status);
        }

        public UpdateAchievementResult zzI(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl zzafF;

                public String getAchievementId() {
                    return this.zzafF.zzFA;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznu();
    }

    public void increment(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(null, str2, i2);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        return googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, str2, i2);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzc((zzb) this, z);
            }
        });
    }

    public void reveal(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza(null, str);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, str);
            }
        });
    }

    public void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(null, str2, i2);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        return googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zzb) this, str2, i2);
            }
        });
    }

    public void unlock(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb(null, str);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            final /* synthetic */ AchievementsImpl zzafz;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zzb) this, str);
            }
        });
    }
}
