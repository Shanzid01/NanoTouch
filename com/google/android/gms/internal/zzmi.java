package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.ParentDriveIdSet;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzm;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class zzmi {
    public static final MetadataField<String> zzVA = new zzn("indexableText", 4300000);
    public static final MetadataField<Boolean> zzVB = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
    public static final MetadataField<Boolean> zzVC = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
    public static final MetadataField<Boolean> zzVD = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
    public static final MetadataField<Boolean> zzVE = new C12631("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000);
    public static final zzb zzVF = new zzb("isPinned", 4100000);
    public static final MetadataField<Boolean> zzVG = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
    public static final MetadataField<Boolean> zzVH = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
    public static final MetadataField<Boolean> zzVI = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField<Boolean> zzVJ = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField<Boolean> zzVK = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
    public static final MetadataField<Boolean> zzVL = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
    public static final zzc zzVM = new zzc("mimeType", 4100000);
    public static final MetadataField<String> zzVN = new zzn("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzVO = new zzm("ownerNames", 4300000);
    public static final zzo zzVP = new zzo("lastModifyingUser", 6000000);
    public static final zzo zzVQ = new zzo("sharingUser", 6000000);
    public static final zzd zzVR = new zzd(4100000);
    public static final zze zzVS = new zze("quotaBytesUsed", 4300000);
    public static final zzg zzVT = new zzg("starred", 4100000);
    public static final MetadataField<com.google.android.gms.common.data.zza> zzVU = new C12642("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
    public static final zzh zzVV = new zzh(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final zzi zzVW = new zzi("trashed", 4100000);
    public static final MetadataField<String> zzVX = new zzn("webContentLink", 4300000);
    public static final MetadataField<String> zzVY = new zzn("webViewLink", 4300000);
    public static final MetadataField<String> zzVZ = new zzn("uniqueIdentifier", 5000000);
    public static final MetadataField<DriveId> zzVs = zzml.zzWj;
    public static final MetadataField<String> zzVt = new zzn("alternateLink", 4300000);
    public static final zza zzVu = new zza(5000000);
    public static final MetadataField<String> zzVv = new zzn(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField<String> zzVw = new zzn("embedLink", 4300000);
    public static final MetadataField<String> zzVx = new zzn("fileExtension", 4300000);
    public static final MetadataField<Long> zzVy = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
    public static final MetadataField<Boolean> zzVz = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzWa = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
    public static final MetadataField<String> zzWb = new zzn("role", 6000000);
    public static final MetadataField<String> zzWc = new zzn("md5Checksum", 7000000);
    public static final zzf zzWd = new zzf(7000000);

    final class C12631 extends com.google.android.gms.drive.metadata.internal.zzb {
        C12631(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzb("trashed", i, i2) == 2);
        }
    }

    final class C12642 extends zzj<com.google.android.gms.common.data.zza> {
        C12642(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzk(dataHolder, i, i2);
        }

        protected com.google.android.gms.common.data.zza zzk(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    public class zza extends zzmj implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    public class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public class zzc extends zzn implements SearchableMetadataField<String> {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    public class zzd extends com.google.android.gms.drive.metadata.internal.zzi<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public zzd(int i) {
            super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId"}), i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzd(dataHolder, i, i2);
        }

        protected Collection<DriveId> zzd(DataHolder dataHolder, int i, int i2) {
            Bundle zziu = dataHolder.zziu();
            List parcelableArrayList = zziu.getParcelableArrayList("parentsExtra");
            if (parcelableArrayList == null) {
                return null;
            }
            return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzs(zziu.getLong("dbInstanceId"));
        }

        protected /* synthetic */ Object zzl(Bundle bundle) {
            return zzq(bundle);
        }

        protected Collection<DriveId> zzq(Bundle bundle) {
            Collection zzq = super.zzq(bundle);
            return zzq == null ? null : new HashSet(zzq);
        }
    }

    public class zze extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField<Long> {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    public class zzf extends com.google.android.gms.drive.metadata.internal.zzi<DriveSpace> {
        public zzf(int i) {
            super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzd(dataHolder, i, i2);
        }

        protected Collection<DriveSpace> zzd(DataHolder dataHolder, int i, int i2) {
            Collection arrayList = new ArrayList();
            if (dataHolder.zzd("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzSl);
            }
            if (dataHolder.zzd("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzSm);
            }
            if (dataHolder.zzd("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzSn);
            }
            return arrayList;
        }
    }

    public class zzg extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public class zzh extends zzn implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzh(String str, int i) {
            super(str, i);
        }
    }

    public class zzi extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzi(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzb(getName(), i, i2) != 0);
        }
    }
}
