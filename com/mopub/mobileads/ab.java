package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.p050b.C1483f;
import com.mopub.mobileads.util.C1560f;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;

/* compiled from: MoPubBrowserController */
class ab extends ah {
    private Context f2402a;

    ab(MraidView mraidView) {
        super(mraidView);
        this.f2402a = mraidView.getContext();
    }

    protected void m4499a(String str) {
        Log.d("MoPubBrowserController", "Opening url: " + str);
        MraidView a = m4496a();
        if (a.m4409d() != null) {
            a.m4409d().onOpen(a);
        }
        if (m4498c(str) || !C1483f.m4064a(this.f2402a, str)) {
            Intent intent = new Intent(this.f2402a, MoPubBrowser.class);
            intent.putExtra(LayoutTagTable.URL, str);
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            this.f2402a.startActivity(intent);
            return;
        }
        m4497b(str);
    }

    private boolean m4497b(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        return C1560f.m4670a(m4496a().getContext(), intent, "Unable to open intent.");
    }

    private boolean m4498c(String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
