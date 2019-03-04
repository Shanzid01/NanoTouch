package p006b.p007a.p008a.p009a.p010a.p016e;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

/* compiled from: HttpRequest */
public class C0278e {
    private static final String[] f885b = new String[0];
    private static C0282h f886c = C0282h.f902a;
    public final URL f887a;
    private HttpURLConnection f888d = null;
    private final String f889e;
    private C0285l f890f;
    private boolean f891g;
    private boolean f892h = true;
    private boolean f893i = false;
    private int f894j = 8192;
    private String f895k;
    private int f896l;

    private static String m2127f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder m2119a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m2122b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m2117a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new C0284j(iOException);
            }
        } catch (IOException e2) {
            throw new C0284j(e2);
        }
    }

    public static String m2118a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        C0278e.m2119a(charSequence2, stringBuilder);
        C0278e.m2122b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static C0278e m2120b(CharSequence charSequence) {
        return new C0278e(charSequence, "GET");
    }

    public static C0278e m2116a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = C0278e.m2118a(charSequence, (Map) map);
        if (z) {
            a = C0278e.m2117a(a);
        }
        return C0278e.m2120b(a);
    }

    public static C0278e m2123c(CharSequence charSequence) {
        return new C0278e(charSequence, "POST");
    }

    public static C0278e m2121b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = C0278e.m2118a(charSequence, (Map) map);
        if (z) {
            a = C0278e.m2117a(a);
        }
        return C0278e.m2123c(a);
    }

    public static C0278e m2124d(CharSequence charSequence) {
        return new C0278e(charSequence, "PUT");
    }

    public static C0278e m2125e(CharSequence charSequence) {
        return new C0278e(charSequence, "DELETE");
    }

    public C0278e(CharSequence charSequence, String str) {
        try {
            this.f887a = new URL(charSequence.toString());
            this.f889e = str;
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    private Proxy m2128q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f895k, this.f896l));
    }

    private HttpURLConnection m2129r() {
        try {
            HttpURLConnection a;
            if (this.f895k != null) {
                a = f886c.mo498a(this.f887a, m2128q());
            } else {
                a = f886c.mo497a(this.f887a);
            }
            a.setRequestMethod(this.f889e);
            return a;
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    public String toString() {
        return m2168p() + ' ' + m2167o();
    }

    public HttpURLConnection m2143a() {
        if (this.f888d == null) {
            this.f888d = m2129r();
        }
        return this.f888d;
    }

    public int m2144b() {
        try {
            m2163k();
            return m2143a().getResponseCode();
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    public boolean m2150c() {
        return 200 == m2144b();
    }

    protected ByteArrayOutputStream m2153d() {
        int j = m2162j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    public String m2142a(String str) {
        OutputStream d = m2153d();
        try {
            m2132a(m2158f(), d);
            return d.toString(C0278e.m2127f(str));
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    public String m2155e() {
        return m2142a(m2160h());
    }

    public BufferedInputStream m2158f() {
        return new BufferedInputStream(m2159g(), this.f894j);
    }

    public InputStream m2159g() {
        if (m2144b() < 400) {
            try {
                InputStream inputStream = m2143a().getInputStream();
            } catch (IOException e) {
                throw new C0284j(e);
            }
        }
        inputStream = m2143a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m2143a().getInputStream();
            } catch (IOException e2) {
                throw new C0284j(e2);
            }
        }
        if (!this.f893i || !"gzip".equals(m2161i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new C0284j(e22);
        }
    }

    public C0278e m2131a(int i) {
        m2143a().setConnectTimeout(i);
        return this;
    }

    public C0278e m2134a(String str, String str2) {
        m2143a().setRequestProperty(str, str2);
        return this;
    }

    public C0278e m2140a(Entry<String, String> entry) {
        return m2134a((String) entry.getKey(), (String) entry.getValue());
    }

    public String m2146b(String str) {
        m2164l();
        return m2143a().getHeaderField(str);
    }

    public int m2148c(String str) {
        return m2130a(str, -1);
    }

    public int m2130a(String str, int i) {
        m2164l();
        return m2143a().getHeaderFieldInt(str, i);
    }

    public String m2147b(String str, String str2) {
        return m2149c(m2146b(str), str2);
    }

    protected String m2149c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String m2160h() {
        return m2147b("Content-Type", "charset");
    }

    public C0278e m2141a(boolean z) {
        m2143a().setUseCaches(z);
        return this;
    }

    public String m2161i() {
        return m2146b("Content-Encoding");
    }

    public C0278e m2151d(String str) {
        return m2152d(str, null);
    }

    public C0278e m2152d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m2134a("Content-Type", str);
        }
        String str3 = "; charset=";
        return m2134a("Content-Type", str + "; charset=" + str2);
    }

    public int m2162j() {
        return m2148c("Content-Length");
    }

    protected C0278e m2132a(InputStream inputStream, OutputStream outputStream) {
        return (C0278e) new C0281f(this, inputStream, this.f892h, inputStream, outputStream).call();
    }

    protected C0278e m2163k() {
        if (this.f890f != null) {
            if (this.f891g) {
                this.f890f.m2179a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f892h) {
                try {
                    this.f890f.close();
                } catch (IOException e) {
                }
            } else {
                this.f890f.close();
            }
            this.f890f = null;
        }
        return this;
    }

    protected C0278e m2164l() {
        try {
            return m2163k();
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    protected C0278e m2165m() {
        if (this.f890f == null) {
            m2143a().setDoOutput(true);
            this.f890f = new C0285l(m2143a().getOutputStream(), m2149c(m2143a().getRequestProperty("Content-Type"), "charset"), this.f894j);
        }
        return this;
    }

    protected C0278e m2166n() {
        if (this.f891g) {
            this.f890f.m2179a("\r\n--00content0boundary00\r\n");
        } else {
            this.f891g = true;
            m2151d("multipart/form-data; boundary=00content0boundary00").m2165m();
            this.f890f.m2179a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected C0278e m2136a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m2157f("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            m2157f("Content-Type", str3);
        }
        return m2156f((CharSequence) "\r\n");
    }

    public C0278e m2154e(String str, String str2) {
        return m2145b(str, null, str2);
    }

    public C0278e m2145b(String str, String str2, String str3) {
        return m2139a(str, str2, null, str3);
    }

    public C0278e m2139a(String str, String str2, String str3, String str4) {
        try {
            m2166n();
            m2136a(str, str2, str3);
            this.f890f.m2179a(str4);
            return this;
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    public C0278e m2133a(String str, Number number) {
        return m2135a(str, null, number);
    }

    public C0278e m2135a(String str, String str2, Number number) {
        return m2145b(str, str2, number != null ? number.toString() : null);
    }

    public C0278e m2137a(String str, String str2, String str3, File file) {
        IOException e;
        Throwable th;
        InputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                C0278e a = m2138a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new C0284j(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new C0284j(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public C0278e m2138a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m2166n();
            m2136a(str, str2, str3);
            m2132a(inputStream, this.f890f);
            return this;
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    public C0278e m2157f(String str, String str2) {
        return m2156f((CharSequence) str).m2156f((CharSequence) ": ").m2156f((CharSequence) str2).m2156f((CharSequence) "\r\n");
    }

    public C0278e m2156f(CharSequence charSequence) {
        try {
            m2165m();
            this.f890f.m2179a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new C0284j(e);
        }
    }

    public URL m2167o() {
        return m2143a().getURL();
    }

    public String m2168p() {
        return m2143a().getRequestMethod();
    }
}
