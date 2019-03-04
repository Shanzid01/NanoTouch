package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class zzqw implements zzrc {
    private static final Uri zzarS;
    private final LogPrinter zzarT = new LogPrinter(4, "GA/LogCatTransport");

    class C13151 implements Comparator<zzqy> {
        final /* synthetic */ zzqw zzarU;

        C13151(zzqw com_google_android_gms_internal_zzqw) {
            this.zzarU = com_google_android_gms_internal_zzqw;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((zzqy) obj, (zzqy) obj2);
        }

        public int zza(zzqy com_google_android_gms_internal_zzqy, zzqy com_google_android_gms_internal_zzqy2) {
            return com_google_android_gms_internal_zzqy.getClass().getCanonicalName().compareTo(com_google_android_gms_internal_zzqy2.getClass().getCanonicalName());
        }
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzarS = builder.build();
    }

    public void zza(zzqx com_google_android_gms_internal_zzqx) {
        List<zzqy> arrayList = new ArrayList(com_google_android_gms_internal_zzqx.zzqQ());
        Collections.sort(arrayList, new C13151(this));
        StringBuilder stringBuilder = new StringBuilder();
        for (zzqy obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.zzarT.println(stringBuilder.toString());
    }

    public Uri zzqP() {
        return zzarS;
    }
}
