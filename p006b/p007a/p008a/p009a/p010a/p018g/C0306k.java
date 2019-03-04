package p006b.p007a.p008a.p009a.p010a.p018g;

import com.google.android.gms.plus.PlusShare;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.p010a.p012b.C0202s;

/* compiled from: DefaultSettingsJsonTransform */
class C0306k implements C0305y {
    C0306k() {
    }

    public C0317w mo508a(C0202s c0202s, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C0317w(m2226a(c0202s, (long) optInt2, jSONObject), m2227a(jSONObject.getJSONObject("app")), m2231e(jSONObject.getJSONObject("session")), m2232f(jSONObject.getJSONObject("prompt")), m2229c(jSONObject.getJSONObject("features")), m2230d(jSONObject.getJSONObject("analytics")), m2233g(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    private C0298e m2227a(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString("status");
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        C0296c c0296c = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            c0296c = m2228b(jSONObject.getJSONObject("icon"));
        }
        return new C0298e(string, string2, string3, string4, optBoolean, c0296c);
    }

    private C0296c m2228b(JSONObject jSONObject) {
        return new C0296c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private C0308m m2229c(JSONObject jSONObject) {
        return new C0308m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private C0295b m2230d(JSONObject jSONObject) {
        return new C0295b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1));
    }

    private C0311p m2231e(JSONObject jSONObject) {
        return new C0311p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private C0310o m2232f(JSONObject jSONObject) {
        return new C0310o(jSONObject.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private C0299f m2233g(JSONObject jSONObject) {
        return new C0299f(jSONObject.optString("update_endpoint", C0318x.f990a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private long m2226a(C0202s c0202s, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return c0202s.mo466a() + (1000 * j);
    }
}
