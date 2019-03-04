package com.slideme.sam.manager.controller.activities.market.userinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.fragment.p056a.C1724o;
import com.slideme.sam.manager.controller.fragment.p056a.aa;
import com.slideme.sam.manager.controller.fragment.p056a.ag;

/* compiled from: MyAppsActivity */
class C1694a extends FragmentStatePagerAdapter {
    Fragment[] f2872a = new Fragment[3];
    String[] f2873b = null;
    final /* synthetic */ MyAppsActivity f2874c;

    public C1694a(MyAppsActivity myAppsActivity, FragmentManager fragmentManager) {
        this.f2874c = myAppsActivity;
        super(fragmentManager);
        this.f2872a[0] = new ag();
        this.f2872a[1] = new aa();
        this.f2872a[2] = new C1724o();
        this.f2873b = myAppsActivity.getResources().getStringArray(R.array.my_apps_tab_titles);
    }

    public Fragment getItem(int i) {
        return this.f2872a[i];
    }

    public int getCount() {
        return this.f2872a.length;
    }

    public CharSequence getPageTitle(int i) {
        return this.f2873b[i];
    }
}
