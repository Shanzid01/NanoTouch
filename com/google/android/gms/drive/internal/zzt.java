package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.api.zze.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzt extends zzy implements DriveFile {

    class zza implements DownloadProgressListener {
        private final zze<DownloadProgressListener> zzTW;

        public zza(zze<DownloadProgressListener> com_google_android_gms_common_api_zze_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzTW = com_google_android_gms_common_api_zze_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long j, long j2) {
            final long j3 = j;
            final long j4 = j2;
            this.zzTW.zza(new zzb<DownloadProgressListener>(this) {
                final /* synthetic */ zza zzTZ;

                public void zza(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j3, j4);
                }

                public /* synthetic */ void zze(Object obj) {
                    zza((DownloadProgressListener) obj);
                }

                public void zzhX() {
                }
            });
        }
    }

    public zzt(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzf(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient googleApiClient, final int i, DownloadProgressListener downloadProgressListener) {
        if (i == DriveFile.MODE_READ_ONLY || i == DriveFile.MODE_WRITE_ONLY || i == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener zza = zza(googleApiClient, downloadProgressListener);
            return googleApiClient.zza(new zzb(this, googleApiClient) {
                final /* synthetic */ zzt zzTV;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new OpenContentsRequest(this.zzTV.getDriveId(), i, 0), new zzbe(this, zza));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
