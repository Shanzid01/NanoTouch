package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzx implements DrivePreferencesApi {

    abstract class zzc extends zzq<FileUploadPreferencesResult> {
        final /* synthetic */ zzx zzUi;

        public zzc(zzx com_google_android_gms_drive_internal_zzx, GoogleApiClient googleApiClient) {
            this.zzUi = com_google_android_gms_drive_internal_zzx;
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzs(status);
        }

        protected FileUploadPreferencesResult zzs(Status status) {
            return new zzb(status, null);
        }
    }

    class zza extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<FileUploadPreferencesResult> zzHa;
        final /* synthetic */ zzx zzUi;

        private zza(zzx com_google_android_gms_drive_internal_zzx, com.google.android.gms.common.api.zza.zzb<FileUploadPreferencesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzUi = com_google_android_gms_drive_internal_zzx;
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) {
            this.zzHa.zzd(new zzb(Status.zzNo, onDeviceUsagePreferenceResponse.zzkN()));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zzb(status, null));
        }
    }

    class zzb implements FileUploadPreferencesResult {
        private final Status zzHb;
        final /* synthetic */ zzx zzUi;
        private final FileUploadPreferences zzUk;

        private zzb(zzx com_google_android_gms_drive_internal_zzx, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzUi = com_google_android_gms_drive_internal_zzx;
            this.zzHb = status;
            this.zzUk = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzUk;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzx zzUi;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zzh(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return googleApiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, googleApiClient) {
                final /* synthetic */ zzx zzUi;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbl(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
