package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class zzjl extends zzk<zzjn> {

    final class zza extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<StateDeletedResult> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<StateDeletedResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult, (Object) "Result holder must not be null");
        }

        public void zzi(int i, int i2) {
            this.zzHa.zzd(new zzb(new Status(i), i2));
        }
    }

    final class zzb implements StateDeletedResult {
        private final Status zzHb;
        private final int zzHc;

        public zzb(Status status, int i) {
            this.zzHb = status;
            this.zzHc = i;
        }

        public int getStateKey() {
            return this.zzHc;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    final class zzc extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<StateListResult> zzHa;

        public zzc(com.google.android.gms.common.api.zza.zzb<StateListResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult, (Object) "Result holder must not be null");
        }

        public void zza(DataHolder dataHolder) {
            this.zzHa.zzd(new zzd(dataHolder));
        }
    }

    final class zzd extends com.google.android.gms.common.api.zzc implements StateListResult {
        private final AppStateBuffer zzHd;

        public zzd(DataHolder dataHolder) {
            super(dataHolder);
            this.zzHd = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.zzHd;
        }
    }

    final class zze extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<StateResult> zzHa;

        public zze(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, (Object) "Result holder must not be null");
        }

        public void zza(int i, DataHolder dataHolder) {
            this.zzHa.zzd(new zzf(i, dataHolder));
        }
    }

    final class zzf extends com.google.android.gms.common.api.zzc implements StateConflictResult, StateLoadedResult, StateResult {
        private final int zzHc;
        private final AppStateBuffer zzHd;

        public zzf(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.zzHc = i;
            this.zzHd = new AppStateBuffer(dataHolder);
        }

        private boolean zzhf() {
            return this.zzHb.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return zzhf() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return zzhf() ? null : this;
        }

        public byte[] getLocalData() {
            return this.zzHd.getCount() == 0 ? null : this.zzHd.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.zzHd.getCount() == 0 ? null : this.zzHd.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.zzHd.getCount() == 0 ? null : this.zzHd.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.zzHc;
        }

        public void release() {
            this.zzHd.release();
        }
    }

    final class zzg extends zzjk {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzHa;

        public zzg(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzHa = (com.google.android.gms.common.api.zza.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzhb() {
            this.zzHa.zzd(new Status(0));
        }
    }

    public zzjl(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 7, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    protected zzjn zzL(IBinder iBinder) {
        return com.google.android.gms.internal.zzjn.zza.zzN(iBinder);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateListResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult) {
        ((zzjn) zzjb()).zza(new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult));
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateDeletedResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult, int i) {
        ((zzjn) zzjb()).zzb(new zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult), i);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i, String str, byte[] bArr) {
        ((zzjn) zzjb()).zza(new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult), i, str, bArr);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i, byte[] bArr) {
        zzjm com_google_android_gms_internal_zzjm;
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult == null) {
            com_google_android_gms_internal_zzjm = null;
        } else {
            Object com_google_android_gms_internal_zzjl_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult);
        }
        ((zzjn) zzjb()).zza(com_google_android_gms_internal_zzjm, i, bArr);
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        ((zzjn) zzjb()).zzb(new zzg(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i) {
        ((zzjn) zzjb()).zza(new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult), i);
    }

    protected String zzcF() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected List<String> zzf(List<String> list) {
        zzx.zza(list.contains(Scopes.APP_STATE), String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
        return list;
    }

    public boolean zzhc() {
        return true;
    }

    public int zzhd() {
        try {
            return ((zzjn) zzjb()).zzhd();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int zzhe() {
        try {
            return ((zzjn) zzjb()).zzhe();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzL(iBinder);
    }
}
