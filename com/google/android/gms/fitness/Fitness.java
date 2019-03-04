package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzmz.zzb;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import com.google.android.gms.internal.zznc.zza;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzoi;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API = null;
    public static final Api<NoOptions> BLE_API = new Api(new zzb(), zzYd, new Scope[0]);
    public static final BleApi BleApi = zzll();
    public static final Api<NoOptions> CONFIG_API = new Api(new zzna.zzb(), zzYe, new Scope[0]);
    public static final ConfigApi ConfigApi = new zzob();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> HISTORY_API = new Api(new zznb.zzb(), zzYf, new Scope[0]);
    public static final HistoryApi HistoryApi = new zzoc();
    public static final Api<NoOptions> RECORDING_API = new Api(new zznd.zzb(), zzYh, new Scope[0]);
    public static final RecordingApi RecordingApi = new zzoe();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final Api<NoOptions> SENSORS_API = new Api(new zzne.zzb(), zzYi, new Scope[0]);
    public static final Api<NoOptions> SESSIONS_API = new Api(new zznf.zzb(), zzYj, new Scope[0]);
    public static final SensorsApi SensorsApi = new zzof();
    public static final SessionsApi SessionsApi = new zzog();
    public static final Api<NoOptions> zzSe = new Api(new zza(), zzYg, new Scope[0]);
    public static final zzc<zzmz> zzYd = new zzc();
    public static final zzc<zzna> zzYe = new zzc();
    public static final zzc<zznb> zzYf = new zzc();
    public static final zzc<zznc> zzYg = new zzc();
    public static final zzc<zznd> zzYh = new zzc();
    public static final zzc<zzne> zzYi = new zzc();
    public static final zzc<zznf> zzYj = new zzc();
    public static final zzny zzYk = new zzod();
    public static final Scope zzYl = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
    public static final Scope zzYm = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zzll() {
        return VERSION.SDK_INT >= 18 ? new zzoa() : new zzoi();
    }
}
