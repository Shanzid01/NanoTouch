package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@zzgi
public final class zzbv {
    private String zzqa;
    private List<String> zzqb;
    private int zzqc;

    public zzbv() {
        this((String) zzca.zzql.zzbY(), new ArrayList(), -1);
    }

    public zzbv(String str, List<String> list) {
        this(str, list, -1);
    }

    public zzbv(String str, List<String> list, int i) {
        List arrayList;
        this.zzqc = -1;
        if (list == null) {
            arrayList = new ArrayList();
        }
        this.zzqb = arrayList;
        this.zzqa = TextUtils.isEmpty(str) ? (String) zzca.zzql.zzbY() : str;
        this.zzqc = i;
    }

    public String zzbV() {
        return this.zzqa;
    }

    public List<String> zzbW() {
        return this.zzqb;
    }

    public int zzbX() {
        return this.zzqc;
    }
}
