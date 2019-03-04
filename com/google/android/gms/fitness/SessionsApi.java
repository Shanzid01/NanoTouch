package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface SessionsApi {

    public class ViewIntentBuilder {
        private final Context mContext;
        private String zzYr;
        private Session zzYs;
        private boolean zzYt = false;

        public ViewIntentBuilder(Context context) {
            this.mContext = context;
        }

        private Intent zzi(Intent intent) {
            if (this.zzYr == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzYr);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzYr, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            zzx.zza(this.zzYs != null, (Object) "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.zzYs.getActivity()));
            zzc.zza(this.zzYs, intent, Session.EXTRA_SESSION);
            if (!this.zzYt) {
                this.zzYr = this.zzYs.getAppPackageName();
            }
            return zzi(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzYr = str;
            this.zzYt = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzYs = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
