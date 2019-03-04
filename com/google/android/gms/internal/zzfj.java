package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzfj {
    public String zzL(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                zzhx.zzac("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String zzM(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                zzhx.zzac("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public void zza(Context context, boolean z, zzfb com_google_android_gms_internal_zzfb) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        zzfb.zza(intent, com_google_android_gms_internal_zzfb);
        context.startActivity(intent);
    }

    public int zzd(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            zzhx.zzac("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            zzhx.zzac("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public String zze(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public int zzf(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzhx.zzac("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            zzhx.zzac("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public String zzf(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
