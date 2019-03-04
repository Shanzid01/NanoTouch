package com.slideme.sam.manager.controller.fragment;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.actionbarsherlock.app.SherlockFragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1599q;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.view.p064a.C1934e;
import java.util.Arrays;

/* compiled from: CategoryListFragment */
public class aa extends SherlockFragment {
    protected boolean f3015a = false;
    private ExpandableListView f3016b;
    private View f3017c;
    private C1934e f3018d = null;
    private Catalog f3019e;
    private C1599q f3020f = new ab(this);
    private SharedPreferences f3021g;
    private OnSharedPreferenceChangeListener f3022h = new ac(this);

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("com.slideme.sam.manager.STATE_CATALOG", this.f3019e);
        bundle.putInt("state_needs_to_reload", this.f3015a ? 1 : 0);
    }

    public void onCreate(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f3021g = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f3021g.registerOnSharedPreferenceChangeListener(this.f3022h);
        this.f3018d = new C1934e(getActivity());
        if (bundle == null) {
            this.f3019e = new Catalog(((SAM) getActivity().getApplication()).m4780d(), 30);
            this.f3019e.m5677d();
            this.f3019e.m5660a(this.f3020f);
            this.f3019e.m5666a(SAM.f2617j.m5520c());
            this.f3019e.m5685f();
            return;
        }
        bundle.setClassLoader(Catalog.class.getClassLoader());
        this.f3019e = (Catalog) bundle.getParcelable("com.slideme.sam.manager.STATE_CATALOG");
        this.f3019e.m5660a(this.f3020f);
        int[] c = SAM.f2617j.m5520c();
        Arrays.sort(c);
        if (!Arrays.equals(this.f3019e.m5694j(), c)) {
            this.f3019e.m5666a(SAM.f2617j.m5520c());
            m5221a();
        }
        this.f3015a = bundle.getInt("state_needs_to_reload") == 1;
    }

    public void onResume() {
        super.onResume();
        if (this.f3015a) {
            m5221a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_category_list, viewGroup, false);
        this.f3016b = (ExpandableListView) inflate.findViewById(16908298);
        this.f3017c = inflate.findViewById(16908292);
        this.f3018d.m5840a(this.f3019e.m5692h());
        this.f3018d.m5839a(this.f3016b);
        this.f3016b.setAdapter(this.f3018d);
        this.f3016b.setOnChildClickListener(new ad(this));
        this.f3016b.setEmptyView(this.f3017c);
        return inflate;
    }

    public void onDestroy() {
        this.f3021g.unregisterOnSharedPreferenceChangeListener(this.f3022h);
        super.onDestroy();
    }

    private void m5221a() {
        this.f3019e.m5673c();
        this.f3019e.m5685f();
    }
}
