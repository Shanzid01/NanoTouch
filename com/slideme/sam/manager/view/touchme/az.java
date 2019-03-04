package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/* compiled from: VerifyableEditText */
class az implements OnClickListener {
    final /* synthetic */ VerifyableEditText f3820a;

    az(VerifyableEditText verifyableEditText) {
        this.f3820a = verifyableEditText;
    }

    public void onClick(View view) {
        if (this.f3820a.f3768i != bc.VERIFIED && this.f3820a.f3767h != null && !this.f3820a.f3767h.equals("")) {
            int[] iArr = new int[2];
            this.f3820a.f3765f.getLocationOnScreen(iArr);
            Toast makeText = Toast.makeText(this.f3820a.getContext(), this.f3820a.f3767h, 0);
            makeText.setGravity(51, iArr[0], iArr[1]);
            makeText.show();
        }
    }
}
