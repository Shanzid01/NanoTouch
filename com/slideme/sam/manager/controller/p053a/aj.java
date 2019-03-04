package com.slideme.sam.manager.controller.p053a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.webkit.WebView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import java.util.Locale;

/* compiled from: TermsAndConditionsDialog */
public class aj extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        View webView = new WebView(getActivity());
        Dialog create = new Builder(getActivity()).setView(webView).setTitle(R.string.terms_and_conditions).setPositiveButton(17039370, null).create();
        webView.setWebViewClient(new ak(this, create));
        webView.loadUrl(aj.m4860a(getActivity()));
        return create;
    }

    public static String m4860a(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder(activity.getString(R.string.SLIDEME_EULA_URL));
        stringBuilder.append("?partner=").append(((SAM) activity.getApplication()).m4780d());
        stringBuilder.append("&locale=").append(Locale.getDefault().toString());
        return stringBuilder.toString();
    }
}
