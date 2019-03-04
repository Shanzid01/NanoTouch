package com.slideme.sam.manager.controller.fragment.p056a;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.net.wrappers.Catalog;

/* compiled from: DeveloperDetailsFragment */
public class C1726q extends C1708i {
    private String f2969a;
    private String f2970b;
    private String f2971i;
    private View f2972j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2969a = getArguments().getString("com.slideme.sam.manager.EXTRA_DEVELOPER_NAME");
        this.f2970b = getArguments().getString("com.slideme.sam.manager.EXTRA_ORGANIZATION_NAME");
        this.f2971i = getArguments().getString("com.slideme.sam.manager.EXTRA_PACKAGE_NAME");
        this.f = R.layout.fragment_developer;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.name)).setText(this.f2970b);
        this.f2972j = getView().findViewById(R.id.contact);
        this.f2972j.setVisibility(8);
        if (!TextUtils.isEmpty(this.f2970b) && !AuthData.m4808d(getActivity())) {
            this.f2972j.setVisibility(0);
            this.f2972j.setOnClickListener(new C1727r(this));
        }
    }

    protected void mo4257a(Catalog catalog) {
        if (!TextUtils.isEmpty(this.f2971i)) {
            this.g.m5664a(true);
            this.g.m5671b("pname:" + this.f2971i);
        } else if (!TextUtils.isEmpty(this.f2969a)) {
            this.g.m5671b("pub:" + Uri.encode(this.f2969a));
        }
    }
}
