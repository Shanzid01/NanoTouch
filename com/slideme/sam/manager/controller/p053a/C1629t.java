package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.net.C1600v;

/* compiled from: ReportDialog */
public class C1629t extends DialogFragment {
    private ApplicationHolder f2716a;

    public void onCreate(Bundle bundle) {
        this.f2716a = (ApplicationHolder) getArguments().getParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER");
        super.onCreate(bundle);
    }

    private View m4877a() {
        return ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.dialog_report, null);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View a = m4877a();
        Spinner spinner = (Spinner) a.findViewById(R.id.reasonSpinner);
        EditText editText = (EditText) a.findViewById(R.id.reasonText);
        spinner.setOnItemSelectedListener(new C1630u(this, editText));
        return new Builder(getActivity()).setPositiveButton(17039370, new C1631v(this, spinner, editText)).setTitle(R.string.report).setView(a).create();
    }

    private void m4878a(int i, String str) {
        int i2 = 41;
        int i3 = 20;
        if (this.f2716a != null && getActivity() != null) {
            Object obj = this.f2716a.getInstallState(getActivity()) != C1828b.NOT_INSTALLED ? 1 : null;
            switch (i) {
                case 0:
                    i2 = 10;
                    break;
                case 1:
                    if (obj != null) {
                        i2 = 42;
                        break;
                    }
                    break;
                case 2:
                    if (obj == null) {
                        i2 = 20;
                        break;
                    } else {
                        i2 = 43;
                        break;
                    }
                case 3:
                    if (obj == null) {
                        i2 = 30;
                        break;
                    }
                    break;
                case 4:
                    if (obj == null) {
                        i3 = 60;
                    }
                    i2 = i3;
                    break;
                case 5:
                    i2 = 30;
                    break;
                case 6:
                    i2 = 60;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            SAM.f2614g.m5608a(this.f2716a.app, i2, str, new C1600v());
        }
    }
}
