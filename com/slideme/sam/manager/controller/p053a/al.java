package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.p061a.C1818f;
import com.slideme.sam.manager.model.p061a.C1822j;

/* compiled from: UpdateDialog */
public class al extends DialogFragment implements OnClickListener {
    C1818f f2688a;
    C1822j f2689b;
    Intent f2690c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2689b = C1822j.values()[getArguments().getInt("status")];
    }

    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        this.f2688a = SAM.f2620m;
        m4861a();
        Dialog create = new Builder(getActivity()).setMessage(getString(R.string.title_application) + " " + getResources().getQuantityString(R.plurals.updates_available, 1, new Object[]{Integer.valueOf(1)})).setPositiveButton(17039370, this).setNegativeButton(17039360, this).setCancelable(false).create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                getActivity().finish();
                return;
            case -1:
                if (this.f2690c != null) {
                    startActivity(this.f2690c);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m4861a() {
        if (this.f2689b == C1822j.UPDATE) {
            this.f2690c = C1818f.m5456a(getActivity());
        } else if (this.f2689b == C1822j.INSTALL) {
            this.f2690c = C1818f.m5459b(getActivity());
        }
    }
}
