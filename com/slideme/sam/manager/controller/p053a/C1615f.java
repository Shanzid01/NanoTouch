package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragmentAllowingStateLoss;
import android.view.View;
import android.webkit.WebView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;

/* compiled from: EulaDialog */
public class C1615f extends DialogFragmentAllowingStateLoss implements OnClickListener {
    public Dialog onCreateDialog(Bundle bundle) {
        View webView = new WebView(getActivity());
        Dialog create = new Builder(getActivity()).setView(webView).setTitle(R.string.agreement_dialog_name).setPositiveButton(17039370, this).setNegativeButton(17039360, this).setCancelable(false).create();
        create.setCanceledOnTouchOutside(false);
        webView.setWebViewClient(new C1616g(this, create));
        webView.loadUrl(aj.m4860a(getActivity()));
        return create;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        CommonActivity commonActivity = (CommonActivity) getActivity();
        if (commonActivity != null) {
            switch (i) {
                case -2:
                    commonActivity.finish();
                    return;
                case -1:
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(commonActivity).edit();
                    edit.putBoolean("eulaAgreed", true);
                    edit.commit();
                    commonActivity.b_();
                    return;
                default:
                    return;
            }
        }
    }
}
