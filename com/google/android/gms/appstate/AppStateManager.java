package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjl;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(zzGS, zzGR, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final com.google.android.gms.common.api.Api.zzc<zzjl> zzGR = new com.google.android.gms.common.api.Api.zzc();
    private static final com.google.android.gms.common.api.Api.zzb<zzjl, NoOptions> zzGS = new C07971();

    final class C07971 implements com.google.android.gms.common.api.Api.zzb<zzjl, NoOptions> {
        C07971() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzjl zzb(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjl(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    final class C07982 implements StateResult {
        final /* synthetic */ Status zzGT;

        C07982(Status status) {
            this.zzGT = status;
        }

        public StateConflictResult getConflictResult() {
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            return null;
        }

        public Status getStatus() {
            return this.zzGT;
        }

        public void release() {
        }
    }

    public abstract class zza<R extends Result> extends com.google.android.gms.common.api.zza.zza<R, zzjl> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppStateManager.zzGR, googleApiClient);
        }
    }

    abstract class zze extends zza<StateResult> {
        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzg(status);
        }

        public StateResult zzg(Status status) {
            return AppStateManager.zzc(status);
        }
    }

    final class C07993 extends zze {
        final /* synthetic */ int zzGU;
        final /* synthetic */ byte[] zzGV;

        C07993(GoogleApiClient googleApiClient, int i, byte[] bArr) {
            this.zzGU = i;
            this.zzGV = bArr;
            super(googleApiClient);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zza(null, this.zzGU, this.zzGV);
        }
    }

    final class C08004 extends zze {
        final /* synthetic */ int zzGU;
        final /* synthetic */ byte[] zzGV;

        C08004(GoogleApiClient googleApiClient, int i, byte[] bArr) {
            this.zzGU = i;
            this.zzGV = bArr;
            super(googleApiClient);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zza(this, this.zzGU, this.zzGV);
        }
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    abstract class zzb extends zza<StateDeletedResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    final class C08025 extends zzb {
        final /* synthetic */ int zzGU;

        C08025(GoogleApiClient googleApiClient, int i) {
            this.zzGU = i;
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zze(status);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zza(this, this.zzGU);
        }

        public StateDeletedResult zze(final Status status) {
            return new StateDeletedResult(this) {
                final /* synthetic */ C08025 zzGW;

                public int getStateKey() {
                    return this.zzGW.zzGU;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    final class C08036 extends zze {
        final /* synthetic */ int zzGU;

        C08036(GoogleApiClient googleApiClient, int i) {
            this.zzGU = i;
            super(googleApiClient);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zzb(this, this.zzGU);
        }
    }

    abstract class zzc extends zza<StateListResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzf(status);
        }

        public StateListResult zzf(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ zzc zzGZ;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    final class C08047 extends zzc {
        C08047(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zza(this);
        }
    }

    final class C08058 extends zze {
        final /* synthetic */ int zzGU;
        final /* synthetic */ String zzGX;
        final /* synthetic */ byte[] zzGY;

        C08058(GoogleApiClient googleApiClient, int i, String str, byte[] bArr) {
            this.zzGU = i;
            this.zzGX = str;
            this.zzGY = bArr;
            super(googleApiClient);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zza(this, this.zzGU, this.zzGX, this.zzGY);
        }
    }

    abstract class zzd extends zza<Status> {
        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        public Status zzb(Status status) {
            return status;
        }
    }

    final class C08069 extends zzd {
        C08069(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzjl com_google_android_gms_internal_zzjl) {
            com_google_android_gms_internal_zzjl.zzb(this);
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    private AppStateManager() {
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zzb(new C08025(googleApiClient, i));
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzhe();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzhd();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C08047(googleApiClient));
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C08036(googleApiClient, i));
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, int i, String str, byte[] bArr) {
        return googleApiClient.zzb(new C08058(googleApiClient, i, str, bArr));
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C08069(googleApiClient));
    }

    public static void update(GoogleApiClient googleApiClient, int i, byte[] bArr) {
        googleApiClient.zzb(new C07993(googleApiClient, i, bArr));
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, int i, byte[] bArr) {
        return googleApiClient.zzb(new C08004(googleApiClient, i, bArr));
    }

    public static zzjl zza(GoogleApiClient googleApiClient) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjl) googleApiClient.zza(zzGR);
    }

    private static StateResult zzc(Status status) {
        return new C07982(status);
    }
}
