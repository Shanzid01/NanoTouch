package com.slideme.sam.manager.controller.fragment;

import android.app.Dialog;
import android.text.TextUtils;
import com.facebook.widget.FacebookDialog.ShareDialogBuilder;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ApplicationDetailsFragment */
class C1769s extends AsyncHttpResponseHandler {
    final /* synthetic */ C1768r f3151a;
    private final /* synthetic */ Dialog f3152b;

    C1769s(C1768r c1768r, Dialog dialog) {
        this.f3151a = c1768r;
        this.f3152b = dialog;
    }

    public void onSuccess(String str) {
        super.onSuccess(str);
        if (this.f3151a.f3148a.f3146a.getActivity() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f3151a.f3148a.f3146a.f2999k = jSONObject.isNull("shareUrl") ? "" : jSONObject.getString("shareUrl");
            } catch (JSONException e) {
            }
        }
    }

    public void onFinish() {
        super.onFinish();
        if (this.f3151a.f3148a.f3146a.getActivity() != null && !TextUtils.isEmpty(this.f3151a.f3148a.f3146a.f2999k)) {
            ((ShareDialogBuilder) new ShareDialogBuilder(this.f3151a.f3148a.f3146a.getActivity()).setLink(this.f3151a.f3148a.f3146a.f2999k)).build().present();
            C0345b.m2427c().m2437a((C0359q) ((C0359q) ((C0359q) new C0359q("FBShare Button Pressed").m2364a("app", this.f3151a.f3148a.f3146a.f2989a.app.getName())).m2364a("country", this.f3151a.f3148a.f3146a.f2984H)).m2364a("channel", this.f3151a.f3148a.f3146a.getString(R.string.live_channel)));
            if (this.f3152b != null && this.f3152b.isShowing()) {
                SAM.f2613f.m5441a(this.f3151a.f3148a.f3146a.f2989a.app.packageName, false);
                this.f3152b.hide();
            }
        }
    }
}
