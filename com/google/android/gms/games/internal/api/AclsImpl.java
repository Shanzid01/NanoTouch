package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    final class C10181 implements LoadAclResult {
        final /* synthetic */ Status zzGT;

        C10181(Status status) {
            this.zzGT = status;
        }

        public Status getStatus() {
            return this.zzGT;
        }

        public void release() {
        }
    }

    abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzL(status);
        }

        public LoadAclResult zzL(Status status) {
            return AclsImpl.zzJ(status);
        }
    }

    class C10192 extends LoadNotifyAclImpl {
        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzh(this);
        }
    }

    abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    class C10203 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzafG;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzo((zzb) this, this.zzafG);
        }
    }

    private static LoadAclResult zzJ(Status status) {
        return new C10181(status);
    }
}
