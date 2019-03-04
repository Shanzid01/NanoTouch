package com.mopub.mobileads;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

/* compiled from: MraidDisplayController */
class bj implements MediaScannerConnectionClient {
    final /* synthetic */ bb f2448a;
    private final String f2449b;
    private final String f2450c;
    private MediaScannerConnection f2451d;

    private bj(bb bbVar, String str, String str2) {
        this.f2448a = bbVar;
        this.f2449b = str;
        this.f2450c = str2;
    }

    private void m4579a(MediaScannerConnection mediaScannerConnection) {
        this.f2451d = mediaScannerConnection;
    }

    public void onMediaScannerConnected() {
        if (this.f2451d != null) {
            this.f2451d.scanFile(this.f2449b, this.f2450c);
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        if (this.f2451d != null) {
            this.f2451d.disconnect();
        }
    }
}
