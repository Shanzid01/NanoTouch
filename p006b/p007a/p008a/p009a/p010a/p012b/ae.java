package p006b.p007a.p008a.p009a.p010a.p012b;

import java.io.InputStream;

/* compiled from: QueueFile */
class ae implements ah {
    boolean f760a = true;
    final /* synthetic */ StringBuilder f761b;
    final /* synthetic */ ad f762c;

    ae(ad adVar, StringBuilder stringBuilder) {
        this.f762c = adVar;
        this.f761b = stringBuilder;
    }

    public void mo465a(InputStream inputStream, int i) {
        if (this.f760a) {
            this.f760a = false;
        } else {
            this.f761b.append(", ");
        }
        this.f761b.append(i);
    }
}
