package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new zzd();
    final int zzFG;
    final ComparisonFilter<?> zzWA;
    final FieldOnlyFilter zzWB;
    final LogicalFilter zzWC;
    final NotFilter zzWD;
    final InFilter<?> zzWE;
    final MatchAllFilter zzWF;
    final HasFilter zzWG;
    final FullTextSearchFilter zzWH;
    private final Filter zzWI;

    FilterHolder(int i, ComparisonFilter<?> comparisonFilter, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> inFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter) {
        this.zzFG = i;
        this.zzWA = comparisonFilter;
        this.zzWB = fieldOnlyFilter;
        this.zzWC = logicalFilter;
        this.zzWD = notFilter;
        this.zzWE = inFilter;
        this.zzWF = matchAllFilter;
        this.zzWG = hasFilter;
        this.zzWH = fullTextSearchFilter;
        if (this.zzWA != null) {
            this.zzWI = this.zzWA;
        } else if (this.zzWB != null) {
            this.zzWI = this.zzWB;
        } else if (this.zzWC != null) {
            this.zzWI = this.zzWC;
        } else if (this.zzWD != null) {
            this.zzWI = this.zzWD;
        } else if (this.zzWE != null) {
            this.zzWI = this.zzWE;
        } else if (this.zzWF != null) {
            this.zzWI = this.zzWF;
        } else if (this.zzWG != null) {
            this.zzWI = this.zzWG;
        } else if (this.zzWH != null) {
            this.zzWI = this.zzWH;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        zzx.zzb((Object) filter, (Object) "Null filter.");
        this.zzFG = 2;
        this.zzWA = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzWB = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzWC = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzWD = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzWE = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzWF = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzWG = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzWH = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        if (this.zzWA == null && this.zzWB == null && this.zzWC == null && this.zzWD == null && this.zzWE == null && this.zzWF == null && this.zzWG == null && this.zzWH == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzWI = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzWI;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.zzWI});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
