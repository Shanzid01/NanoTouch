package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzM(status);
        }

        public LoadAppContentResult zzM(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl zzafK;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C10211 extends LoadsImpl {
        final /* synthetic */ int zzafH;
        final /* synthetic */ String zzafI;
        final /* synthetic */ String[] zzafJ;
        final /* synthetic */ boolean zzafy;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafH, this.zzafI, this.zzafJ, this.zzafy);
        }
    }
}
