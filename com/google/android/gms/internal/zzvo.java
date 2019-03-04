package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.zzbf;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class zzvo {
    private String zzaya = "https://www.google-analytics.com";

    private String zzdv(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            zzbf.zzZ("Cannot encode the string: " + str);
            return "";
        }
    }

    public void zzdx(String str) {
        this.zzaya = str;
        zzbf.zzaa("The Ctfe server endpoint was changed to: " + str);
    }

    public String zzv(List<zzve> list) {
        return this.zzaya + "/gtm/android?" + zzw(list);
    }

    String zzw(List<zzve> list) {
        boolean z = true;
        if (list.size() > 1) {
            z = false;
        }
        zzx.zzO(z);
        if (list.isEmpty()) {
            return "";
        }
        zzve com_google_android_gms_internal_zzve = (zzve) list.get(0);
        String trim = !com_google_android_gms_internal_zzve.zzul().trim().equals("") ? com_google_android_gms_internal_zzve.zzul().trim() : "-1";
        StringBuilder stringBuilder = new StringBuilder();
        if (com_google_android_gms_internal_zzve.zzui() != null) {
            stringBuilder.append(com_google_android_gms_internal_zzve.zzui());
        } else {
            stringBuilder.append("id");
        }
        stringBuilder.append("=").append(zzdv(com_google_android_gms_internal_zzve.getContainerId())).append("&").append("pv").append("=").append(zzdv(trim));
        if (com_google_android_gms_internal_zzve.zzuk()) {
            stringBuilder.append("&gtm_debug=x");
        }
        return stringBuilder.toString();
    }
}
