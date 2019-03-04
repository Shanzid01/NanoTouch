package com.slideme.sam.manager.controller.fragment.preference;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.slideme.sam.manager.R;

public class LocalPreferencesFragment extends PreferenceFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_local);
    }
}
