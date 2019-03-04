package com.google.android.gms.internal;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.Device;

public class zznz {
    private static final ThreadLocal<String> zzZY = new ThreadLocal();

    private static Device zzb(Device device) {
        return new Device(zzbM(device.getManufacturer()), zzbM(device.getModel()), zzbM(device.getVersion()), device.getUid(), device.getType());
    }

    public static String zzbM(String str) {
        return zzu(str, (String) zzZY.get());
    }

    public static DataSource zzc(DataSource dataSource) {
        return (zzlM() || ((String) zzZY.get()).equals(dataSource.getAppPackageName())) ? dataSource : zzd(dataSource);
    }

    private static DataSource zzd(DataSource dataSource) {
        return new Builder().setDataType(dataSource.getDataType()).setName(dataSource.getName()).setType(dataSource.getType()).setDevice(dataSource.getDevice() == null ? null : zzb(dataSource.getDevice())).zzb(dataSource.zzlz()).setStreamName(dataSource.getStreamName()).build();
    }

    public static boolean zzlM() {
        String str = (String) zzZY.get();
        return str == null || str.startsWith(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    private static String zzu(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        Object obj = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, obj, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, obj, str.length(), str2.length());
        return Integer.toHexString(zzmc.zza(obj, 0, obj.length, 0));
    }
}
