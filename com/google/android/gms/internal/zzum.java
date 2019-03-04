package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;

public class zzum implements SafetyNetApi {

    abstract class zzb extends zzuj<AttestationResult> {
        protected zzuk zzawK = new C13551(this);

        class C13551 extends zzui {
            final /* synthetic */ zzb zzawL;

            C13551(zzb com_google_android_gms_internal_zzum_zzb) {
                this.zzawL = com_google_android_gms_internal_zzum_zzb;
            }

            public void zza(Status status, com.google.android.gms.safetynet.zza com_google_android_gms_safetynet_zza) {
                this.zzawL.setResult(new zza(status, com_google_android_gms_safetynet_zza));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzaL(status);
        }

        protected AttestationResult zzaL(Status status) {
            return new zza(status, null);
        }
    }

    class zza implements AttestationResult {
        private final Status zzHb;
        private final com.google.android.gms.safetynet.zza zzawJ;

        public zza(Status status, com.google.android.gms.safetynet.zza com_google_android_gms_safetynet_zza) {
            this.zzHb = status;
            this.zzawJ = com_google_android_gms_safetynet_zza;
        }

        public String getJwsResult() {
            return this.zzawJ == null ? null : this.zzawJ.getJwsResult();
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] bArr) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzum zzawI;

            protected void zza(zzun com_google_android_gms_internal_zzun) {
                com_google_android_gms_internal_zzun.zza(this.zzawK, bArr);
            }
        });
    }
}
