package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzan implements NodeApi {

    final class zza extends zzg<Status> {
        private NodeListener zzaGz;

        private zza(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.zzaGz = nodeListener;
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
            com_google_android_gms_wearable_internal_zzbd.zza((com.google.android.gms.common.api.zza.zzb) this, this.zzaGz);
            this.zzaGz = null;
        }

        public Status zzb(Status status) {
            this.zzaGz = null;
            return status;
        }
    }

    public class zzb implements GetConnectedNodesResult {
        private final Status zzHb;
        private final List<Node> zzaGA;

        public zzb(Status status, List<Node> list) {
            this.zzHb = status;
            this.zzaGA = list;
        }

        public List<Node> getNodes() {
            return this.zzaGA;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public class zzc implements GetLocalNodeResult {
        private final Status zzHb;
        private final Node zzaGB;

        public zzc(Status status, Node node) {
            this.zzHb = status;
            this.zzaGB = node;
        }

        public Node getNode() {
            return this.zzaGB;
        }

        public Status getStatus() {
            return this.zzHb;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, NodeListener nodeListener) {
        return googleApiClient.zza(new zza(googleApiClient, nodeListener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzg<GetConnectedNodesResult>(this, googleApiClient) {
            final /* synthetic */ zzan zzaGx;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaV(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zzo(this);
            }

            protected GetConnectedNodesResult zzaV(Status status) {
                return new zzb(status, new ArrayList());
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzg<GetLocalNodeResult>(this, googleApiClient) {
            final /* synthetic */ zzan zzaGx;

            protected /* synthetic */ Result createFailedResult(Status status) {
                return zzaU(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zzn(this);
            }

            protected GetLocalNodeResult zzaU(Status status) {
                return new zzc(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final NodeListener nodeListener) {
        return googleApiClient.zza(new zzg<Status>(this, googleApiClient) {
            final /* synthetic */ zzan zzaGx;

            public /* synthetic */ Result createFailedResult(Status status) {
                return zzb(status);
            }

            protected void zza(zzbd com_google_android_gms_wearable_internal_zzbd) {
                com_google_android_gms_wearable_internal_zzbd.zzb((com.google.android.gms.common.api.zza.zzb) this, nodeListener);
            }

            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
