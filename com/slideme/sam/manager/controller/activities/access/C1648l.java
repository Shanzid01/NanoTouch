package com.slideme.sam.manager.controller.activities.access;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: SimpleRegisterActivity */
class C1648l implements OnClickListener {
    final /* synthetic */ SimpleRegisterActivity f2773a;

    C1648l(SimpleRegisterActivity simpleRegisterActivity) {
        this.f2773a = simpleRegisterActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f2773a, RegisterActivity.class);
        intent.putExtra("is_adding_new_account", true);
        intent.putExtra("com.slideme.sam.manager.EXTRA_EIMAIL", this.f2773a.f2757f.m6053a().toString());
        this.f2773a.startActivityForResult(intent, 1);
    }
}
