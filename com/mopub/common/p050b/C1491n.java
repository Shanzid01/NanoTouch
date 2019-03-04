package com.mopub.common.p050b;

import java.io.InputStream;

/* compiled from: Strings */
public class C1491n {
    public static String m4087a(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[4096];
        int i = 0;
        while (i != -1) {
            stringBuffer.append(new String(bArr, 0, i));
            i = inputStream.read(bArr);
        }
        inputStream.close();
        return stringBuffer.toString();
    }

    public static boolean m4088a(String str) {
        if (str != null && str.length() == 0) {
            return true;
        }
        return false;
    }
}
