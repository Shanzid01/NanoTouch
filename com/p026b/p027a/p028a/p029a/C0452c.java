package com.p026b.p027a.p028a.p029a;

import com.p026b.p027a.p028a.p029a.p031b.C0456a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LimitedDiscCache */
public abstract class C0452c extends C0451a {
    private final AtomicInteger f1397b;
    private final int f1398c;
    private final Map<File, Long> f1399d = Collections.synchronizedMap(new HashMap());

    protected abstract int mo917a(File file);

    public C0452c(File file, C0456a c0456a, int i) {
        super(file, c0456a);
        this.f1398c = i;
        this.f1397b = new AtomicInteger();
        m2890b();
    }

    private void m2890b() {
        new Thread(new C0458d(this)).start();
    }

    public void mo916a(String str, File file) {
        int a = mo917a(file);
        int i = this.f1397b.get();
        while (i + a > this.f1398c) {
            i = m2891c();
            if (i == 0) {
                break;
            }
            i = this.f1397b.addAndGet(-i);
        }
        this.f1397b.addAndGet(a);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(valueOf.longValue());
        this.f1399d.put(file, valueOf);
    }

    public File mo914a(String str) {
        File a = super.mo914a(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        a.setLastModified(valueOf.longValue());
        this.f1399d.put(a, valueOf);
        return a;
    }

    public void mo915a() {
        this.f1399d.clear();
        this.f1397b.set(0);
        super.mo915a();
    }

    private int m2891c() {
        File file = null;
        if (this.f1399d.isEmpty()) {
            return 0;
        }
        Set<Entry> entrySet = this.f1399d.entrySet();
        synchronized (this.f1399d) {
            Long l = null;
            for (Entry entry : entrySet) {
                File file2;
                Long l2;
                if (file == null) {
                    file2 = (File) entry.getKey();
                    l2 = (Long) entry.getValue();
                } else {
                    Long l3 = (Long) entry.getValue();
                    if (l3.longValue() < l.longValue()) {
                        File file3 = (File) entry.getKey();
                        l2 = l3;
                        file2 = file3;
                    } else {
                        file2 = file;
                        l2 = l;
                    }
                }
                file = file2;
                l = l2;
            }
        }
        int a = mo917a(file);
        if (!file.delete()) {
            return a;
        }
        this.f1399d.remove(file);
        return a;
    }
}
