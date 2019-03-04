package com.p019a.p020a.p023c;

/* compiled from: NativeCrashWriter */
final class bp extends bo {
    private final bo[] f1283a;

    public bp(bo... boVarArr) {
        super(0, new bo[0]);
        this.f1283a = boVarArr;
    }

    public void mo557b(C0393f c0393f) {
        for (bo b : this.f1283a) {
            b.mo557b(c0393f);
        }
    }

    public int mo558b() {
        int i = 0;
        bo[] boVarArr = this.f1283a;
        int i2 = 0;
        while (i < boVarArr.length) {
            i2 += boVarArr[i].mo558b();
            i++;
        }
        return i2;
    }
}
