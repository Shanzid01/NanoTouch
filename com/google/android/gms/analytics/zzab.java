package com.google.android.gms.analytics;

import android.text.TextUtils;

public class zzab {
    private final String zzEA;
    private String zzEB;
    private String zzEC = "https:";
    private String zzEx;
    private final long zzEy;
    private final long zzEz;

    public zzab(String str, long j, long j2, String str2) {
        this.zzEx = str;
        this.zzEy = j;
        this.zzEz = j2;
        this.zzEA = str2;
    }

    public void zzap(String str) {
        this.zzEx = str;
    }

    public void zzaq(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzEB = str;
            if (str.toLowerCase().startsWith("http:")) {
                this.zzEC = "http:";
            }
        }
    }

    public String zzgr() {
        return this.zzEx;
    }

    public long zzgs() {
        return this.zzEy;
    }

    public long zzgt() {
        return this.zzEz;
    }

    public String zzgu() {
        return this.zzEC;
    }
}
