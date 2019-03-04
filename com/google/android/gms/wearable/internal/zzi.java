package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzi implements DataApi {

    final class zza extends zzg<Status> {
        private DataListener zzaGa;
        private IntentFilter[] zzaGb;

        private zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaGa = dataListener;
            this.zzaGb = intentFilterArr;
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
            com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaGa, this.zzaGb);
            this.zzaGa = null;
            this.zzaGb = null;
        }

        public Status zzb(Status status) {
            this.zzaGa = null;
            this.zzaGb = null;
            return status;
        }
    }

    public class zzb implements DataItemResult {
        private final Status zzHb;
        private final DataItem zzaGc;

        public zzb(Status status, DataItem dataItem) {
            this.zzHb = status;
            this.zzaGc = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzaGc;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public class zzc implements DeleteDataItemsResult {
        private final Status zzHb;
        private final int zzaGd;

        public zzc(Status status, int i) {
            this.zzHb = status;
            this.zzaGd = i;
        }

        public int getNumDeleted() {
            return this.zzaGd;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public class zzd implements GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzHb;
        private volatile ParcelFileDescriptor zzaGe;
        private volatile InputStream zzaGf;

        public zzd(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzHb = status;
            this.zzaGe = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzaGe;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzaGe == null) {
                return null;
            } else {
                if (this.zzaGf == null) {
                    this.zzaGf = new AutoCloseInputStream(this.zzaGe);
                }
                return this.zzaGf;
            }
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public void release() {
            if (this.zzaGe != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzaGf != null) {
                        this.zzaGf.close();
                    } else {
                        this.zzaGe.close();
                    }
                    this.mClosed = true;
                    this.zzaGe = null;
                    this.zzaGf = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, dataListener, intentFilterArr));
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataListener dataListener) {
        return zza(googleApiClient, dataListener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zzg<DeleteDataItemsResult>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaR(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zzc(this, uri);
            }

            protected DeleteDataItemsResult zzaR(Status status) {
                return new zzc(status, 0);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zzg<DataItemResult>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaP(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, uri);
            }

            protected DataItemResult zzaP(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzg<DataItemBuffer>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaQ(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zzm(this);
            }

            protected DataItemBuffer zzaQ(Status status) {
                return new DataItemBuffer(DataHolder.zzay(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zzg<DataItemBuffer>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaQ(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zzb((com.google.android.gms.common.api.zza.zzb) this, uri);
            }

            protected DataItemBuffer zzaQ(Status status) {
                return new DataItemBuffer(DataHolder.zzay(status.getStatusCode()));
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, final Asset asset) {
        zza(asset);
        return googleApiClient.zza(new zzg<GetFdForAssetResult>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaS(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, asset);
            }

            protected GetFdForAssetResult zzaS(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, final DataItemAsset dataItemAsset) {
        return googleApiClient.zza(new zzg<GetFdForAssetResult>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaS(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, dataItemAsset);
            }

            protected GetFdForAssetResult zzaS(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient googleApiClient, final PutDataRequest putDataRequest) {
        return googleApiClient.zza(new zzg<DataItemResult>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            public /* synthetic */ Result createFailedResult(Status status) {
                return zzaP(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, putDataRequest);
            }

            public DataItemResult zzaP(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final DataListener dataListener) {
        return googleApiClient.zza(new zzg<Status>(this, googleApiClient) {
            final /* synthetic */ zzi zzaFW;

            public /* synthetic */ Result createFailedResult(Status status) {
                return zzb(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, dataListener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
