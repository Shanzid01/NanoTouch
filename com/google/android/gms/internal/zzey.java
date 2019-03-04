package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzgi
public class zzey extends Handler {
    private final zzex zzuM;

    public zzey(Context context) {
        this(new zzez(context));
    }

    public zzey(zzex com_google_android_gms_internal_zzex) {
        this.zzuM = com_google_android_gms_internal_zzex;
    }

    private void zzb(JSONObject jSONObject) {
        try {
            this.zzuM.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    zzb(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
