package com.google.analytics.tracking.android;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HitBuilder */
class at {
    static Map<String, String> m3810a(aw awVar, Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            ay a = awVar.m3824a((String) entry.getKey());
            if (a != null) {
                String a2 = a.m3828a((String) entry.getKey());
                if (a2 != null) {
                    String str = (String) entry.getValue();
                    if (a.m3829b() != null) {
                        str = a.m3829b().mo1190a(str);
                    }
                    if (!(str == null || str.equals(a.m3827a()))) {
                        hashMap.put(a2, str);
                    }
                }
            }
        }
        return hashMap;
    }

    static String m3808a(as asVar, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(asVar.m3802a());
        if (asVar.m3806c() > 0) {
            long c = j - asVar.m3806c();
            if (c >= 0) {
                stringBuilder.append("&").append("qt").append("=").append(c);
            }
        }
        stringBuilder.append("&").append("z").append("=").append(asVar.m3804b());
        return stringBuilder.toString();
    }

    static String m3809a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }
}
