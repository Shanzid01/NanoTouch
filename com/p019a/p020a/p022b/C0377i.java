package com.p019a.p020a.p022b;

import org.json.JSONObject;

/* compiled from: CheckForUpdatesResponseTransform */
class C0377i {
    C0377i() {
    }

    public C0376h m2542a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C0376h(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
