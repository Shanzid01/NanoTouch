package p006b.p007a.p008a.p009a.p010a.p016e;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* compiled from: HttpRequest */
public class C0285l extends BufferedOutputStream {
    private final CharsetEncoder f903a;

    public C0285l(OutputStream outputStream, String str, int i) {
        super(outputStream, i);
        this.f903a = Charset.forName(C0278e.m2127f(str)).newEncoder();
    }

    public C0285l m2179a(String str) {
        ByteBuffer encode = this.f903a.encode(CharBuffer.wrap(str));
        super.write(encode.array(), 0, encode.limit());
        return this;
    }
}
