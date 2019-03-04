package com.p019a.p020a.p021a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.IOException;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.p010a.p015d.C0263c;

/* compiled from: SessionEventTransform */
class an implements C0263c<ai> {
    an() {
    }

    public byte[] m2409a(ai aiVar) {
        return m2411b(aiVar).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject m2411b(ai aiVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            am amVar = aiVar.f1067a;
            jSONObject.put("appBundleId", amVar.f1083a);
            jSONObject.put("executionId", amVar.f1084b);
            jSONObject.put("installationId", amVar.f1085c);
            jSONObject.put("androidId", amVar.f1086d);
            jSONObject.put("advertisingId", amVar.f1087e);
            jSONObject.put("limitAdTrackingEnabled", amVar.f1088f);
            jSONObject.put("betaDeviceToken", amVar.f1089g);
            jSONObject.put("buildId", amVar.f1090h);
            jSONObject.put("osVersion", amVar.f1091i);
            jSONObject.put("deviceModel", amVar.f1092j);
            jSONObject.put("appVersionCode", amVar.f1093k);
            jSONObject.put("appVersionName", amVar.f1094l);
            jSONObject.put("timestamp", aiVar.f1068b);
            jSONObject.put("type", aiVar.f1069c.toString());
            jSONObject.put("details", new JSONObject(aiVar.f1070d));
            jSONObject.put("customType", aiVar.f1071e);
            jSONObject.put("customAttributes", new JSONObject(aiVar.f1072f));
            jSONObject.put("predefinedType", aiVar.f1073g);
            jSONObject.put("predefinedAttributes", new JSONObject(aiVar.f1074h));
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
