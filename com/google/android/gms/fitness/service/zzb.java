package com.google.android.gms.fitness.service;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzk;
import java.util.List;

class zzb implements SensorEventDispatcher {
    private final zzk zzabp;

    zzb(zzk com_google_android_gms_fitness_data_zzk) {
        this.zzabp = (zzk) zzx.zzl(com_google_android_gms_fitness_data_zzk);
    }

    public void publish(DataPoint dataPoint) {
        this.zzabp.zzc(dataPoint);
    }

    public void publish(List<DataPoint> list) {
        for (DataPoint publish : list) {
            publish(publish);
        }
    }
}
