package com.slideme.sam.manager.controller.p053a;

import android.content.SharedPreferences.Editor;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.C1922m;
import org.json.JSONObject;

/* compiled from: PasswordCheckDialog */
class C1618i extends AsyncHttpResponseHandler {
    final /* synthetic */ C1617h f2706a;

    C1618i(C1617h c1617h) {
        this.f2706a = c1617h;
    }

    public void onSuccess(String str) {
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("valid")) {
                z = false;
            } else {
                z = jSONObject.getBoolean("valid");
            }
            if (this.f2706a.f2703c != null && this.f2706a.f2704d != null) {
                if (z) {
                    Editor edit = this.f2706a.f2704d.getSharedPreferences("pcd_preferences", 0).edit();
                    edit.putLong("last_checked", System.currentTimeMillis());
                    edit.commit();
                }
                this.f2706a.f2703c.mo4278a(z);
            }
        } catch (Exception e) {
            C1922m.m5790a(e);
            if (this.f2706a.f2703c != null) {
                this.f2706a.f2703c.mo4278a(false);
            }
        }
    }

    public void onFailure(Throwable th, String str) {
        if (this.f2706a.f2703c != null) {
            this.f2706a.f2703c.mo4278a(false);
        }
    }
}
