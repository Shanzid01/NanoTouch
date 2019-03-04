package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

@zzgi
public final class zzdb implements zzcv {
    private static int zza(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = zzbe.zzbD().zza(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            zzhx.zzac("Action missing from video GMSG.");
            return;
        }
        zzel zzeF = com_google_android_gms_internal_zzic.zzeF();
        if (zzeF == null) {
            zzhx.zzac("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int zza;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = com_google_android_gms_internal_zzic.getContext().getResources().getDisplayMetrics();
            zza = zza(displayMetrics, map, "x", 0);
            int zza2 = zza(displayMetrics, map, "y", 0);
            int zza3 = zza(displayMetrics, map, "w", -1);
            int zza4 = zza(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && zzeF.zzdb() == null) {
                zzeF.zzf(zza, zza2, zza3, zza4);
                return;
            } else {
                zzeF.zze(zza, zza2, zza3, zza4);
                return;
            }
        }
        zzeq zzdb = zzeF.zzdb();
        if (zzdb == null) {
            zzeq.zza(com_google_android_gms_internal_zzic, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = com_google_android_gms_internal_zzic.getContext().getResources().getDisplayMetrics();
            int zza5 = zza(displayMetrics, map, "x", 0);
            zza = zza(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza, 0);
            zzdb.zzb(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                zzhx.zzac("Enabled parameter missing from controls video GMSG.");
            } else {
                zzdb.zzu(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                zzhx.zzac("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzdb.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            zzdb.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            zzdb.zzdo();
        } else if ("pause".equalsIgnoreCase(str)) {
            zzdb.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            zzdb.play();
        } else if ("show".equalsIgnoreCase(str)) {
            zzdb.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            zzdb.zzK((String) map.get("src"));
        } else {
            zzhx.zzac("Unknown video action: " + str);
        }
    }
}
