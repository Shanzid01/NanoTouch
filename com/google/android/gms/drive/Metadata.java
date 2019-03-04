package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmm;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public String getAlternateLink() {
        return (String) zza(zzmi.zzVt);
    }

    public int getContentAvailability() {
        Integer num = (Integer) zza(zzmm.zzWk);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) zza(zzmk.zzWe);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zzmi.zzVu);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzkV();
    }

    public String getDescription() {
        return (String) zza(zzmi.zzVv);
    }

    public DriveId getDriveId() {
        return (DriveId) zza(zzmi.zzVs);
    }

    public String getEmbedLink() {
        return (String) zza(zzmi.zzVw);
    }

    public String getFileExtension() {
        return (String) zza(zzmi.zzVx);
    }

    public long getFileSize() {
        return ((Long) zza(zzmi.zzVy)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) zza(zzmk.zzWf);
    }

    public String getMimeType() {
        return (String) zza(zzmi.zzVM);
    }

    public Date getModifiedByMeDate() {
        return (Date) zza(zzmk.zzWh);
    }

    public Date getModifiedDate() {
        return (Date) zza(zzmk.zzWg);
    }

    public String getOriginalFilename() {
        return (String) zza(zzmi.zzVN);
    }

    public long getQuotaBytesUsed() {
        return ((Long) zza(zzmi.zzVS)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) zza(zzmk.zzWi);
    }

    public String getTitle() {
        return (String) zza(zzmi.zzVV);
    }

    public String getWebContentLink() {
        return (String) zza(zzmi.zzVX);
    }

    public String getWebViewLink() {
        return (String) zza(zzmi.zzVY);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zzmi.zzVD);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zzmi.zzVE);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zzmi.zzVB);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zzmm.zzWl);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zzmi.zzVF);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zzmi.zzVG);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) zza(zzmi.zzVH);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zzmi.zzVT);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zzmi.zzVK);
        return bool == null ? true : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zzmi.zzVW);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zzmi.zzVL);
        return bool == null ? false : bool.booleanValue();
    }

    public abstract <T> T zza(MetadataField<T> metadataField);
}
