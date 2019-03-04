package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzal;
import com.google.android.gms.wearable.internal.zzao;
import com.google.android.gms.wearable.internal.zze;

public abstract class WearableListenerService extends Service implements DataListener, MessageListener, NodeListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private String zzFO;
    private volatile int zzPm = -1;
    private IBinder zzPp;
    private Handler zzaFF;
    private Object zzaFG = new Object();
    private boolean zzaFH;

    class zza extends com.google.android.gms.wearable.internal.zzah.zza {
        final /* synthetic */ WearableListenerService zzaFI;

        private zza(WearableListenerService wearableListenerService) {
            this.zzaFI = wearableListenerService;
        }

        public void zza(final zzal com_google_android_gms_wearable_internal_zzal) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + com_google_android_gms_wearable_internal_zzal);
            }
            this.zzaFI.zzuZ();
            synchronized (this.zzaFI.zzaFG) {
                if (this.zzaFI.zzaFH) {
                    return;
                }
                this.zzaFI.zzaFF.post(new Runnable(this) {
                    final /* synthetic */ zza zzaFK;

                    public void run() {
                        this.zzaFK.zzaFI.onMessageReceived(com_google_android_gms_wearable_internal_zzal);
                    }
                });
            }
        }

        public void zza(final zzao com_google_android_gms_wearable_internal_zzao) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.zzaFI.zzFO + ": " + com_google_android_gms_wearable_internal_zzao);
            }
            this.zzaFI.zzuZ();
            synchronized (this.zzaFI.zzaFG) {
                if (this.zzaFI.zzaFH) {
                    return;
                }
                this.zzaFI.zzaFF.post(new Runnable(this) {
                    final /* synthetic */ zza zzaFK;

                    public void run() {
                        this.zzaFK.zzaFI.onPeerConnected(com_google_android_gms_wearable_internal_zzao);
                    }
                });
            }
        }

        public void zza(zze com_google_android_gms_wearable_internal_zze) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onNotificationReceived: " + com_google_android_gms_wearable_internal_zze);
            }
        }

        public void zzab(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.zzaFI.zzFO + ": " + dataHolder);
            }
            this.zzaFI.zzuZ();
            synchronized (this.zzaFI.zzaFG) {
                if (this.zzaFI.zzaFH) {
                    dataHolder.close();
                    return;
                }
                this.zzaFI.zzaFF.post(new Runnable(this) {
                    final /* synthetic */ zza zzaFK;

                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            this.zzaFK.zzaFI.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                });
            }
        }

        public void zzb(final zzao com_google_android_gms_wearable_internal_zzao) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.zzaFI.zzFO + ": " + com_google_android_gms_wearable_internal_zzao);
            }
            this.zzaFI.zzuZ();
            synchronized (this.zzaFI.zzaFG) {
                if (this.zzaFI.zzaFH) {
                    return;
                }
                this.zzaFI.zzaFF.post(new Runnable(this) {
                    final /* synthetic */ zza zzaFK;

                    public void run() {
                        this.zzaFK.zzaFI.onPeerDisconnected(com_google_android_gms_wearable_internal_zzao);
                    }
                });
            }
        }
    }

    private void zzuZ() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.zzPm) {
            if (GooglePlayServicesUtil.zzd(this, callingUid)) {
                this.zzPm = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.zzPp : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.zzFO = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzaFF = new Handler(handlerThread.getLooper());
        this.zzPp = new zza();
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    public void onDestroy() {
        synchronized (this.zzaFG) {
            this.zzaFH = true;
            this.zzaFF.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }
}
