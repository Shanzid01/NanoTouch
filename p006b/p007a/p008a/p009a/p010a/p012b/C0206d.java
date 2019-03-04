package p006b.p007a.p008a.p009a.p010a.p012b;

import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AdvertisingInfoProvider */
class C0206d extends C0205l {
    final /* synthetic */ C0203b f778a;
    final /* synthetic */ C0204c f779b;

    C0206d(C0204c c0204c, C0203b c0203b) {
        this.f779b = c0204c;
        this.f778a = c0203b;
    }

    public void mo467a() {
        C0203b a = this.f779b.m1871e();
        if (!this.f778a.equals(a)) {
            C0326f.m2298h().mo511a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            this.f779b.m1869b(a);
        }
    }
}
