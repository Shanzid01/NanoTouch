package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

class zzbe extends zzc {
    private final zzb<DriveContentsResult> zzHa;
    private final DownloadProgressListener zzVc;

    zzbe(zzb<DriveContentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult, DownloadProgressListener downloadProgressListener) {
        this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        this.zzVc = downloadProgressListener;
    }

    public void zza(OnContentsResponse onContentsResponse) {
        this.zzHa.zzd(new zza(onContentsResponse.zzkM() ? new Status(-1) : Status.zzNo, new zzs(onContentsResponse.zzkL())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) {
        if (this.zzVc != null) {
            this.zzVc.onProgress(onDownloadProgressResponse.zzkO(), onDownloadProgressResponse.zzkP());
        }
    }

    public void zzm(Status status) {
        this.zzHa.zzd(new zza(status, null));
    }
}
