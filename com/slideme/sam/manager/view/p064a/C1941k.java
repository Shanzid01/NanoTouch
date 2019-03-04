package com.slideme.sam.manager.view.p064a;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.fragment.aa;
import com.slideme.sam.manager.controller.fragment.ae;
import com.slideme.sam.manager.controller.fragment.p056a.C1716f;
import com.slideme.sam.manager.controller.fragment.p056a.C1734z;
import com.slideme.sam.manager.controller.fragment.p056a.ac;
import com.slideme.sam.manager.controller.fragment.p056a.ad;
import com.slideme.sam.manager.controller.fragment.p056a.aj;
import com.slideme.sam.manager.controller.fragment.p056a.al;
import com.slideme.sam.manager.controller.fragment.p056a.am;
import com.slideme.sam.manager.controller.fragment.p056a.ap;
import com.slideme.sam.manager.model.p061a.C1815c;

/* compiled from: MainPagerAdapter */
public class C1941k extends FragmentStatePagerAdapter {
    private static String[] f3563d;
    private Context f3564a;
    private C1815c f3565b;
    private String f3566c;

    public C1941k(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        f3563d = context.getResources().getStringArray(R.array.front_page_titles);
        this.f3565b = new C1815c(context);
        this.f3564a = context;
        this.f3566c = "mainpage" + (SAM.f2615h.m5512c() ? "" : "_sme");
    }

    public CharSequence getPageTitle(int i) {
        if (i > 1 && !SAM.f2628u) {
            i++;
        }
        return f3563d[i];
    }

    public int getCount() {
        if (SAM.f2628u) {
            return f3563d.length;
        }
        return f3563d.length - 1;
    }

    public Fragment getItem(int i) {
        if (i > 1 && !SAM.f2628u) {
            i++;
        }
        Fragment c1716f;
        Bundle bundle;
        switch (i) {
            case 0:
                return new aa();
            case 1:
                return new ae();
            case 2:
                c1716f = new C1716f();
                bundle = new Bundle();
                bundle.putString("BUNDLE_EXTRA_AD_SLOT_ID", this.f3566c);
                bundle.putString("BUNDLE_EXTRA_LIMIT", "100");
                bundle.putString("BUNDLE_EXTRA_SOURCE", this.f3565b.m5433g());
                c1716f.setArguments(bundle);
                return c1716f;
            case 3:
                return new aj();
            case 4:
                return new am();
            case 5:
                c1716f = new al();
                bundle = new Bundle();
                bundle.putInt("com.slideme.sam.manager.EXTRA_PRICE", 1);
                c1716f.setArguments(bundle);
                return c1716f;
            case 6:
                c1716f = new ad();
                bundle = new Bundle();
                bundle.putInt("com.slideme.sam.manager.EXTRA_PRICE", 0);
                c1716f.setArguments(bundle);
                return c1716f;
            case 7:
                return new ap();
            case 8:
                return new ac();
            case 9:
                return new C1734z();
            default:
                return null;
        }
    }

    public float getPageWidth(int i) {
        if (i == 0 && this.f3564a.getResources().getBoolean(R.bool.showHalfScreenCategories)) {
            return 0.5f;
        }
        return super.getPageWidth(i);
    }
}
