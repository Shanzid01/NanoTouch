package com.slideme.sam.manager.view.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;

/* compiled from: MultiselectListPreference */
class C1959a implements OnMultiChoiceClickListener {
    final /* synthetic */ MultiselectListPreference f3637a;

    C1959a(MultiselectListPreference multiselectListPreference) {
        this.f3637a = multiselectListPreference;
    }

    public void onClick(DialogInterface dialogInterface, int i, boolean z) {
        if (z) {
            MultiselectListPreference multiselectListPreference = this.f3637a;
            multiselectListPreference.f3632e = multiselectListPreference.f3632e | this.f3637a.f3631d.add(this.f3637a.f3629b[i].toString());
            return;
        }
        multiselectListPreference = this.f3637a;
        multiselectListPreference.f3632e = multiselectListPreference.f3632e | this.f3637a.f3631d.remove(this.f3637a.f3629b[i].toString());
    }
}
