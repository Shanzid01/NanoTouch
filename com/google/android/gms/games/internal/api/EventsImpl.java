package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzN(status);
        }

        public LoadEventsResult zzN(final Status status) {
            return new LoadEventsResult(this) {
                final /* synthetic */ LoadImpl zzafP;

                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzay(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result createFailedResult(final Status status) {
            return new Result(this) {
                final /* synthetic */ UpdateImpl zzafQ;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient googleApiClient, final String str, final int i) {
        GamesClientImpl zzc = Games.zzc(googleApiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzp(str, i);
            } else {
                googleApiClient.zzb(new UpdateImpl(this, googleApiClient) {
                    final /* synthetic */ EventsImpl zzafM;

                    public void zza(GamesClientImpl gamesClientImpl) {
                        gamesClientImpl.zzp(str, i);
                    }
                });
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            final /* synthetic */ EventsImpl zzafM;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzd((zzb) this, z);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            final /* synthetic */ EventsImpl zzafM;

            public void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, z, strArr);
            }
        });
    }
}
