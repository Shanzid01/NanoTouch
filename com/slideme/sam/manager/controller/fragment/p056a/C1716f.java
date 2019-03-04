package com.slideme.sam.manager.controller.fragment.p056a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.google.analytics.tracking.android.C0771n;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1703e;
import com.slideme.sam.manager.net.C1867a;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.view.p064a.C1930a;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.lucasr.twowayview.widget.TwoWayView;

/* compiled from: AdsApplicationListFragment */
public class C1716f extends SherlockFragment {
    String f2951a;
    String f2952b;
    String f2953c;
    private SafeViewFlipper f2954d = null;
    private TwoWayView f2955e = null;
    private TextView f2956f = null;
    private C1930a f2957g;
    private ArrayList<AdProxyItem> f2958h = new ArrayList();
    private int f2959i = 2;

    public void onStart() {
        super.onStart();
        C0771n.m3940b().mo1215c(getClass().getName());
    }

    public void onStop() {
        super.onStop();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("STATE_AD_PROXY_ITEMS", this.f2958h);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_app_masonry_list, viewGroup, false);
        this.f2954d = (SafeViewFlipper) viewGroup2.findViewById(R.id.flipper);
        this.f2956f = (TextView) viewGroup2.findViewById(R.id.empty);
        this.f2955e = (TwoWayView) viewGroup2.findViewById(R.id.apps);
        this.f2959i = getActivity().getResources().getInteger(R.integer.masonryGridColumns);
        this.f2951a = getArguments().getString("BUNDLE_EXTRA_AD_SLOT_ID");
        this.f2952b = getArguments().getString("BUNDLE_EXTRA_LIMIT");
        this.f2953c = getArguments().getString("BUNDLE_EXTRA_SOURCE");
        this.f2957g = new C1930a(getActivity(), this.f2959i, this.f2953c);
        this.f2955e.setAdapter(this.f2957g);
        if (bundle != null) {
            bundle.setClassLoader(AdProxyItem.class.getClassLoader());
            this.f2958h = bundle.getParcelableArrayList("STATE_AD_PROXY_ITEMS");
        }
        if (this.f2958h == null || this.f2958h.isEmpty()) {
            C1867a c1867a = SAM.f2614g;
            Context activity = getActivity();
            String str = this.f2951a;
            String str2 = this.f2952b;
            String str3 = this.f2953c;
            if (!SAM.f2615h.m5512c()) {
                z = true;
            }
            c1867a.m5602a(activity, -1, str, str2, str3, z, new C1717g(this));
        } else {
            m5148a();
        }
        return viewGroup2;
    }

    private void m5148a() {
        if (this.f2957g == null) {
            this.f2957g = new C1930a(getActivity(), this.f2959i, this.f2951a);
        }
        this.f2957g.m5836a(this.f2958h);
        if (this.f2958h.isEmpty()) {
            this.f2956f.setVisibility(0);
        } else {
            this.f2956f.setVisibility(8);
        }
        m5152a(true);
    }

    private void m5151a(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            if (C1914e.f3493a) {
                e.printStackTrace();
            }
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            this.f2958h = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.f2958h.add(C1703e.m5067a(jSONArray.getJSONObject(i)));
                } catch (Exception e2) {
                    if (C1914e.f3493a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        m5148a();
    }

    private void m5152a(boolean z) {
        if (this.f2954d != null) {
            int i = z ? 1 : 0;
            if (this.f2954d.getDisplayedChild() != i) {
                this.f2954d.setDisplayedChild(i);
            }
        }
    }
}
