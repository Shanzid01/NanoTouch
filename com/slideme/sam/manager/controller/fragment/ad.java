package com.slideme.sam.manager.controller.fragment;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.Category;

/* compiled from: CategoryListFragment */
class ad implements OnChildClickListener {
    final /* synthetic */ aa f3025a;

    ad(aa aaVar) {
        this.f3025a = aaVar;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C1698a.m5063a((Category) this.f3025a.f3018d.getChild(i, i2), this.f3025a.getActivity());
        return true;
    }
}
