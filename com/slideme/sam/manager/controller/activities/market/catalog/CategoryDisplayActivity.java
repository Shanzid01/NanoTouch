package com.slideme.sam.manager.controller.activities.market.catalog;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.p053a.ad;
import com.slideme.sam.manager.controller.p053a.ag;
import com.slideme.sam.manager.model.data.Category;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;
import com.slideme.sam.manager.view.C1950a;
import com.slideme.sam.manager.view.p064a.C1933d;
import com.slideme.sam.manager.view.touchme.SlidingTabSelector;

public class CategoryDisplayActivity extends FlipperFragmentActivity implements ag {
    private SlidingTabSelector f2800a = null;
    private C1933d f2801b;
    private ViewPager f2802c;
    private Category f2803d;
    private MenuItem f2804e;
    private boolean f2805f = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2803d = (Category) getIntent().getParcelableExtra("com.slideme.sam.manager.extra.CATEGORY");
        setTitle(C1950a.m5855a(this.f2803d.name));
        setContentView((int) R.layout.activity_display_category);
        mo4242b();
    }

    private void m4960h() {
        this.f2802c = (ViewPager) findViewById(R.id.viewpager);
        this.f2800a = (SlidingTabSelector) findViewById(R.id.layout_filter);
        this.f2800a.setVisibility(0);
        for (int i = 0; i < this.f2800a.getChildCount(); i++) {
            this.f2800a.getChildAt(i).setOnFocusChangeListener(new C1666a(this));
        }
        mo4246a(new Sort(1, 3));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_category_display, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.f2804e = menu.findItem(R.id.sort);
        if (!this.f2805f) {
            this.f2804e.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.sort:
                ad adVar = new ad();
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.slideme.sam.manager.extra.SORT", this.f2801b.m5838a());
                adVar.setArguments(bundle);
                adVar.show(getSupportFragmentManager(), "sortDialog");
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void mo4246a(Sort sort) {
        if (this.f2801b == null || !this.f2801b.m5838a().equals(sort)) {
            int currentItem = this.f2802c.getCurrentItem();
            this.f2801b = new C1933d(getSupportFragmentManager(), this.f2803d, sort);
            this.f2802c.m186a(this.f2801b);
            this.f2800a.m6042a(this.f2802c);
            this.f2802c.setCurrentItem(currentItem);
        }
    }

    public void mo4242b() {
        m4960h();
        m4796e();
        if (this.f2804e != null) {
            this.f2804e.setVisible(true);
        }
        this.f2805f = true;
    }
}
