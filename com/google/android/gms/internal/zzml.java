package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzml extends zzj<DriveId> {
    public static final zzml zzWj = new zzml();

    private zzml() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzm(dataHolder, i, i2);
    }

    protected DriveId zzm(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.zziu().getLong("dbInstanceId");
        int i3 = DriveFolder.MIME_TYPE.equals(dataHolder.zzc(zzmi.zzVM.getName(), i, i2)) ? 1 : 0;
        String zzc = dataHolder.zzc("resourceId", i, i2);
        if (zzc != null && zzc.startsWith("generated-android-")) {
            zzc = null;
        }
        return new DriveId(zzc, Long.valueOf(dataHolder.zza("sqlId", i, i2)).longValue(), j, i3);
    }
}
