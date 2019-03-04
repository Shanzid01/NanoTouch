package com.mopub.mobileads;

import android.util.Log;

/* compiled from: MraidDisplayController */
class bf implements Runnable {
    final /* synthetic */ be f2443a;

    bf(be beVar) {
        this.f2443a = beVar;
    }

    public void run() {
        this.f2443a.f2436a.m4546c("Image failed to download.");
        this.f2443a.f2436a.m4496a().m4401a(ap.STORE_PICTURE, "Error downloading and saving image file.");
        Log.d("MoPub", "Error downloading and saving image file.");
    }
}
