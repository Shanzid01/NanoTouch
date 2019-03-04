package com.slideme.sam.manager.controller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.actions.SearchIntents;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;
import com.slideme.sam.manager.controller.fragment.ap;
import com.slideme.sam.manager.controller.fragment.p056a.C1728t;
import com.slideme.sam.manager.controller.fragment.p056a.C1729u;
import com.slideme.sam.manager.controller.fragment.p056a.C1730v;
import com.slideme.sam.manager.controller.fragment.p056a.C1731w;
import com.slideme.sam.manager.controller.fragment.p056a.C1732x;
import com.slideme.sam.manager.controller.fragment.p056a.C1733y;
import com.slideme.sam.manager.controller.fragment.p056a.af;
import com.slideme.sam.manager.model.data.cache.SamSuggestionProvider;
import com.slideme.sam.manager.view.p064a.C1949t;

public class SearchActivity extends CommonActivity implements ap {
    private C1949t f2737a;
    private ViewPager f2738b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_search);
        this.f2738b = (ViewPager) findViewById(R.id.pager);
        m4905a(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_search, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_filter:
                this.f2738b.setCurrentItem(1);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m4905a(Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.SEARCH".equals(action)) {
            m4906a("q=" + getIntent().getStringExtra(SearchIntents.EXTRA_QUERY));
        } else if ("android.intent.action.VIEW".equals(action)) {
            m4906a(intent.getData().getQuery());
        }
    }

    private void m4906a(String str) {
        String trim = str.split("=")[1].trim();
        setTitle(trim);
        new SearchRecentSuggestions(this, SamSuggestionProvider.AUTHORITY, 1).saveRecentQuery(trim, null);
        this.f2737a = new C1949t(getSupportFragmentManager(), trim);
        this.f2738b.m186a(this.f2737a);
    }

    public void mo4237a(C1732x c1732x, C1730v c1730v, C1731w c1731w, C1728t c1728t, C1729u c1729u, C1733y c1733y) {
        af a = this.f2737a.m5854a();
        a.a = c1732x;
        a.b = c1730v;
        a.i = c1731w;
        a.j = c1728t;
        a.k = c1729u;
        a.l = c1733y;
        a.m5126f();
        this.f2738b.setCurrentItem(0);
    }
}
