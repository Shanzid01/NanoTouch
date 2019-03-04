package com.slideme.sam.manager.controller.fragment.p056a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.p004b.C0059a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0358p;
import com.p026b.p027a.p034b.C0510g;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.web.AdProxyWebViewActivity;
import com.slideme.sam.manager.controller.p055b.C1703e;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.net.C1599q;
import com.slideme.sam.manager.net.C1867a;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.util.C1914e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AdProxyApplicationsListFragment */
public class C1709a extends C1708i {
    String f2916a;
    C1599q f2917b = new C1712b(this);
    private ArrayList<AdProxyItem> f2918i = new ArrayList();
    private C0059a<String, Application> f2919j = new C0059a();
    private C0059a<String, AdProxyItem> f2920k = new C0059a();
    private boolean f2921l = true;

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("STATE_AD_PROXY_ITEMS", this.f2918i);
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(AdProxyItem.class.getClassLoader());
            this.f2918i = bundle.getParcelableArrayList("STATE_AD_PROXY_ITEMS");
            m5104b(this.f2918i);
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        TextView textView = (TextView) onCreateView.findViewById(R.id.info_title);
        textView.setVisibility(0);
        C0345b.m2427c().m2436a(new C0358p().m2483b("AdProxyApplicationsList").m2484c("Activity").m2481a(this.f2916a));
        if (this.f2916a.contains("reward")) {
            textView.setText(getResources().getString(R.string.reward_help));
            textView.setOnClickListener(new C1713c(this, textView));
        } else if (this.f2916a.contains("shareandearn")) {
            textView.setText(getResources().getString(R.string.sharearn_help));
            textView.setOnClickListener(new C1714d(this, textView));
        }
        return onCreateView;
    }

    protected void mo4257a(Catalog catalog) {
        boolean z = false;
        m5093b(false);
        catalog.m5660a(this.f2917b);
        this.f2916a = getArguments().getString("com.slideme.sam.manager.EXTRA_DYNAMIC_LAYOUT_SOURCE");
        if (catalog.m5669b() == 0) {
            C1867a c1867a = SAM.f2614g;
            Context activity = getActivity();
            String str = this.f2916a;
            String str2 = "100";
            if (!SAM.f2615h.m5512c()) {
                z = true;
            }
            c1867a.m5602a(activity, -1, str, str2, null, z, new C1715e(this, catalog));
            return;
        }
        m5102a(catalog.m5693i());
    }

    void mo4256a(AdapterView<?> adapterView, int i) {
        boolean z = true;
        if (!this.d.m5844a() || i != this.d.getCount() - 1) {
            Application application = (Application) adapterView.getAdapter().getItem(i);
            C0510g.m3081a().m3088e();
            AdProxyItem adProxyItem = (AdProxyItem) this.f2920k.get(application.packageName);
            Intent intent;
            if (C1827a.m5491a(getActivity(), application.packageName, application.versionCode) == C1828b.UP_TO_DATE && !TextUtils.isEmpty(application.bundleId)) {
                intent = new Intent(getActivity(), ApplicationDetailsActivity.class);
                intent.putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", application.bundleId);
                intent.putExtra("com.slideme.sam.manager.EXTRA_APP_PRIVATE", true);
                if (adProxyItem != null) {
                    intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", adProxyItem.offerId);
                    intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", adProxyItem.platform.contains("ios"));
                    intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", adProxyItem.payout);
                }
                startActivity(intent);
            } else if (adProxyItem != null) {
                if (SAM.f2615h.m5512c() && C1703e.m5068a(this.f2916a)) {
                    z = false;
                }
                intent = new Intent(getActivity(), AdProxyWebViewActivity.class);
                intent.putExtra("com.slideme.sam.manager.EXTRA_DESTINATION_URL", adProxyItem.clickUrl);
                intent.putExtra("com.slideme.sam.manager.EXTRA_SAM_AVAILABLE_AD", z);
                intent.putExtra("com.slideme.sam.manager.EXTRA_ADSLOT_ID", this.f2916a);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", adProxyItem.offerId);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", adProxyItem.platform.contains("ios"));
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", adProxyItem.payout);
                intent.putExtra("com.slideme.sam.manager.EXTRA_NETWORK_ID", adProxyItem.network);
                intent.putExtra("com.slideme.sam.manager.EXTRA_PACKAGE_NAME", application.packageName);
                startActivity(intent);
            }
        }
    }

    private void m5101a(String str) {
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
            this.f2918i = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.f2918i.add(C1703e.m5067a(jSONArray.getJSONObject(i)));
                } catch (Exception e2) {
                    if (C1914e.f3493a) {
                        e2.printStackTrace();
                    }
                }
            }
            m5104b(this.f2918i);
        }
    }

    private void m5102a(ArrayList<Application> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Application application = (Application) it.next();
            this.f2919j.put(application.packageName, application);
        }
    }

    private void m5104b(ArrayList<AdProxyItem> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AdProxyItem adProxyItem = (AdProxyItem) it.next();
            this.f2920k.put(adProxyItem.packageName, adProxyItem);
        }
    }

    boolean mo4258a() {
        return false;
    }
}
