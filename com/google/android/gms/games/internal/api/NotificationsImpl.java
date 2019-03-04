package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    class C10591 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzagt;

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzX(status);
        }

        public GameMuteStatusChangeResult zzX(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C10591 zzagu;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd((zzb) this, this.zzagt, true);
        }
    }

    class C10612 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzagt;

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzX(status);
        }

        public GameMuteStatusChangeResult zzX(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C10612 zzagv;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzd((zzb) this, this.zzagt, false);
        }
    }

    class C10633 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String zzagt;

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzY(status);
        }

        public GameMuteStatusLoadResult zzY(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ C10633 zzagw;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzp((zzb) this, this.zzagt);
        }
    }

    abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzZ(status);
        }

        public ContactSettingLoadResult zzZ(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl zzagz;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class C10644 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzh((zzb) this, this.zzafy);
        }
    }

    abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    class C10655 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzagx;
        final /* synthetic */ Bundle zzagy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzagx, this.zzagy);
        }
    }

    abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzaa(status);
        }

        public InboxCountResult zzaa(final Status status) {
            return new InboxCountResult(this) {
                final /* synthetic */ InboxCountImpl zzagA;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class C10666 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzi(this);
        }
    }

    public void clear(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzeC(i);
        }
    }

    public void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, 31);
    }
}
