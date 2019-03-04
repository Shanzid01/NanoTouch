package com.slideme.sam.manager.controller.activities.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.SplashActivity;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

public class FlipperFragmentActivity extends CommonActivity {
    private SafeViewFlipper f2646a;
    private FrameLayout f2647b;

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("displayed_child", this.f2646a.getDisplayedChild());
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("displayed_child");
        if (i < this.f2646a.getChildCount()) {
            this.f2646a.setDisplayedChild(i);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f2646a = new SafeViewFlipper(this);
        this.f2646a.setLayoutParams(layoutParams);
        this.f2646a.setInAnimation(this, 17432576);
        this.f2646a.setOutAnimation(this, 17432577);
        this.f2646a.addView(getLayoutInflater().inflate(R.layout.widget_loading_activity, null), C1665j.LOADING.ordinal());
        this.f2646a.addView(getLayoutInflater().inflate(R.layout.widget_flipper_state_no_connectivity, null), C1665j.NO_CONNECTION.ordinal());
        this.f2646a.addView(m4798g(), C1665j.CONTENT.ordinal());
        m4790a(this.f2646a);
        super.setContentView(this.f2646a);
        if (getWindow().getDecorView().getBackground() == null) {
            findViewById(R.id.no_con_container).setBackgroundColor(-16777216);
        }
    }

    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, null), null);
    }

    public void setContentView(View view) {
        setContentView(view, null);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f2646a.addView(view, C1665j.CONTENT.ordinal());
    }

    private void m4790a(View view) {
        ((Button) view.findViewById(R.id.refresh)).setOnClickListener(new C1660e(this));
        ((Button) view.findViewById(R.id.wifiSettings)).setOnClickListener(new C1661f(this));
    }

    public void m4796e() {
        if (!C1922m.m5793a((Context) this)) {
            if (this instanceof SplashActivity) {
                m4788d();
            }
            mo4242b();
        } else if (TextUtils.isEmpty(SAM.f2614g.m5596a())) {
            C1922m.m5797b("Connect", "Device needs to connect");
            if (this instanceof SplashActivity) {
                this.f2646a.setDisplayedChild(C1665j.CONTENT.ordinal());
            }
            new C1662g().execute(new Void[0]);
        } else {
            C1922m.m5797b("Connect", "Device is connected");
            this.f2646a.setDisplayedChild(C1665j.CONTENT.ordinal());
            if (!this.k) {
                m4787c();
            } else if (this instanceof SplashActivity) {
                C1698a.m5060a(this, false, null, AuthData.m4813i(getApplicationContext()));
                finish();
            }
        }
    }

    public void mo4273f() {
        if (this.f2646a != null) {
            this.f2646a.setDisplayedChild(C1665j.LOADING.ordinal());
        }
    }

    private void mo4242b() {
        if (this.f2646a != null) {
            this.f2646a.setDisplayedChild(C1665j.NO_CONNECTION.ordinal());
        }
    }

    public void m4793a(View view, int i) {
        if (this.f2646a == null) {
            return;
        }
        if (this.f2646a.getChildAt(i) != null) {
            throw new IllegalArgumentException("Index already used");
        }
        this.f2646a.addView(view, i);
    }

    public void m4792a(int i) {
        if (i < C1665j.values().length) {
            throw new IllegalArgumentException("Use the other show*() methods");
        } else if (this.f2646a != null) {
            this.f2646a.setDisplayedChild(i);
        }
    }

    public FrameLayout m4798g() {
        if (this.f2647b == null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f2647b = new FrameLayout(this);
            this.f2647b.setLayoutParams(layoutParams);
            this.f2647b.setId(R.id.flipper_default_container);
        }
        return this.f2647b;
    }

    public void m4795b(int i) {
        ((TextView) findViewById(R.id.loading_description)).setText(i);
    }

    public void m4794a(CharSequence charSequence) {
        ((TextView) findViewById(R.id.loading_description)).setText(charSequence);
    }
}
