package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new zza();
    final int zzFG;
    final List<DriveSpace> zzUx;
    private final Set<DriveSpace> zzUy;
    final LogicalFilter zzWm;
    final String zzWn;
    final SortOrder zzWo;
    final List<String> zzWp;
    final boolean zzWq;

    public class Builder {
        private Set<DriveSpace> zzUy;
        private String zzWn;
        private SortOrder zzWo;
        private List<String> zzWp;
        private boolean zzWq;
        private final List<Filter> zzWr = new ArrayList();

        public Builder(Query query) {
            this.zzWr.add(query.getFilter());
            this.zzWn = query.getPageToken();
            this.zzWo = query.getSortOrder();
            this.zzWp = query.zzlb();
            this.zzWq = query.zzlc();
            this.zzUy = query.zzld();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzWr.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzWR, this.zzWr), this.zzWn, this.zzWo, this.zzWp, this.zzWq, this.zzUy);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzWn = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzWo = sortOrder;
            return this;
        }
    }

    Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2) {
        this(i, logicalFilter, str, sortOrder, list, z, list2, list2 == null ? null : new HashSet(list2));
    }

    private Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, Set<DriveSpace> set) {
        this.zzFG = i;
        this.zzWm = logicalFilter;
        this.zzWn = str;
        this.zzWo = sortOrder;
        this.zzWp = list;
        this.zzWq = z;
        this.zzUx = list2;
        this.zzUy = set;
    }

    private Query(LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, Set<DriveSpace> set) {
        this(1, logicalFilter, str, sortOrder, list, z, set == null ? null : new ArrayList(set), set);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzWm;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzWn;
    }

    public SortOrder getSortOrder() {
        return this.zzWo;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzWm, this.zzWo, this.zzWn, this.zzUx});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<String> zzlb() {
        return this.zzWp;
    }

    public boolean zzlc() {
        return this.zzWq;
    }

    public Set<DriveSpace> zzld() {
        return this.zzUy;
    }
}
