package com.slideme.sam.manager.controller.activities;

import android.os.Bundle;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;

public class NoResultsActivity extends CommonActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4895b();
    }

    private void m4895b() {
        CharSequence string;
        setContentView((int) R.layout.activity_no_results);
        String stringExtra = getIntent().getStringExtra(SearchIntents.EXTRA_QUERY);
        TextView textView = (TextView) findViewById(R.id.results);
        if (stringExtra == null) {
            string = getString(R.string.search_no_matches);
        } else {
            string = getString(R.string.search_no_matches_for) + " " + stringExtra;
        }
        textView.setText(string);
    }
}
