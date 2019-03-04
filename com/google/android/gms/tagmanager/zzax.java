package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class zzax extends zzaj {
    private static final String ID = com.google.android.gms.internal.zza.JOINER.toString();
    private static final String zzayC = zzb.ARG0.toString();
    private static final String zzayU = zzb.ITEM_SEPARATOR.toString();
    private static final String zzayV = zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String zzayW = zzb.ESCAPE.toString();

    enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzax() {
        super(ID, zzayC);
    }

    private String zza(String str, zza com_google_android_gms_tagmanager_zzax_zza, Set<Character> set) {
        switch (com_google_android_gms_tagmanager_zzax_zza) {
            case URL:
                try {
                    return zzdi.zzdv(str);
                } catch (Throwable e) {
                    zzbf.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void zza(StringBuilder stringBuilder, String str, zza com_google_android_gms_tagmanager_zzax_zza, Set<Character> set) {
        stringBuilder.append(zza(str, com_google_android_gms_tagmanager_zzax_zza, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public com.google.android.gms.internal.zzd.zza zzH(Map<String, com.google.android.gms.internal.zzd.zza> map) {
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza = (com.google.android.gms.internal.zzd.zza) map.get(zzayC);
        if (com_google_android_gms_internal_zzd_zza == null) {
            return zzde.zzuf();
        }
        zza com_google_android_gms_tagmanager_zzax_zza;
        Set set;
        com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza2 = (com.google.android.gms.internal.zzd.zza) map.get(zzayU);
        String zzg = com_google_android_gms_internal_zzd_zza2 != null ? zzde.zzg(com_google_android_gms_internal_zzd_zza2) : "";
        com_google_android_gms_internal_zzd_zza2 = (com.google.android.gms.internal.zzd.zza) map.get(zzayV);
        String zzg2 = com_google_android_gms_internal_zzd_zza2 != null ? zzde.zzg(com_google_android_gms_internal_zzd_zza2) : "=";
        zza com_google_android_gms_tagmanager_zzax_zza2 = zza.NONE;
        com_google_android_gms_internal_zzd_zza2 = (com.google.android.gms.internal.zzd.zza) map.get(zzayW);
        if (com_google_android_gms_internal_zzd_zza2 != null) {
            String zzg3 = zzde.zzg(com_google_android_gms_internal_zzd_zza2);
            if ("url".equals(zzg3)) {
                com_google_android_gms_tagmanager_zzax_zza = zza.URL;
                set = null;
            } else if ("backslash".equals(zzg3)) {
                com_google_android_gms_tagmanager_zzax_zza = zza.BACKSLASH;
                set = new HashSet();
                zza(set, zzg);
                zza(set, zzg2);
                set.remove(Character.valueOf('\\'));
            } else {
                zzbf.zzZ("Joiner: unsupported escape type: " + zzg3);
                return zzde.zzuf();
            }
        }
        set = null;
        com_google_android_gms_tagmanager_zzax_zza = com_google_android_gms_tagmanager_zzax_zza2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (com_google_android_gms_internal_zzd_zza.type) {
            case 2:
                Object obj = 1;
                com.google.android.gms.internal.zzd.zza[] com_google_android_gms_internal_zzd_zzaArr = com_google_android_gms_internal_zzd_zza.zzgw;
                int length = com_google_android_gms_internal_zzd_zzaArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.zzd.zza com_google_android_gms_internal_zzd_zza3 = com_google_android_gms_internal_zzd_zzaArr[i];
                    if (obj == null) {
                        stringBuilder.append(zzg);
                    }
                    zza(stringBuilder, zzde.zzg(com_google_android_gms_internal_zzd_zza3), com_google_android_gms_tagmanager_zzax_zza, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < com_google_android_gms_internal_zzd_zza.zzgx.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(zzg);
                    }
                    String zzg4 = zzde.zzg(com_google_android_gms_internal_zzd_zza.zzgx[i2]);
                    String zzg5 = zzde.zzg(com_google_android_gms_internal_zzd_zza.zzgy[i2]);
                    zza(stringBuilder, zzg4, com_google_android_gms_tagmanager_zzax_zza, set);
                    stringBuilder.append(zzg2);
                    zza(stringBuilder, zzg5, com_google_android_gms_tagmanager_zzax_zza, set);
                }
                break;
            default:
                zza(stringBuilder, zzde.zzg(com_google_android_gms_internal_zzd_zza), com_google_android_gms_tagmanager_zzax_zza, set);
                break;
        }
        return zzde.zzx(stringBuilder.toString());
    }

    public boolean zzsD() {
        return true;
    }
}
