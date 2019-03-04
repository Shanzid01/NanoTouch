package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.facebook.AppEventsConstants;

public class SamListPreference extends ListPreference {
    public SamListPreference(Context context) {
        super(context);
    }

    public SamListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected boolean callChangeListener(Object obj) {
        setSummary(getEntries()[Integer.parseInt(getPersistedString(AppEventsConstants.EVENT_PARAM_VALUE_NO))]);
        return super.callChangeListener(obj);
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        super.onSetInitialValue(z, obj);
        if (z) {
            setSummary(getEntries()[Integer.parseInt(getPersistedString((String) obj))]);
        } else {
            setSummary(getEntries()[Integer.parseInt((String) obj)]);
        }
    }
}
