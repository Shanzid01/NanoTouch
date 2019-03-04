package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
    public static final Creator<SortOrder> CREATOR = new zzb();
    final int zzFG;
    final List<FieldWithSortOrder> zzWu;
    final boolean zzWv;

    public class Builder {
        private final List<FieldWithSortOrder> zzWu = new ArrayList();
        private boolean zzWv = false;

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.zzWu.add(new FieldWithSortOrder(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.zzWu.add(new FieldWithSortOrder(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.zzWu, this.zzWv);
        }
    }

    SortOrder(int i, List<FieldWithSortOrder> list, boolean z) {
        this.zzFG = i;
        this.zzWu = list;
        this.zzWv = z;
    }

    private SortOrder(List<FieldWithSortOrder> list, boolean z) {
        this(1, (List) list, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.zzWu), Boolean.valueOf(this.zzWv)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
