package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class zzbc {

    abstract class zza<T> extends zza {
        private com.google.android.gms.common.api.zza.zzb<T> zzGC;

        public zza(com.google.android.gms.common.api.zza.zzb<T> com_google_android_gms_common_api_zza_zzb_T) {
            this.zzGC = com_google_android_gms_common_api_zza_zzb_T;
        }

        public void zzE(T t) {
            com.google.android.gms.common.api.zza.zzb com_google_android_gms_common_api_zza_zzb = this.zzGC;
            if (com_google_android_gms_common_api_zza_zzb != null) {
                com_google_android_gms_common_api_zza_zzb.zzd(t);
                this.zzGC = null;
            }
        }
    }

    final class zzb extends zza<DeleteDataItemsResult> {
        public zzb(com.google.android.gms.common.api.zza.zzb<DeleteDataItemsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult);
        }

        public void zza(zzs com_google_android_gms_wearable_internal_zzs) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzc(zzay.zzep(com_google_android_gms_wearable_internal_zzs.statusCode), com_google_android_gms_wearable_internal_zzs.zzaGh));
        }
    }

    final class zzc extends zza<GetConnectedNodesResult> {
        public zzc(com.google.android.gms.common.api.zza.zzb<GetConnectedNodesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult);
        }

        public void zza(zzy com_google_android_gms_wearable_internal_zzy) {
            List arrayList = new ArrayList();
            arrayList.addAll(com_google_android_gms_wearable_internal_zzy.zzaGk);
            zzE(new com.google.android.gms.wearable.internal.zzan.zzb(zzay.zzep(com_google_android_gms_wearable_internal_zzy.statusCode), arrayList));
        }
    }

    final class zzd extends zza<DataItemResult> {
        public zzd(com.google.android.gms.common.api.zza.zzb<DataItemResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
        }

        public void zza(zzaa com_google_android_gms_wearable_internal_zzaa) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzb(zzay.zzep(com_google_android_gms_wearable_internal_zzaa.statusCode), com_google_android_gms_wearable_internal_zzaa.zzaGl));
        }
    }

    final class zze extends zza<DataItemBuffer> {
        public zze(com.google.android.gms.common.api.zza.zzb<DataItemBuffer> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer);
        }

        public void zzac(DataHolder dataHolder) {
            zzE(new DataItemBuffer(dataHolder));
        }
    }

    final class zzf extends zza<GetFdForAssetResult> {
        public zzf(com.google.android.gms.common.api.zza.zzb<GetFdForAssetResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult);
        }

        public void zza(zzac com_google_android_gms_wearable_internal_zzac) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzd(zzay.zzep(com_google_android_gms_wearable_internal_zzac.statusCode), com_google_android_gms_wearable_internal_zzac.zzaGm));
        }
    }

    final class zzg extends zza<GetLocalNodeResult> {
        public zzg(com.google.android.gms.common.api.zza.zzb<GetLocalNodeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult);
        }

        public void zza(zzae com_google_android_gms_wearable_internal_zzae) {
            zzE(new com.google.android.gms.wearable.internal.zzan.zzc(zzay.zzep(com_google_android_gms_wearable_internal_zzae.statusCode), com_google_android_gms_wearable_internal_zzae.zzaGn));
        }
    }

    final class zzh extends zza {
        zzh() {
        }

        public void zza(Status status) {
        }
    }

    final class zzi extends zza<DataItemResult> {
        private final List<FutureTask<Boolean>> zzaGF;

        zzi(com.google.android.gms.common.api.zza.zzb<DataItemResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, List<FutureTask<Boolean>> list) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
            this.zzaGF = list;
        }

        public void zza(zzas com_google_android_gms_wearable_internal_zzas) {
            zzE(new com.google.android.gms.wearable.internal.zzi.zzb(zzay.zzep(com_google_android_gms_wearable_internal_zzas.statusCode), com_google_android_gms_wearable_internal_zzas.zzaGl));
            if (com_google_android_gms_wearable_internal_zzas.statusCode != 0) {
                for (FutureTask cancel : this.zzaGF) {
                    cancel.cancel(true);
                }
            }
        }
    }

    final class zzj extends zza<SendMessageResult> {
        public zzj(com.google.android.gms.common.api.zza.zzb<SendMessageResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult);
        }

        public void zza(zzaw com_google_android_gms_wearable_internal_zzaw) {
            zzE(new com.google.android.gms.wearable.internal.zzak.zzb(zzay.zzep(com_google_android_gms_wearable_internal_zzaw.statusCode), com_google_android_gms_wearable_internal_zzaw.zzaGD));
        }
    }
}
