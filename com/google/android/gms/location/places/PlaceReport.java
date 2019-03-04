package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;

public class PlaceReport implements SafeParcelable {
    public static final PlaceReportCreator CREATOR = new PlaceReportCreator();
    private final String mTag;
    final int zzFG;
    private final String zzanM;
    private final String zzanN;

    PlaceReport(int i, String str, String str2, String str3) {
        this.zzFG = i;
        this.zzanM = str;
        this.mTag = str2;
        this.zzanN = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzf(str, str2, FitnessActivities.UNKNOWN);
    }

    private static boolean zzcm(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals(FitnessActivities.UNKNOWN)) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzf(String str, String str2, String str3) {
        zzx.zzbn(str);
        zzx.zzbn(str2);
        zzx.zzbn(str3);
        zzx.zzb(zzcm(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        PlaceReportCreator placeReportCreator = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzw.equal(this.zzanM, placeReport.zzanM) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzanN, placeReport.zzanN);
    }

    public String getPlaceId() {
        return this.zzanM;
    }

    public String getSource() {
        return this.zzanN;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanM, this.mTag, this.zzanN);
    }

    public String toString() {
        zza zzk = zzw.zzk(this);
        zzk.zza("placeId", this.zzanM);
        zzk.zza("tag", this.mTag);
        if (!FitnessActivities.UNKNOWN.equals(this.zzanN)) {
            zzk.zza("source", this.zzanN);
        }
        return zzk.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlaceReportCreator placeReportCreator = CREATOR;
        PlaceReportCreator.zza(this, parcel, i);
    }
}
