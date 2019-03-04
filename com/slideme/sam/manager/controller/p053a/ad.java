package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;

/* compiled from: SortDialog */
public class ad extends DialogFragment {
    private String[] f2677a;
    private Sort f2678b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2677a = getResources().getStringArray(R.array.sort_names);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Builder(getActivity()).setTitle(R.string.sort_by).setNegativeButton(17039360, null).setPositiveButton(17039370, new ae(this)).setSingleChoiceItems(this.f2677a, m4853a(), new af(this)).create();
    }

    private int m4853a() {
        Sort sort = (Sort) getArguments().getParcelable("com.slideme.sam.manager.extra.SORT");
        if (sort == null) {
            return -1;
        }
        if (sort.f3413c.equals(Sort.f3411d[3])) {
            return 0;
        }
        if (sort.f3413c.equals(Sort.f3411d[1])) {
            return 1;
        }
        if (sort.f3413c.equals(Sort.f3411d[6])) {
            return 2;
        }
        if (sort.f3413c.equals(Sort.f3411d[5])) {
            if (sort.f3412a.equals(Sort.f3410b[1])) {
                return 3;
            }
            return 4;
        } else if (!sort.f3413c.equals(Sort.f3411d[0])) {
            return -1;
        } else {
            if (sort.f3412a.equals(Sort.f3410b[0])) {
                return 5;
            }
            return 6;
        }
    }
}
