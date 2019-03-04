package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.net.C1881n;

/* compiled from: SupportDialog */
public class ah extends DialogFragment {
    private C1881n f2681a;
    private String f2682b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2681a = C1881n.values()[getArguments().getInt("com.slideme.sam.manager.extra.SUPPORT_RECEPIENT")];
        this.f2682b = getArguments().getString("com.slideme.sam.manager.EXTRA_BUNDLE_ID");
    }

    private View m4857a() {
        return ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.dialog_support, null);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View a = m4857a();
        return new Builder(getActivity()).setTitle(R.string.support).setView(a).setPositiveButton(17039370, new ai(this, (EditText) a.findViewById(R.id.subject), (EditText) a.findViewById(R.id.message))).create();
    }
}
