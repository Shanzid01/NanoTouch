package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.internal.zzr;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.internal.zzz;

public final class Drive {
    public static final Api<NoOptions> API = new Api(new C09441(), zzGR, new Scope[0]);
    public static final DriveApi DriveApi = new zzp();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzx();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final zzc<zzr> zzGR = new zzc();
    public static final Scope zzSc = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzSd = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzSe = new Api(new C09452(), zzGR, new Scope[0]);
    public static final zzc zzSf = new zzu();
    public static final zzf zzSg = new zzz();

    public abstract class zza<O extends ApiOptions> implements com.google.android.gms.common.api.Api.zzb<zzr, O> {
        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        protected abstract Bundle zza(O o);

        public zzr zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzr(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    final class C09441 extends zza<NoOptions> {
        C09441() {
        }

        protected Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }

    final class C09452 extends zza<zzb> {
        C09452() {
        }

        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzkp();
        }
    }

    public class zzb implements Optional {
        private final Bundle zzGK;

        private zzb() {
            this(new Bundle());
        }

        private zzb(Bundle bundle) {
            this.zzGK = bundle;
        }

        public Bundle zzkp() {
            return this.zzGK;
        }
    }

    private Drive() {
    }
}
