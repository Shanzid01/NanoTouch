package com.slideme.sam.manager.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockListFragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.net.wrappers.C1903p;
import com.slideme.sam.manager.view.p064a.C1942l;
import com.slideme.sam.manager.view.touchme.ReviewChartView;
import com.slideme.sam.manager.view.touchme.ReviewFilterControlView;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: ReviewListFragment */
public class ay extends SherlockListFragment {
    private ReviewFilterControlView f3067a = null;
    private SafeViewFlipper f3068b = null;
    private ReviewChartView f3069c = null;
    private ApplicationHolder f3070d;
    private C1903p f3071e;
    private C1942l f3072f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3070d = (ApplicationHolder) getArguments().getParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER");
        this.f3071e = new C1903p(this.f3070d.app.bundleId);
        if (bundle != null) {
            this.f3071e.m5736b(bundle);
        } else {
            this.f3071e.m5732a();
        }
        this.f3072f = new C1942l(getActivity(), this.f3071e.m5737c(), this.f3070d.app.versionCode);
        this.f3071e.m5734a(new az(this));
        if (bundle != null) {
            this.f3072f.m5847a(m5270a());
        }
        setListAdapter(this.f3072f);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f3071e.m5733a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.fragment_review_list, null);
        this.f3067a = (ReviewFilterControlView) inflate.findViewById(R.id.reviewFilter);
        this.f3067a.m6017a(new ba(this));
        this.f3069c = (ReviewChartView) inflate.findViewById(R.id.reviewChart);
        this.f3069c.setLoading(true);
        this.f3068b = (SafeViewFlipper) inflate.findViewById(R.id.listflipper);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getListView().setOnScrollListener(new bb(this));
        if (bundle == null) {
            this.f3069c.m6011a(this.f3070d.app, getActivity());
            setListShown(false);
            return;
        }
        setListShown(true);
    }

    public void setListShown(boolean z) {
        if (this.f3068b != null) {
            int i = z ? 1 : 0;
            if (this.f3068b.getDisplayedChild() != i) {
                this.f3068b.setDisplayedChild(i);
            }
        }
    }

    public void setListShownNoAnimation(boolean z) {
        setListShown(z);
    }

    private boolean m5270a() {
        return this.f3071e.m5735b() < 0 || this.f3071e.m5735b() >= this.f3071e.m5738d();
    }
}
