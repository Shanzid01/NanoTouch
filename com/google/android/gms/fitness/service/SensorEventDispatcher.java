package com.google.android.gms.fitness.service;

import com.google.android.gms.fitness.data.DataPoint;
import java.util.List;

public interface SensorEventDispatcher {
    void publish(DataPoint dataPoint);

    void publish(List<DataPoint> list);
}
