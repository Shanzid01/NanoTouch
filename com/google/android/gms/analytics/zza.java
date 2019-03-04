package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzra;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

class zza implements zzq {
    private final zzra zzAM;
    private final zzk zzAN;
    private Info zzAO;
    private long zzAP;
    private String zzAQ;
    private boolean zzAR = false;
    private Object zzAS = new Object();

    zza(zzra com_google_android_gms_internal_zzra, zzk com_google_android_gms_analytics_zzk) {
        zzx.zzl(com_google_android_gms_internal_zzra);
        zzx.zzl(com_google_android_gms_analytics_zzk);
        this.zzAM = com_google_android_gms_internal_zzra;
        this.zzAN = com_google_android_gms_analytics_zzk;
    }

    static String zzB(Context context) {
        String str = null;
        try {
            FileInputStream openFileInput = context.openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzae.zzac("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                context.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzae.zzaa("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    str = str2;
                    zzae.zzac("Error reading Hash file, deleting it.");
                    context.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            zzae.zzac("Error reading Hash file, deleting it.");
            context.deleteFile("gaClientIdData");
            return str;
        }
    }

    private boolean zza(Info info, Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String value = this.zzAN.getValue("&cid");
        synchronized (this.zzAS) {
            if (!this.zzAR) {
                this.zzAQ = zzB(this.zzAM.getContext());
                this.zzAR = true;
            } else if (TextUtils.isEmpty(this.zzAQ)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    boolean zzai = zzai(id + value);
                    return zzai;
                }
                this.zzAQ = zzah(str + value);
            }
            Object zzah = zzah(id + value);
            if (TextUtils.isEmpty(zzah)) {
                return false;
            } else if (zzah.equals(this.zzAQ)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.zzAQ)) {
                    str = value;
                } else {
                    zzae.zzab("Resetting the client id because Advertising Id changed.");
                    str = this.zzAN.zzfw();
                    zzae.zzab("New client Id: " + str);
                }
                zzai = zzai(id + str);
                return zzai;
            }
        }
    }

    static String zzah(String str) {
        if (zzan.zzav("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzan.zzav("MD5").digest(str.getBytes()))});
    }

    private boolean zzai(String str) {
        try {
            String zzah = zzah(str);
            zzae.zzab("Storing hashed adid.");
            FileOutputStream openFileOutput = this.zzAM.getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzah.getBytes());
            openFileOutput.close();
            this.zzAQ = zzah;
            return true;
        } catch (FileNotFoundException e) {
            zzae.zzZ("Error creating hash file.");
            return false;
        } catch (IOException e2) {
            zzae.zzZ("Error writing to hash file.");
            return false;
        }
    }

    public String getValue(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.zzAP) > 1000) {
            Info zzeZ = zzeZ();
            if (zza(this.zzAO, zzeZ)) {
                this.zzAO = zzeZ;
            } else {
                this.zzAO = new Info("", false);
            }
            this.zzAP = currentTimeMillis;
        }
        if (this.zzAO != null) {
            if ("&adid".equals(str)) {
                return this.zzAO.getId();
            }
            if ("&ate".equals(str)) {
                return this.zzAO.isLimitAdTrackingEnabled() ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
        }
        return null;
    }

    Info zzeZ() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzAM.getContext());
        } catch (IllegalStateException e) {
            zzae.zzac("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (GooglePlayServicesRepairableException e2) {
            zzae.zzac("GooglePlayServicesRepairableException getting Ad Id Info");
        } catch (IOException e3) {
            zzae.zzac("IOException getting Ad Id Info");
        } catch (GooglePlayServicesNotAvailableException e4) {
            zzae.zzac("GooglePlayServicesNotAvailableException getting Ad Id Info");
        } catch (Throwable th) {
            zzae.zzac("Unknown exception. Could not get the ad Id.");
        }
        return info;
    }
}
