package com.google.android.gms.tagmanager;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzd.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzde {
    private static final Object zzaBl = null;
    private static Long zzaBm = new Long(0);
    private static Double zzaBn = new Double(0.0d);
    private static zzdd zzaBo = zzdd.zzI(0);
    private static String zzaBp = new String("");
    private static Boolean zzaBq = new Boolean(false);
    private static List<Object> zzaBr = new ArrayList(0);
    private static Map<Object, Object> zzaBs = new HashMap();
    private static zza zzaBt = zzx(zzaBp);

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzbf.zzZ("getDouble received non-Number");
        return 0.0d;
    }

    private static long zzA(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbf.zzZ("getInt64 received non-Number");
        return 0;
    }

    public static zza zzdo(String str) {
        zza com_google_android_gms_internal_zzd_zza = new zza();
        com_google_android_gms_internal_zzd_zza.type = 5;
        com_google_android_gms_internal_zzd_zza.zzgA = str;
        return com_google_android_gms_internal_zzd_zza;
    }

    private static zzdd zzdp(String str) {
        try {
            return zzdd.zzdn(str);
        } catch (NumberFormatException e) {
            zzbf.zzZ("Failed to convert '" + str + "' to a number.");
            return zzaBo;
        }
    }

    private static Long zzdq(String str) {
        zzdd zzdp = zzdp(str);
        return zzdp == zzaBo ? zzaBm : Long.valueOf(zzdp.longValue());
    }

    private static Double zzdr(String str) {
        zzdd zzdp = zzdp(str);
        return zzdp == zzaBo ? zzaBn : Double.valueOf(zzdp.doubleValue());
    }

    private static Boolean zzds(String str) {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzaBq;
    }

    public static String zzg(zza com_google_android_gms_internal_zzd_zza) {
        return zzs(zzl(com_google_android_gms_internal_zzd_zza));
    }

    public static zzdd zzh(zza com_google_android_gms_internal_zzd_zza) {
        return zzt(zzl(com_google_android_gms_internal_zzd_zza));
    }

    public static Long zzi(zza com_google_android_gms_internal_zzd_zza) {
        return zzu(zzl(com_google_android_gms_internal_zzd_zza));
    }

    public static Double zzj(zza com_google_android_gms_internal_zzd_zza) {
        return zzv(zzl(com_google_android_gms_internal_zzd_zza));
    }

    public static Boolean zzk(zza com_google_android_gms_internal_zzd_zza) {
        return zzw(zzl(com_google_android_gms_internal_zzd_zza));
    }

    public static Object zzl(zza com_google_android_gms_internal_zzd_zza) {
        int i = 0;
        if (com_google_android_gms_internal_zzd_zza == null) {
            return zzaBl;
        }
        zza[] com_google_android_gms_internal_zzd_zzaArr;
        int length;
        switch (com_google_android_gms_internal_zzd_zza.type) {
            case 1:
                return com_google_android_gms_internal_zzd_zza.zzgv;
            case 2:
                ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzd_zza.zzgw.length);
                com_google_android_gms_internal_zzd_zzaArr = com_google_android_gms_internal_zzd_zza.zzgw;
                length = com_google_android_gms_internal_zzd_zzaArr.length;
                while (i < length) {
                    Object zzl = zzl(com_google_android_gms_internal_zzd_zzaArr[i]);
                    if (zzl == zzaBl) {
                        return zzaBl;
                    }
                    arrayList.add(zzl);
                    i++;
                }
                return arrayList;
            case 3:
                if (com_google_android_gms_internal_zzd_zza.zzgx.length != com_google_android_gms_internal_zzd_zza.zzgy.length) {
                    zzbf.zzZ("Converting an invalid value to object: " + com_google_android_gms_internal_zzd_zza.toString());
                    return zzaBl;
                }
                Map hashMap = new HashMap(com_google_android_gms_internal_zzd_zza.zzgy.length);
                while (i < com_google_android_gms_internal_zzd_zza.zzgx.length) {
                    Object zzl2 = zzl(com_google_android_gms_internal_zzd_zza.zzgx[i]);
                    Object zzl3 = zzl(com_google_android_gms_internal_zzd_zza.zzgy[i]);
                    if (zzl2 == zzaBl || zzl3 == zzaBl) {
                        return zzaBl;
                    }
                    hashMap.put(zzl2, zzl3);
                    i++;
                }
                return hashMap;
            case 4:
                zzbf.zzZ("Trying to convert a macro reference to object");
                return zzaBl;
            case 5:
                zzbf.zzZ("Trying to convert a function id to object");
                return zzaBl;
            case 6:
                return Long.valueOf(com_google_android_gms_internal_zzd_zza.zzgB);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                com_google_android_gms_internal_zzd_zzaArr = com_google_android_gms_internal_zzd_zza.zzgD;
                length = com_google_android_gms_internal_zzd_zzaArr.length;
                while (i < length) {
                    String zzg = zzg(com_google_android_gms_internal_zzd_zzaArr[i]);
                    if (zzg == zzaBp) {
                        return zzaBl;
                    }
                    stringBuffer.append(zzg);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(com_google_android_gms_internal_zzd_zza.zzgC);
            default:
                zzbf.zzZ("Failed to convert a value of type: " + com_google_android_gms_internal_zzd_zza.type);
                return zzaBl;
        }
    }

    public static String zzs(Object obj) {
        return obj == null ? zzaBp : obj.toString();
    }

    public static zzdd zzt(Object obj) {
        return obj instanceof zzdd ? (zzdd) obj : zzz(obj) ? zzdd.zzI(zzA(obj)) : zzy(obj) ? zzdd.zza(Double.valueOf(getDouble(obj))) : zzdp(zzs(obj));
    }

    public static Object zztZ() {
        return zzaBl;
    }

    public static Long zzu(Object obj) {
        return zzz(obj) ? Long.valueOf(zzA(obj)) : zzdq(zzs(obj));
    }

    public static Long zzua() {
        return zzaBm;
    }

    public static Double zzub() {
        return zzaBn;
    }

    public static Boolean zzuc() {
        return zzaBq;
    }

    public static zzdd zzud() {
        return zzaBo;
    }

    public static String zzue() {
        return zzaBp;
    }

    public static zza zzuf() {
        return zzaBt;
    }

    public static Double zzv(Object obj) {
        return zzy(obj) ? Double.valueOf(getDouble(obj)) : zzdr(zzs(obj));
    }

    public static Boolean zzw(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzds(zzs(obj));
    }

    public static zza zzx(Object obj) {
        boolean z = false;
        zza com_google_android_gms_internal_zzd_zza = new zza();
        if (obj instanceof zza) {
            return (zza) obj;
        }
        if (obj instanceof String) {
            com_google_android_gms_internal_zzd_zza.type = 1;
            com_google_android_gms_internal_zzd_zza.zzgv = (String) obj;
        } else if (obj instanceof List) {
            com_google_android_gms_internal_zzd_zza.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object zzx : list) {
                zza zzx2 = zzx(zzx);
                if (zzx2 == zzaBt) {
                    return zzaBt;
                }
                r0 = r1 || zzx2.zzgF;
                r5.add(zzx2);
                r1 = r0;
            }
            com_google_android_gms_internal_zzd_zza.zzgw = (zza[]) r5.toArray(new zza[0]);
            z = r1;
        } else if (obj instanceof Map) {
            com_google_android_gms_internal_zzd_zza.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                zza zzx3 = zzx(entry.getKey());
                zza zzx4 = zzx(entry.getValue());
                if (zzx3 == zzaBt || zzx4 == zzaBt) {
                    return zzaBt;
                }
                r0 = r1 || zzx3.zzgF || zzx4.zzgF;
                r5.add(zzx3);
                arrayList.add(zzx4);
                r1 = r0;
            }
            com_google_android_gms_internal_zzd_zza.zzgx = (zza[]) r5.toArray(new zza[0]);
            com_google_android_gms_internal_zzd_zza.zzgy = (zza[]) arrayList.toArray(new zza[0]);
            z = r1;
        } else if (zzy(obj)) {
            com_google_android_gms_internal_zzd_zza.type = 1;
            com_google_android_gms_internal_zzd_zza.zzgv = obj.toString();
        } else if (zzz(obj)) {
            com_google_android_gms_internal_zzd_zza.type = 6;
            com_google_android_gms_internal_zzd_zza.zzgB = zzA(obj);
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzd_zza.type = 8;
            com_google_android_gms_internal_zzd_zza.zzgC = ((Boolean) obj).booleanValue();
        } else {
            zzbf.zzZ("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return zzaBt;
        }
        com_google_android_gms_internal_zzd_zza.zzgF = z;
        return com_google_android_gms_internal_zzd_zza;
    }

    private static boolean zzy(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzdd) && ((zzdd) obj).zztU());
    }

    private static boolean zzz(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzdd) && ((zzdd) obj).zztV());
    }
}
