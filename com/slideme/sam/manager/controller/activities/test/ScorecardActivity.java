package com.slideme.sam.manager.controller.activities.test;

import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.data.cache.helper.TestModeCache;
import com.slideme.sam.manager.model.data.test.ScoreCardData;
import com.slideme.sam.manager.model.data.test.ScoreCardItem;
import com.slideme.sam.manager.view.touchme.ScorecardView;
import java.util.ArrayList;

public class ScorecardActivity extends AccountAwareActivity {
    private ScorecardView f2881a;
    private ApplicationHolder f2882b;
    private boolean f2883c = false;
    private boolean f2884d = false;
    private ArrayList<ScoreCardItem> f2885e;
    private ArrayList<ScoreCardItem> f2886f;
    private ArrayList<ScoreCardItem> f2887g;
    private String f2888h;

    public void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scorecard);
        this.f2882b = (ApplicationHolder) getIntent().getParcelableExtra("com.slideme.sam.manager.EXTRA_APPHOLDER");
        this.f2881a = (ScorecardView) findViewById(R.id.scorecard);
        if (bundle != null) {
            bundle.setClassLoader(ScoreCardItem.class.getClassLoader());
            this.f2885e = bundle.getParcelableArrayList("STATE_GLOBAL_LIST");
            this.f2886f = bundle.getParcelableArrayList("STATE_DEVELOPER_LIST");
            this.f2887g = bundle.getParcelableArrayList("STATE_TESTER_LIST");
            this.f2888h = bundle.getString("STATE_CARD_ID");
            m5040h();
            return;
        }
        setSupportProgressBarIndeterminateVisibility(true);
        SAM.f2614g.m5640c(this.f2882b.app.packageName, new C1696b(this));
    }

    private void m5040h() {
        this.f2881a.m6027a(this, this.f2885e, this.f2886f, this.f2887g);
        setSupportProgressBarIndeterminateVisibility(false);
        m4796e();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("STATE_GLOBAL_LIST", this.f2885e);
        bundle.putParcelableArrayList("STATE_DEVELOPER_LIST", this.f2886f);
        bundle.putParcelableArrayList("STATE_TESTER_LIST", this.f2887g);
        bundle.putString("STATE_CARD_ID", this.f2888h);
        super.onSaveInstanceState(bundle);
    }

    public void mo4242b() {
        ScoreCardData a = this.f2881a.m6026a();
        a.version_name = new StringBuilder(String.valueOf(this.f2882b.app.version)).append(".").append(this.f2882b.app.versionCode).toString();
        a.package_name = this.f2882b.app.packageName;
        SAM.f2614g.m5621a(this.f2888h, a, new C1697c(this));
        setSupportProgressBarIndeterminateVisibility(true);
        this.f2883c = true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_test, menu);
        menu.findItem(R.id.skip).setVisible(((SAM) getApplication()).m4779c());
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f2883c || this.f2884d) {
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.skip:
                m5041i();
                finish();
                return true;
            case R.id.done:
                mo4242b();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void m5041i() {
        TestModeCache testModeCache = new TestModeCache(this);
        if (testModeCache.has(this.f2882b.app.bundleId)) {
            testModeCache.close();
            return;
        }
        testModeCache.close();
        Intent intent = new Intent(this, ApproveActivity.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
    }

    public void mo4239a() {
        if (!AuthData.m4807c(this)) {
            finish();
        }
    }
}
