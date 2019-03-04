package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: SupportDialog */
class ai implements OnClickListener {
    final /* synthetic */ ah f2683a;
    private final /* synthetic */ EditText f2684b;
    private final /* synthetic */ EditText f2685c;

    ai(ah ahVar, EditText editText, EditText editText2) {
        this.f2683a = ahVar;
        this.f2684b = editText;
        this.f2685c = editText2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Toast a;
        if (this.f2684b.getText().length() <= 0) {
            a = C1920k.m5782a(this.f2683a.getActivity(), "Subject: " + this.f2683a.getString(R.string.generic_empty), 0);
            a.getView().setBackgroundResource(R.drawable.toast_frame);
            a.show();
        } else if (this.f2685c.getText().length() <= 30) {
            a = Toast.makeText(this.f2683a.getActivity(), "Message: " + (this.f2685c.getText().length() > 0 ? "Too short" : this.f2683a.getString(R.string.generic_empty)), 0);
            a.getView().setBackgroundResource(R.drawable.toast_frame);
            a.show();
        } else {
            SAM.f2614g.m5625a(this.f2683a.f2682b, this.f2684b.getText().toString(), this.f2685c.getText().toString(), this.f2683a.f2681a, new C1600v());
        }
    }
}
