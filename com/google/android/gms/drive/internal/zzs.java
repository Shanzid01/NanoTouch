package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzq.zza;
import java.io.InputStream;
import java.io.OutputStream;

public class zzs implements DriveContents {
    private boolean mClosed = false;
    private final Contents zzTO;
    private boolean zzTP = false;
    private boolean zzTQ = false;

    class C09593 implements ResultCallback<Status> {
        final /* synthetic */ zzs zzTR;

        C09593(zzs com_google_android_gms_drive_internal_zzs) {
            this.zzTR = com_google_android_gms_drive_internal_zzs;
        }

        public /* synthetic */ void onResult(Result result) {
            zzi((Status) result);
        }

        public void zzi(Status status) {
            if (status.isSuccess()) {
                zzw.zzq("DriveContentsImpl", "Contents discarded");
            } else {
                zzw.zzs("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    public zzs(Contents contents) {
        this.zzTO = (Contents) zzx.zzl(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return commit(googleApiClient, metadataChangeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.zzTO.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzbl(executionOptions.zzkv()) || this.zzTO.zzko()) {
            ExecutionOptions.zza(googleApiClient, executionOptions);
            if (zzks()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.zzSv;
                }
                zzkr();
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zzs zzTR;

                    protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                        metadataChangeSet.zzkx().setContext(com_google_android_gms_drive_internal_zzr.getContext());
                        com_google_android_gms_drive_internal_zzr.zzkF().zza(new CloseContentsAndUpdateMetadataRequest(this.zzTR.zzTO.getDriveId(), metadataChangeSet.zzkx(), this.zzTR.zzTO, executionOptions), new zzbl(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient googleApiClient) {
        if (zzks()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzkr();
        ((C09604) googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzs zzTR;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new CloseContentsRequest(this.zzTR.zzTO, false), new zzbl(this));
            }
        })).setResultCallback(new C09593(this));
    }

    public DriveId getDriveId() {
        return this.zzTO.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzks()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzTO.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzTP) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzTP = true;
            return this.zzTO.getInputStream();
        }
    }

    public int getMode() {
        return this.zzTO.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzks()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzTO.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzTQ) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzTQ = true;
            return this.zzTO.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzks()) {
            return this.zzTO.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (zzks()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzTO.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzkr();
            return googleApiClient.zza(new zzb(this, googleApiClient) {
                final /* synthetic */ zzs zzTR;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new OpenContentsRequest(this.zzTR.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzTR.zzTO.getRequestId()), new zzbe(this, null));
                }
            });
        }
    }

    public Contents zzkq() {
        return this.zzTO;
    }

    public void zzkr() {
        this.mClosed = true;
    }

    public boolean zzks() {
        return this.mClosed;
    }
}
