package p006b.p007a.p008a.p009a.p010a.p015d;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p006b.p007a.p008a.p009a.p010a.p012b.C0202s;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: EventsFilesManager */
public abstract class C0264d<T> {
    protected final Context f862a;
    protected final C0263c<T> f863b;
    protected final C0202s f864c;
    protected final C0267h f865d;
    protected volatile long f866e;
    protected final List<C0268i> f867f = new CopyOnWriteArrayList();
    private final int f868g;

    protected abstract String mo535a();

    public C0264d(Context context, C0263c<T> c0263c, C0202s c0202s, C0267h c0267h, int i) {
        this.f862a = context.getApplicationContext();
        this.f863b = c0263c;
        this.f865d = c0267h;
        this.f864c = c0202s;
        this.f866e = this.f864c.mo466a();
        this.f868g = i;
    }

    public void m2072a(T t) {
        byte[] a = this.f863b.mo539a(t);
        m2067a(a.length);
        this.f865d.mo487a(a);
    }

    public void m2071a(C0268i c0268i) {
        if (c0268i != null) {
            this.f867f.add(c0268i);
        }
    }

    public boolean m2076d() {
        boolean z = true;
        String str = null;
        if (this.f865d.mo489b()) {
            z = false;
        } else {
            str = mo535a();
            this.f865d.mo485a(str);
            C0214m.m1909a(this.f862a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f866e = this.f864c.mo466a();
        }
        m2068b(str);
        return z;
    }

    private void m2067a(int i) {
        if (!this.f865d.mo488a(i, mo537c())) {
            C0214m.m1909a(this.f862a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f865d.mo483a()), Integer.valueOf(i), Integer.valueOf(mo537c())}));
            m2076d();
        }
    }

    protected int mo536b() {
        return this.f868g;
    }

    protected int mo537c() {
        return 8000;
    }

    private void m2068b(String str) {
        for (C0268i a : this.f867f) {
            try {
                a.mo540a(str);
            } catch (Throwable e) {
                C0214m.m1911a(this.f862a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> m2077e() {
        return this.f865d.mo484a(1);
    }

    public void m2073a(List<File> list) {
        this.f865d.mo486a((List) list);
    }

    public void m2078f() {
        this.f865d.mo486a(this.f865d.mo490c());
        this.f865d.mo491d();
    }

    public void m2079g() {
        List<File> c = this.f865d.mo490c();
        int b = mo536b();
        if (c.size() > b) {
            int size = c.size() - b;
            C0214m.m1910a(this.f862a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C0265e(this));
            for (File file : c) {
                treeSet.add(new C0266f(file, m2069a(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0266f) it.next()).f870a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f865d.mo486a(arrayList);
        }
    }

    public long m2069a(String str) {
        long j = 0;
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
