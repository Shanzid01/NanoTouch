package com.p019a.p020a.p023c;

import java.io.InputStream;
import p006b.p007a.p008a.p009a.p010a.p012b.ah;

/* compiled from: QueueFileLogStore */
class bu implements ah {
    final /* synthetic */ byte[] f1292a;
    final /* synthetic */ int[] f1293b;
    final /* synthetic */ bt f1294c;

    bu(bt btVar, byte[] bArr, int[] iArr) {
        this.f1294c = btVar;
        this.f1292a = bArr;
        this.f1293b = iArr;
    }

    public void mo465a(InputStream inputStream, int i) {
        try {
            inputStream.read(this.f1292a, this.f1293b[0], i);
            int[] iArr = this.f1293b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
