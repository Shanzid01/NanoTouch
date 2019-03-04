package com.slideme.sam.manager.net.wrappers;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.util.p063a.C1907a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

/* compiled from: FileDownloader */
public class C1892h {
    private static final String f3463b = C1892h.class.getName();
    protected File f3464a;
    private URL f3465c;
    private FileOutputStream f3466d;
    private URLConnection f3467e;
    private InputStream f3468f;
    private int f3469g;
    private int f3470h;
    private boolean f3471i;
    private int f3472j;
    private Context f3473k;
    private C1751l f3474l;

    public C1892h(Context context, String str, String str2) {
        this(context, str, str2, C1892h.m5705h());
    }

    public C1892h(Context context, String str, String str2, C1856m c1856m) {
        this.f3468f = null;
        this.f3469g = 0;
        this.f3470h = -1;
        this.f3471i = false;
        this.f3472j = 0;
        this.f3474l = C1892h.m5704g();
        this.f3473k = context;
        try {
            this.f3465c = new URL(str);
        } catch (Exception e) {
            C1922m.m5790a(e);
        }
        if (TextUtils.isEmpty(str2)) {
            c1856m.mo4306a(this);
        } else {
            this.f3464a = new File(str2);
        }
    }

    private void mo4318a() {
        try {
            this.f3472j++;
            this.f3467e = this.f3465c.openConnection();
            if (this.f3467e instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) this.f3467e;
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.addRequestProperty("User-Agent", SAM.f2626s);
                httpURLConnection.setInstanceFollowRedirects(true);
                if (C1914e.f3493a) {
                    httpURLConnection.setRequestProperty("Authorization", "Basic ZGV2OjEyM3NsaWRl");
                }
                httpURLConnection.addRequestProperty("Cookie", SAM.f2614g.m5596a());
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new AllowAllHostnameVerifier());
                }
                if (this.f3470h > 0 && this.f3469g > 0) {
                    String str = "bytes=" + String.valueOf(this.f3469g) + "-";
                    httpURLConnection.addRequestProperty("Range", str);
                    C1922m.m5797b(f3463b, "Resume Connection counter#" + this.f3472j + " Range :" + str);
                }
                int responseCode = httpURLConnection.getResponseCode();
                this.f3470h = httpURLConnection.getContentLength();
                switch (responseCode) {
                    case 200:
                        this.f3466d = m5699a(false);
                        if (this.f3466d == null) {
                            C1922m.m5797b(f3463b, "Couldn't open file to save .apk");
                            return;
                        }
                        return;
                    case 206:
                        if (this.f3466d == null) {
                            this.f3466d = m5699a(true);
                            if (this.f3466d == null) {
                                C1922m.m5797b(f3463b, "Couldn't open file to save .apk");
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        if (responseCode <= 299 || responseCode >= 400) {
                            if (C1914e.f3493a) {
                                Log.w(f3463b, "Response Code = " + responseCode);
                            }
                            throw new IOException("IOI: Dead end.");
                        }
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            throw new IOException("IOI: Redirect without new destination!");
                        } else if (this.f3472j > 0) {
                            this.f3465c = new URL(headerField);
                            this.f3472j--;
                            mo4318a();
                            return;
                        } else {
                            throw new IOException("IOI: Too many redirects!");
                        }
                }
                C1922m.m5790a(e);
            }
        } catch (Exception e) {
            C1922m.m5790a(e);
        }
    }

    private void mo4319b() {
        try {
            InputStream inputStream = this.f3467e.getInputStream();
            this.f3468f = inputStream;
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = this.f3468f.read(bArr);
                    if (read != -1 && !this.f3471i) {
                        if (read != 0) {
                            this.f3466d.write(bArr, 0, read);
                            this.f3466d.flush();
                            this.f3469g = read + this.f3469g;
                            this.f3474l.mo4267a(this.f3469g, this.f3470h);
                        }
                    }
                }
                if (this.f3471i) {
                    this.f3474l.mo4269b();
                }
            } else if (C1914e.f3493a) {
                Log.e(f3463b, "Couldn't open file to save .apk");
            }
        } catch (Exception e) {
            C1922m.m5790a(e);
        }
    }

    public void m5707c() {
        if (this.f3464a != null) {
            do {
                mo4318a();
                mo4319b();
                if (this.f3469g >= this.f3470h || this.f3471i || this.f3472j >= 10) {
                }
            } while (this.f3466d != null);
            if (!this.f3471i) {
                if (this.f3469g <= 0) {
                    this.f3474l.mo4268a(C1900k.NO_BYTES_READ);
                } else if (this.f3472j >= 10) {
                    this.f3474l.mo4268a(C1900k.MAX_RETRIES_REACHED);
                } else if (this.f3469g < this.f3470h) {
                    this.f3474l.mo4268a(C1900k.GENERIC_DOWNLOAD_ERROR);
                } else {
                    this.f3474l.mo4266a();
                }
            }
        }
    }

    private FileOutputStream m5699a(boolean z) {
        try {
            if (this.f3464a.getAbsolutePath().startsWith("/data/data")) {
                return this.f3473k.openFileOutput(this.f3464a.getName(), 1);
            }
            return new FileOutputStream(this.f3464a);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public int m5708d() {
        return this.f3469g;
    }

    public int m5709e() {
        return this.f3470h;
    }

    public void m5710f() {
        this.f3471i = true;
    }

    public void m5706a(C1751l c1751l) {
        if (this.f3474l == null) {
            this.f3474l = C1892h.m5704g();
        } else {
            this.f3474l = c1751l;
        }
    }

    private static File m5702b(Context context) {
        if (VERSION.SDK_INT < 8) {
            return Environment.getExternalStorageDirectory();
        }
        return C1907a.m5746a(context, null);
    }

    public static String m5700a(Context context) {
        File b;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            b = C1892h.m5702b(context);
        } else {
            b = context.getFilesDir();
        }
        if (b == null) {
            b = context.getFilesDir();
        }
        return b.getAbsolutePath();
    }

    private static final C1751l m5704g() {
        return new C1898i();
    }

    private static final C1856m m5705h() {
        return new C1899j();
    }
}
