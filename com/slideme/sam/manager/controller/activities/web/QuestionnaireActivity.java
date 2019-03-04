package com.slideme.sam.manager.controller.activities.web;

import android.os.Bundle;

public class QuestionnaireActivity extends WebViewActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().setHomeButtonEnabled(false);
    }
}
