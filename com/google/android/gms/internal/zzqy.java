package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class zzqy<T extends zzqy> {
    protected static String zzG(Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : new TreeMap(map).entrySet()) {
            Object value = entry.getValue();
            if (value != null && (!((value instanceof String) && TextUtils.isEmpty((String) value)) && (!((value instanceof Integer) && ((Integer) value).intValue() == 0) && (!((value instanceof Long) && ((Long) value).longValue() == 0) && (!((value instanceof Double) && ((Double) value).doubleValue() == 0.0d) && (!(value instanceof Boolean) || ((Boolean) value).booleanValue())))))) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append('=');
                stringBuffer.append(value);
            }
        }
        return stringBuffer.toString();
    }
}
