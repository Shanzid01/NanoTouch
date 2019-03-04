package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.zzvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl extends zzk<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    EventIncrementManager zzadP = new C10051(this);
    private final String zzadQ;
    private PlayerEntity zzadR;
    private GameEntity zzadS;
    private final PopupManager zzadT;
    private boolean zzadU = false;
    private final Binder zzadV;
    private final long zzadW;
    private final GamesOptions zzadX;

    class C10051 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzadY;

        C10051(GamesClientImpl gamesClientImpl) {
            this.zzadY = gamesClientImpl;
        }

        public EventIncrementCache zznM() {
            return new GameClientEventIncrementCache(this.zzadY);
        }
    }

    abstract class AbstractRoomStatusNotifier extends zzb<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzR(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzadZ = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder);
            for (Object add : strArr) {
                this.zzadZ.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzadZ);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    abstract class AbstractRoomNotifier extends zzb<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzR(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    abstract class GamesDataHolderResult extends zzc {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzep(dataHolder.getStatusCode()));
        }
    }

    final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzaea;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaea = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaea = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzaea;
        }
    }

    final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateAchievementResult> zzHa;

        AchievementUpdatedBinderCallback(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, (Object) "Holder must not be null");
        }

        public void zzf(int i, String str) {
            this.zzHa.zzd(new UpdateAchievementResultImpl(i, str));
        }
    }

    final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAchievementsResult> zzHa;

        AchievementsLoadedBinderCallback(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, (Object) "Holder must not be null");
        }

        public void zzc(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAppContentResult> zzaeb;

        public AppContentLoadedBinderCallbacks(zza.zzb<LoadAppContentResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult) {
            this.zzaeb = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzaeb.zzd(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzHb;
        private final String zzaec;

        CancelMatchResultImpl(Status status, String str) {
            this.zzHb = status;
            this.zzaec = str;
        }

        public String getMatchId() {
            return this.zzaec;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzaea;
        private final Milestone zzaed;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaea = new QuestEntity((Quest) questBuffer.get(0));
                    List zzoZ = this.zzaea.zzoZ();
                    int size = zzoZ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzoZ.get(i)).getMilestoneId().equals(str)) {
                            this.zzaed = (Milestone) zzoZ.get(i);
                            return;
                        }
                    }
                    this.zzaed = null;
                } else {
                    this.zzaed = null;
                    this.zzaea = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzaed;
        }

        public Quest getQuest() {
            return this.zzaea;
        }
    }

    final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzaee;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaee = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaee = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaee;
        }
    }

    final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<ContactSettingLoadResult> zzHa;

        ContactSettingsLoadedBinderCallback(zza.zzb<ContactSettingLoadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, (Object) "Holder must not be null");
        }

        public void zzD(DataHolder dataHolder) {
            this.zzHa.zzd(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzey(int i) {
            this.zzHa.zzd(GamesStatusCodes.zzep(i));
        }
    }

    final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzHb;
        private final String zzaef;

        DeleteSnapshotResultImpl(int i, String str) {
            this.zzHb = GamesStatusCodes.zzep(i);
            this.zzaef = str;
        }

        public String getSnapshotId() {
            return this.zzaef;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadEventsResult> zzHa;

        EventsLoadedBinderCallback(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, (Object) "Holder must not be null");
        }

        public void zzd(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadEventResultImpl(dataHolder));
        }
    }

    final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadExtendedGamesResult> zzHa;

        ExtendedGamesLoadedBinderCallback(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzadY;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzadY = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void zzs(String str, int i) {
            try {
                if (this.zzadY.isConnected()) {
                    ((IGamesService) this.zzadY.zzjb()).zzp(str, i);
                } else {
                    GamesLog.zzs("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "service died");
            }
        }
    }

    final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameInstancesResult> zzHa;

        GameInstancesLoadedBinderCallback(zza.zzb<LoadGameInstancesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzHb;
        private final String zzaeg;
        private final boolean zzaeh;

        public GameMuteStatusChangeResultImpl(int i, String str, boolean z) {
            this.zzHb = GamesStatusCodes.zzep(i);
            this.zzaeg = str;
            this.zzaeh = z;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusChangeResult> zzHa;

        GameMuteStatusChangedBinderCallback(zza.zzb<GameMuteStatusChangeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzHa.zzd(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzHb;
        private final String zzaeg;
        private final boolean zzaeh;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzHb = GamesStatusCodes.zzep(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaeg = dataHolder.zzc("external_game_id", 0, 0);
                    this.zzaeh = dataHolder.zzd("muted", 0, 0);
                } else {
                    this.zzaeg = null;
                    this.zzaeh = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusLoadResult> zzHa;

        GameMuteStatusLoadedBinderCallback(zza.zzb<GameMuteStatusLoadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, (Object) "Holder must not be null");
        }

        public void zzB(DataHolder dataHolder) {
            this.zzHa.zzd(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameSearchSuggestionsResult> zzHa;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGamesResult> zzHa;

        GamesLoadedBinderCallback(zza.zzb<LoadGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadGamesResultImpl(dataHolder));
        }
    }

    final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzHb;
        private final Bundle zzaei;

        InboxCountResultImpl(Status status, Bundle bundle) {
            this.zzHb = status;
            this.zzaei = bundle;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<InboxCountResult> zzHa;

        InboxCountsLoadedBinderCallback(zza.zzb<InboxCountResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult, (Object) "Holder must not be null");
        }

        public void zzh(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzHa.zzd(new InboxCountResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaeG;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaeG = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaeG = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaeG;
        }
    }

    final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zze<OnInvitationReceivedListener> zzTW;

        InvitationReceivedBinderCallback(zze<OnInvitationReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
            this.zzTW = com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener;
        }

        public void onInvitationRemoved(String str) {
            this.zzTW.zza(new InvitationRemovedNotifier(str));
        }

        public void zzn(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzTW.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    final class InvitationReceivedNotifier implements zze.zzb<OnInvitationReceivedListener> {
        private final Invitation zzaej;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaej = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaej);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class InvitationRemovedNotifier implements zze.zzb<OnInvitationReceivedListener> {
        private final String zzaek;

        InvitationRemovedNotifier(String str) {
            this.zzaek = str;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzaek);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadInvitationsResult> zzHa;

        InvitationsLoadedBinderCallback(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, (Object) "Holder must not be null");
        }

        public void zzm(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzael;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzael = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzael;
        }
    }

    final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadScoresResult> zzHa;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzHa.zzd(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LeaderboardMetadataResult> zzHa;

        LeaderboardsLoadedBinderCallback(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, (Object) "Holder must not be null");
        }

        public void zze(DataHolder dataHolder) {
            this.zzHa.zzd(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LeftRoomNotifier implements zze.zzb<RoomUpdateListener> {
        private final int zzLs;
        private final String zzaem;

        LeftRoomNotifier(int i, String str) {
            this.zzLs = i;
            this.zzaem = str;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzLs, this.zzaem);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RoomUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzaen;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaen = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzaen;
        }
    }

    final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzaeo;

        LoadAppContentsResultImpl(DataHolder[] dataHolderArr) {
            super(dataHolderArr[0]);
            this.zzaeo = new ArrayList(Arrays.asList(dataHolderArr));
        }
    }

    final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzaep;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaep = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzaep;
        }
    }

    final class LoadExtendedGamesResultImpl extends GamesDataHolderResult implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer zzaeq;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaeq = new ExtendedGameBuffer(dataHolder);
        }
    }

    final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzaer;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaer = new GameInstanceBuffer(dataHolder);
        }
    }

    final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaes;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaes = new GameSearchSuggestionBuffer(dataHolder);
        }
    }

    final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzaet;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaet = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzaet;
        }
    }

    final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzaeu;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaeu = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzaeu;
        }
    }

    final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzHb;
        private final LoadMatchesResponse zzaev;

        LoadMatchesResultImpl(Status status, Bundle bundle) {
            this.zzHb = status;
            this.zzaev = new LoadMatchesResponse(bundle);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzaev;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            this.zzaev.release();
        }
    }

    final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle zzGK;
        private final Status zzHb;

        LoadOwnerCoverPhotoUrisResultImpl(int i, Bundle bundle) {
            this.zzHb = GamesStatusCodes.zzep(i);
            this.zzGK = bundle;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaew;

        LoadPlayerScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaew = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaew = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzaew;
        }
    }

    final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzaex;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaex = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzaex;
        }
    }

    final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzadM;
        private final boolean zzaey;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzax = dataHolder.zzax(0);
                    this.zzadM = dataHolder.zzd("profile_visible", 0, zzax);
                    this.zzaey = dataHolder.zzd("profile_visibility_explicitly_set", 0, zzax);
                } else {
                    this.zzadM = true;
                    this.zzaey = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public boolean isProfileVisible() {
            return this.zzadM;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.zzaey;
        }
    }

    final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzMd;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzMd = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzMd);
        }
    }

    final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzHb;
        private final Bundle zzaez;

        LoadRequestsResultImpl(Status status, Bundle bundle) {
            this.zzHb = status;
            this.zzaez = bundle;
        }

        public GameRequestBuffer getRequests(int i) {
            String zzeJ = RequestType.zzeJ(i);
            return !this.zzaez.containsKey(zzeJ) ? null : new GameRequestBuffer((DataHolder) this.zzaez.get(zzeJ));
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            for (String parcelable : this.zzaez.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzaez.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzaeA;
        private final LeaderboardScoreBuffer zzaeB;

        LoadScoresResultImpl(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaeA = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaeA = null;
                }
                leaderboardBuffer.release();
                this.zzaeB = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzaeA;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzaeB;
        }
    }

    final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzMd);
        }
    }

    final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzHb;
        private final List<String> zzaeC;
        private final Bundle zzaeD;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle) {
            this.zzHb = status;
            this.zzaeC = bundle.getStringArrayList("game_category_list");
            this.zzaeD = bundle;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzaeE;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaeE = new ExperienceEventBuffer(dataHolder);
        }
    }

    final class MatchRemovedNotifier implements zze.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaeF;

        MatchRemovedNotifier(String str) {
            this.zzaeF = str;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaeF);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zze<OnTurnBasedMatchUpdateReceivedListener> zzTW;

        MatchUpdateReceivedBinderCallback(zze<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
            this.zzTW = com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener;
        }

        public void onTurnBasedMatchRemoved(String str) {
            this.zzTW.zza(new MatchRemovedNotifier(str));
        }

        public void zzt(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzTW.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    final class MatchUpdateReceivedNotifier implements zze.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaeG;

        MatchUpdateReceivedNotifier(TurnBasedMatch turnBasedMatch) {
            this.zzaeG = turnBasedMatch;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaeG);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class MessageReceivedNotifier implements zze.zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaeH;

        MessageReceivedNotifier(RealTimeMessage realTimeMessage) {
            this.zzaeH = realTimeMessage;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaeH);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class NearbyPlayerDetectedNotifier implements zze.zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzaeI;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaeI);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAclResult> zzHa;

        NotifyAclLoadedBinderCallback(zza.zzb<LoadAclResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult, (Object) "Holder must not be null");
        }

        public void zzC(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadAclResultImpl(dataHolder));
        }
    }

    final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzex(int i) {
            this.zzHa.zzd(GamesStatusCodes.zzep(i));
        }
    }

    final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzaeJ;
        private final String zzaeK;
        private final Snapshot zzaeL;
        private final Contents zzaeM;
        private final SnapshotContents zzaeN;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            boolean z = true;
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaeJ = null;
                    this.zzaeL = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (dataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzN(z);
                    this.zzaeJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzaeL = null;
                } else {
                    this.zzaeJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzaeL = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                }
                snapshotMetadataBuffer.release();
                this.zzaeK = str;
                this.zzaeM = contents3;
                this.zzaeN = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzaeK;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzaeL;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaeN;
        }

        public Snapshot getSnapshot() {
            return this.zzaeJ;
        }
    }

    final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadOwnerCoverPhotoUrisResult> zzHa;

        OwnerCoverPhotoUrisLoadedBinderCallback(zza.zzb<LoadOwnerCoverPhotoUrisResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadOwnerCoverPhotoUrisResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadOwnerCoverPhotoUrisResult, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzHa.zzd(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    final class P2PConnectedNotifier implements zze.zzb<RoomStatusUpdateListener> {
        private final String zzaeO;

        P2PConnectedNotifier(String str) {
            this.zzaeO = str;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaeO);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    final class P2PDisconnectedNotifier implements zze.zzb<RoomStatusUpdateListener> {
        private final String zzaeO;

        P2PDisconnectedNotifier(String str) {
            this.zzaeO = str;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaeO);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayerScoreResult> zzHa;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<LoadPlayerScoreResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, (Object) "Holder must not be null");
        }

        public void zzE(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpForGameCategoriesResult> zzHa;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<LoadXpForGameCategoriesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzHa.zzd(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpStreamResult> zzHa;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, (Object) "Holder must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayersResult> zzHa;

        PlayersLoadedBinderCallback(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, (Object) "Holder must not be null");
        }

        public void zzg(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzh(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadPlayersResultImpl(dataHolder));
        }
    }

    final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzadT;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzadT = popupManager;
        }

        public PopupLocationInfoParcelable zznk() {
            return new PopupLocationInfoParcelable(this.zzadT.zzof());
        }
    }

    final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadProfileSettingsResult> zzHa;

        ProfileSettingsLoadedBinderCallback(zza.zzb<LoadProfileSettingsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzHa.zzd(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzez(int i) {
            this.zzHa.zzd(GamesStatusCodes.zzep(i));
        }
    }

    final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AcceptQuestResult> zzaeP;

        public QuestAcceptedBinderCallbacks(zza.zzb<AcceptQuestResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult) {
            this.zzaeP = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaeP.zzd(new AcceptQuestResultImpl(dataHolder));
        }
    }

    final class QuestCompletedNotifier implements zze.zzb<QuestUpdateListener> {
        private final Quest zzaea;

        QuestCompletedNotifier(Quest quest) {
            this.zzaea = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaea);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((QuestUpdateListener) obj);
        }

        public void zzhX() {
        }
    }

    final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<ClaimMilestoneResult> zzaeQ;
        private final String zzaeR;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<ClaimMilestoneResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str) {
            this.zzaeQ = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, (Object) "Holder must not be null");
            this.zzaeR = (String) zzx.zzb((Object) str, (Object) "MilestoneId must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzaeQ.zzd(new ClaimMilestoneResultImpl(dataHolder, this.zzaeR));
        }
    }

    final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zze<QuestUpdateListener> zzTW;

        QuestUpdateBinderCallback(zze<QuestUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_quest_QuestUpdateListener) {
            this.zzTW = com_google_android_gms_common_api_zze_com_google_android_gms_games_quest_QuestUpdateListener;
        }

        private Quest zzT(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzM(DataHolder dataHolder) {
            Quest zzT = zzT(dataHolder);
            if (zzT != null) {
                this.zzTW.zza(new QuestCompletedNotifier(zzT));
            }
        }
    }

    final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadQuestsResult> zzaeS;

        public QuestsLoadedBinderCallbacks(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult) {
            this.zzaeS = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzaeS.zzd(new LoadQuestsResultImpl(dataHolder));
        }
    }

    final class RealTimeMessageSentNotifier implements zze.zzb<ReliableMessageSentCallback> {
        private final int zzLs;
        private final String zzaeT;
        private final int zzaeU;

        RealTimeMessageSentNotifier(int i, int i2, String str) {
            this.zzLs = i;
            this.zzaeU = i2;
            this.zzaeT = str;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzLs, this.zzaeU, this.zzaeT);
            }
        }

        public /* synthetic */ void zze(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }

        public void zzhX() {
        }
    }

    final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zze<ReliableMessageSentCallback> zzaeV;

        public RealTimeReliableMessageBinderCallbacks(zze<ReliableMessageSentCallback> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback) {
            this.zzaeV = com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzaeV != null) {
                this.zzaeV.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zze<OnRequestReceivedListener> zzTW;

        RequestReceivedBinderCallback(zze<OnRequestReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_request_OnRequestReceivedListener) {
            this.zzTW = com_google_android_gms_common_api_zze_com_google_android_gms_games_request_OnRequestReceivedListener;
        }

        public void onRequestRemoved(String str) {
            this.zzTW.zza(new RequestRemovedNotifier(str));
        }

        public void zzo(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzTW.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    final class RequestReceivedNotifier implements zze.zzb<OnRequestReceivedListener> {
        private final GameRequest zzaeW;

        RequestReceivedNotifier(GameRequest gameRequest) {
            this.zzaeW = gameRequest;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaeW);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class RequestRemovedNotifier implements zze.zzb<OnRequestReceivedListener> {
        private final String zzxv;

        RequestRemovedNotifier(String str) {
            this.zzxv = str;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzxv);
        }

        public /* synthetic */ void zze(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }

        public void zzhX() {
        }
    }

    final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SendRequestResult> zzaeX;

        public RequestSentBinderCallbacks(zza.zzb<SendRequestResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult) {
            this.zzaeX = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzaeX.zzd(new SendRequestResultImpl(dataHolder));
        }
    }

    final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestSummariesResult> zzaeY;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<LoadRequestSummariesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult) {
            this.zzaeY = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzaeY.zzd(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestsResult> zzaeZ;

        public RequestsLoadedBinderCallbacks(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult) {
            this.zzaeZ = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, (Object) "Holder must not be null");
        }

        public void zze(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaeZ.zzd(new LoadRequestsResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateRequestsResult> zzafa;

        public RequestsUpdatedBinderCallbacks(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult) {
            this.zzafa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, (Object) "Holder must not be null");
        }

        public void zzF(DataHolder dataHolder) {
            this.zzafa.zzd(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zze<? extends RoomUpdateListener> zzafb;
        private final zze<? extends RoomStatusUpdateListener> zzafc;
        private final zze<RealTimeMessageReceivedListener> zzafd;

        public RoomBinderCallbacks(zze<RoomUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener) {
            this.zzafb = (zze) zzx.zzb((Object) com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, (Object) "Callbacks must not be null");
            this.zzafc = null;
            this.zzafd = null;
        }

        public RoomBinderCallbacks(zze<? extends RoomUpdateListener> com_google_android_gms_common_api_zze__extends_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zze<? extends RoomStatusUpdateListener> com_google_android_gms_common_api_zze__extends_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zze<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener) {
            this.zzafb = (zze) zzx.zzb((Object) com_google_android_gms_common_api_zze__extends_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, (Object) "Callbacks must not be null");
            this.zzafc = com_google_android_gms_common_api_zze__extends_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener;
            this.zzafd = com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener;
        }

        public void onLeftRoom(int i, String str) {
            this.zzafb.zza(new LeftRoomNotifier(i, str));
        }

        public void onP2PConnected(String str) {
            if (this.zzafc != null) {
                this.zzafc.zza(new P2PConnectedNotifier(str));
            }
        }

        public void onP2PDisconnected(String str) {
            if (this.zzafc != null) {
                this.zzafc.zza(new P2PDisconnectedNotifier(str));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            if (this.zzafd != null) {
                this.zzafd.zza(new MessageReceivedNotifier(realTimeMessage));
            }
        }

        public void zzA(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzafc != null) {
                this.zzafc.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzu(DataHolder dataHolder) {
            this.zzafb.zza(new RoomCreatedNotifier(dataHolder));
        }

        public void zzv(DataHolder dataHolder) {
            this.zzafb.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzw(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzx(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzy(DataHolder dataHolder) {
            this.zzafb.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzz(DataHolder dataHolder) {
            if (this.zzafc != null) {
                this.zzafc.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }
    }

    final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzaeW;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaeW = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzaeW = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzHa;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzhb() {
            this.zzHa.zzd(GamesStatusCodes.zzep(0));
        }
    }

    final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CommitSnapshotResult> zzafe;

        public SnapshotCommittedBinderCallbacks(zza.zzb<CommitSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult) {
            this.zzafe = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzafe.zzd(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<DeleteSnapshotResult> zzHa;

        public SnapshotDeletedBinderCallbacks(zza.zzb<DeleteSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzHa.zzd(new DeleteSnapshotResultImpl(i, str));
        }
    }

    final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<OpenSnapshotResult> zzaff;

        public SnapshotOpenedBinderCallbacks(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult) {
            this.zzaff = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaff.zzd(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaff.zzd(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadSnapshotsResult> zzafg;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult) {
            this.zzafg = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzafg.zzd(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SubmitScoreResult> zzHa;

        public SubmitScoreBinderCallbacks(zza.zzb<SubmitScoreResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult) {
            this.zzHa = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, (Object) "Holder must not be null");
        }

        public void zzf(DataHolder dataHolder) {
            this.zzHa.zzd(new SubmitScoreResultImpl(dataHolder));
        }
    }

    final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzafh;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzafh = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzafh;
        }
    }

    final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CancelMatchResult> zzafi;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<CancelMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult) {
            this.zzafi = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzafi.zzd(new CancelMatchResultImpl(GamesStatusCodes.zzep(i), str));
        }
    }

    final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<InitiateMatchResult> zzafj;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult) {
            this.zzafj = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzafj.zzd(new InitiateMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LeaveMatchResult> zzafk;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult) {
            this.zzafk = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, (Object) "Holder must not be null");
        }

        public void zzs(DataHolder dataHolder) {
            this.zzafk.zzd(new LeaveMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchResult> zzafl;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<LoadMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult) {
            this.zzafl = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzafl.zzd(new LoadMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateMatchResult> zzafm;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult) {
            this.zzafm = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzafm.zzd(new UpdateMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchesResult> zzafn;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult) {
            this.zzafn = (zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzafn.zzd(new LoadMatchesResultImpl(GamesStatusCodes.zzep(i), bundle));
        }
    }

    final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzHb;
        private final String zzacY;

        UpdateAchievementResultImpl(int i, String str) {
            this.zzHb = GamesStatusCodes.zzep(i);
            this.zzacY = str;
        }

        public String getAchievementId() {
            return this.zzacY;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzafo;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzafo = RequestUpdateOutcomes.zzW(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzafo.getRequestIds();
        }

        public int getRequestOutcome(String str) {
            return this.zzafo.getRequestOutcome(str);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        this.zzadQ = com_google_android_gms_common_internal_zzf.zziR();
        this.zzadV = new Binder();
        this.zzadT = PopupManager.zza(this, com_google_android_gms_common_internal_zzf.zziO());
        zzl(com_google_android_gms_common_internal_zzf.zziT());
        this.zzadW = (long) hashCode();
        this.zzadX = gamesOptions;
        registerConnectionCallbacks(this);
        registerConnectionFailedListener(this);
    }

    private static Room zzR(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zznn() {
        this.zzadR = null;
        this.zzadS = null;
    }

    public void connect() {
        zznn();
        super.connect();
    }

    public void disconnect() {
        this.zzadU = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzjb();
                iGamesService.zznL();
                this.zzadP.flush();
                iGamesService.zzu(this.zzadW);
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnected(Bundle bundle) {
        if (this.zzadU) {
            this.zzadT.zzoc();
            this.zzadU = false;
        }
        if (!this.zzadX.zzacA) {
            zzno();
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzadU = false;
    }

    public void onConnectionSuspended(int i) {
    }

    public int zza(zze<ReliableMessageSentCallback> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzjb()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzjb()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent zza(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzjb()).zza(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzjb()).zza(i, bArr, i2, str);
            zzx.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzjb()).zza(playerEntity);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzjb()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzjb()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzadU = bundle.getBoolean("show_welcome_popup");
            this.zzadR = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzadS = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzjb()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "service died");
            }
        }
    }

    public void zza(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) {
        ((IGamesService) zzjb()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, int i, int i2, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zza(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), i, i2, z, z2);
    }

    public void zza(zza.zzb<LoadAppContentResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) {
        ((IGamesService) zzjb()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        ((IGamesService) zzjb()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zzoQ().zzoR(), i, i2);
    }

    public void zza(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzoX(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<CommitSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        com.google.android.gms.common.data.zza zzpc = snapshotMetadataChange.zzpc();
        if (zzpc != null) {
            zzpc.zza(getContext().getCacheDir());
        }
        Contents zzkq = snapshotContents.zzkq();
        snapshotContents.close();
        ((IGamesService) zzjb()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzkq);
    }

    public void zza(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzjb()).zza(iGamesCallbacks, str, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zza(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) {
        ((IGamesService) zzjb()).zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzjb()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                ((IGamesService) zzjb()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ((IGamesService) zzjb()).zza(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), str, i, z, z2, z3, z4);
    }

    public void zza(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zza.zzb<SubmitScoreResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) {
        ((IGamesService) zzjb()).zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) {
        ((IGamesService) zzjb()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zza.zzb<LoadPlayerScoreResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) {
        ((IGamesService) zzjb()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) {
        ((IGamesService) zzjb()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzjb()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                ((IGamesService) zzjb()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        com.google.android.gms.common.data.zza zzpc = snapshotMetadataChange.zzpc();
        if (zzpc != null) {
            zzpc.zza(getContext().getCacheDir());
        }
        Contents zzkq = snapshotContents.zzkq();
        snapshotContents.close();
        ((IGamesService) zzjb()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzkq);
    }

    public void zza(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) {
        ((IGamesService) zzjb()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) {
        ((IGamesService) zzjb()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) {
        ((IGamesService) zzjb()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) {
        ((IGamesService) zzjb()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        ((IGamesService) zzjb()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<SendRequestResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) {
        ((IGamesService) zzjb()).zza(new RequestSentBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) {
        ((IGamesService) zzjb()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, boolean z, Bundle bundle) {
        ((IGamesService) zzjb()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), z, bundle);
    }

    public void zza(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new EventsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) {
        ((IGamesService) zzjb()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public void zza(zze<OnInvitationReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zzjb()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zza(zze<RoomUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zze<RoomStatusUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zze<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzjb()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzadV, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zza(zze<RoomUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zzjb()).zzc(new RoomBinderCallbacks(com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzkq = snapshotContents.zzkq();
        snapshotContents.close();
        try {
            ((IGamesService) zzjb()).zza(zzkq);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    protected IGamesService zzaW(IBinder iBinder) {
        return Stub.zzaZ(iBinder);
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzjb()).zzb(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzjb()).zzb(iArr);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zzb(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzjb()).zzb(iGamesCallbacks, str, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zzb(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) {
        ((IGamesService) zzjb()).zzb(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzadT.zzoe(), this.zzadT.zzod());
    }

    public void zzb(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzjb()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, String str, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zza(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), str, i, z, z2);
    }

    public void zzb(zza.zzb<ClaimMilestoneResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzjb()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) {
        ((IGamesService) zzjb()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) {
        ((IGamesService) zzjb()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) {
        ((IGamesService) zzjb()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) {
        ((IGamesService) zzjb()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(zze<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zzjb()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzb(zze<RoomUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zze<RoomStatusUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zze<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzjb()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_zze_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzadV, roomConfig.getInvitationId(), false, this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzbO(String str) {
        try {
            ((IGamesService) zzjb()).zzbW(str);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public Intent zzbP(String str) {
        try {
            return ((IGamesService) zzjb()).zzbP(str);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zzbQ(String str) {
        try {
            ((IGamesService) zzjb()).zza(str, this.zzadT.zzoe(), this.zzadT.zzod());
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzc(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) {
        ((IGamesService) zzjb()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zzc(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) {
        ((IGamesService) zzjb()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) {
        ((IGamesService) zzjb()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzc(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, String str, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zze(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), str, i, z, z2);
    }

    public void zzc(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) {
        ((IGamesService) zzjb()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) {
        ((IGamesService) zzjb()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) {
        ((IGamesService) zzjb()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzc(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) {
        ((IGamesService) zzjb()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) {
        ((IGamesService) zzjb()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzc(zze<QuestUpdateListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zzjb()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_common_api_zze_com_google_android_gms_games_quest_QuestUpdateListener), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzjb()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void zzd(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) {
        ((IGamesService) zzjb()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) {
        ((IGamesService) zzjb()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, String str, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zzf(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), str, i, z, z2);
    }

    public void zzd(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) {
        ((IGamesService) zzjb()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zza.zzb<GameMuteStatusChangeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) {
        ((IGamesService) zzjb()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zzd(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public void zzd(zze<OnRequestReceivedListener> com_google_android_gms_common_api_zze_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zzjb()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_common_api_zze_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zze(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) {
        ((IGamesService) zzjb()).zzo(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) {
        ((IGamesService) zzjb()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zze(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, String str, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zzc(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), str, i, z, z2);
    }

    public void zze(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) {
        ((IGamesService) zzjb()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    public void zzeB(int i) {
        this.zzadT.setGravity(i);
    }

    public void zzeC(int i) {
        try {
            ((IGamesService) zzjb()).zzeC(i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    protected List<String> zzf(List<String> list) {
        int size = list.size();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < size) {
            int i3;
            boolean z2;
            String str = (String) list.get(i);
            if (str.equals(Scopes.GAMES)) {
                i3 = i2;
                z2 = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i3 = 1;
                z2 = z;
            } else {
                i3 = i2;
                z2 = z;
            }
            i++;
            z = z2;
            i2 = i3;
        }
        if (i2 != 0) {
            zzx.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return list;
    }

    public void zzf(zza.zzb<LoadGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) {
        ((IGamesService) zzjb()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zzf(zza.zzb<CancelMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) {
        ((IGamesService) zzjb()).zzn(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zza.zzb<LoadRequestSummariesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) {
        ((IGamesService) zzjb()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzf(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) {
        ((IGamesService) zzjb()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzf(zza.zzb<LoadProfileSettingsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z) {
        ((IGamesService) zzjb()).zzg(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z);
    }

    public void zzg(zza.zzb<LoadOwnerCoverPhotoUrisResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadOwnerCoverPhotoUrisResult) {
        ((IGamesService) zzjb()).zzj(new OwnerCoverPhotoUrisLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadOwnerCoverPhotoUrisResult));
    }

    public void zzg(zza.zzb<LoadMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) {
        ((IGamesService) zzjb()).zzp(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, boolean z) {
        ((IGamesService) zzjb()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzh(zza.zzb<LoadAclResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) {
        ((IGamesService) zzjb()).zzh(new NotifyAclLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult));
    }

    public void zzh(zza.zzb<AcceptQuestResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) {
        this.zzadP.flush();
        ((IGamesService) zzjb()).zzu(new QuestAcceptedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zza.zzb<ContactSettingLoadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) {
        ((IGamesService) zzjb()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public boolean zzhc() {
        return true;
    }

    public Bundle zzhp() {
        try {
            Bundle zzhp = ((IGamesService) zzjb()).zzhp();
            if (zzhp == null) {
                return zzhp;
            }
            zzhp.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzhp;
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    protected Bundle zzhq() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.gms.games.key.gamePackageName", this.zzadQ);
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzadX.zzacA);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzadX.zzacB);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzadX.zzacC);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzadX.zzacD);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzadX.zzacE);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzadX.zzacF);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzadX.zzacG);
        bundle.putString("com.google.android.gms.games.key.desiredLocale", locale);
        bundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzadT.zzoe()));
        zzf zzja = zzja();
        if (zzja.zziU() != null) {
            bundle.putBundle("com.google.android.gms.games.key.signInOptions", zzvc.zza(zzja.zziU(), zzja.zziV(), Executors.newSingleThreadExecutor()));
        }
        return bundle;
    }

    public void zzi(zza.zzb<InboxCountResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult) {
        ((IGamesService) zzjb()).zzt(new InboxCountsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzi(zza.zzb<DeleteSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) {
        ((IGamesService) zzjb()).zzr(new SnapshotDeletedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzj(zza.zzb<LoadExtendedGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult, String str) {
        ((IGamesService) zzjb()).zze(new ExtendedGamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadExtendedGamesResult), str);
    }

    public void zzk(zza.zzb<LoadGameInstancesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) {
        ((IGamesService) zzjb()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzl(View view) {
        this.zzadT.zzm(view);
    }

    public void zzl(zza.zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) {
        ((IGamesService) zzjb()).zzq(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    public void zzm(zza.zzb<LoadXpForGameCategoriesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) {
        ((IGamesService) zzjb()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    public void zzn(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) {
        ((IGamesService) zzjb()).zzk(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public void zznA() {
        try {
            ((IGamesService) zzjb()).zzx(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public Intent zznB() {
        try {
            return ((IGamesService) zzjb()).zznB();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznC() {
        try {
            return ((IGamesService) zzjb()).zznC();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public int zznD() {
        try {
            return ((IGamesService) zzjb()).zznD();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String zznE() {
        try {
            return ((IGamesService) zzjb()).zznE();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public int zznF() {
        try {
            return ((IGamesService) zzjb()).zznF();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent zznG() {
        try {
            return ((IGamesService) zzjb()).zznG();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public int zznH() {
        try {
            return ((IGamesService) zzjb()).zznH();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zznI() {
        try {
            return ((IGamesService) zzjb()).zznI();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zznJ() {
        try {
            return ((IGamesService) zzjb()).zznJ();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int zznK() {
        try {
            return ((IGamesService) zzjb()).zznK();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void zznL() {
        if (isConnected()) {
            try {
                ((IGamesService) zzjb()).zznL();
            } catch (RemoteException e) {
                GamesLog.zzr("GamesClientImpl", "service died");
            }
        }
    }

    public void zzno() {
        try {
            ((IGamesService) zzjb()).zza(new PopupLocationInfoBinderCallbacks(this.zzadT), this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public String zznp() {
        try {
            return ((IGamesService) zzjb()).zznp();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public String zznq() {
        if (this.zzadR != null) {
            return this.zzadR.getPlayerId();
        }
        try {
            return ((IGamesService) zzjb()).zznq();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player zznr() {
        zzfc();
        synchronized (this) {
            if (this.zzadR == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzjb()).zznN());
                    if (playerBuffer.getCount() > 0) {
                        this.zzadR = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.zzr("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzadR;
    }

    public Game zzns() {
        zzfc();
        synchronized (this) {
            if (this.zzadS == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzjb()).zznP());
                    if (gameBuffer.getCount() > 0) {
                        this.zzadS = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.zzr("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzadS;
    }

    public Intent zznt() {
        try {
            return ((IGamesService) zzjb()).zznt();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznu() {
        try {
            return ((IGamesService) zzjb()).zznu();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznv() {
        try {
            return ((IGamesService) zzjb()).zznv();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent zznw() {
        try {
            return ((IGamesService) zzjb()).zznw();
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zznx() {
        try {
            ((IGamesService) zzjb()).zzv(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzny() {
        try {
            ((IGamesService) zzjb()).zzw(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zznz() {
        try {
            ((IGamesService) zzjb()).zzy(this.zzadW);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public Intent zzo(String str, int i) {
        try {
            return ((IGamesService) zzjb()).zzv(str, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
            return null;
        }
    }

    public void zzo(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str) {
        ((IGamesService) zzjb()).zzj(new NotifyAclUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), str);
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzaW(iBinder);
    }

    public void zzp(zza.zzb<GameMuteStatusLoadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) {
        ((IGamesService) zzjb()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public void zzp(String str, int i) {
        this.zzadP.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzjb()).zzq(str, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzjb()).zzr(str, i);
        } catch (RemoteException e) {
            GamesLog.zzr("GamesClientImpl", "service died");
        }
    }
}
