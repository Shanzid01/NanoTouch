package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzc;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public final class zzkb {
    public static final zzc<zzju> zzGR = new zzc();
    public static final String zzKO = zzjv.zzaL("com.google.cast.receiver");
    public static final String zzKP = zzjv.zzaL("com.google.cast.tp.connection");
    public static final Charset zzKQ;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        zzKQ = charset;
    }
}
