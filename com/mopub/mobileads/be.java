package com.mopub.mobileads;

import android.media.MediaScannerConnection;
import com.mopub.common.p050b.C1489l;
import com.mopub.common.p050b.C1490m;
import com.mopub.mobileads.p051a.C1530j;
import com.mopub.mobileads.util.C1558d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* compiled from: MraidDisplayController */
class be implements Runnable {
    final /* synthetic */ bb f2436a;
    private URI f2437b;
    private InputStream f2438c;
    private OutputStream f2439d;
    private MediaScannerConnection f2440e;
    private final /* synthetic */ String f2441f;
    private final /* synthetic */ File f2442g;

    be(bb bbVar, String str, File file) {
        this.f2436a = bbVar;
        this.f2441f = str;
        this.f2442g = file;
    }

    public void run() {
        try {
            this.f2437b = URI.create(this.f2441f);
            HttpResponse execute = C1530j.m4491a().execute(new HttpGet(this.f2437b));
            this.f2438c = execute.getEntity().getContent();
            String a = C1558d.m4662a(execute, C1489l.LOCATION);
            if (a != null) {
                this.f2437b = URI.create(a);
            }
            File file = new File(this.f2442g, this.f2436a.m4534a(this.f2437b, execute));
            String file2 = file.toString();
            this.f2439d = new FileOutputStream(file);
            C1490m.m4086a(this.f2438c, this.f2439d);
            m4578a(file2);
        } catch (Exception e) {
            this.f2436a.f2424j.post(new bf(this));
        } finally {
            C1490m.m4085a(this.f2438c);
            C1490m.m4085a(this.f2439d);
        }
    }

    private void m4578a(String str) {
        Object bjVar = new bj(this.f2436a, str, null);
        this.f2440e = new MediaScannerConnection(this.f2436a.m4558r().getApplicationContext(), bjVar);
        bjVar.m4579a(this.f2440e);
        this.f2440e.connect();
    }
}
