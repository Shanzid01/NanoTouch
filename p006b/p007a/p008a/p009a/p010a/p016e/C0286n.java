package p006b.p007a.p008a.p009a.p010a.p016e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
public final class C0286n {
    public static final SSLSocketFactory m2180a(C0287o c0287o) {
        SSLContext instance = SSLContext.getInstance("TLS");
        C0288p c0288p = new C0288p(new C0289q(c0287o.mo565a(), c0287o.mo566b()), c0287o);
        instance.init(null, new TrustManager[]{c0288p}, null);
        return instance.getSocketFactory();
    }
}
