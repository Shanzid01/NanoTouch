package com.mopub.mobileads.util;

import com.facebook.AppEventsConstants;
import com.mopub.common.p050b.C1489l;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* compiled from: HttpResponses */
public class C1558d {
    public static String m4662a(HttpResponse httpResponse, C1489l c1489l) {
        Header firstHeader = httpResponse.getFirstHeader(c1489l.getKey());
        return firstHeader != null ? firstHeader.getValue() : null;
    }

    public static boolean m4663a(HttpResponse httpResponse, C1489l c1489l, boolean z) {
        String a = C1558d.m4662a(httpResponse, c1489l);
        return a == null ? z : a.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    public static Integer m4664b(HttpResponse httpResponse, C1489l c1489l) {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        instance.setParseIntegerOnly(true);
        try {
            return Integer.valueOf(instance.parse(C1558d.m4662a(httpResponse, c1489l).trim()).intValue());
        } catch (Exception e) {
            return null;
        }
    }

    public static int m4661a(HttpResponse httpResponse, C1489l c1489l, int i) {
        Integer b = C1558d.m4664b(httpResponse, c1489l);
        return b == null ? i : b.intValue();
    }
}
