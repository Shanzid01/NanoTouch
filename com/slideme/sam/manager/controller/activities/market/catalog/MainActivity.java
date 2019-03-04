package com.slideme.sam.manager.controller.activities.market.catalog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.C0090q;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.facebook.AppEventsConstants;
import com.mopub.mobileads.MoPubView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.AboutActivity;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.activities.market.userinfo.MyAccountActivity;
import com.slideme.sam.manager.controller.activities.market.userinfo.MyAppsActivity;
import com.slideme.sam.manager.controller.activities.preference.SettingsActivity;
import com.slideme.sam.manager.model.p061a.C1815c;
import com.slideme.sam.manager.model.p061a.C1818f;
import com.slideme.sam.manager.model.p061a.C1822j;
import com.slideme.sam.manager.view.p064a.C1941k;
import com.slideme.sam.manager.view.touchme.C1972e;
import com.slideme.sam.manager.view.touchme.ClosableTextPanel;
import java.util.Locale;

public class MainActivity extends FlipperFragmentActivity {
    private static String f2808a = "STATE_LAST_POSITION";
    private ViewPager f2809b;
    private LinearLayout f2810c;
    private MoPubView f2811d;
    private C1818f f2812e;
    private C1815c f2813f;
    private ClosableTextPanel f2814g;
    private int f2815h = 1;
    private BroadcastReceiver f2816i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2812e = SAM.f2620m;
        this.f2813f = SAM.f2619l;
        setContentView((int) R.layout.activity_main);
        m4968b();
        m4796e();
        this.f2816i = new C1667b(this);
        if (bundle != null) {
            this.f2815h = bundle.getInt(f2808a, 1);
        }
        IntentFilter intentFilter = new IntentFilter("com.slideme.sam.manager.ACTION_DAILY_UPDATED");
        intentFilter.addAction("com.slideme.sam.manager.ACTION_NOTIFICATION_BANNER_REFRESH");
        C0090q.m145a((Context) this).m149a(this.f2816i, intentFilter);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    private void m4968b() {
        m4973h();
        this.f2814g = (ClosableTextPanel) findViewById(R.id.bottom);
        this.f2814g.setTitle(R.string.bottom_notif);
        this.f2814g.setOnClickListener(new C1668c(this));
        this.f2809b = (ViewPager) findViewById(R.id.pager);
        this.f2809b.m186a(new C1941k(getSupportFragmentManager(), this));
        this.f2809b.setCurrentItem(this.f2815h);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent();
        switch (menuItem.getItemId()) {
            case R.id.menu_about:
                intent.setClass(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_myapps:
                intent.setClass(this, MyAppsActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_categories:
                switch (this.f2809b.getCurrentItem()) {
                    case 0:
                        this.f2809b.setCurrentItem(this.f2815h);
                        return true;
                    default:
                        this.f2815h = this.f2809b.getCurrentItem();
                        this.f2809b.setCurrentItem(0);
                        return true;
                }
            case R.id.menu_myaccount:
                intent.setClass(this, MyAccountActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_updates:
                intent.setClass(this, UpdatesListActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_settings:
                intent.setClass(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_help:
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(getString(R.string.SLIDEME_HTTPS_URL) + "/mobile/faq?locale=" + Locale.getDefault().getLanguage() + "#t203"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m4973h() {
        this.f2811d = (MoPubView) findViewById(R.id.adview);
        if (this.f2813f.m5429c()) {
            this.f2810c = (LinearLayout) findViewById(R.id.adViewsContainer);
            m4966a(this.f2811d, getString(R.string.pub_id_320x50));
        } else if (this.f2811d != null) {
            this.f2811d.m4349c();
        }
    }

    private void m4966a(MoPubView moPubView, String str) {
        if (moPubView != null) {
            moPubView.m4344a(str);
            moPubView.m4348b("m_channel:" + ((SAM) getApplication()).m4780d() + ",m_hps:" + (SAM.f2615h.m5512c() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO));
            moPubView.m4343a(new C1669d(this, moPubView));
            moPubView.m4346b();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(f2808a, this.f2809b.getCurrentItem());
        super.onSaveInstanceState(bundle);
    }

    protected void onDestroy() {
        if (this.f2811d != null) {
            this.f2811d.m4349c();
        }
        if (this.f2816i != null) {
            C0090q.m145a((Context) this).m148a(this.f2816i);
        }
        super.onDestroy();
    }

    private void m4974i() {
        if (this.f2812e.m5465a() == C1822j.INSTALL) {
            m4977l();
        } else if (this.f2812e.m5465a() == C1822j.UPDATE) {
            m4976k();
        } else if (this.f2812e.m5465a() == C1822j.NOUPDATE && !this.f2813f.m5426a()) {
            m4975j();
        }
    }

    private void m4975j() {
        if (!TextUtils.isEmpty(this.f2813f.m5434h()) && this.f2814g.m5920a() != C1972e.UPDATE_PANEL) {
            this.f2814g.m5921a(this.f2813f.m5435i() ? C1972e.STICKY_PANEL : C1972e.CLOSABLE_PANEL);
            this.f2814g.m5922a(this.f2813f.m5434h());
            this.f2814g.setOnClickListener(new C1670e(this));
            this.f2814g.m5925c();
        }
    }

    private void m4976k() {
        this.f2814g.m5921a(C1972e.UPDATE_PANEL);
        this.f2814g.m5922a("SlideME: " + getResources().getQuantityString(R.plurals.updates_available, 1, new Object[]{Integer.valueOf(1)}));
        this.f2814g.setSubtitle(R.string.touch_to_update);
        this.f2814g.setOnClickListener(new C1671f(this));
        this.f2814g.m5925c();
    }

    private void m4977l() {
        this.f2814g.m5921a(C1972e.UPDATE_PANEL);
        this.f2814g.m5922a("SlideME: " + getResources().getQuantityString(R.plurals.updates_available, 1, new Object[]{Integer.valueOf(1)}));
        this.f2814g.setSubtitle(R.string.touch_to_update);
        this.f2814g.setOnClickListener(new C1672g(this));
        this.f2814g.m5925c();
    }
}
