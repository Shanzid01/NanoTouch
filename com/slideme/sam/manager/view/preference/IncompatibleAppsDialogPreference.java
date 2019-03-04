package com.slideme.sam.manager.view.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import com.slideme.sam.manager.R;

public class IncompatibleAppsDialogPreference extends DialogPreference {
    private CheckBox f3622a;

    public IncompatibleAppsDialogPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IncompatibleAppsDialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        Log.d("IncompatibleAppsDialogPreference", "onGetDefaultValue " + String.valueOf(typedArray.getBoolean(i, false)));
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        Log.d("IncompatibleAppsDialogPreference", "onSetInitialValue " + String.valueOf(z) + " " + ((Boolean) obj));
        if (z) {
            m5877a(m5878a());
        } else {
            m5877a(((Boolean) obj).booleanValue());
        }
    }

    protected void onDialogClosed(boolean z) {
        if (z) {
            m5877a(!m5878a());
        }
        super.onDialogClosed(z);
    }

    protected void showDialog(Bundle bundle) {
        if (m5878a()) {
            m5877a(false);
        } else {
            super.showDialog(bundle);
        }
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setTitle(17039380);
        builder.setMessage(R.string.compatibility_preference_message);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        this.f3622a = (CheckBox) view.findViewById(R.id.checkbox);
        if (this.f3622a != null) {
            this.f3622a.setChecked(m5878a());
        }
    }

    private void m5877a(boolean z) {
        Log.d("IncompatibleAppsDialogPreference", "setChecked " + String.valueOf(z));
        if (this.f3622a != null) {
            this.f3622a.setChecked(z);
        }
        persistBoolean(z);
    }

    private boolean m5878a() {
        return getPersistedBoolean(getContext().getResources().getBoolean(R.bool.default_settings_advanced_show_incompatible_apps));
    }
}
