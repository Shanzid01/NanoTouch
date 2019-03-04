package com.slideme.sam.manager.auth;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.access.LoginActivity;

public class AuthenticatorActivity extends LoginActivity {
    public static String f2655a = "112166135536105";
    private Button f2656e;
    private EditText f2657f;
    private EditText f2658g;
    private UiLifecycleHelper f2659h;
    private StatusCallback f2660i = new C1598b(this);

    private void m4822a(Session session, SessionState sessionState, Exception exception) {
        if (sessionState.isOpened()) {
            this.b.setMessage(getString(R.string.login_progress));
            mo4228a(true);
            SAM.f2614g.m5637b(session.getAccessToken(), new C1601c(this, session));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m4830b(null);
        if (getIntent().hasExtra("com.slideme.sam.manager.EXTRA_USERNAME") && getIntent().hasExtra("com.slideme.sam.manager.EXTRA_PASSWORD") && ((TextView) findViewById(R.id.user_edit)).getText().length() != 0 && ((TextView) findViewById(R.id.pass_edit)).getText().length() != 0) {
            m4819a(this.f2657f.getText().toString(), this.f2658g.getText().toString());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2659h = new UiLifecycleHelper(this, this.f2660i);
        this.f2659h.onCreate(bundle);
        m4827b();
        m4830b(bundle);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public void m4830b(Bundle bundle) {
        if (getIntent().hasExtra("com.slideme.sam.manager.EXTRA_USERNAME")) {
            ((TextView) findViewById(R.id.user_edit)).setText(getIntent().getStringExtra("com.slideme.sam.manager.EXTRA_USERNAME"));
        }
        if (getIntent().hasExtra("com.slideme.sam.manager.EXTRA_PASSWORD")) {
            ((TextView) findViewById(R.id.pass_edit)).setText(getIntent().getStringExtra("com.slideme.sam.manager.EXTRA_PASSWORD"));
        }
    }

    private void m4827b() {
        setContentView((int) R.layout.activity_login);
        m4796e();
        this.f2656e = (Button) findViewById(R.id.login);
        this.f2657f = (EditText) findViewById(R.id.user_edit);
        this.f2658g = (EditText) findViewById(R.id.pass_edit);
        Button button = (Button) findViewById(R.id.register);
        Button button2 = (Button) findViewById(R.id.forgotPassword);
        this.f2658g.setOnEditorActionListener(new C1602d(this));
        this.f2657f.setOnEditorActionListener(new C1603e(this));
        this.f2656e.setOnClickListener(new C1604f(this));
        button.setOnClickListener(new C1605g(this));
        button2.setOnClickListener(new C1606h(this));
        LoginButton loginButton = (LoginButton) findViewById(R.id.facebook_register);
        if (VERSION.SDK_INT < 9) {
            loginButton.setVisibility(8);
            return;
        }
        loginButton.setReadPermissions("email");
        loginButton.setSessionStatusCallback(this.f2660i);
    }

    private void m4828c(boolean z) {
        this.f2656e.setEnabled(z);
        this.f2656e.setClickable(z);
        this.f2656e.setFocusable(z);
    }

    protected void mo4228a(boolean z) {
        super.mo4228a(z);
        m4828c(!z);
    }

    public void onResume() {
        super.onResume();
        Session activeSession = Session.getActiveSession();
        if (activeSession != null && (activeSession.isOpened() || activeSession.isClosed())) {
            m4822a(activeSession, activeSession.getState(), null);
        }
        this.f2659h.onResume();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f2659h.onActivityResult(i, i2, intent);
    }

    public void onPause() {
        super.onPause();
        this.f2659h.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f2659h.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f2659h.onSaveInstanceState(bundle);
    }
}
