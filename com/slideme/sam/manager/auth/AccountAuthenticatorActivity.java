package com.slideme.sam.manager.auth;

import android.accounts.AccountAuthenticatorResponse;
import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.AboutActivity;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;

public class AccountAuthenticatorActivity extends FlipperFragmentActivity {
    private AccountAuthenticatorResponse f2648a = null;
    private Bundle f2649b = null;

    public final void m4799a(Bundle bundle) {
        this.f2649b = bundle;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4796e();
        this.f2648a = (AccountAuthenticatorResponse) getIntent().getParcelableExtra("accountAuthenticatorResponse");
        if (this.f2648a != null) {
            this.f2648a.onRequestContinued();
        }
    }

    public void finish() {
        if (this.f2648a != null) {
            if (this.f2649b != null) {
                this.f2648a.onResult(this.f2649b);
            } else {
                this.f2648a.onError(4, "canceled");
            }
            this.f2648a = null;
        }
        super.finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_login, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent();
        switch (menuItem.getItemId()) {
            case R.id.menu_about:
                intent.setClass(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
