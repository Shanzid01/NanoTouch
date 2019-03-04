package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;

/* compiled from: SortDialog */
class af implements OnClickListener {
    final /* synthetic */ ad f2680a;

    af(ad adVar) {
        this.f2680a = adVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f2680a.f2678b = new Sort(1, 3);
                return;
            case 1:
                this.f2680a.f2678b = new Sort(1, 1);
                return;
            case 2:
                this.f2680a.f2678b = new Sort(1, 6);
                return;
            case 3:
                this.f2680a.f2678b = new Sort(1, 5);
                return;
            case 4:
                this.f2680a.f2678b = new Sort(0, 5);
                return;
            case 5:
                this.f2680a.f2678b = new Sort(0, 0);
                return;
            case 6:
                this.f2680a.f2678b = new Sort(1, 0);
                return;
            default:
                return;
        }
    }
}
