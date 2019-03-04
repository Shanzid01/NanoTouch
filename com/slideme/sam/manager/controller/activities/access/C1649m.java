package com.slideme.sam.manager.controller.activities.access;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.UserProfile;

/* compiled from: SimpleRegisterActivity */
class C1649m implements OnClickListener {
    final /* synthetic */ SimpleRegisterActivity f2774a;

    C1649m(SimpleRegisterActivity simpleRegisterActivity) {
        this.f2774a = simpleRegisterActivity;
    }

    public void onClick(View view) {
        UserProfile userProfile = new UserProfile();
        userProfile.setMail(this.f2774a.f2757f.m6053a().toString());
        this.f2774a.m4926c(true);
        SAM.f2614g.m5613a(userProfile, new C1650n(this));
    }
}
