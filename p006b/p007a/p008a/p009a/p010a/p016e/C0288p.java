package p006b.p007a.p008a.p009a.p010a.p016e;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: PinningTrustManager */
class C0288p implements X509TrustManager {
    private final TrustManager[] f904a;
    private final C0289q f905b;
    private final long f906c;
    private final List<byte[]> f907d = new LinkedList();
    private final Set<X509Certificate> f908e = Collections.synchronizedSet(new HashSet());

    public C0288p(C0289q c0289q, C0287o c0287o) {
        this.f904a = m2189a(c0289q);
        this.f905b = c0289q;
        this.f906c = c0287o.mo568d();
        for (String a : c0287o.mo567c()) {
            this.f907d.add(m2188a(a));
        }
    }

    private TrustManager[] m2189a(C0289q c0289q) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(c0289q.f909a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m2187a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f907d) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m2186a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f904a) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m2185a(X509Certificate[] x509CertificateArr) {
        if (this.f906c == -1 || System.currentTimeMillis() - this.f906c <= 15552000000L) {
            X509Certificate[] a = C0273a.m2106a(x509CertificateArr, this.f905b);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m2187a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C0326f.m2298h().mo516d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f906c) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f908e.contains(x509CertificateArr[0])) {
            m2186a(x509CertificateArr, str);
            m2185a(x509CertificateArr);
            this.f908e.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    private byte[] m2188a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
