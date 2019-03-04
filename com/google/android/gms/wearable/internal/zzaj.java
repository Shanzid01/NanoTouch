package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

abstract class zzaj<T> {
    private final HashMap<T, zzbe> zzaGo = new HashMap();

    class zza<T> extends zza<Status> {
        private WeakReference<Map<T, zzbe>> zzaGp;
        private WeakReference<T> zzaGq;

        zza(Map<T, zzbe> map, T t, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzaGp = new WeakReference(map);
            this.zzaGq = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzaGp.get();
            Object obj = this.zzaGq.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbe com_google_android_gms_wearable_internal_zzbe = (zzbe) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbe != null) {
                        com_google_android_gms_wearable_internal_zzbe.clear();
                    }
                }
            }
            zzE(status);
        }
    }

    final class zzb extends zzaj<com.google.android.gms.wearable.zza.zza> {
        zzb() {
        }

        zzbe zza(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza, IntentFilter[] intentFilterArr) {
            return zzbe.zza(com_google_android_gms_wearable_zza_zza);
        }
    }

    final class zzc extends zzaj<DataListener> {
        zzc() {
        }

        zzbe zza(DataListener dataListener, IntentFilter[] intentFilterArr) {
            return zzbe.zzb(dataListener, intentFilterArr);
        }
    }

    final class zzd extends zzaj<MessageListener> {
        zzd() {
        }

        zzbe zza(MessageListener messageListener, IntentFilter[] intentFilterArr) {
            return zzbe.zzb(messageListener, intentFilterArr);
        }
    }

    final class zze extends zzaj<NodeListener> {
        zze() {
        }

        zzbe zza(NodeListener nodeListener, IntentFilter[] intentFilterArr) {
            return zzbe.zza(nodeListener);
        }
    }

    class zzf<T> extends zza<Status> {
        private WeakReference<Map<T, zzbe>> zzaGp;
        private WeakReference<T> zzaGq;

        zzf(Map<T, zzbe> map, T t, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzaGp = new WeakReference(map);
            this.zzaGq = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzaGp.get();
            Object obj = this.zzaGq.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzbe com_google_android_gms_wearable_internal_zzbe = (zzbe) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbe != null) {
                        com_google_android_gms_wearable_internal_zzbe.clear();
                    }
                }
            }
            zzE(status);
        }
    }

    zzaj() {
    }

    abstract zzbe zza(T t, IntentFilter[] intentFilterArr);

    public void zza(zzbd com_google_android_gms_wearable_internal_zzbd, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, T t) {
        synchronized (this.zzaGo) {
            zzbe com_google_android_gms_wearable_internal_zzbe = (zzbe) this.zzaGo.remove(t);
            if (com_google_android_gms_wearable_internal_zzbe == null) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzd(new Status(4002));
                return;
            }
            com_google_android_gms_wearable_internal_zzbe.clear();
            ((zzai) com_google_android_gms_wearable_internal_zzbd.zzjb()).zza(new zzf(this.zzaGo, t, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), new zzau(com_google_android_gms_wearable_internal_zzbe));
        }
    }

    public void zza(zzbd com_google_android_gms_wearable_internal_zzbd, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, T t, IntentFilter[] intentFilterArr) {
        zzbe zza = zza(t, intentFilterArr);
        synchronized (this.zzaGo) {
            if (this.zzaGo.get(t) != null) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzd(new Status(4001));
                return;
            }
            this.zzaGo.put(t, zza);
            try {
                ((zzai) com_google_android_gms_wearable_internal_zzbd.zzjb()).zza(new zza(this.zzaGo, t, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), new zzb(zza));
            } catch (RemoteException e) {
                this.zzaGo.remove(t);
                throw e;
            }
        }
    }

    public void zzb(zzbd com_google_android_gms_wearable_internal_zzbd) {
        synchronized (this.zzaGo) {
            zzag com_google_android_gms_wearable_internal_zzbc_zzh = new zzh();
            for (Entry entry : this.zzaGo.entrySet()) {
                zzbe com_google_android_gms_wearable_internal_zzbe = (zzbe) entry.getValue();
                if (com_google_android_gms_wearable_internal_zzbe != null) {
                    com_google_android_gms_wearable_internal_zzbe.clear();
                    if (com_google_android_gms_wearable_internal_zzbd.isConnected()) {
                        try {
                            ((zzai) com_google_android_gms_wearable_internal_zzbd.zzjb()).zza(com_google_android_gms_wearable_internal_zzbc_zzh, new zzau(com_google_android_gms_wearable_internal_zzbe));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbe);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbe);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.zzaGo.clear();
        }
    }

    public void zzcS(IBinder iBinder) {
        synchronized (this.zzaGo) {
            zzai zzcR = com.google.android.gms.wearable.internal.zzai.zza.zzcR(iBinder);
            zzag com_google_android_gms_wearable_internal_zzbc_zzh = new zzh();
            for (Entry entry : this.zzaGo.entrySet()) {
                zzbe com_google_android_gms_wearable_internal_zzbe = (zzbe) entry.getValue();
                try {
                    zzcR.zza(com_google_android_gms_wearable_internal_zzbc_zzh, new zzb(com_google_android_gms_wearable_internal_zzbe));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbe);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbe);
                }
            }
        }
    }
}
