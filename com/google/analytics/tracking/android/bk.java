package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

/* compiled from: SimpleNetworkDispatcher */
class bk implements C0763m {
    private final String f2038a;
    private final au f2039b;
    private final Context f2040c;

    bk(C0761h c0761h, au auVar, Context context) {
        this(auVar, context);
    }

    bk(au auVar, Context context) {
        this.f2040c = context.getApplicationContext();
        this.f2038a = m3882a("GoogleAnalytics", "2.0", VERSION.RELEASE, bq.m3909a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f2039b = auVar;
    }

    public boolean mo1201a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2040c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        av.m3820g("...no network connectivity");
        return false;
    }

    public int mo1200a(List<as> list) {
        int min = Math.min(list.size(), 40);
        int i = 0;
        int i2 = 0;
        while (i < min) {
            int i3;
            HttpClient a = this.f2039b.mo1199a();
            as asVar = (as) list.get(i);
            URL a2 = m3878a(asVar);
            if (a2 == null) {
                if (av.m3814a()) {
                    av.m3821h("No destination: discarding hit: " + asVar.m3802a());
                } else {
                    av.m3821h("No destination: discarding hit.");
                }
                i3 = i2 + 1;
            } else {
                HttpHost httpHost = new HttpHost(a2.getHost(), a2.getPort(), a2.getProtocol());
                String path = a2.getPath();
                String a3 = TextUtils.isEmpty(asVar.m3802a()) ? "" : at.m3808a(asVar, System.currentTimeMillis());
                HttpEntityEnclosingRequest a4 = m3879a(a3, path);
                if (a4 == null) {
                    i3 = i2 + 1;
                } else {
                    a4.addHeader("Host", httpHost.toHostString());
                    m3880a(av.m3814a(), a4);
                    if (a3.length() > 8192) {
                        av.m3821h("Hit too long (> 8192 bytes)--not sent");
                    } else {
                        try {
                            HttpResponse execute = a.execute(httpHost, a4);
                            if (execute.getStatusLine().getStatusCode() != 200) {
                                av.m3821h("Bad response: " + execute.getStatusLine().getStatusCode());
                                return i2;
                            }
                        } catch (ClientProtocolException e) {
                            av.m3821h("ClientProtocolException sending hit; discarding hit...");
                        } catch (IOException e2) {
                            av.m3821h("Exception sending hit: " + e2.getClass().getSimpleName());
                            av.m3821h(e2.getMessage());
                            return i2;
                        }
                    }
                    i3 = i2 + 1;
                }
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    private HttpEntityEnclosingRequest m3879a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            av.m3821h("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                av.m3821h("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.f2038a);
        return basicHttpEntityEnclosingRequest;
    }

    private void m3880a(boolean z, HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (z) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
                stringBuffer.append(obj.toString()).append("\n");
            }
            stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
            if (httpEntityEnclosingRequest.getEntity() != null) {
                try {
                    InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                    if (content != null) {
                        int available = content.available();
                        if (available > 0) {
                            byte[] bArr = new byte[available];
                            content.read(bArr);
                            stringBuffer.append("POST:\n");
                            stringBuffer.append(new String(bArr)).append("\n");
                        }
                    }
                } catch (IOException e) {
                    av.m3821h("Error Writing hit to log...");
                }
            }
            av.m3817d(stringBuffer.toString());
        }
    }

    String m3882a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private URL m3878a(as asVar) {
        if (TextUtils.isEmpty(asVar.m3807d())) {
            return null;
        }
        try {
            return new URL(asVar.m3807d());
        } catch (MalformedURLException e) {
            try {
                return new URL("http://www.google-analytics.com/collect");
            } catch (MalformedURLException e2) {
                return null;
            }
        }
    }
}
