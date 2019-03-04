package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzy implements DriveResource {
    protected final DriveId zzRX;

    abstract class zzd extends zzq<MetadataResult> {
        final /* synthetic */ zzy zzUm;

        private zzd(zzy com_google_android_gms_drive_internal_zzy, GoogleApiClient googleApiClient) {
            this.zzUm = com_google_android_gms_drive_internal_zzy;
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzt(status);
        }

        public MetadataResult zzt(Status status) {
            return new zzc(status, null);
        }
    }

    class zza extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> zzHa;

        public zza(com.google.android.gms.common.api.zza.zzb<MetadataBufferResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListParentsResponse onListParentsResponse) {
            this.zzHa.zzd(new zzf(Status.zzNo, new MetadataBuffer(onListParentsResponse.zzkT()), false));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zzf(status, null, false));
        }
    }

    class zzb extends zzc {
        private final com.google.android.gms.common.api.zza.zzb<MetadataResult> zzHa;

        public zzb(com.google.android.gms.common.api.zza.zzb<MetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzHa = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void zza(OnMetadataResponse onMetadataResponse) {
            this.zzHa.zzd(new zzc(Status.zzNo, new zzm(onMetadataResponse.zzkU())));
        }

        public void zzm(Status status) {
            this.zzHa.zzd(new zzc(status, null));
        }
    }

    class zzc implements MetadataResult {
        private final Status zzHb;
        private final Metadata zzUo;

        public zzc(Status status, Metadata metadata) {
            this.zzHb = status;
            this.zzUo = metadata;
        }

        public Metadata getMetadata() {
            return this.zzUo;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    protected zzy(DriveId driveId) {
        this.zzRX = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(this, googleApiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new GetMetadataRequest(this.zzUm.zzRX, z), new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzr) googleApiClient.zza(Drive.zzGR)).zza(googleApiClient, this.zzRX, 1, changeListener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzr) googleApiClient.zza(Drive.zzGR)).zza(googleApiClient, this.zzRX, 1);
    }

    public DriveId getDriveId() {
        return this.zzRX;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzg(this, googleApiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new ListParentsRequest(this.zzUm.zzRX), new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzr) googleApiClient.zza(Drive.zzGR)).zzb(googleApiClient, this.zzRX, 1, changeListener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzr) googleApiClient.zza(Drive.zzGR)).zzb(googleApiClient, this.zzRX, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set) {
        if (set == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (set.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final List arrayList = new ArrayList(set);
            return googleApiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, googleApiClient) {
                final /* synthetic */ zzy zzUm;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new SetResourceParentsRequest(this.zzUm.zzRX, arrayList), new zzbl(this));
                }
            });
        }
    }

    public PendingResult<Status> trash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, googleApiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new TrashResourceRequest(this.zzUm.zzRX), new zzbl(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.drive.internal.zzq.zza(this, googleApiClient) {
            final /* synthetic */ zzy zzUm;

            protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                com_google_android_gms_drive_internal_zzr.zzkF().zza(new UntrashResourceRequest(this.zzUm.zzRX), new zzbl(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            return googleApiClient.zzb(new zzd(this, googleApiClient) {
                final /* synthetic */ zzy zzUm;

                protected void zza(zzr com_google_android_gms_drive_internal_zzr) {
                    metadataChangeSet.zzkx().setContext(com_google_android_gms_drive_internal_zzr.getContext());
                    com_google_android_gms_drive_internal_zzr.zzkF().zza(new UpdateMetadataRequest(this.zzUm.zzRX, metadataChangeSet.zzkx()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
