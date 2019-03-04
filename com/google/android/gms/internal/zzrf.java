package com.google.android.gms.internal;

import android.support.v4.p004b.C0059a;
import java.util.Map;

public final class zzrf extends zzqy<zzrf> {
    private String zzBa;
    private String zzBb;
    private String zzBc;
    private String zzBd;

    public void setAppId(String str) {
        this.zzBc = str;
    }

    public void setAppInstallerId(String str) {
        this.zzBd = str;
    }

    public void setAppName(String str) {
        this.zzBa = str;
    }

    public void setAppVersion(String str) {
        this.zzBb = str;
    }

    public String toString() {
        Map c0059a = new C0059a();
        c0059a.put("appName", this.zzBa);
        c0059a.put("appVersion", this.zzBb);
        c0059a.put("appId", this.zzBc);
        c0059a.put("appInstallerId", this.zzBd);
        return zzqy.zzG(c0059a);
    }

    public String zzga() {
        return this.zzBa;
    }

    public String zzgc() {
        return this.zzBb;
    }

    public String zznE() {
        return this.zzBc;
    }

    public String zzra() {
        return this.zzBd;
    }
}
