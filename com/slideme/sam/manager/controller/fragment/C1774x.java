package com.slideme.sam.manager.controller.fragment;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.util.C1920k;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ApplicationDetailsFragment */
class C1774x extends AsyncHttpResponseHandler {
    final /* synthetic */ C1735a f3162a;

    C1774x(C1735a c1735a) {
        this.f3162a = c1735a;
    }

    public void onSuccess(String str) {
        super.onSuccess(str);
        if (this.f3162a.getActivity() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f3162a.f2999k = jSONObject.isNull("shareUrl") ? "" : jSONObject.getString("shareUrl");
            } catch (JSONException e) {
            }
        }
    }

    public void onFinish() {
        super.onFinish();
        if (this.f3162a.getActivity() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f3162a.f2999k)) {
            C1920k.m5781a(this.f3162a.getActivity(), (int) R.string.timeout_message, 0).show();
        } else {
            this.f3162a.m5182c();
        }
    }
}
