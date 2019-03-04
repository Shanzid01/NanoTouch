package p006b.p007a.p008a.p009a.p010a.p016e;

import java.io.IOException;

/* compiled from: HttpRequest */
public class C0284j extends RuntimeException {
    private static final long serialVersionUID = -1170466989781746231L;

    public /* synthetic */ Throwable getCause() {
        return m2178a();
    }

    protected C0284j(IOException iOException) {
        super(iOException);
    }

    public IOException m2178a() {
        return (IOException) super.getCause();
    }
}
