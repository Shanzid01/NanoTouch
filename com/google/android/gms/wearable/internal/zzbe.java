package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzah.zza;

public class zzbe extends zza {
    private com.google.android.gms.wearable.zza.zza zzaGM;
    private DataListener zzaGN;
    private MessageListener zzaGO;
    private NodeListener zzaGP;
    private final IntentFilter[] zzaGb;

    private zzbe(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza, DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, IntentFilter[] intentFilterArr) {
        this.zzaGM = com_google_android_gms_wearable_zza_zza;
        this.zzaGN = dataListener;
        this.zzaGO = messageListener;
        this.zzaGP = nodeListener;
        this.zzaGb = intentFilterArr;
    }

    public static zzbe zza(NodeListener nodeListener) {
        return new zzbe(null, null, null, nodeListener, null);
    }

    public static zzbe zza(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza) {
        return new zzbe(com_google_android_gms_wearable_zza_zza, null, null, null, null);
    }

    public static zzbe zzb(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new zzbe(null, dataListener, null, null, intentFilterArr);
    }

    public static zzbe zzb(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new zzbe(null, null, messageListener, null, intentFilterArr);
    }

    public void clear() {
        this.zzaGM = null;
        this.zzaGN = null;
        this.zzaGO = null;
        this.zzaGP = null;
    }

    public void zza(zzal com_google_android_gms_wearable_internal_zzal) {
        if (this.zzaGO != null) {
            this.zzaGO.onMessageReceived(com_google_android_gms_wearable_internal_zzal);
        }
    }

    public void zza(zzao com_google_android_gms_wearable_internal_zzao) {
        if (this.zzaGP != null) {
            this.zzaGP.onPeerConnected(com_google_android_gms_wearable_internal_zzao);
        }
    }

    public void zza(zze com_google_android_gms_wearable_internal_zze) {
        if (this.zzaGM != null) {
            this.zzaGM.zza(com_google_android_gms_wearable_internal_zze);
        }
    }

    public void zzab(DataHolder dataHolder) {
        if (this.zzaGN != null) {
            try {
                this.zzaGN.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public void zzb(zzao com_google_android_gms_wearable_internal_zzao) {
        if (this.zzaGP != null) {
            this.zzaGP.onPeerDisconnected(com_google_android_gms_wearable_internal_zzao);
        }
    }

    public IntentFilter[] zzvm() {
        return this.zzaGb;
    }
}
