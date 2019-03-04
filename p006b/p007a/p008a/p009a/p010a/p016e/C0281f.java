package p006b.p007a.p008a.p009a.p010a.p016e;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: HttpRequest */
class C0281f extends C0280g<C0278e> {
    final /* synthetic */ InputStream f899a;
    final /* synthetic */ OutputStream f900b;
    final /* synthetic */ C0278e f901c;

    C0281f(C0278e c0278e, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
        this.f901c = c0278e;
        this.f899a = inputStream;
        this.f900b = outputStream;
        super(closeable, z);
    }

    public /* synthetic */ Object mo496b() {
        return m2172a();
    }

    public C0278e m2172a() {
        byte[] bArr = new byte[this.f901c.f894j];
        while (true) {
            int read = this.f899a.read(bArr);
            if (read == -1) {
                return this.f901c;
            }
            this.f900b.write(bArr, 0, read);
        }
    }
}
