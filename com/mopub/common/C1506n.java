package com.mopub.common;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.p050b.C1486i;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: DownloadTask */
public class C1506n extends AsyncTask<HttpUriRequest, Void, C1505m> {
    private final C1507o f2194a;
    private String f2195b;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4133a((HttpUriRequest[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4134a((C1505m) obj);
    }

    public C1506n(C1507o c1507o) {
        if (c1507o == null) {
            throw new IllegalArgumentException("DownloadTaskListener must not be null.");
        }
        this.f2194a = c1507o;
    }

    protected C1505m m4133a(HttpUriRequest... httpUriRequestArr) {
        AndroidHttpClient androidHttpClient;
        Throwable th;
        if (httpUriRequestArr == null || httpUriRequestArr.length == 0 || httpUriRequestArr[0] == null) {
            C1486i.m4076a("Download task tried to execute null or empty url");
            return null;
        }
        HttpUriRequest httpUriRequest = httpUriRequestArr[0];
        this.f2195b = httpUriRequest.getURI().toString();
        AndroidHttpClient a;
        try {
            a = C1511s.m4151a();
            try {
                C1505m c1505m = new C1505m(a.execute(httpUriRequest));
                if (a == null) {
                    return c1505m;
                }
                a.close();
                return c1505m;
            } catch (Exception e) {
                androidHttpClient = a;
                try {
                    C1486i.m4076a("Download task threw an internal exception");
                    cancel(true);
                    if (androidHttpClient != null) {
                        androidHttpClient.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    a = androidHttpClient;
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            androidHttpClient = null;
            C1486i.m4076a("Download task threw an internal exception");
            cancel(true);
            if (androidHttpClient != null) {
                androidHttpClient.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    protected void m4134a(C1505m c1505m) {
        if (isCancelled()) {
            onCancelled();
        } else {
            this.f2194a.mo4076a(this.f2195b, c1505m);
        }
    }

    protected void onCancelled() {
        this.f2194a.mo4076a(this.f2195b, null);
    }
}
