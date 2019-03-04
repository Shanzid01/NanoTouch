package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zzmk;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = zzmi.zzVF;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = zzmk.zzWf;
    public static final SearchableMetadataField<String> MIME_TYPE = zzmi.zzVM;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = zzmk.zzWg;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = zzmi.zzVR;
    public static final SearchableMetadataField<Boolean> STARRED = zzmi.zzVT;
    public static final SearchableMetadataField<String> TITLE = zzmi.zzVV;
    public static final SearchableMetadataField<Boolean> TRASHED = zzmi.zzVW;
    public static final SearchableOrderedMetadataField<Date> zzWs = zzmk.zzWi;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzWt = zzmi.zzVu;
}
