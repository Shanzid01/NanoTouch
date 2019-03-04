package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzp implements DriveApi {

    abstract class zzg extends zzq<MetadataBufferResult> {
        zzg(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzp(status);
        }

        public MetadataBufferResult zzp(Status status) {
            return new zzf(status, null, false);
        }
    }

    abstract class zzb extends zzq<DriveContentsResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzn(status);
        }

        public DriveContentsResult zzn(Status status) {
            return new zza(status, null);
        }
    }

    abstract class zze extends zzq<DriveIdResult> {
        zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzo(status);
        }

        public DriveIdResult zzo(Status status) {
            return new zzd(status, null);
        }
    }

    class zza implements DriveContentsResult {
        private final Status zzHb;
        private final DriveContents zzSa;

        public zza(Status status, DriveContents driveContents) {
            this.zzHb = status;
            this.zzSa = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzSa;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    class zzc extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveIdResult> zzHa;

        public zzc(com.google.android.gms.common.api.zza.zzb<DriveIdResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) {
            this.zzHa.zzd(new zzd(Status.zzNo, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) {
            this.zzHa.zzd(new zzd(Status.zzNo, new zzm(onMetadataResponse.zzkU()).getDriveId()));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zzd(status, null));
        }
    }

    class zzd implements DriveIdResult {
        private final Status zzHb;
        private final DriveId zzRX;

        public zzd(Status status, DriveId driveId) {
            this.zzHb = status;
            this.zzRX = driveId;
        }

        public DriveId getDriveId() {
            return this.zzRX;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    class zzf implements MetadataBufferResult {
        private final Status zzHb;
        private final MetadataBuffer zzTA;
        private final boolean zzTB;

        public zzf(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzHb = status;
            this.zzTA = metadataBuffer;
            this.zzTB = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzTA;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    class zzh extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveContentsResult> zzHa;

        public zzh(com.google.android.gms.common.api.zza.zzb<DriveContentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        }

        public void zza(OnContentsResponse onContentsResponse) {
            this.zzHa.zzd(new zza(Status.zzNo, new zzs(onContentsResponse.zzkL())));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zza(status, null));
        }
    }

    class zzi extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzHa;

        public zzi(com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) {
            this.zzHa.zzd(new zzf(Status.zzNo, new MetadataBuffer(onListEntriesResponse.zzkR()), onListEntriesResponse.zzkS()));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zzf(status, null, false));
        }
    }

    class zzj extends com.google.android.gms.drive.internal.zzq.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            setResult(status);
        }

        protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, List<String> list) {
        return ((zzr) googleApiClient.zza(Drive.zzGR)).cancelPendingActions(googleApiClient, list);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zze(this, googleApiClient) {
            final /* synthetic */ zzp zzTx;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new GetMetadataRequest(DriveId.zzbu(str), false), new zzc(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            DriveId zzkH = ((zzr) googleApiClient.zza(Drive.zzGR)).zzkH();
            return zzkH != null ? new zzv(zzkH) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new zzt(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new zzv(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            return new zzv(((zzr) googleApiClient.zza(Drive.zzGR)).zzkG());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient googleApiClient, final Query query) {
        if (query != null) {
            return googleApiClient.zza(new zzg(this, googleApiClient) {
                final /* synthetic */ zzp zzTx;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new QueryRequest(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, googleApiClient) {
            final /* synthetic */ zzp zzTx;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new zzbl(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzp zzTx;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new CreateContentsRequest(i), new zzh(this));
            }
        });
    }
}
