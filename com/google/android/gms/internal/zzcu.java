package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public final class zzcu {
    public static final zzcv zzrA = new C11682();
    public static final zzcv zzrB = new C11693();
    public static final zzcv zzrC = new C11704();
    public static final zzcv zzrD = new C11715();
    public static final zzcv zzrE = new C11726();
    public static final zzcv zzrF = new C11737();
    public static final zzcv zzrG = new C11748();
    public static final zzcv zzrH = new C11759();
    public static final zzcv zzrI = new zzdb();
    public static final zzcv zzrz = new C11671();

    final class C11671 implements zzcv {
        C11671() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        }
    }

    final class C11682 implements zzcv {
        C11682() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzhx.zzac("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zzic.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            com_google_android_gms_internal_zzic.zzb("openableURLs", hashMap);
        }
    }

    final class C11693 implements zzcv {
        C11693() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            PackageManager packageManager = com_google_android_gms_internal_zzic.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                zzhx.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzhx.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    com_google_android_gms_internal_zzic.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    com_google_android_gms_internal_zzic.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                com_google_android_gms_internal_zzic.zzb("openableIntents", new JSONObject());
            }
        }
    }

    final class C11704 implements zzcv {
        C11704() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzhx.zzac("URL missing from click GMSG.");
                return;
            }
            Uri zza;
            Uri parse = Uri.parse(str);
            try {
                zzk zzeI = com_google_android_gms_internal_zzic.zzeI();
                if (zzeI != null && zzeI.zzb(parse)) {
                    zza = zzeI.zza(parse, com_google_android_gms_internal_zzic.getContext());
                    new zzhu(com_google_android_gms_internal_zzic.getContext(), com_google_android_gms_internal_zzic.zzeJ().zzzH, zza.toString()).start();
                }
            } catch (zzl e) {
                zzhx.zzac("Unable to append parameter to URL: " + str);
            }
            zza = parse;
            new zzhu(com_google_android_gms_internal_zzic.getContext(), com_google_android_gms_internal_zzic.zzeJ().zzzH, zza.toString()).start();
        }
    }

    final class C11715 implements zzcv {
        C11715() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            zzel zzeF = com_google_android_gms_internal_zzic.zzeF();
            if (zzeF == null) {
                zzhx.zzac("A GMSG tried to close something that wasn't an overlay.");
            } else {
                zzeF.close();
            }
        }
    }

    final class C11726 implements zzcv {
        C11726() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            com_google_android_gms_internal_zzic.zzB(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
        }
    }

    final class C11737 implements zzcv {
        C11737() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzhx.zzac("URL missing from httpTrack GMSG.");
            } else {
                new zzhu(com_google_android_gms_internal_zzic.getContext(), com_google_android_gms_internal_zzic.zzeJ().zzzH, str).start();
            }
        }
    }

    final class C11748 implements zzcv {
        C11748() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            zzhx.zzaa("Received log message: " + ((String) map.get("string")));
        }
    }

    final class C11759 implements zzcv {
        C11759() {
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzk zzeI = com_google_android_gms_internal_zzic.zzeI();
                if (zzeI != null) {
                    zzeI.zzC().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzhx.zzac("Could not parse touch parameters from gmsg.");
            }
        }
    }
}
