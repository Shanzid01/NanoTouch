package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.slideme.sam.manager.R;

/* compiled from: PrivacyPolicyDialog */
public class C1627r extends DialogFragment {
    String f2714a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2714a = getArguments().getString("com.slideme.sam.manager.extra.TEXT");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Builder(getActivity()).setTitle(R.string.privacy_policy).setMessage(R.string.privacy_policy_text).setNeutralButton(17039370, new C1628s(this)).create();
    }
}
