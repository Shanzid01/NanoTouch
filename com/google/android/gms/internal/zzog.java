package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzog implements SessionsApi {

    class zza extends com.google.android.gms.internal.zznt.zza {
        private final com.google.android.gms.common.api.zza.zzb<SessionReadResult> zzHa;

        private zza(com.google.android.gms.common.api.zza.zzb<SessionReadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) {
            this.zzHa.zzd(sessionReadResult);
        }
    }

    class zzb extends com.google.android.gms.internal.zznu.zza {
        private final com.google.android.gms.common.api.zza.zzb<SessionStopResult> zzHa;

        private zzb(com.google.android.gms.common.api.zza.zzb<SessionStopResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzHa.zzd(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zza<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzz(status);
            }

            protected void zza(zznf com_google_android_gms_internal_zznf) {
                ((zznp) com_google_android_gms_internal_zznf.zzjb()).zza(new zzam(str, str2, new zzb(this), com_google_android_gms_internal_zznf.getContext().getPackageName()));
            }

            protected SessionStopResult zzz(Status status) {
                return SessionStopResult.zzG(status);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient googleApiClient, final SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf com_google_android_gms_internal_zznf) {
                ((zznp) com_google_android_gms_internal_zznf.zzjb()).zza(new SessionInsertRequest(sessionInsertRequest, new zzoh(this), com_google_android_gms_internal_zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, final SessionReadRequest sessionReadRequest) {
        return googleApiClient.zza(new zza<SessionReadResult>(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzA(status);
            }

            protected SessionReadResult zzA(Status status) {
                return SessionReadResult.zzF(status);
            }

            protected void zza(zznf com_google_android_gms_internal_zznf) {
                ((zznp) com_google_android_gms_internal_zznf.zzjb()).zza(new SessionReadRequest(sessionReadRequest, new zza(this), com_google_android_gms_internal_zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf com_google_android_gms_internal_zznf) {
                ((zznp) com_google_android_gms_internal_zznf.zzjb()).zza(new zzai(pendingIntent, new zzoh(this), com_google_android_gms_internal_zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> startSession(GoogleApiClient googleApiClient, final Session session) {
        zzx.zzb((Object) session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf com_google_android_gms_internal_zznf) {
                ((zznp) com_google_android_gms_internal_zznf.zzjb()).zza(new zzak(session, new zzoh(this), com_google_android_gms_internal_zznf.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, null, str);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzog zzaaD;

            protected void zza(zznf com_google_android_gms_internal_zznf) {
                ((zznp) com_google_android_gms_internal_zznf.zzjb()).zza(new zzao(pendingIntent, new zzoh(this), com_google_android_gms_internal_zznf.getContext().getPackageName()));
            }
        });
    }
}
