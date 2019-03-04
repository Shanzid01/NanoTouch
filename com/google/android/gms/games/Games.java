package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import java.util.ArrayList;

public final class Games {
    public static final Api<GamesOptions> API = new Api(zzGS, zzGR, SCOPE_GAMES);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final zzc<GamesClientImpl> zzGR = new zzc();
    private static final zzb<GamesClientImpl, GamesOptions> zzGS = new C09991();
    public static final Scope zzacv = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzacw = new Api(zzGS, zzGR, zzacv);
    public static final AppContents zzacx = new AppContentsImpl();
    public static final Multiplayer zzacy = new MultiplayerImpl();
    public static final Acls zzacz = new AclsImpl();

    final class C09991 implements zzb<GamesClientImpl, GamesOptions> {
        C09991() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public abstract class BaseGamesApiMethodImpl<R extends Result> extends zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzGR, googleApiClient);
        }
    }

    abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    final class C10002 extends SignOutImpl {
        C10002(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzb((com.google.android.gms.common.api.zza.zzb) this);
        }
    }

    public final class GamesOptions implements Optional {
        public final boolean zzacA;
        public final boolean zzacB;
        public final int zzacC;
        public final boolean zzacD;
        public final int zzacE;
        public final String zzacF;
        public final ArrayList<String> zzacG;

        public final class Builder {
            boolean zzacA;
            boolean zzacB;
            int zzacC;
            boolean zzacD;
            int zzacE;
            String zzacF;
            ArrayList<String> zzacG;

            private Builder() {
                this.zzacA = false;
                this.zzacB = true;
                this.zzacC = 17;
                this.zzacD = false;
                this.zzacE = 4368;
                this.zzacF = null;
                this.zzacG = new ArrayList();
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int i) {
                this.zzacE = i;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z) {
                this.zzacB = z;
                this.zzacC = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z, int i) {
                this.zzacB = z;
                this.zzacC = i;
                return this;
            }
        }

        private GamesOptions() {
            this.zzacA = false;
            this.zzacB = true;
            this.zzacC = 17;
            this.zzacD = false;
            this.zzacE = 4368;
            this.zzacF = null;
            this.zzacG = new ArrayList();
        }

        private GamesOptions(Builder builder) {
            this.zzacA = builder.zzacA;
            this.zzacB = builder.zzacB;
            this.zzacC = builder.zzacC;
            this.zzacD = builder.zzacD;
            this.zzacE = builder.zzacE;
            this.zzacF = builder.zzacF;
            this.zzacG = builder.zzacG;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient).zznE();
    }

    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient).zznp();
    }

    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient).zznD();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient).zznC();
    }

    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzeB(i);
        }
    }

    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        zzx.zzl(view);
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzl(view);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C10002(googleApiClient));
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zzb = googleApiClient.zzb(API);
        if (!z || zzb) {
            return zzb ? (GamesClientImpl) googleApiClient.zza(zzGR) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }

    public static GamesClientImpl zzd(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
