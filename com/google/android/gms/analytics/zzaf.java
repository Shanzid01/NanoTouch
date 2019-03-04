package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class zzaf {
    private final Map<String, Integer> zzEO = new HashMap();
    private final Map<String, String> zzEP = new HashMap();
    private final boolean zzEQ;
    private final String zzER;

    public zzaf(String str, boolean z) {
        this.zzEQ = z;
        this.zzER = str;
    }

    public void zze(String str, int i) {
        if (this.zzEQ) {
            Integer num = (Integer) this.zzEO.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.zzEO.put(str, Integer.valueOf(num.intValue() + i));
        }
    }

    public String zzgx() {
        if (!this.zzEQ) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zzER);
        for (String str : this.zzEO.keySet()) {
            stringBuilder.append("&").append(str).append("=").append(this.zzEO.get(str));
        }
        for (String str2 : this.zzEP.keySet()) {
            stringBuilder.append("&").append(str2).append("=").append((String) this.zzEP.get(str2));
        }
        return stringBuilder.toString();
    }

    public void zzk(String str, String str2) {
        if (this.zzEQ && !TextUtils.isEmpty(str)) {
            this.zzEP.put(str, str2);
        }
    }
}
