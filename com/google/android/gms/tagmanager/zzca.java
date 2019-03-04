package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzca {
    private static zzca zzazx;
    private volatile String zzaxw;
    private volatile String zzazA;
    private volatile zza zzazy;
    private volatile String zzazz;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzca() {
        clear();
    }

    private String zzdf(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String zzm(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static zzca zztx() {
        zzca com_google_android_gms_tagmanager_zzca;
        synchronized (zzca.class) {
            if (zzazx == null) {
                zzazx = new zzca();
            }
            com_google_android_gms_tagmanager_zzca = zzazx;
        }
        return com_google_android_gms_tagmanager_zzca;
    }

    void clear() {
        this.zzazy = zza.NONE;
        this.zzazz = null;
        this.zzaxw = null;
        this.zzazA = null;
    }

    String getContainerId() {
        return this.zzaxw;
    }

    synchronized boolean zzl(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    zzbf.zzab("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.zzazy = zza.CONTAINER_DEBUG;
                    } else {
                        this.zzazy = zza.CONTAINER;
                    }
                    this.zzazA = zzm(uri);
                    if (this.zzazy == zza.CONTAINER || this.zzazy == zza.CONTAINER_DEBUG) {
                        this.zzazz = "/r?" + this.zzazA;
                    }
                    this.zzaxw = zzdf(this.zzazA);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        zzbf.zzac("Invalid preview uri: " + decode);
                        z = false;
                    } else if (zzdf(uri.getQuery()).equals(this.zzaxw)) {
                        zzbf.zzab("Exit preview mode for container: " + this.zzaxw);
                        this.zzazy = zza.NONE;
                        this.zzazz = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    zza zzty() {
        return this.zzazy;
    }

    String zztz() {
        return this.zzazz;
    }
}
