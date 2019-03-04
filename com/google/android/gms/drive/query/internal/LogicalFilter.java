package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR = new zzj();
    final int zzFG;
    final List<FilterHolder> zzWK;
    private List<Filter> zzWr;
    final Operator zzWw;

    LogicalFilter(int i, Operator operator, List<FilterHolder> list) {
        this.zzFG = i;
        this.zzWw = operator;
        this.zzWK = list;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... filterArr) {
        this.zzFG = 1;
        this.zzWw = operator;
        this.zzWK = new ArrayList(filterArr.length + 1);
        this.zzWK.add(new FilterHolder(filter));
        this.zzWr = new ArrayList(filterArr.length + 1);
        this.zzWr.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzWK.add(new FilterHolder(filter2));
            this.zzWr.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> iterable) {
        this.zzFG = 1;
        this.zzWw = operator;
        this.zzWr = new ArrayList();
        this.zzWK = new ArrayList();
        for (Filter filter : iterable) {
            this.zzWr.add(filter);
            this.zzWK.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public <T> T zza(zzf<T> com_google_android_gms_drive_query_internal_zzf_T) {
        List arrayList = new ArrayList();
        for (FilterHolder filter : this.zzWK) {
            arrayList.add(filter.getFilter().zza(com_google_android_gms_drive_query_internal_zzf_T));
        }
        return com_google_android_gms_drive_query_internal_zzf_T.zzb(this.zzWw, arrayList);
    }
}
