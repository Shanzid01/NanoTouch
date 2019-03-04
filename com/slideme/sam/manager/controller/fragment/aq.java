package com.slideme.sam.manager.controller.fragment;

import android.accounts.AccountManager;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0090q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;

/* compiled from: MyAccountFragment */
public class aq extends SherlockFragment {
    private MenuItem f3055a;
    private BroadcastReceiver f3056b = new ar(this);
    private BroadcastReceiver f3057c = new as(this);
    private boolean f3058d = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.options_my_account, menu);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        boolean z = true;
        super.onPrepareOptionsMenu(menu);
        this.f3055a = menu.findItem(R.id.menu_switch_account);
        MenuItem menuItem = this.f3055a;
        if (AccountManager.get(getActivity()).getAccountsByType("com.slideme.user_account").length <= 1) {
            z = false;
        }
        menuItem.setVisible(z);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_switch_account:
                SAM.f2622o.m4847a(getActivity(), new at(this), false);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        SAM.m4763a(getActivity());
        if (AuthData.m4808d(getActivity())) {
            getView().findViewById(R.id.registerIndicator).setVisibility(0);
            getView().findViewById(R.id.registerButton).setVisibility(0);
            getView().findViewById(R.id.topup).setVisibility(8);
        } else {
            getView().findViewById(R.id.registerIndicator).setVisibility(8);
            getView().findViewById(R.id.registerButton).setVisibility(8);
            getView().findViewById(R.id.topup).setVisibility(0);
        }
        m5265a();
        ((TextView) getView().findViewById(R.id.username)).setText(AuthData.m4811g(getActivity()));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_account, null);
        inflate.findViewById(R.id.registerButton).setOnClickListener(new av(this));
        inflate.findViewById(R.id.topup).setOnClickListener(new aw(this));
        inflate.findViewById(R.id.storagelocker).setOnClickListener(new ax(this));
        return inflate;
    }

    public void onStart() {
        super.onStart();
        C0090q.m145a(getActivity()).m149a(this.f3057c, new IntentFilter("com.slideme.sam.manager.ACTION_WALLET_REFRESH_INITIATED"));
        C0090q.m145a(getActivity()).m149a(this.f3056b, new IntentFilter("com.slideme.sam.manager.ACTION_WALLET_REFRESH_FINISHED"));
    }

    public void onStop() {
        super.onStop();
        C0090q.m145a(getActivity()).m148a(this.f3057c);
        C0090q.m145a(getActivity()).m148a(this.f3056b);
    }

    private void m5265a() {
        if (AuthData.m4814j(getActivity()) < 0.0f) {
            m5266a(GroundOverlayOptions.NO_DIMENSION);
        } else {
            m5266a(AuthData.m4814j(getActivity()));
        }
    }

    private void m5266a(float f) {
        if (getActivity() != null && isAdded()) {
            CharSequence string;
            if (f < 0.0f) {
                string = getString(R.string.loading);
            } else {
                Object a = SAM.f2616i.m5487a((double) f);
            }
            ((TextView) getView().findViewById(R.id.user_wallet)).setText(string);
        }
    }
}
