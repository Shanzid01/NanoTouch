package com.slideme.sam.manager.controller.activities.common;

import android.app.Activity;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.C0090q;
import android.view.View;
import android.widget.FrameLayout;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
import com.google.analytics.tracking.android.C0771n;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.SamUpdateActivity;
import com.slideme.sam.manager.controller.activities.SplashActivity;
import com.slideme.sam.manager.controller.p053a.C1615f;
import com.slideme.sam.manager.controller.p053a.al;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.p061a.C1818f;
import com.slideme.sam.manager.model.p061a.C1822j;
import com.slideme.sam.manager.util.C1922m;

public abstract class CommonActivity extends SherlockFragmentActivity {
    private boolean f2641a = true;
    private boolean f2642b = false;
    private BroadcastReceiver f2643c = new C1658c(this);
    private BroadcastReceiver f2644d = new C1659d(this);
    protected boolean f2645k;

    protected void m4787c() {
        if (getSupportFragmentManager().findFragmentByTag("EULA_DIALOG") == null) {
            try {
                new C1615f().show(getSupportFragmentManager(), "EULA_DIALOG");
            } catch (Exception e) {
                C1922m.m5790a(e);
            }
        }
    }

    public void b_() {
    }

    protected void onCreate(Bundle bundle) {
        this.f2642b = bundle != null;
        if (this.f2641a) {
            m4788d();
        }
        super.onCreate(bundle);
        this.f2645k = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("eulaAgreed", false);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        C0090q.m145a((Context) this).m149a(this.f2643c, new IntentFilter("com.slideme.sam.manager.action.KILL_SAM"));
        C0090q.m145a((Context) this).m149a(this.f2644d, new IntentFilter("com.slideme.sam.manager.action.REFRESH_SAM"));
    }

    protected void onDestroy() {
        super.onDestroy();
        C0090q.m145a((Context) this).m148a(this.f2643c);
        C0090q.m145a((Context) this).m148a(this.f2644d);
    }

    protected void onStart() {
        super.onStart();
        C0771n.m3938a().m3944a((Activity) this);
    }

    protected void onPostResume() {
        super.onPostResume();
        if (!(this instanceof SplashActivity) && !(this instanceof SamUpdateActivity)) {
            C1818f c1818f = SAM.f2620m;
            if ((c1818f.m5465a() == C1822j.INSTALL || c1818f.m5465a() == C1822j.UPDATE) && ((al) getSupportFragmentManager().findFragmentByTag("UpdateDialog")) == null) {
                al alVar = new al();
                Bundle bundle = new Bundle();
                bundle.putInt("status", c1818f.m5465a().ordinal());
                alVar.setArguments(bundle);
                alVar.show(getSupportFragmentManager(), "UpdateDialog");
            }
        }
    }

    protected void onStop() {
        super.onStop();
        C0771n.m3938a().m3947b(this);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.menu_search);
        MenuItem findItem2 = menu.findItem(R.id.menu_search_view);
        if (!(findItem == null || findItem2 == null)) {
            if (VERSION.SDK_INT >= 8) {
                SearchManager searchManager = (SearchManager) getSystemService("search");
                SearchView searchView = (SearchView) menu.findItem(R.id.menu_search_view).getActionView();
                if (!(searchView == null || searchManager == null)) {
                    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                }
                findItem.setVisible(false);
                findItem2.setVisible(true);
            } else {
                findItem.setVisible(true);
                findItem2.setVisible(false);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                C1698a.m5059a((Activity) this, true, null);
                return true;
            case R.id.menu_search:
                onSearchRequested();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void m4788d() {
        switch (SAM.f2613f.m5447d()) {
            case 0:
                setTheme(R.style.Theme.Slideme.Dark);
                break;
            case 1:
                setTheme(R.style.Theme.Slideme.Light);
                break;
        }
        View findViewById = getWindow().getDecorView().findViewById(16908290);
        if ((findViewById instanceof FrameLayout) && VERSION.SDK_INT < 14) {
            ((FrameLayout) findViewById).setForeground(null);
        }
    }

    protected void m4786b(boolean z) {
        this.f2641a = z;
    }
}
