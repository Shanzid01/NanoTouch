package com.mopub.common.p050b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Json */
public class C1484g {
    public static Map<String, String> m4070a(String str) {
        Map<String, String> hashMap = new HashMap();
        if (str == null || str.equals("")) {
            return hashMap;
        }
        JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, jSONObject.getString(str2));
        }
        return hashMap;
    }

    public static String m4069a(Map<String, String> map) {
        if (map == null) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"");
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("\":\"");
            stringBuilder.append((String) entry.getValue());
            stringBuilder.append("\"");
            obj = null;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
