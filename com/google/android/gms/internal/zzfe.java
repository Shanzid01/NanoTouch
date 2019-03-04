package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.internal.zzfn.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgi
public class zzfe extends zza {
    private Context mContext;
    private String zznf;
    private String zzvf;
    private ArrayList<String> zzvg;

    public zzfe(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzvf = str;
        this.zzvg = arrayList;
        this.zznf = str2;
        this.mContext = context;
    }

    public String getProductId() {
        return this.zzvf;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            zzdy();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.zzvf);
        hashMap.put("status", String.valueOf(zzs(i)));
        List linkedList = new LinkedList();
        Iterator it = this.zzvg.iterator();
        while (it.hasNext()) {
            linkedList.add(zza((String) it.next(), hashMap));
        }
        zzab.zzaM().zza(this.mContext, this.zznf, linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            zzdy();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(i));
        hashMap.put("sku", this.zzvf);
        List linkedList = new LinkedList();
        Iterator it = this.zzvg.iterator();
        while (it.hasNext()) {
            linkedList.add(zza((String) it.next(), hashMap));
        }
        zzab.zzaM().zza(this.mContext, this.zznf, linkedList);
    }

    protected String zza(String str, HashMap<String, String> hashMap) {
        Object obj;
        Object obj2 = "";
        try {
            obj = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            zzhx.zzd("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzab.zzaP().zzef().zzeo();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{zzab.zzaP().getSessionId()})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{r2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.zznf})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    void zzdy() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.zzvf, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            zzhx.zzac("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzhx.zzac("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            zzhx.zzd("Fail to report a conversion.", e3);
        }
    }

    protected int zzs(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }
}
