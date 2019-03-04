package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import com.google.android.gms.internal.zzd.zza;
import com.google.android.gms.internal.zzvl.zzb;
import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzd;
import com.google.android.gms.internal.zzvl.zze;
import com.google.android.gms.internal.zzvl.zzf;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzde;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzvf {
    static zza zza(int i, JSONArray jSONArray, zza[] com_google_android_gms_internal_zzd_zzaArr, Set<Integer> set) {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzdw("Value cycle detected. Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        Object zza = zza(jSONArray, i, "values");
        if (com_google_android_gms_internal_zzd_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzd_zzaArr[i];
        }
        set.add(Integer.valueOf(i));
        zza com_google_android_gms_internal_zzd_zza = new zza();
        JSONArray jSONArray2;
        if (zza instanceof JSONArray) {
            jSONArray2 = (JSONArray) zza;
            com_google_android_gms_internal_zzd_zza.type = 2;
            com_google_android_gms_internal_zzd_zza.zzgF = true;
            com_google_android_gms_internal_zzd_zza.zzgw = new zza[jSONArray2.length()];
            while (i2 < com_google_android_gms_internal_zzd_zza.zzgw.length) {
                com_google_android_gms_internal_zzd_zza.zzgw[i2] = zza(jSONArray2.getInt(i2), jSONArray, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                i2++;
            }
        } else if (zza instanceof JSONObject) {
            int i3;
            JSONObject jSONObject = (JSONObject) zza;
            JSONArray optJSONArray = jSONObject.optJSONArray("escaping");
            if (optJSONArray != null) {
                com_google_android_gms_internal_zzd_zza.zzgE = new int[optJSONArray.length()];
                for (i3 = 0; i3 < com_google_android_gms_internal_zzd_zza.zzgE.length; i3++) {
                    com_google_android_gms_internal_zzd_zza.zzgE[i3] = optJSONArray.getInt(i3);
                }
            }
            if (jSONObject.has("function_id")) {
                com_google_android_gms_internal_zzd_zza.type = 5;
                com_google_android_gms_internal_zzd_zza.zzgA = jSONObject.getString("function_id");
            } else if (jSONObject.has("macro_reference")) {
                com_google_android_gms_internal_zzd_zza.type = 4;
                com_google_android_gms_internal_zzd_zza.zzgF = true;
                com_google_android_gms_internal_zzd_zza.zzgz = zzde.zzg(zza(jSONObject.getInt("macro_reference"), jSONArray, com_google_android_gms_internal_zzd_zzaArr, (Set) set));
            } else if (jSONObject.has("template_token")) {
                com_google_android_gms_internal_zzd_zza.type = 7;
                com_google_android_gms_internal_zzd_zza.zzgF = true;
                jSONArray2 = jSONObject.getJSONArray("template_token");
                com_google_android_gms_internal_zzd_zza.zzgD = new zza[jSONArray2.length()];
                while (i2 < com_google_android_gms_internal_zzd_zza.zzgD.length) {
                    com_google_android_gms_internal_zzd_zza.zzgD[i2] = zza(jSONArray2.getInt(i2), jSONArray, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    i2++;
                }
            } else {
                com_google_android_gms_internal_zzd_zza.type = 3;
                com_google_android_gms_internal_zzd_zza.zzgF = true;
                i3 = jSONObject.length();
                com_google_android_gms_internal_zzd_zza.zzgx = new zza[i3];
                com_google_android_gms_internal_zzd_zza.zzgy = new zza[i3];
                Iterator keys = jSONObject.keys();
                i3 = 0;
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    com_google_android_gms_internal_zzd_zza.zzgx[i3] = zza(new Integer(str).intValue(), jSONArray, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    com_google_android_gms_internal_zzd_zza.zzgy[i3] = zza(jSONObject.getInt(str), jSONArray, com_google_android_gms_internal_zzd_zzaArr, (Set) set);
                    i3++;
                }
            }
        } else if (zza instanceof String) {
            com_google_android_gms_internal_zzd_zza.zzgv = (String) zza;
            com_google_android_gms_internal_zzd_zza.type = 1;
        } else if (zza instanceof Boolean) {
            com_google_android_gms_internal_zzd_zza.zzgC = ((Boolean) zza).booleanValue();
            com_google_android_gms_internal_zzd_zza.type = 8;
        } else if (zza instanceof Integer) {
            com_google_android_gms_internal_zzd_zza.zzgB = (long) ((Integer) zza).intValue();
            com_google_android_gms_internal_zzd_zza.type = 6;
        } else {
            zzdw("Invalid value type: " + zza);
        }
        com_google_android_gms_internal_zzd_zzaArr[i] = com_google_android_gms_internal_zzd_zza;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzd_zza;
    }

    static zzvl.zza zza(JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, zza[] com_google_android_gms_internal_zzd_zzaArr, int i) {
        zzb zzuu = zzvl.zza.zzuu();
        JSONArray jSONArray3 = jSONObject.getJSONArray("property");
        for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) zza(jSONArray, jSONArray3.getInt(i2), "properties");
            String str = (String) zza(jSONArray2, jSONObject2.getInt("key"), "key");
            zza com_google_android_gms_internal_zzd_zza = (zza) zza((Object[]) com_google_android_gms_internal_zzd_zzaArr, jSONObject2.getInt("value"), "value");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzuu.zzq(com_google_android_gms_internal_zzd_zza);
            } else {
                zzuu.zzb(str, com_google_android_gms_internal_zzd_zza);
            }
        }
        return zzuu.zzuw();
    }

    static zze zza(JSONObject jSONObject, List<zzvl.zza> list, List<zzvl.zza> list2, List<zzvl.zza> list3, zza[] com_google_android_gms_internal_zzd_zzaArr) {
        int i;
        int i2;
        zzf zzuB = zze.zzuB();
        JSONArray optJSONArray = jSONObject.optJSONArray("positive_predicate");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("negative_predicate");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("add_tag");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("remove_tag");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("add_tag_rule_name");
        JSONArray optJSONArray6 = jSONObject.optJSONArray("remove_tag_rule_name");
        JSONArray optJSONArray7 = jSONObject.optJSONArray("add_macro");
        JSONArray optJSONArray8 = jSONObject.optJSONArray("remove_macro");
        JSONArray optJSONArray9 = jSONObject.optJSONArray("add_macro_rule_name");
        JSONArray optJSONArray10 = jSONObject.optJSONArray("remove_macro_rule_name");
        if (optJSONArray != null) {
            for (i = 0; i < optJSONArray.length(); i++) {
                zzuB.zzd((zzvl.zza) list3.get(optJSONArray.getInt(i)));
            }
        }
        if (optJSONArray2 != null) {
            for (i = 0; i < optJSONArray2.length(); i++) {
                zzuB.zze((zzvl.zza) list3.get(optJSONArray2.getInt(i)));
            }
        }
        if (optJSONArray3 != null) {
            for (i = 0; i < optJSONArray3.length(); i++) {
                zzuB.zzf((zzvl.zza) list.get(optJSONArray3.getInt(i)));
            }
        }
        if (optJSONArray4 != null) {
            for (i = 0; i < optJSONArray4.length(); i++) {
                zzuB.zzg((zzvl.zza) list.get(optJSONArray4.getInt(i)));
            }
        }
        if (optJSONArray5 != null) {
            for (i2 = 0; i2 < optJSONArray5.length(); i2++) {
                zzuB.zzdz(com_google_android_gms_internal_zzd_zzaArr[optJSONArray5.getInt(i2)].zzgv);
            }
        }
        if (optJSONArray6 != null) {
            for (i2 = 0; i2 < optJSONArray6.length(); i2++) {
                zzuB.zzdA(com_google_android_gms_internal_zzd_zzaArr[optJSONArray6.getInt(i2)].zzgv);
            }
        }
        if (optJSONArray7 != null) {
            for (i = 0; i < optJSONArray7.length(); i++) {
                zzuB.zzh((zzvl.zza) list2.get(optJSONArray7.getInt(i)));
            }
        }
        if (optJSONArray8 != null) {
            for (i = 0; i < optJSONArray8.length(); i++) {
                zzuB.zzi((zzvl.zza) list2.get(optJSONArray8.getInt(i)));
            }
        }
        if (optJSONArray9 != null) {
            for (i2 = 0; i2 < optJSONArray9.length(); i2++) {
                zzuB.zzdB(com_google_android_gms_internal_zzd_zzaArr[optJSONArray9.getInt(i2)].zzgv);
            }
        }
        if (optJSONArray10 != null) {
            for (i2 = 0; i2 < optJSONArray10.length(); i2++) {
                zzuB.zzdC(com_google_android_gms_internal_zzd_zzaArr[optJSONArray10.getInt(i2)].zzgv);
            }
        }
        return zzuB.zzuM();
    }

    private static <T> T zza(JSONArray jSONArray, int i, String str) {
        if (i >= 0 && i < jSONArray.length()) {
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
            }
        }
        zzdw("Index out of bounds detected: " + i + " in " + str);
        return null;
    }

    private static <T> T zza(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            zzdw("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    static List<zzvl.zza> zza(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, zza[] com_google_android_gms_internal_zzd_zzaArr) {
        List<zzvl.zza> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i), jSONArray2, jSONArray3, com_google_android_gms_internal_zzd_zzaArr, i));
        }
        return arrayList;
    }

    static zzc zzdd(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Object obj = jSONObject.get("resource");
        if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) obj;
            zzd zzux = zzc.zzux();
            zza[] zzf = zzf(jSONObject2);
            JSONArray jSONArray = jSONObject2.getJSONArray("properties");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("key");
            List zza = zza(jSONObject2.getJSONArray("tags"), jSONArray, jSONArray2, zzf);
            List zza2 = zza(jSONObject2.getJSONArray("predicates"), jSONArray, jSONArray2, zzf);
            List<zzvl.zza> zza3 = zza(jSONObject2.getJSONArray("macros"), jSONArray, jSONArray2, zzf);
            for (zzvl.zza zzc : zza3) {
                zzux.zzc(zzc);
            }
            jSONArray = jSONObject2.getJSONArray("rules");
            for (int i = 0; i < jSONArray.length(); i++) {
                zzux.zzb(zza(jSONArray.getJSONObject(i), zza, (List) zza3, zza2, zzf));
            }
            zzux.zzdy(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            zzux.zzhk(1);
            if (jSONObject.optJSONArray("runtime") != null) {
            }
            return zzux.zzuA();
        }
        throw new zzg("Resource map not found");
    }

    private static void zzdw(String str) {
        zzbf.zzZ(str);
        throw new zzg(str);
    }

    static zza[] zzf(JSONObject jSONObject) {
        Object opt = jSONObject.opt("values");
        if (opt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) opt;
            zza[] com_google_android_gms_internal_zzd_zzaArr = new zza[jSONArray.length()];
            for (int i = 0; i < com_google_android_gms_internal_zzd_zzaArr.length; i++) {
                zza(i, jSONArray, com_google_android_gms_internal_zzd_zzaArr, new HashSet(0));
            }
            return com_google_android_gms_internal_zzd_zzaArr;
        }
        throw new zzg("Missing Values list");
    }
}
