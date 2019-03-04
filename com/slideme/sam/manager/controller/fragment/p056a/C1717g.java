package com.slideme.sam.manager.controller.fragment.p056a;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: AdsApplicationListFragment */
class C1717g extends AsyncHttpResponseHandler {
    final /* synthetic */ C1716f f2960a;

    C1717g(C1716f c1716f) {
        this.f2960a = c1716f;
    }

    public void onSuccess(String str) {
        if (this.f2960a.getActivity() != null) {
            this.f2960a.getActivity().runOnUiThread(new C1718h(this, str));
        }
    }

    public void onFailure(Throwable th, String str) {
        C1922m.m5790a(new Exception(str, th));
        this.f2960a.m5148a();
    }
}
