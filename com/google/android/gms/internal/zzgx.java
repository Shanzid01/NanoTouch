package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public final class zzgx {
    private static final SimpleDateFormat zzxu = new SimpleDateFormat("yyyyMMdd");

    public static zzgq zza(Context context, zzgo com_google_android_gms_internal_zzgo, String str) {
        try {
            zzgq com_google_android_gms_internal_zzgq;
            int i;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            Object optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString6)) {
                i2 = zzab.zzaO().zzey();
            } else if ("landscape".equals(optString6)) {
                i2 = zzab.zzaO().zzex();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    zzhx.zzac("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new zzgq(0);
                }
                zzgq zza = zzgw.zza(context, com_google_android_gms_internal_zzgo.zzlP.zzzH, optString2, null, null);
                optString = zza.zzus;
                optString4 = zza.zzwG;
                j = zza.zzwM;
                com_google_android_gms_internal_zzgq = zza;
            } else if (TextUtils.isEmpty(optString)) {
                zzhx.zzac("Could not parse the mediation config: Missing required ad_base_url field");
                return new zzgq(0);
            } else {
                com_google_android_gms_internal_zzgq = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = com_google_android_gms_internal_zzgq == null ? null : com_google_android_gms_internal_zzgq.zzst;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = com_google_android_gms_internal_zzgq == null ? null : com_google_android_gms_internal_zzgq.zzsu;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = com_google_android_gms_internal_zzgq == null ? null : com_google_android_gms_internal_zzgq.zzwK;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (com_google_android_gms_internal_zzgq != null) {
                if (com_google_android_gms_internal_zzgq.orientation != -1) {
                    i2 = com_google_android_gms_internal_zzgq.orientation;
                }
                if (com_google_android_gms_internal_zzgq.zzwH > 0) {
                    j2 = com_google_android_gms_internal_zzgq.zzwH;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", null);
            }
            return new zzgq(optString, optString4, list, list2, j2, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i2, optString3, j, optString5, optBoolean, str2, optString7, jSONObject.optBoolean("custom_render_allowed", false), jSONObject.optBoolean("native", false), com_google_android_gms_internal_zzgo.zzwv, jSONObject.optBoolean("content_url_opted_out", false), jSONObject.optBoolean("prefetch", false));
        } catch (JSONException e) {
            zzhx.zzac("Could not parse the mediation config: " + e.getMessage());
            return new zzgq(0);
        }
    }

    public static JSONObject zza(zzgo com_google_android_gms_internal_zzgo, zzhb com_google_android_gms_internal_zzhb, Location location, zzbv com_google_android_gms_internal_zzbv) {
        try {
            Map hashMap = new HashMap();
            Iterable zzbW = com_google_android_gms_internal_zzbv.zzbW();
            if (zzbW.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", zzbW));
            }
            if (com_google_android_gms_internal_zzgo.zzwm != null) {
                hashMap.put("ad_pos", com_google_android_gms_internal_zzgo.zzwm);
            }
            zza((HashMap) hashMap, com_google_android_gms_internal_zzgo.zzwn);
            hashMap.put("format", com_google_android_gms_internal_zzgo.zzlV.zzpa);
            if (com_google_android_gms_internal_zzgo.zzlV.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (com_google_android_gms_internal_zzgo.zzlV.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (com_google_android_gms_internal_zzgo.zzlV.zzpc != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (zzba com_google_android_gms_internal_zzba : com_google_android_gms_internal_zzgo.zzlV.zzpc) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(com_google_android_gms_internal_zzba.width == -1 ? (int) (((float) com_google_android_gms_internal_zzba.widthPixels) / com_google_android_gms_internal_zzhb.zzwz) : com_google_android_gms_internal_zzba.width);
                    stringBuilder.append("x");
                    stringBuilder.append(com_google_android_gms_internal_zzba.height == -2 ? (int) (((float) com_google_android_gms_internal_zzba.heightPixels) / com_google_android_gms_internal_zzhb.zzwz) : com_google_android_gms_internal_zzba.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            if (com_google_android_gms_internal_zzgo.zzwt != 0) {
                hashMap.put("native_version", Integer.valueOf(com_google_android_gms_internal_zzgo.zzwt));
                hashMap.put("native_templates", com_google_android_gms_internal_zzgo.zzmf);
            }
            hashMap.put("slotname", com_google_android_gms_internal_zzgo.zzlM);
            hashMap.put("pn", com_google_android_gms_internal_zzgo.applicationInfo.packageName);
            if (com_google_android_gms_internal_zzgo.zzwo != null) {
                hashMap.put("vc", Integer.valueOf(com_google_android_gms_internal_zzgo.zzwo.versionCode));
            }
            hashMap.put("ms", com_google_android_gms_internal_zzgo.zzwp);
            hashMap.put("seq_num", com_google_android_gms_internal_zzgo.zzwq);
            hashMap.put("session_id", com_google_android_gms_internal_zzgo.zzwr);
            hashMap.put("js", com_google_android_gms_internal_zzgo.zzlP.zzzH);
            zza((HashMap) hashMap, com_google_android_gms_internal_zzhb);
            hashMap.put("fdz", new Integer(com_google_android_gms_internal_zzbv.zzbX()));
            if (com_google_android_gms_internal_zzgo.zzwn.versionCode >= 2 && com_google_android_gms_internal_zzgo.zzwn.zzoT != null) {
                zza((HashMap) hashMap, com_google_android_gms_internal_zzgo.zzwn.zzoT);
            }
            if (com_google_android_gms_internal_zzgo.versionCode >= 2) {
                hashMap.put("quality_signals", com_google_android_gms_internal_zzgo.zzws);
            }
            if (com_google_android_gms_internal_zzgo.versionCode >= 4 && com_google_android_gms_internal_zzgo.zzwv) {
                hashMap.put("forceHttps", Boolean.valueOf(com_google_android_gms_internal_zzgo.zzwv));
            }
            if (com_google_android_gms_internal_zzgo.versionCode >= 4 && com_google_android_gms_internal_zzgo.zzwu != null) {
                hashMap.put("content_info", com_google_android_gms_internal_zzgo.zzwu);
            }
            if (com_google_android_gms_internal_zzgo.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzgo.zzwz));
                hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzgo.zzwy));
                hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzgo.zzwx));
            } else {
                hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzhb.zzwz));
                hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzhb.zzwy));
                hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzhb.zzwx));
            }
            if (com_google_android_gms_internal_zzgo.versionCode >= 6) {
                if (!TextUtils.isEmpty(com_google_android_gms_internal_zzgo.zzwA)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(com_google_android_gms_internal_zzgo.zzwA));
                    } catch (Throwable e) {
                        zzhx.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                if (((Boolean) zzca.zzqL.get()).booleanValue() && com_google_android_gms_internal_zzgo.zzwB) {
                    hashMap.put("ga_hid", Integer.valueOf(com_google_android_gms_internal_zzgo.zzwC));
                    hashMap.put("ga_cid", com_google_android_gms_internal_zzgo.zzwD);
                }
                hashMap.put("correlation_id", Long.valueOf(com_google_android_gms_internal_zzgo.zzwE));
            }
            if (com_google_android_gms_internal_zzgo.versionCode >= 7) {
                hashMap.put("request_id", com_google_android_gms_internal_zzgo.zzwF);
            }
            if (zzhx.zzA(2)) {
                zzhx.zzab("Ad Request JSON: " + zzab.zzaM().zzw(hashMap).toString(2));
            }
            return zzab.zzaM().zzw(hashMap);
        } catch (JSONException e2) {
            zzhx.zzac("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, zzax com_google_android_gms_internal_zzax) {
        String zzep = zzhk.zzep();
        if (zzep != null) {
            hashMap.put("abf", zzep);
        }
        if (com_google_android_gms_internal_zzax.zzoL != -1) {
            hashMap.put("cust_age", zzxu.format(new Date(com_google_android_gms_internal_zzax.zzoL)));
        }
        if (com_google_android_gms_internal_zzax.extras != null) {
            hashMap.put("extras", com_google_android_gms_internal_zzax.extras);
        }
        if (com_google_android_gms_internal_zzax.zzoM != -1) {
            hashMap.put("cust_gender", Integer.valueOf(com_google_android_gms_internal_zzax.zzoM));
        }
        if (com_google_android_gms_internal_zzax.zzoN != null) {
            hashMap.put("kw", com_google_android_gms_internal_zzax.zzoN);
        }
        if (com_google_android_gms_internal_zzax.zzoP != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(com_google_android_gms_internal_zzax.zzoP));
        }
        if (com_google_android_gms_internal_zzax.zzoO) {
            hashMap.put("adtest", "on");
        }
        if (com_google_android_gms_internal_zzax.versionCode >= 2) {
            if (com_google_android_gms_internal_zzax.zzoQ) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzax.zzoR)) {
                hashMap.put("ppid", com_google_android_gms_internal_zzax.zzoR);
            }
            if (com_google_android_gms_internal_zzax.zzoS != null) {
                zza((HashMap) hashMap, com_google_android_gms_internal_zzax.zzoS);
            }
        }
        if (com_google_android_gms_internal_zzax.versionCode >= 3 && com_google_android_gms_internal_zzax.zzoU != null) {
            hashMap.put("url", com_google_android_gms_internal_zzax.zzoU);
        }
        if (com_google_android_gms_internal_zzax.versionCode >= 5) {
            if (com_google_android_gms_internal_zzax.zzoW != null) {
                hashMap.put("custom_targeting", com_google_android_gms_internal_zzax.zzoW);
            }
            if (com_google_android_gms_internal_zzax.zzoX != null) {
                hashMap.put("category_exclusions", com_google_android_gms_internal_zzax.zzoX);
            }
            if (com_google_android_gms_internal_zzax.zzoY != null) {
                hashMap.put("request_agent", com_google_android_gms_internal_zzax.zzoY);
            }
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzbs com_google_android_gms_internal_zzbs) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(com_google_android_gms_internal_zzbs.zzpN) != 0) {
            hashMap.put("acolor", zzy(com_google_android_gms_internal_zzbs.zzpN));
        }
        if (Color.alpha(com_google_android_gms_internal_zzbs.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzy(com_google_android_gms_internal_zzbs.backgroundColor));
        }
        if (!(Color.alpha(com_google_android_gms_internal_zzbs.zzpO) == 0 || Color.alpha(com_google_android_gms_internal_zzbs.zzpP) == 0)) {
            hashMap.put("gradientto", zzy(com_google_android_gms_internal_zzbs.zzpO));
            hashMap.put("gradientfrom", zzy(com_google_android_gms_internal_zzbs.zzpP));
        }
        if (Color.alpha(com_google_android_gms_internal_zzbs.zzpQ) != 0) {
            hashMap.put("bcolor", zzy(com_google_android_gms_internal_zzbs.zzpQ));
        }
        hashMap.put("bthick", Integer.toString(com_google_android_gms_internal_zzbs.zzpR));
        switch (com_google_android_gms_internal_zzbs.zzpS) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (com_google_android_gms_internal_zzbs.zzpT) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (com_google_android_gms_internal_zzbs.zzpU != null) {
            hashMap.put("channel", com_google_android_gms_internal_zzbs.zzpU);
        }
        if (Color.alpha(com_google_android_gms_internal_zzbs.zzpV) != 0) {
            hashMap.put("dcolor", zzy(com_google_android_gms_internal_zzbs.zzpV));
        }
        if (com_google_android_gms_internal_zzbs.zzpW != null) {
            hashMap.put("font", com_google_android_gms_internal_zzbs.zzpW);
        }
        if (Color.alpha(com_google_android_gms_internal_zzbs.zzpX) != 0) {
            hashMap.put("hcolor", zzy(com_google_android_gms_internal_zzbs.zzpX));
        }
        hashMap.put("headersize", Integer.toString(com_google_android_gms_internal_zzbs.zzpY));
        if (com_google_android_gms_internal_zzbs.zzpZ != null) {
            hashMap.put("q", com_google_android_gms_internal_zzbs.zzpZ);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzhb com_google_android_gms_internal_zzhb) {
        hashMap.put("am", Integer.valueOf(com_google_android_gms_internal_zzhb.zzxY));
        hashMap.put("cog", zzw(com_google_android_gms_internal_zzhb.zzxZ));
        hashMap.put("coh", zzw(com_google_android_gms_internal_zzhb.zzya));
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzhb.zzyb)) {
            hashMap.put("carrier", com_google_android_gms_internal_zzhb.zzyb);
        }
        hashMap.put("gl", com_google_android_gms_internal_zzhb.zzyc);
        if (com_google_android_gms_internal_zzhb.zzyd) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", zzw(com_google_android_gms_internal_zzhb.zzye));
        hashMap.put("sp", zzw(com_google_android_gms_internal_zzhb.zzyf));
        hashMap.put("hl", com_google_android_gms_internal_zzhb.zzyg);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzhb.zzyh)) {
            hashMap.put("mv", com_google_android_gms_internal_zzhb.zzyh);
        }
        hashMap.put("muv", Integer.valueOf(com_google_android_gms_internal_zzhb.zzyi));
        if (com_google_android_gms_internal_zzhb.zzyj != -2) {
            hashMap.put("cnt", Integer.valueOf(com_google_android_gms_internal_zzhb.zzyj));
        }
        hashMap.put("gnt", Integer.valueOf(com_google_android_gms_internal_zzhb.zzyk));
        hashMap.put("pt", Integer.valueOf(com_google_android_gms_internal_zzhb.zzyl));
        hashMap.put("rm", Integer.valueOf(com_google_android_gms_internal_zzhb.zzym));
        hashMap.put("riv", Integer.valueOf(com_google_android_gms_internal_zzhb.zzyn));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", com_google_android_gms_internal_zzhb.zzyr);
        bundle.putBoolean("active_network_metered", com_google_android_gms_internal_zzhb.zzyq);
        hashMap.put("connectivity", bundle);
        bundle = new Bundle();
        bundle.putBoolean("is_charging", com_google_android_gms_internal_zzhb.zzyp);
        bundle.putDouble("battery_level", com_google_android_gms_internal_zzhb.zzyo);
        hashMap.put("battery", bundle);
    }

    private static Integer zzw(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String zzy(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
