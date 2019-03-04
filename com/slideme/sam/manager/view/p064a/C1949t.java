package com.slideme.sam.manager.view.p064a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.google.android.gms.actions.SearchIntents;
import com.slideme.sam.manager.controller.fragment.am;
import com.slideme.sam.manager.controller.fragment.p056a.af;

/* compiled from: SearchPagerAdapter */
public class C1949t extends FragmentStatePagerAdapter {
    private String f3593a = "";
    private af f3594b;

    public C1949t(FragmentManager fragmentManager, String str) {
        super(fragmentManager);
        this.f3593a = str;
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Fragment afVar = new af();
                Bundle bundle = new Bundle();
                bundle.putString(SearchIntents.EXTRA_QUERY, this.f3593a);
                afVar.setArguments(bundle);
                return afVar;
            case 1:
                return new am();
            default:
                return null;
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        if (i == 0) {
            this.f3594b = (af) fragment;
        }
        return fragment;
    }

    public af m5854a() {
        return this.f3594b;
    }

    public float getPageWidth(int i) {
        if (i == 1) {
            return 0.75f;
        }
        return super.getPageWidth(i);
    }
}
