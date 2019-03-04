package com.slideme.sam.manager.controller.fragment;

import android.app.Dialog;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/* compiled from: ApplicationDetailsFragment */
class C1767q implements Runnable {
    final /* synthetic */ C1735a f3146a;
    private final /* synthetic */ String f3147b;

    C1767q(C1735a c1735a, String str) {
        this.f3146a = c1735a;
        this.f3147b = str;
    }

    public void run() {
        Dialog dialog = new Dialog(this.f3146a.getActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_fb_share);
        CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.dontshowagain);
        Button button = (Button) dialog.findViewById(R.id.share);
        String string = this.f3146a.getString(R.string.sharearn_prompt);
        button.setText(string.substring(0, string.indexOf(" ")));
        button.setOnClickListener(new C1768r(this, this.f3147b, dialog));
        TextView textView = (TextView) dialog.findViewById(R.id.cancel);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new C1770t(this, checkBox, dialog));
        C0345b.m2427c().m2437a((C0359q) ((C0359q) ((C0359q) new C0359q("FBShare Show FB Share Dialog").m2364a("app", this.f3146a.f2989a.app.getName())).m2364a("country", this.f3146a.f2984H)).m2364a("channel", this.f3146a.getString(R.string.live_channel)));
        dialog.show();
        String language = Locale.getDefault().getLanguage();
        int i = ("en".equals(language) || "el".equals(language) || "fr".equals(language)) ? 0 : 1;
        if (i != 0) {
            checkBox.setVisibility(8);
            return;
        }
        TextView textView2 = (TextView) dialog.findViewById(R.id.description);
        if (this.f3146a.f2994f > 0.0d) {
            BigDecimal scale = new BigDecimal(this.f3146a.f2994f * ((double) (SAM.f2619l.m5428b() / 100.0f))).setScale(2, RoundingMode.HALF_UP);
            textView2.setText(this.f3146a.getString(R.string.earn_x_everytime, SAM.f2616i.m5487a(scale.doubleValue())));
            textView2.setVisibility(0);
            return;
        }
        textView2.setVisibility(8);
    }
}
