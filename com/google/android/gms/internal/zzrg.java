package com.google.android.gms.internal;

import android.support.v4.p004b.C0059a;
import java.util.Map;

public final class zzrg extends zzqy<zzrg> {
    private String zzIO;
    public int zzasn;
    public int zzaso;
    public int zzasp;
    public int zztI;
    public int zztJ;

    public void setLanguage(String str) {
        this.zzIO = str;
    }

    public String toString() {
        Map c0059a = new C0059a();
        c0059a.put("language", this.zzIO);
        c0059a.put("screenColors", Integer.valueOf(this.zzasn));
        c0059a.put("screenWidth", Integer.valueOf(this.zztI));
        c0059a.put("screenHeight", Integer.valueOf(this.zztJ));
        c0059a.put("viewportWidth", Integer.valueOf(this.zzaso));
        c0059a.put("viewportHeight", Integer.valueOf(this.zzasp));
        return zzqy.zzG(c0059a);
    }

    public void zzgp(int i) {
        this.zztI = i;
    }

    public void zzgq(int i) {
        this.zztJ = i;
    }

    public int zzrb() {
        return this.zztI;
    }

    public int zzrc() {
        return this.zztJ;
    }
}
