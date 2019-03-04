package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzcc {
    private final Context mContext;
    private final String zznf;
    private int zzqP;
    private int zzqQ;
    private int zzqR;
    private int zzqS;
    private String zzqT;
    private BlockingQueue<zzcf> zzqV;
    private ExecutorService zzqW;
    private LinkedHashMap<String, String> zzqX = new LinkedHashMap();

    class C11651 implements Runnable {
        final /* synthetic */ zzcc zzqY;

        C11651(zzcc com_google_android_gms_internal_zzcc) {
            this.zzqY = com_google_android_gms_internal_zzcc;
        }

        public void run() {
            if (!zzca.zzcb().isEmpty()) {
                this.zzqY.zze("eid", TextUtils.join(",", zzca.zzcb()));
            }
        }
    }

    class C11662 implements Runnable {
        final /* synthetic */ zzcc zzqY;

        C11662(zzcc com_google_android_gms_internal_zzcc) {
            this.zzqY = com_google_android_gms_internal_zzcc;
        }

        public void run() {
            this.zzqY.zzcm();
        }
    }

    public zzcc(Context context, String str, String str2, int i, int i2, int i3, int i4, Map<String, String> map, int i5) {
        this.mContext = context;
        this.zznf = str;
        this.zzqT = str2;
        this.zzqQ = i;
        this.zzqR = i2;
        this.zzqS = i3;
        zzk(i4);
        for (Entry entry : map.entrySet()) {
            zze((String) entry.getKey(), (String) entry.getValue());
        }
        if (i5 == 1) {
            zzck();
        }
        if (i5 == 2) {
            zzcl();
        }
        init();
    }

    private void init() {
        this.zzqV = new ArrayBlockingQueue(this.zzqQ);
        this.zzqW = Executors.newSingleThreadExecutor();
        this.zzqW.execute(new C11662(this));
    }

    private boolean zzb(Map<String, String> map) {
        boolean z = false;
        int i = 0;
        while (!z && i < this.zzqR) {
            try {
                Thread.sleep((long) this.zzqS);
                zzab.zzaM().zzc(this.mContext, this.zznf, zza(this.zzqT, map));
                z = true;
            } catch (Throwable e) {
                zzhx.zzd("CsiReporter:interrupted in sendReport()", e);
                Thread.currentThread().interrupt();
            }
            i++;
        }
        return z;
    }

    private void zzck() {
        zzca.zza(new C11651(this));
    }

    private void zzcl() {
        if (!zzca.zzca().isEmpty()) {
            zze("eid", TextUtils.join(",", zzca.zzca()));
        }
    }

    private void zzcm() {
        while (true) {
            try {
                List zzj = zzj(this.zzqP);
                if (zzj != null) {
                    for (Map zzb : zzc(zzj).values()) {
                        zzb(zzb);
                    }
                }
            } catch (Throwable e) {
                zzhx.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private List<zzcf> zzj(int i) {
        List<zzcf> arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.zzqV.take());
        }
        return arrayList;
    }

    private void zzk(int i) {
        if (i < 1) {
            zzhx.zzac("CsiReporter - too small batch size :" + i + ", changed to 1");
            i = 1;
        }
        if (i > this.zzqQ) {
            zzhx.zzac("CsiReporter - batch size :" + i + " bigger than buffer size, " + "change to buffer limit");
            i = this.zzqQ;
        }
        this.zzqP = i;
    }

    String zza(String str, Map<String, String> map) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public boolean zza(zzcf com_google_android_gms_internal_zzcf) {
        return this.zzqV.offer(com_google_android_gms_internal_zzcf);
    }

    Map<String, Map<String, String>> zzc(List<zzcf> list) {
        Map linkedHashMap = new LinkedHashMap();
        for (zzcf com_google_android_gms_internal_zzcf : list) {
            String zzct = com_google_android_gms_internal_zzcf.zzct();
            if (linkedHashMap.containsKey(zzct)) {
                ((List) linkedHashMap.get(zzct)).add(com_google_android_gms_internal_zzcf);
            } else {
                List arrayList = new ArrayList();
                arrayList.add(com_google_android_gms_internal_zzcf);
                linkedHashMap.put(zzct, arrayList);
            }
        }
        Map<String, Map<String, String>> linkedHashMap2 = new LinkedHashMap();
        for (Entry entry : linkedHashMap.entrySet()) {
            List list2 = (List) entry.getValue();
            Map linkedHashMap3 = new LinkedHashMap(this.zzqX);
            try {
                linkedHashMap3.putAll(zzcf.zza((zzcf[]) list2.toArray(new zzcf[list2.size()])));
                linkedHashMap2.put(entry.getKey(), linkedHashMap3);
            } catch (Throwable e) {
                zzhx.zzd("CsiReporter:failed to merge tickers:" + list2, e);
            }
        }
        return linkedHashMap2;
    }

    void zze(String str, String str2) {
        this.zzqX.put(str, str2);
    }
}
