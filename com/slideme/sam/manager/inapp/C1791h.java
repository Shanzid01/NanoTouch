package com.slideme.sam.manager.inapp;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.p019a.p020a.p021a.C0343a;
import com.p019a.p020a.p021a.C0345b;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p053a.C1622m;
import com.slideme.sam.manager.model.data.inapp.InAppProduct;
import com.slideme.sam.manager.net.response.InAppPurchaseResponse;
import com.slideme.sam.manager.util.C1920k;
import java.math.BigDecimal;
import java.util.Currency;

/* compiled from: InAppPurchasingFragment */
public class C1791h extends Fragment implements C1622m {
    private InAppProduct f3217a;
    private String f3218b;
    private String f3219c;
    private int f3220d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f3217a = (InAppProduct) getArguments().getParcelable("com.slideme.sam.manager.extra.IAP_PRODUCT");
        } else {
            bundle.setClassLoader(InAppProduct.class.getClassLoader());
            this.f3217a = (InAppProduct) bundle.getParcelable("com.slideme.sam.manager.extra.IAP_PRODUCT");
        }
        this.f3218b = getArguments().getString("com.slideme.sam.manager.extra.CALLER_PACKAGE");
        this.f3219c = getArguments().getString("com.slideme.sam.manager.extra.DEVELOPER_PAYLOAD");
        this.f3220d = getArguments().getInt("com.slideme.sam.manager.extra.API_VERSION");
        C0345b.m2427c().m2431a(new C0343a().m2369a(BigDecimal.valueOf((double) this.f3217a.price)).m2370a(Currency.getInstance("USD")).m2373b(this.f3217a.title).m2374c("inapp").m2368a(this.f3217a.productId));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_iap_details, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f3217a != null) {
            m5359a(view);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("com.slideme.sam.manager.extra.IAP_PRODUCT", this.f3217a);
    }

    public void onStop() {
        super.onStop();
        m5365a().m4794a(null);
    }

    public void onStart() {
        super.onStart();
        m5365a().m4795b(R.string.purchasing);
    }

    private void m5359a(View view) {
        ((TextView) view.findViewById(R.id.title)).setText(this.f3217a.title);
        try {
            ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(getActivity().getPackageManager().getApplicationIcon(this.f3218b));
        } catch (NameNotFoundException e) {
        }
        if (!TextUtils.isEmpty(this.f3217a.description)) {
            ((TextView) view.findViewById(R.id.description)).setText(Html.fromHtml(this.f3217a.description));
        }
        ((Button) view.findViewById(R.id.purchase)).setText(SAM.f2616i.m5487a((double) this.f3217a.price));
        ((Button) view.findViewById(R.id.purchase)).setOnClickListener(new C1792i(this));
    }

    private void m5363b() {
        m5364c();
        SAM.f2614g.m5601a(this.f3220d, this.f3217a.productId, this.f3218b, this.f3219c, new C1793j(this));
    }

    public InAppPurchasingActivity m5365a() {
        return (InAppPurchasingActivity) getActivity();
    }

    private void m5364c() {
        if (m5365a() != null) {
            m5365a().mo4273f();
        }
    }

    private void m5362a(InAppPurchaseResponse inAppPurchaseResponse) {
        switch (inAppPurchaseResponse.status) {
            case 1:
                m5365a().m5334a(inAppPurchaseResponse);
                return;
            case 2:
                m5365a().m5339i();
                return;
            case 3:
                m5365a().m5340j();
                return;
            case 4:
                m5365a().m5338h();
                return;
            case 5:
                m5365a().mo4242b();
                return;
            case 6:
                m5365a().m5335a(inAppPurchaseResponse.webBuyUrl);
                return;
            default:
                m5365a().m5338h();
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!(intent == null || intent.getExtras() == null)) {
            m5362a((InAppPurchaseResponse) intent.getExtras().getParcelable("com.slideme.sam.manager.RESULT_IAP_RESPONSE"));
        }
        super.onActivityResult(i, i2, intent);
    }

    public void mo4278a(boolean z) {
        if (getActivity() == null) {
            return;
        }
        if (z) {
            m5363b();
        } else {
            C1920k.m5782a(getActivity(), getActivity().getResources().getString(R.string.login_error), 1).show();
        }
    }
}
