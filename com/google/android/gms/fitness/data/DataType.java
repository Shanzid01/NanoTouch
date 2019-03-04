package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzxc.zzc;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataType implements SafeParcelable {
    public static final DataType AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", Field.FIELD_ACTIVITY, Field.FIELD_DURATION, Field.zzZz);
    public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final DataType AGGREGATE_CALORIES_CONSUMED = TYPE_CALORIES_CONSUMED;
    public static final DataType AGGREGATE_CALORIES_EXPENDED = TYPE_CALORIES_EXPENDED;
    public static final DataType AGGREGATE_DISTANCE_DELTA = TYPE_DISTANCE_DELTA;
    public static final DataType AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final Set<DataType> AGGREGATE_INPUT_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DataType[]{TYPE_STEP_COUNT_DELTA, TYPE_DISTANCE_DELTA, TYPE_ACTIVITY_SEGMENT, TYPE_SPEED, TYPE_HEART_RATE_BPM, TYPE_WEIGHT, TYPE_LOCATION_SAMPLE, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_BODY_FAT_PERCENTAGE, zzYV, zzYU, zzYW})));
    public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE);
    public static final DataType AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final DataType AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final DataType AGGREGATE_STEP_COUNT_DELTA = TYPE_STEP_COUNT_DELTA;
    public static final DataType AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final Creator<DataType> CREATOR = new zzh();
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.data_type/";
    public static final DataType TYPE_ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE);
    public static final DataType TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", Field.FIELD_ACTIVITY);
    public static final DataType TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", Field.FIELD_CALORIES);
    public static final DataType TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", Field.FIELD_PERCENTAGE);
    public static final DataType TYPE_CALORIES_CONSUMED = new DataType("com.google.calories.consumed", Field.FIELD_CALORIES);
    public static final DataType TYPE_CALORIES_EXPENDED = new DataType("com.google.calories.expended", Field.FIELD_CALORIES);
    public static final DataType TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", Field.FIELD_RPM);
    public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", Field.FIELD_REVOLUTIONS);
    public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", Field.FIELD_REVOLUTIONS);
    public static final DataType TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", Field.FIELD_RPM);
    public static final DataType TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", Field.FIELD_DISTANCE);
    public static final DataType TYPE_DISTANCE_DELTA = new DataType("com.google.distance.delta", Field.FIELD_DISTANCE);
    public static final DataType TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", Field.FIELD_BPM);
    public static final DataType TYPE_HEIGHT = new DataType("com.google.height", Field.FIELD_HEIGHT);
    public static final DataType TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE);
    public static final DataType TYPE_LOCATION_TRACK = new DataType("com.google.location.track", Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE);
    public static final DataType TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", Field.FIELD_WATTS);
    public static final DataType TYPE_SPEED = new DataType("com.google.speed", Field.FIELD_SPEED);
    public static final DataType TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", Field.FIELD_RPM);
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", Field.FIELD_STEPS);
    public static final DataType TYPE_STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", Field.FIELD_STEPS);
    public static final DataType TYPE_WEIGHT = new DataType("com.google.weight", Field.FIELD_WEIGHT);
    public static final DataType zzYS = new DataType("com.google.activity.edge", Field.FIELD_ACTIVITY, Field.zzZA);
    public static final DataType zzYT = new DataType("com.google.accelerometer", Field.zzZB, Field.zzZC, Field.zzZD);
    public static final DataType zzYU = new DataType("com.google.body.waist.circumference", Field.FIELD_CIRCUMFERENCE);
    public static final DataType zzYV = new DataType("com.google.body.hip.circumference", Field.FIELD_CIRCUMFERENCE);
    public static final DataType zzYW = new DataType("com.google.nutrition.meal", Field.zzZi, Field.FIELD_CALORIES, Field.zzZj, Field.zzZk, Field.zzZl, Field.zzZm, Field.zzZn, Field.zzZo, Field.zzZp, Field.zzZq, Field.zzZr, Field.zzZs, Field.zzZt, Field.zzZu, Field.zzZv, Field.zzZw, Field.zzZx, Field.zzZy);
    public static final DataType zzYX = new DataType("com.google.body.hip.circumference.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final DataType zzYY = new DataType("com.google.body.waist.circumference.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
    public static final DataType zzYZ = new DataType("com.google.nutrition.summary", Field.FIELD_CALORIES, Field.zzZj, Field.zzZk, Field.zzZl, Field.zzZm, Field.zzZn, Field.zzZo, Field.zzZp, Field.zzZq, Field.zzZr, Field.zzZs, Field.zzZt, Field.zzZu, Field.zzZv, Field.zzZw, Field.zzZx, Field.zzZy);
    private static final Map<DataType, List<DataType>> zzZa = new C09851();
    public static final DataType[] zzZb = new DataType[]{zzYT, zzYS, TYPE_ACTIVITY_SAMPLE, TYPE_ACTIVITY_SEGMENT, AGGREGATE_ACTIVITY_SUMMARY, TYPE_BODY_FAT_PERCENTAGE, AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, zzYV, zzYX, zzYU, zzYY, TYPE_BASAL_METABOLIC_RATE, AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_CYCLING_PEDALING_CADENCE, TYPE_CYCLING_PEDALING_CUMULATIVE, TYPE_CYCLING_WHEEL_REVOLUTION, TYPE_CYCLING_WHEEL_RPM, TYPE_DISTANCE_CUMULATIVE, TYPE_DISTANCE_DELTA, TYPE_HEART_RATE_BPM, AGGREGATE_HEART_RATE_SUMMARY, TYPE_HEIGHT, AGGREGATE_LOCATION_BOUNDING_BOX, TYPE_LOCATION_SAMPLE, TYPE_LOCATION_TRACK, zzYW, zzYZ, TYPE_POWER_SAMPLE, AGGREGATE_POWER_SUMMARY, TYPE_SPEED, AGGREGATE_SPEED_SUMMARY, TYPE_STEP_COUNT_CADENCE, TYPE_STEP_COUNT_CUMULATIVE, TYPE_STEP_COUNT_DELTA, TYPE_WEIGHT, AGGREGATE_WEIGHT_SUMMARY};
    public static final String[] zzZc = new String[]{zzYT.getName(), zzYS.getName(), TYPE_ACTIVITY_SAMPLE.getName(), TYPE_ACTIVITY_SEGMENT.getName(), AGGREGATE_ACTIVITY_SUMMARY.getName(), TYPE_BODY_FAT_PERCENTAGE.getName(), AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY.getName(), zzYV.getName(), zzYX.getName(), zzYU.getName(), zzYY.getName(), TYPE_BASAL_METABOLIC_RATE.getName(), AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY.getName(), TYPE_CALORIES_CONSUMED.getName(), TYPE_CALORIES_EXPENDED.getName(), TYPE_CYCLING_PEDALING_CADENCE.getName(), TYPE_CYCLING_PEDALING_CUMULATIVE.getName(), TYPE_CYCLING_WHEEL_REVOLUTION.getName(), TYPE_CYCLING_WHEEL_RPM.getName(), TYPE_DISTANCE_CUMULATIVE.getName(), TYPE_DISTANCE_DELTA.getName(), TYPE_HEART_RATE_BPM.getName(), AGGREGATE_HEART_RATE_SUMMARY.getName(), TYPE_HEIGHT.getName(), AGGREGATE_LOCATION_BOUNDING_BOX.getName(), TYPE_LOCATION_SAMPLE.getName(), TYPE_LOCATION_TRACK.getName(), zzYW.getName(), zzYZ.getName(), TYPE_POWER_SAMPLE.getName(), AGGREGATE_POWER_SUMMARY.getName(), TYPE_SPEED.getName(), AGGREGATE_SPEED_SUMMARY.getName(), TYPE_STEP_COUNT_CADENCE.getName(), TYPE_STEP_COUNT_CUMULATIVE.getName(), TYPE_STEP_COUNT_DELTA.getName(), TYPE_WEIGHT.getName(), AGGREGATE_WEIGHT_SUMMARY.getName()};
    private final String mName;
    private final int zzFG;
    private final List<Field> zzZd;

    final class C09851 extends HashMap<DataType, List<DataType>> {
        C09851() {
            put(DataType.TYPE_ACTIVITY_SEGMENT, Arrays.asList(new DataType[]{DataType.AGGREGATE_ACTIVITY_SUMMARY}));
            put(DataType.TYPE_BASAL_METABOLIC_RATE, Arrays.asList(new DataType[]{DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY}));
            put(DataType.TYPE_BODY_FAT_PERCENTAGE, Arrays.asList(new DataType[]{DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY}));
            put(DataType.zzYV, Arrays.asList(new DataType[]{DataType.zzYX}));
            put(DataType.zzYU, Arrays.asList(new DataType[]{DataType.zzYY}));
            put(DataType.TYPE_CALORIES_CONSUMED, Arrays.asList(new DataType[]{DataType.AGGREGATE_CALORIES_CONSUMED}));
            put(DataType.TYPE_CALORIES_EXPENDED, Arrays.asList(new DataType[]{DataType.AGGREGATE_CALORIES_EXPENDED}));
            put(DataType.TYPE_DISTANCE_DELTA, Arrays.asList(new DataType[]{DataType.AGGREGATE_DISTANCE_DELTA}));
            put(DataType.TYPE_LOCATION_SAMPLE, Arrays.asList(new DataType[]{DataType.AGGREGATE_LOCATION_BOUNDING_BOX}));
            put(DataType.zzYW, Arrays.asList(new DataType[]{DataType.zzYZ}));
            put(DataType.TYPE_POWER_SAMPLE, Arrays.asList(new DataType[]{DataType.AGGREGATE_POWER_SUMMARY}));
            put(DataType.TYPE_HEART_RATE_BPM, Arrays.asList(new DataType[]{DataType.AGGREGATE_HEART_RATE_SUMMARY}));
            put(DataType.TYPE_SPEED, Arrays.asList(new DataType[]{DataType.AGGREGATE_SPEED_SUMMARY}));
            put(DataType.TYPE_STEP_COUNT_DELTA, Arrays.asList(new DataType[]{DataType.AGGREGATE_STEP_COUNT_DELTA}));
            put(DataType.TYPE_WEIGHT, Arrays.asList(new DataType[]{DataType.AGGREGATE_WEIGHT_SUMMARY}));
        }
    }

    DataType(int i, String str, List<Field> list) {
        this.zzFG = i;
        this.mName = str;
        this.zzZd = Collections.unmodifiableList(list);
    }

    public DataType(String str, Field... fieldArr) {
        this(1, str, zzls.zzb(fieldArr));
    }

    public static List<DataType> getAggregatesForInput(DataType dataType) {
        List list = (List) zzZa.get(dataType);
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static String getMimeType(DataType dataType) {
        return MIME_TYPE_PREFIX + dataType.getName();
    }

    private boolean zza(DataType dataType) {
        return this.mName.equals(dataType.mName) && this.zzZd.equals(dataType.zzZd);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataType) && zza((DataType) obj));
    }

    public List<Field> getFields() {
        return this.zzZd;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public int indexOf(Field field) {
        if (this.zzZd.contains(field)) {
            return this.zzZd.indexOf(field);
        }
        throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[]{field, this}));
    }

    public String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.mName, this.zzZd});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public String zzlB() {
        return this.mName.startsWith("com.google.") ? this.mName.substring(11) : this.mName;
    }

    public zzc zzlC() {
        return zzmp.zzZU.zzc(this);
    }
}
