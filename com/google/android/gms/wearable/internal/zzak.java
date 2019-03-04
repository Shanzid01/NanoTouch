package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzak implements MessageApi {

    final class zza extends zzg<Status> {
        private IntentFilter[] zzaGb;
        private MessageListener zzaGv;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaGv = messageListener;
            this.zzaGb = intentFilterArr;
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
            com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaGv, this.zzaGb);
            this.zzaGv = null;
            this.zzaGb = null;
        }

        public Status zzb(Status status) {
            this.zzaGv = null;
            this.zzaGb = null;
            return status;
        }
    }

    public class zzb implements SendMessageResult {
        private final Status zzHb;
        private final int zzRV;

        public zzb(Status status, int i) {
            this.zzHb = status;
            this.zzRV = i;
        }

        public int getRequestId() {
            return this.zzRV;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, messageListener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final MessageListener messageListener) {
        return googleApiClient.zza(new zzg<Status>(this, googleApiClient) {
            final /* synthetic */ zzak zzaGt;

            public /* synthetic */ Result createFailedResult(Status status) {
                return zzb(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, messageListener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return googleApiClient.zza(new zzg<SendMessageResult>(this, googleApiClient) {
            final /* synthetic */ zzak zzaGt;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaT(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza(this, str3, str4, bArr2);
            }

            protected SendMessageResult zzaT(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
