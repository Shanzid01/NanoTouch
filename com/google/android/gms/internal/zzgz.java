package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzgi
public final class zzgz {
    private int mOrientation = -1;
    private String zzrm;
    private List<String> zzwY;
    private String zzxC;
    private String zzxD;
    private List<String> zzxE;
    private String zzxF;
    private String zzxG;
    private List<String> zzxH;
    private long zzxI = -1;
    private boolean zzxJ = false;
    private final long zzxK = -1;
    private long zzxL = -1;
    private boolean zzxM = false;
    private boolean zzxN = false;
    private boolean zzxO = false;
    private boolean zzxP = true;

    static String zza(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long zzb(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    static List<String> zzc(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private boolean zzd(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void zzi(Map<String, List<String>> map) {
        this.zzxC = zza(map, "X-Afma-Ad-Size");
    }

    private void zzj(Map<String, List<String>> map) {
        List zzc = zzc(map, "X-Afma-Click-Tracking-Urls");
        if (zzc != null) {
            this.zzxE = zzc;
        }
    }

    private void zzk(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzxF = (String) list.get(0);
        }
    }

    private void zzl(Map<String, List<String>> map) {
        List zzc = zzc(map, "X-Afma-Tracking-Urls");
        if (zzc != null) {
            this.zzxH = zzc;
        }
    }

    private void zzm(Map<String, List<String>> map) {
        long zzb = zzb(map, "X-Afma-Interstitial-Timeout");
        if (zzb != -1) {
            this.zzxI = zzb;
        }
    }

    private void zzn(Map<String, List<String>> map) {
        this.zzxG = zza(map, "X-Afma-ActiveView");
    }

    private void zzo(Map<String, List<String>> map) {
        this.zzxN |= zzd(map, "X-Afma-Native");
    }

    private void zzp(Map<String, List<String>> map) {
        this.zzxM |= zzd(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzq(Map<String, List<String>> map) {
        this.zzxJ |= zzd(map, "X-Afma-Mediation");
    }

    private void zzr(Map<String, List<String>> map) {
        List zzc = zzc(map, "X-Afma-Manual-Tracking-Urls");
        if (zzc != null) {
            this.zzwY = zzc;
        }
    }

    private void zzs(Map<String, List<String>> map) {
        long zzb = zzb(map, "X-Afma-Refresh-Rate");
        if (zzb != -1) {
            this.zzxL = zzb;
        }
    }

    private void zzt(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = zzab.zzaO().zzey();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = zzab.zzaO().zzex();
            }
        }
    }

    private void zzu(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.zzxO = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzv(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.zzxP = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    public void zza(String str, Map<String, List<String>> map, String str2) {
        this.zzxD = str;
        this.zzrm = str2;
        zzh(map);
    }

    public void zzh(Map<String, List<String>> map) {
        zzi((Map) map);
        zzj(map);
        zzk(map);
        zzl(map);
        zzm(map);
        zzq(map);
        zzr(map);
        zzs(map);
        zzt(map);
        zzn(map);
        zzu(map);
        zzp(map);
        zzo(map);
        zzv(map);
    }

    public zzgq zzi(long j) {
        return new zzgq(this.zzxD, this.zzrm, this.zzxE, this.zzxH, this.zzxI, this.zzxJ, -1, this.zzwY, this.zzxL, this.mOrientation, this.zzxC, j, this.zzxF, this.zzxG, this.zzxM, this.zzxN, this.zzxO, this.zzxP, false);
    }
}
