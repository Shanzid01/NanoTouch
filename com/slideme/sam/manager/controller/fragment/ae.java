package com.slideme.sam.manager.controller.fragment;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0090q;
import android.support.v4.p004b.C0059a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.google.analytics.tracking.android.C0771n;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0358p;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.catalog.DynamicLayoutActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.dynamic.DynamicLayout;
import com.slideme.sam.manager.model.data.dynamic.DynamicLayout.Template;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.view.featured.DynamicLayoutGridView;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DynamicLayoutFragment */
public class ae extends SherlockFragment {
    private static /* synthetic */ int[] f3026l;
    private ShowcaseView f3027a;
    private FrameLayout f3028b;
    private SafeViewFlipper f3029c;
    private DynamicLayoutGridView f3030d;
    private DynamicLayout f3031e;
    private String f3032f;
    private boolean f3033g = false;
    private boolean f3034h = true;
    private C0059a<String, Application> f3035i = new C0059a();
    private C0059a<String, AdProxyItem> f3036j = new C0059a();
    private BroadcastReceiver f3037k = new af(this);

    static /* synthetic */ int[] m5233a() {
        int[] iArr = f3026l;
        if (iArr == null) {
            iArr = new int[Template.values().length];
            try {
                iArr[Template.GRID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            f3026l = iArr;
        }
        return iArr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(DynamicLayout.class.getClassLoader());
            this.f3032f = bundle.getString("source");
            this.f3031e = (DynamicLayout) bundle.getParcelable("com.slideme.sam.manager.STATE_DYNAMIC_DATA");
        } else if (getArguments() != null) {
            this.f3032f = SAM.f2609b + getArguments().getString("com.slideme.sam.manager.EXTRA_DYNAMIC_LAYOUT_SOURCE");
        } else {
            this.f3032f = SAM.f2609b + "/template/home";
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_dynamic_layout, null);
        this.f3029c = (SafeViewFlipper) inflate.findViewById(R.id.flipper);
        this.f3028b = (FrameLayout) inflate.findViewById(R.id.dynamic_layout);
        C0345b.m2427c().m2436a(new C0358p().m2483b("DynamicLayoutFragment").m2484c("Activity").m2481a(this.f3032f));
        TextView textView;
        if (this.f3032f.contains("reward")) {
            textView = (TextView) inflate.findViewById(R.id.info_title);
            textView.setVisibility(0);
            textView.setText(getResources().getString(R.string.reward_help));
            textView.setOnClickListener(new ag(this, textView));
        } else if (this.f3032f.contains("shareandearn")) {
            textView = (TextView) inflate.findViewById(R.id.info_title);
            textView.setVisibility(0);
            textView.setText(getResources().getString(R.string.sharearn_help));
            textView.setOnClickListener(new ah(this, textView));
        }
        if (this.f3031e == null) {
            SAM.f2614g.m5644e(this.f3032f, new ai(this));
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        C0771n.m3940b().mo1215c(this.f3032f);
        if (this.f3030d == null && m5232a(this.f3031e) && !this.f3033g) {
            m5235b();
        }
        C0090q.m145a(getActivity()).m149a(this.f3037k, new IntentFilter("com.slideme.sam.manager.ACTION_HIDE_SHOWCASE"));
    }

    public void onPause() {
        super.onPause();
        C0090q.m145a(getActivity()).m148a(this.f3037k);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f3027a != null && this.f3027a.m3188e()) {
            this.f3027a.m3186c();
        }
    }

    private void m5235b() {
        if (getActivity() != null) {
            switch (m5233a()[this.f3031e.template.ordinal()]) {
                case 1:
                    this.f3030d = new DynamicLayoutGridView(getActivity());
                    this.f3030d.setLayoutParams(new LayoutParams(-1, -1));
                    this.f3030d.m5871a(this.f3031e, getActivity());
                    this.f3028b.addView(this.f3030d);
                    break;
            }
            if (TextUtils.isEmpty(this.f3031e.title) && (getActivity() instanceof DynamicLayoutActivity)) {
                getActivity().setTitle(this.f3031e.title);
            }
            m5230a(false);
            new aj(this).start();
        }
    }

    private void m5230a(boolean z) {
        if (this.f3029c != null) {
            this.f3029c.setDisplayedChild(z ? 0 : 1);
        }
    }

    private boolean m5232a(DynamicLayout dynamicLayout) {
        return (dynamicLayout == null || dynamicLayout.template == null) ? false : true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("com.slideme.sam.manager.STATE_DYNAMIC_DATA", this.f3031e);
        bundle.putString("source", this.f3032f);
    }

    private void m5229a(ArrayList<Application> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Application application = (Application) it.next();
            this.f3035i.put(application.packageName, application);
        }
    }

    private void m5239b(ArrayList<AdProxyItem> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AdProxyItem adProxyItem = (AdProxyItem) it.next();
            this.f3036j.put(adProxyItem.packageName, adProxyItem);
        }
    }
}
