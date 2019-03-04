package p006b.p007a.p008a.p009a;

import p006b.p007a.p008a.p009a.p010a.p012b.ak;
import p006b.p007a.p008a.p009a.p010a.p013c.C0246o;
import p006b.p007a.p008a.p009a.p010a.p013c.C0249p;
import p006b.p007a.p008a.p009a.p010a.p013c.C0257z;

/* compiled from: InitializationTask */
class C0336p<Result> extends C0249p<Void, Void, Result> {
    final C0337q<Result> f1036a;

    public C0336p(C0337q<Result> c0337q) {
        this.f1036a = c0337q;
    }

    protected void mo526a() {
        super.mo526a();
        ak a = m2326a("onPreExecute");
        try {
            boolean a_ = this.f1036a.a_();
            a.m1865b();
            if (!a_) {
                m1990a(true);
            }
        } catch (C0257z e) {
            throw e;
        } catch (Throwable e2) {
            C0326f.m2298h().mo519e("Fabric", "Failure onPreExecute()", e2);
            a.m1865b();
            m1990a(true);
        } catch (Throwable th) {
            a.m1865b();
            m1990a(true);
        }
    }

    protected Result m2328a(Void... voidArr) {
        ak a = m2326a("doInBackground");
        Result result = null;
        if (!m1993e()) {
            result = this.f1036a.mo532f();
        }
        a.m1865b();
        return result;
    }

    protected void mo527a(Result result) {
        this.f1036a.m2342a((Object) result);
        this.f1036a.f1040h.mo524a((Object) result);
    }

    protected void mo528b(Result result) {
        this.f1036a.m2344b((Object) result);
        this.f1036a.f1040h.mo523a(new C0335o(this.f1036a.mo531b() + " Initialization was cancelled"));
    }

    public C0246o mo471b() {
        return C0246o.HIGH;
    }

    private ak m2326a(String str) {
        ak akVar = new ak(this.f1036a.mo531b() + "." + str, "KitInitialization");
        akVar.m1864a();
        return akVar;
    }
}
