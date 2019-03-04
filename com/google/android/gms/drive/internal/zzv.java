package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class zzv extends zzy implements DriveFolder {

    abstract class zzd extends zzq<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzq(status);
        }

        public DriveFileResult zzq(Status status) {
            return new zzc(status, null);
        }
    }

    abstract class zzf extends zzq<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzr(status);
        }

        public DriveFolderResult zzr(Status status) {
            return new zze(status, null);
        }
    }

    class zza extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveFileResult> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<DriveFileResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) {
            this.zzHa.zzd(new zzc(Status.zzNo, new zzt(onDriveIdResponse.getDriveId())));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zzc(status, null));
        }
    }

    class zzb extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<DriveFolderResult> zzHa;

        public zzb(com.google.android.gms.common.api.zza.zzb<DriveFolderResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) {
            this.zzHa.zzd(new zze(Status.zzNo, new zzv(onDriveIdResponse.getDriveId())));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zze(status, null));
        }
    }

    class zzc implements DriveFileResult {
        private final Status zzHb;
        private final DriveFile zzUf;

        public zzc(Status status, DriveFile driveFile) {
            this.zzHb = status;
            this.zzUf = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzUf;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    class zze implements DriveFolderResult {
        private final Status zzHb;
        private final DriveFolder zzUg;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzHb = status;
            this.zzUg = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzUg;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public zzv(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.zzb(new zzd(this, googleApiClient) {
            final /* synthetic */ zzv zzUe;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                metadataChangeSet2.zzkx().setContext(com_google_android_gms_drive_internal_zzr.getContext());
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new CreateFileRequest(this.zzUe.getDriveId(), metadataChangeSet2.zzkx(), i3, i4, executionOptions2), new zza(this));
            }
        });
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof zzs)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzks()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.zzkq().getRequestId();
            driveContents.zzkr();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return zza(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents) {
        return createFile(googleApiClient, metadataChangeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzkv() == 0) {
            return zza(googleApiClient, metadataChangeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (metadataChangeSet.getMimeType() == null || metadataChangeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return googleApiClient.zzb(new zzf(this, googleApiClient) {
                final /* synthetic */ zzv zzUe;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    metadataChangeSet.zzkx().setContext(com_google_android_gms_drive_internal_zzr.getContext());
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new CreateFolderRequest(this.zzUe.getDriveId(), metadataChangeSet.zzkx()), new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient googleApiClient) {
        return queryChildren(googleApiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient googleApiClient, Query query) {
        return new zzp().query(googleApiClient, zza(query));
    }
}
