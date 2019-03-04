package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class zzcf {
    private static int zzrd;
    private final Object zznh = new Object();
    final String zzrc;
    private final LinkedList<zzce> zzre;
    private zzce zzrf;

    public zzcf(String str) {
        this.zzrc = str;
        zzrd = ((Integer) zzca.zzqz.get()).intValue();
        synchronized (this.zznh) {
            this.zzre = new LinkedList();
        }
    }

    private zzce zza(long j) {
        return new zzce(j, null, null);
    }

    private static Map<String, String> zza(String str, StringBuilder stringBuilder) {
        Map<String, String> map = null;
        if (stringBuilder.length() > 0) {
            map = new LinkedHashMap();
            if (str != null) {
                map.put("action", str);
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            map.put("it", stringBuilder.toString());
        }
        return map;
    }

    public static Map<String, String> zza(zzcf... com_google_android_gms_internal_zzcfArr) {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder((zzrd * 10) * 20);
        for (int i = 0; i < com_google_android_gms_internal_zzcfArr.length; i++) {
            Map zzcs = com_google_android_gms_internal_zzcfArr[i].zzcs();
            if (zzcs != null) {
                if (i == 0) {
                    str = (String) zzcs.get("action");
                    stringBuilder.append((String) zzcs.get("it")).append(",");
                } else if ((zzcs.containsKey("action") || str == null) && (!zzcs.containsKey("action") || ((String) zzcs.get("action")).equals(str))) {
                    stringBuilder.append((String) zzcs.get("it")).append(",");
                } else {
                    throw new IllegalArgumentException("Can not merge report items for the tickers with different action names.");
                }
            }
        }
        return zza(str, stringBuilder);
    }

    private boolean zza(zzce com_google_android_gms_internal_zzce, long j, String... strArr) {
        synchronized (this.zznh) {
            for (String com_google_android_gms_internal_zzce2 : strArr) {
                this.zzre.add(new zzce(j, com_google_android_gms_internal_zzce2, com_google_android_gms_internal_zzce));
            }
        }
        return true;
    }

    public boolean zza(zzce com_google_android_gms_internal_zzce, String... strArr) {
        return (!zzab.zzaR().zzcd() || com_google_android_gms_internal_zzce == null) ? false : zza(com_google_android_gms_internal_zzce, zzab.zzaQ().elapsedRealtime(), strArr);
    }

    public zzce zzcq() {
        return !zzab.zzaR().zzcd() ? null : zza(zzab.zzaQ().elapsedRealtime());
    }

    public void zzcr() {
        this.zzrf = zzcq();
    }

    Map<String, String> zzcs() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.zznh) {
            Iterator it = this.zzre.iterator();
            while (it.hasNext()) {
                zzce com_google_android_gms_internal_zzce = (zzce) it.next();
                Long zzcn = com_google_android_gms_internal_zzce.zzcn();
                String zzco = com_google_android_gms_internal_zzce.zzco();
                com_google_android_gms_internal_zzce = com_google_android_gms_internal_zzce.zzcp();
                if (com_google_android_gms_internal_zzce != null && zzcn.longValue() > 0) {
                    stringBuilder.append(zzco).append('.').append(zzcn.longValue() - com_google_android_gms_internal_zzce.zzcn().longValue()).append(',');
                }
            }
            this.zzre.clear();
        }
        return zza(this.zzrc, stringBuilder);
    }

    public String zzct() {
        return this.zzrc;
    }

    public zzce zzcu() {
        return this.zzrf;
    }
}
