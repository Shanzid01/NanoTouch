package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import com.p026b.p027a.p034b.C0510g;

public class ClearCacheDialogPreference extends DialogPreference {
    public ClearCacheDialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ClearCacheDialogPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                dialogInterface.dismiss();
                break;
            case -1:
                C0510g.m3081a().m3085b().mo915a();
                dialogInterface.dismiss();
                break;
        }
        super.onClick(dialogInterface, i);
    }
}
