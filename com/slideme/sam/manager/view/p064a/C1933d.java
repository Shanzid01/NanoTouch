package com.slideme.sam.manager.view.p064a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.slideme.sam.manager.controller.fragment.p056a.C1725p;
import com.slideme.sam.manager.model.data.Category;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;

/* compiled from: CategoryDisplayPagerAdapter */
public class C1933d extends FragmentStatePagerAdapter {
    private Category f3542a;
    private Sort f3543b;

    public C1933d(FragmentManager fragmentManager, Category category, Sort sort) {
        super(fragmentManager);
        this.f3542a = category;
        this.f3543b = sort;
    }

    public int getCount() {
        return 3;
    }

    public Fragment getItem(int i) {
        Fragment c1725p = new C1725p();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.slideme.sam.manager.extra.CATEGORY", this.f3542a);
        if (this.f3543b != null) {
            bundle.putParcelable("com.slideme.sam.manager.extra.SORT", this.f3543b);
        }
        switch (i) {
            case 0:
                break;
            case 1:
                bundle.putInt("com.slideme.sam.manager.EXTRA_PRICE", 0);
                break;
            case 2:
                bundle.putInt("com.slideme.sam.manager.EXTRA_PRICE", 1);
                break;
            default:
                c1725p = null;
                break;
        }
        c1725p.setArguments(bundle);
        return c1725p;
    }

    public Sort m5838a() {
        return this.f3543b;
    }
}
