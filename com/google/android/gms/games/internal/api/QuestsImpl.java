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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzag(status);
        }

        public AcceptQuestResult zzag(final Status status) {
            return new AcceptQuestResult(this) {
                final /* synthetic */ AcceptImpl zzagS;

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzah(status);
        }

        public ClaimMilestoneResult zzah(final Status status) {
            return new ClaimMilestoneResult(this) {
                final /* synthetic */ ClaimImpl zzagT;

                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzai(status);
        }

        public LoadQuestsResult zzai(final Status status) {
            return new LoadQuestsResult(this) {
                final /* synthetic */ LoadsImpl zzagU;

                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzay(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C10875 extends LoadsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ boolean zzafy;
        final /* synthetic */ int[] zzagP;
        final /* synthetic */ String zzagR;
        final /* synthetic */ int zzagc;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzagP, this.zzagc, this.zzafy);
        }
    }

    class C10886 extends LoadsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ boolean zzafy;
        final /* synthetic */ String[] zzagQ;
        final /* synthetic */ String zzagR;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzafy, this.zzagQ);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new AcceptImpl(this, googleApiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzh((zzb) this, str);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new ClaimImpl(this, googleApiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zzb) this, str, str2);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.zzd(googleApiClient).zzbP(str);
    }

    public Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.zzd(googleApiClient).zzb(iArr);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        final int[] iArr2 = iArr;
        final int i2 = i;
        final boolean z2 = z;
        return googleApiClient.zza(new LoadsImpl(this, googleApiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, iArr2, i2, z2);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza(new LoadsImpl(this, googleApiClient) {
            final /* synthetic */ QuestsImpl zzagN;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zzb) this, z, strArr);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzc(googleApiClient.zzf(questUpdateListener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzbQ(str);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zznz();
        }
    }
}
