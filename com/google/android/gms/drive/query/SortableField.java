package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zzmk;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE = zzmk.zzWe;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME = zzmk.zzWf;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE = zzmk.zzWh;
    public static final SortableMetadataField<Date> MODIFIED_DATE = zzmk.zzWg;
    public static final SortableMetadataField<Long> QUOTA_USED = zzmi.zzVS;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE = zzmk.zzWi;
    public static final SortableMetadataField<String> TITLE = zzmi.zzVV;
}
