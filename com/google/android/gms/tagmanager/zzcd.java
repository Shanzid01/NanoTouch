package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcd extends zzaj {
    private static final String ID = zza.REGEX_GROUP.toString();
    private static final String zzazH = zzb.ARG0.toString();
    private static final String zzazI = zzb.ARG1.toString();
    private static final String zzazJ = zzb.IGNORE_CASE.toString();
    private static final String zzazK = zzb.GROUP.toString();

    public zzcd() {
        super(ID, zzazH, zzazI);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzazH);
        zzd.zza com_google_android_gms_internal_zzd_zza2 = (zzd.zza) map.get(zzazI);
        if (com_google_android_gms_internal_zzd_zza == null || com_google_android_gms_internal_zzd_zza == zzde.zzuf() || com_google_android_gms_internal_zzd_zza2 == null || com_google_android_gms_internal_zzd_zza2 == zzde.zzuf()) {
            return zzde.zzuf();
        }
        int i = 64;
        if (zzde.zzk((zzd.zza) map.get(zzazJ)).booleanValue()) {
            i = 66;
        }
        zzd.zza com_google_android_gms_internal_zzd_zza3 = (zzd.zza) map.get(zzazK);
        int intValue;
        if (com_google_android_gms_internal_zzd_zza3 != null) {
            Long zzi = zzde.zzi(com_google_android_gms_internal_zzd_zza3);
            if (zzi == zzde.zzua()) {
                return zzde.zzuf();
            }
            intValue = zzi.intValue();
            if (intValue < 0) {
                return zzde.zzuf();
            }
        }
        intValue = 1;
        try {
            CharSequence zzg = zzde.zzg(com_google_android_gms_internal_zzd_zza);
            Object obj = null;
            Matcher matcher = Pattern.compile(zzde.zzg(com_google_android_gms_internal_zzd_zza2), i).matcher(zzg);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? zzde.zzuf() : zzde.zzx(obj);
        } catch (PatternSyntaxException e) {
            return zzde.zzuf();
        }
    }

    public boolean zzsD() {
        return true;
    }
}
