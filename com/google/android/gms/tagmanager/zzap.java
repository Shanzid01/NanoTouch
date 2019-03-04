package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzap {
    private String zzEB;
    private final long zzEy;
    private final long zzEz;
    private final long zzayJ;

    zzap(long j, long j2, long j3) {
        this.zzEy = j;
        this.zzEz = j2;
        this.zzayJ = j3;
    }

    void zzaq(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzEB = str;
        }
    }

    long zzgs() {
        return this.zzEy;
    }

    long zztj() {
        return this.zzayJ;
    }

    String zztk() {
        return this.zzEB;
    }
}
