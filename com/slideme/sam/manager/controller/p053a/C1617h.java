package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.R;

/* compiled from: PasswordCheckDialog */
public class C1617h extends DialogFragment {
    private EditText f2701a;
    private AlertDialog f2702b;
    private C1622m f2703c;
    private Context f2704d;
    private AsyncHttpResponseHandler f2705e = new C1618i(this);

    public Dialog onCreateDialog(Bundle bundle) {
        m4865a();
        this.f2704d = getActivity().getApplicationContext();
        this.f2702b = new Builder(getActivity()).setPositiveButton(17039370, new C1619j(this)).setNegativeButton(17039360, new C1620k(this)).setView(this.f2701a).setTitle(R.string.confirm_password).setCancelable(false).create();
        this.f2702b.setCanceledOnTouchOutside(false);
        this.f2701a.addTextChangedListener(new C1621l(this));
        return this.f2702b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.f2702b.getButton(-1).setEnabled(false);
        super.onViewCreated(view, bundle);
    }

    private void m4865a() {
        this.f2701a = new EditText(getActivity());
        this.f2701a.setLayoutParams(new LayoutParams(-1, -2));
        this.f2701a.setImeOptions(6);
        this.f2701a.setInputType(129);
        this.f2701a.setHint(R.string.password);
    }

    public static boolean m4866a(Context context, int i) {
        return System.currentTimeMillis() - C1617h.m4863a(context) > 60000 * ((long) i);
    }

    private static long m4863a(Context context) {
        return context.getSharedPreferences("pcd_preferences", 0).getLong("last_checked", 0);
    }

    public C1617h m4871a(C1622m c1622m) {
        this.f2703c = c1622m;
        return this;
    }
}
