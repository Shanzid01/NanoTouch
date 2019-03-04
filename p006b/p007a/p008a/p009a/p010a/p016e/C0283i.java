package p006b.p007a.p008a.p009a.p010a.p016e;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* compiled from: HttpRequest */
final class C0283i implements C0282h {
    C0283i() {
    }

    public HttpURLConnection mo497a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpURLConnection mo498a(URL url, Proxy proxy) {
        return (HttpURLConnection) url.openConnection(proxy);
    }
}
