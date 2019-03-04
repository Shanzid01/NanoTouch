package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzt.zza {
    private final BleScanCallback zzaaI;

    public class zza {
        private static final zza zzaaJ = new zza();
        private final Map<BleScanCallback, zza> zzaaK = new HashMap();

        private zza() {
        }

        public static zza zzlO() {
            return zzaaJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzaaK) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzaaK.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza == null) {
                    com_google_android_gms_fitness_request_zza = new zza(bleScanCallback);
                    this.zzaaK.put(bleScanCallback, com_google_android_gms_fitness_request_zza);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzaaK) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzaaK.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza != null) {
                } else {
                    com_google_android_gms_fitness_request_zza = new zza(bleScanCallback);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaaI = (BleScanCallback) zzx.zzl(bleScanCallback);
    }

    public void onDeviceFound(BleDevice bleDevice) {
        this.zzaaI.onDeviceFound(bleDevice);
    }

    public void onScanStopped() {
        this.zzaaI.onScanStopped();
    }
}
