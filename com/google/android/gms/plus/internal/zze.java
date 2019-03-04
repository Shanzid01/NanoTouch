package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzlk;
import com.google.android.gms.internal.zztt;
import com.google.android.gms.internal.zztw;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class zze extends zzk<zzd> {
    private Person zzaur;
    private final zzh zzaus;

    final class zza implements LoadMomentsResult {
        private final Status zzHb;
        private final String zzaut;
        private final String zzauu;
        private final MomentBuffer zzauv;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzHb = status;
            this.zzaut = str;
            this.zzauu = str2;
            this.zzauv = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzauv;
        }

        public String getNextPageToken() {
            return this.zzaut;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public String getUpdated() {
            return this.zzauu;
        }

        public void release() {
            if (this.zzauv != null) {
                this.zzauv.release();
            }
        }
    }

    final class zzb implements LoadPeopleResult {
        private final Status zzHb;
        private final String zzaut;
        private final PersonBuffer zzauw;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzHb = status;
            this.zzaut = str;
            this.zzauw = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzaut;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzauw;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            if (this.zzauw != null) {
                this.zzauw.release();
            }
        }
    }

    final class zzc extends zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzanf;

        public zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzanf = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzaI(Status status) {
            this.zzanf.zzd(status);
        }
    }

    final class zzd extends zza {
        private final com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> zzanf;

        public zzd(com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
            this.zzanf = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zziu() != null ? (PendingIntent) dataHolder.zziu().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzanf.zzd(new zza(status, dataHolder, str, str2));
        }
    }

    final class zze extends zza {
        private final com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> zzanf;

        public zze(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
            this.zzanf = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zziu() != null ? (PendingIntent) dataHolder.zziu().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzanf.zzd(new zzb(status, dataHolder, str));
        }
    }

    final class zzf extends zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzanf;

        public zzf(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzanf = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzj(int i, Bundle bundle) {
            this.zzanf.zzd(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, zzh com_google_android_gms_plus_internal_zzh, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        this.zzaus = com_google_android_gms_plus_internal_zzh;
    }

    public static boolean zzf(String[] strArr) {
        return (strArr == null || strArr.length == 0) ? false : (strArr.length == 1 && "plus_one_placeholder_scope".equals(strArr[0])) ? false : true;
    }

    private Bundle zzrP() {
        Bundle zzsa = this.zzaus.zzsa();
        zzsa.putStringArray("request_visible_actions", this.zzaus.zzrT());
        zzsa.putString("auth_package", this.zzaus.zzrV());
        return zzsa;
    }

    public String getAccountName() {
        zzfc();
        try {
            return ((zzd) zzjb()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public ICancelToken zza(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, int i, String str) {
        zzfc();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            return ((zzd) zzjb()).zza(com_google_android_gms_plus_internal_zze_zze, 1, i, -1, str);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzay(8), null);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzaur = zztw.zzj(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, int i, String str, Uri uri, String str2, String str3) {
        zzfc();
        Object com_google_android_gms_plus_internal_zze_zzd = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult != null ? new zzd(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) : null;
        try {
            ((zzd) zzjb()).zza(com_google_android_gms_plus_internal_zze_zzd, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzd.zza(DataHolder.zzay(8), null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, Moment moment) {
        zzfc();
        zzb com_google_android_gms_plus_internal_zze_zzc = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status != null ? new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) : null;
        try {
            ((zzd) zzjb()).zza(com_google_android_gms_plus_internal_zze_zzc, zzlk.zza((zztt) moment));
        } catch (Throwable e) {
            if (com_google_android_gms_plus_internal_zze_zzc == null) {
                throw new IllegalStateException(e);
            }
            com_google_android_gms_plus_internal_zze_zzc.zzaI(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Collection<String> collection) {
        zzfc();
        zzb com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzjb()).zza(com_google_android_gms_plus_internal_zze_zze, new ArrayList(collection));
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzay(8), null);
        }
    }

    public void zzcE(String str) {
        zzfc();
        try {
            ((zzd) zzjb()).zzcE(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected String zzcF() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String zzcG() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected zzd zzcz(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzcy(iBinder);
    }

    public void zzd(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String[] strArr) {
        zza((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Arrays.asList(strArr));
    }

    public boolean zzhc() {
        return zzf(zzja().zziQ());
    }

    protected Bundle zzhq() {
        return zzrP();
    }

    public void zzj(com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
        zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, 20, null, null, null, "me");
    }

    protected Bundle zzjc() {
        return zzrP();
    }

    public void zzk(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
        zzfc();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzjb()).zza(com_google_android_gms_plus_internal_zze_zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzay(8), null);
        }
    }

    public void zzl(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        zzfc();
        zzrK();
        Object com_google_android_gms_plus_internal_zze_zzf = new zzf(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        try {
            ((zzd) zzjb()).zzb(com_google_android_gms_plus_internal_zze_zzf);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzf.zzj(8, null);
        }
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcz(iBinder);
    }

    public ICancelToken zzr(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String str) {
        return zza((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, 0, str);
    }

    public void zzrK() {
        zzfc();
        try {
            this.zzaur = null;
            ((zzd) zzjb()).zzrK();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzrO() {
        zzfc();
        return this.zzaur;
    }
}
