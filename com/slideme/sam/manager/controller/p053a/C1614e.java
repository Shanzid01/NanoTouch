package com.slideme.sam.manager.controller.p053a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.slideme.sam.manager.R;

/* compiled from: CommunicatingProgressDialogFragment */
public class C1614e extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
