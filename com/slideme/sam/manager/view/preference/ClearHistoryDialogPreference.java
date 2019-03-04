package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.provider.SearchRecentSuggestions;
import android.util.AttributeSet;
import com.slideme.sam.manager.model.data.cache.SamSuggestionProvider;

public class ClearHistoryDialogPreference extends DialogPreference {
    public ClearHistoryDialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ClearHistoryDialogPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                dialogInterface.dismiss();
                break;
            case -1:
                new SearchRecentSuggestions(getContext(), SamSuggestionProvider.AUTHORITY, 1).clearHistory();
                dialogInterface.dismiss();
                break;
        }
        super.onClick(dialogInterface, i);
    }
}
