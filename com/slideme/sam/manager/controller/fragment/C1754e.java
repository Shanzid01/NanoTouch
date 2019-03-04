package com.slideme.sam.manager.controller.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.slideme.sam.manager.R;

/* compiled from: ApplicationDetailsFragment */
class C1754e implements OnLongClickListener {
    final /* synthetic */ C1735a f3124a;

    C1754e(C1735a c1735a) {
        this.f3124a = c1735a;
    }

    @SuppressLint({"InlinedApi"})
    public boolean onLongClick(View view) {
        Toast makeText = Toast.makeText(this.f3124a.getActivity(), R.string.bookmark, 0);
        makeText.setGravity(8388659, view.getLeft() - 50, view.getBottom());
        makeText.show();
        return true;
    }
}
