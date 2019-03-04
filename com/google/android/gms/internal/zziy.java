package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class zziy {
    private static final String[] zzGf = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzGg = new HashMap(zzGf.length);

    static {
        int i = 0;
        while (i < zzGf.length) {
            zzGg.put(zzGf[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzV(int i) {
        return (i < 0 || i >= zzGf.length) ? null : zzGf[i];
    }

    public static int zzay(String str) {
        Integer num = (Integer) zzGg.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzgW() {
        return zzGf.length;
    }
}
