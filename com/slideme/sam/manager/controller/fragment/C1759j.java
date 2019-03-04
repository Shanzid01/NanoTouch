package com.slideme.sam.manager.controller.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import java.util.ArrayList;

/* compiled from: ApplicationDetailsFragment */
class C1759j implements OnClickListener {
    final /* synthetic */ C1735a f3133a;
    private final /* synthetic */ Intent f3134b;
    private final /* synthetic */ ArrayList f3135c;

    C1759j(C1735a c1735a, Intent intent, ArrayList arrayList) {
        this.f3133a = c1735a;
        this.f3134b = intent;
        this.f3135c = arrayList;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3134b.setPackage((String) this.f3135c.get(i));
        this.f3133a.m5217a(this.f3134b, (String) this.f3135c.get(i));
    }
}
