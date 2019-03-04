package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR = new zzj();
    public static final Field FIELD_ACCURACY = zzbK("accuracy");
    public static final Field FIELD_ACTIVITY = zzbJ("activity");
    public static final Field FIELD_ALTITUDE = zzbK("altitude");
    public static final Field FIELD_AVERAGE = zzbK("average");
    public static final Field FIELD_BPM = zzbK("bpm");
    public static final Field FIELD_CALORIES = zzbK("calories");
    public static final Field FIELD_CIRCUMFERENCE = zzbK("circumference");
    public static final Field FIELD_CONFIDENCE = zzbK("confidence");
    public static final Field FIELD_DISTANCE = zzbK("distance");
    public static final Field FIELD_DURATION = zzbJ("duration");
    public static final Field FIELD_HEIGHT = zzbK("height");
    public static final Field FIELD_HIGH_LATITUDE = zzbK("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzbK("high_longitude");
    public static final Field FIELD_LATITUDE = zzbK("latitude");
    public static final Field FIELD_LONGITUDE = zzbK("longitude");
    public static final Field FIELD_LOW_LATITUDE = zzbK("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzbK("low_longitude");
    public static final Field FIELD_MAX = zzbK("max");
    public static final Field FIELD_MIN = zzbK("min");
    public static final Field FIELD_PERCENTAGE = zzbK("percentage");
    public static final Field FIELD_REVOLUTIONS = zzbJ("revolutions");
    public static final Field FIELD_RPM = zzbK("rpm");
    public static final Field FIELD_SPEED = zzbK("speed");
    public static final Field FIELD_STEPS = zzbJ("steps");
    public static final Field FIELD_WATTS = zzbK("watts");
    public static final Field FIELD_WEIGHT = zzbK("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final Field zzZA = zzbJ("edge_type");
    public static final Field zzZB = zzbK("x");
    public static final Field zzZC = zzbK("y");
    public static final Field zzZD = zzbK("z");
    public static final Field zzZi = zzbJ("meal_type");
    public static final Field zzZj = zzbK("fat.total");
    public static final Field zzZk = zzbK("fat.saturated");
    public static final Field zzZl = zzbK("fat.polyunsaturated");
    public static final Field zzZm = zzbK("fat.monounsaturated");
    public static final Field zzZn = zzbK("fat.trans");
    public static final Field zzZo = zzbK("cholesterol");
    public static final Field zzZp = zzbK("sodium");
    public static final Field zzZq = zzbK("potassium");
    public static final Field zzZr = zzbK("carbs.total");
    public static final Field zzZs = zzbK("dietary_fiber");
    public static final Field zzZt = zzbK("sugar");
    public static final Field zzZu = zzbK("protein");
    public static final Field zzZv = zzbK("vitamin_a");
    public static final Field zzZw = zzbK("vitamin_c");
    public static final Field zzZx = zzbK("calcium");
    public static final Field zzZy = zzbK("iron");
    public static final Field zzZz = zzbJ("num_segments");
    private final String mName;
    private final int zzFG;
    private final int zzZE;

    Field(int i, String str, int i2) {
        this.zzFG = i;
        this.mName = (String) zzx.zzl(str);
        this.zzZE = i2;
    }

    private Field(String str, int i) {
        this(1, str, i);
    }

    private boolean zza(Field field) {
        return this.mName.equals(field.mName) && this.zzZE == field.zzZE;
    }

    private static Field zzbJ(String str) {
        return new Field(str, 1);
    }

    private static Field zzbK(String str) {
        return new Field(str, 2);
    }

    public static Field zzn(String str, int i) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2131707655:
                if (str.equals("accuracy")) {
                    obj = null;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    obj = 12;
                    break;
                }
                break;
            case -1930010315:
                if (str.equals("potassium")) {
                    obj = 29;
                    break;
                }
                break;
            case -1762597548:
                if (str.equals("vitamin_a")) {
                    obj = 40;
                    break;
                }
                break;
            case -1762597546:
                if (str.equals("vitamin_c")) {
                    obj = 41;
                    break;
                }
                break;
            case -1734926706:
                if (str.equals("cholesterol")) {
                    obj = 7;
                    break;
                }
                break;
            case -1655966961:
                if (str.equals("activity")) {
                    obj = 1;
                    break;
                }
                break;
            case -1569430471:
                if (str.equals("num_segments")) {
                    obj = 26;
                    break;
                }
                break;
            case -1439978388:
                if (str.equals("latitude")) {
                    obj = 18;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    obj = 14;
                    break;
                }
                break;
            case -1124148177:
                if (str.equals("fat.total")) {
                    obj = 38;
                    break;
                }
                break;
            case -1124076653:
                if (str.equals("fat.trans")) {
                    obj = 39;
                    break;
                }
                break;
            case -984531717:
                if (str.equals("fat.polyunsaturated")) {
                    obj = 28;
                    break;
                }
                break;
            case -921832806:
                if (str.equals("percentage")) {
                    obj = 27;
                    break;
                }
                break;
            case -897020359:
                if (str.equals("sodium")) {
                    obj = 34;
                    break;
                }
                break;
            case -791592328:
                if (str.equals("weight")) {
                    obj = 43;
                    break;
                }
                break;
            case -631448035:
                if (str.equals("average")) {
                    obj = 3;
                    break;
                }
                break;
            case -626344110:
                if (str.equals("high_longitude")) {
                    obj = 16;
                    break;
                }
                break;
            case -619868540:
                if (str.equals("low_longitude")) {
                    obj = 21;
                    break;
                }
                break;
            case -612488479:
                if (str.equals("dietary_fiber")) {
                    obj = 10;
                    break;
                }
                break;
            case -494782871:
                if (str.equals("high_latitude")) {
                    obj = 15;
                    break;
                }
                break;
            case -437053898:
                if (str.equals("meal_type")) {
                    obj = 23;
                    break;
                }
                break;
            case -309012605:
                if (str.equals("protein")) {
                    obj = 30;
                    break;
                }
                break;
            case -277306353:
                if (str.equals("circumference")) {
                    obj = 8;
                    break;
                }
                break;
            case -168965370:
                if (str.equals("calories")) {
                    obj = 6;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    obj = 44;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    obj = 45;
                    break;
                }
                break;
            case 122:
                if (str.equals("z")) {
                    obj = 46;
                    break;
                }
                break;
            case 97759:
                if (str.equals("bpm")) {
                    obj = 4;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    obj = 22;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    obj = 24;
                    break;
                }
                break;
            case 113135:
                if (str.equals("rpm")) {
                    obj = 32;
                    break;
                }
                break;
            case 3241160:
                if (str.equals("iron")) {
                    obj = 17;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    obj = 35;
                    break;
                }
                break;
            case 109792566:
                if (str.equals("sugar")) {
                    obj = 36;
                    break;
                }
                break;
            case 112903913:
                if (str.equals("watts")) {
                    obj = 42;
                    break;
                }
                break;
            case 125042491:
                if (str.equals("carbs.total")) {
                    obj = 37;
                    break;
                }
                break;
            case 137365935:
                if (str.equals("longitude")) {
                    obj = 19;
                    break;
                }
                break;
            case 198162679:
                if (str.equals("low_latitude")) {
                    obj = 20;
                    break;
                }
                break;
            case 215325440:
                if (str.equals("fat.saturated")) {
                    obj = 33;
                    break;
                }
                break;
            case 224520316:
                if (str.equals("edge_type")) {
                    obj = 13;
                    break;
                }
                break;
            case 288459765:
                if (str.equals("distance")) {
                    obj = 11;
                    break;
                }
                break;
            case 548373068:
                if (str.equals("calcium")) {
                    obj = 5;
                    break;
                }
                break;
            case 811264586:
                if (str.equals("revolutions")) {
                    obj = 31;
                    break;
                }
                break;
            case 829251210:
                if (str.equals("confidence")) {
                    obj = 9;
                    break;
                }
                break;
            case 1205114244:
                if (str.equals("fat.monounsaturated")) {
                    obj = 25;
                    break;
                }
                break;
            case 2036550306:
                if (str.equals("altitude")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return FIELD_ACCURACY;
            case 1:
                return FIELD_ACTIVITY;
            case 2:
                return FIELD_ALTITUDE;
            case 3:
                return FIELD_AVERAGE;
            case 4:
                return FIELD_BPM;
            case 5:
                return zzZx;
            case 6:
                return FIELD_CALORIES;
            case 7:
                return zzZo;
            case 8:
                return FIELD_CIRCUMFERENCE;
            case 9:
                return FIELD_CONFIDENCE;
            case 10:
                return zzZs;
            case 11:
                return FIELD_DISTANCE;
            case 12:
                return FIELD_DURATION;
            case 13:
                return zzZA;
            case 14:
                return FIELD_HEIGHT;
            case 15:
                return FIELD_HIGH_LATITUDE;
            case 16:
                return FIELD_HIGH_LONGITUDE;
            case 17:
                return zzZy;
            case 18:
                return FIELD_LATITUDE;
            case 19:
                return FIELD_LONGITUDE;
            case 20:
                return FIELD_LOW_LATITUDE;
            case 21:
                return FIELD_LOW_LONGITUDE;
            case 22:
                return FIELD_MAX;
            case 23:
                return zzZi;
            case 24:
                return FIELD_MIN;
            case 25:
                return zzZm;
            case 26:
                return zzZz;
            case 27:
                return FIELD_PERCENTAGE;
            case 28:
                return zzZl;
            case 29:
                return zzZq;
            case 30:
                return zzZu;
            case 31:
                return FIELD_REVOLUTIONS;
            case 32:
                return FIELD_RPM;
            case 33:
                return zzZk;
            case 34:
                return zzZp;
            case 35:
                return FIELD_SPEED;
            case 36:
                return zzZt;
            case 37:
                return zzZr;
            case 38:
                return zzZj;
            case 39:
                return zzZn;
            case 40:
                return zzZv;
            case 41:
                return zzZw;
            case 42:
                return FIELD_WATTS;
            case 43:
                return FIELD_WEIGHT;
            case 44:
                return zzZB;
            case 45:
                return zzZC;
            case 46:
                return zzZD;
            default:
                return new Field(str, i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Field) && zza((Field) obj));
    }

    public int getFormat() {
        return this.zzZE;
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

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.zzZE == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
