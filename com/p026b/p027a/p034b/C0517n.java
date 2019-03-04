package com.p026b.p027a.p034b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.p026b.p027a.p034b.p035a.C0474b;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.p026b.p027a.p034b.p035a.C0478f;
import com.p026b.p027a.p034b.p035a.C0484l;
import com.p026b.p027a.p034b.p037b.C0487d;
import com.p026b.p027a.p034b.p037b.C0491e;
import com.p026b.p027a.p034b.p039d.C0498c;
import com.p026b.p027a.p034b.p039d.C0501d;
import com.p026b.p027a.p041c.C0523c;
import com.p026b.p027a.p041c.C0524d;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: LoadAndDisplayImageTask */
final class C0517n implements Runnable {
    final String f1571a;
    final ImageView f1572b;
    final C0506d f1573c;
    final C0476d f1574d;
    private final C0514k f1575e;
    private final C0516m f1576f;
    private final Handler f1577g;
    private final C0511h f1578h;
    private final C0498c f1579i = this.f1578h.f1520q;
    private final C0498c f1580j = this.f1578h.f1525v;
    private final C0498c f1581k = this.f1578h.f1526w;
    private final C0487d f1582l = this.f1578h.f1521r;
    private final boolean f1583m = this.f1578h.f1523t;
    private final String f1584n;
    private final C0478f f1585o;

    public C0517n(C0514k c0514k, C0516m c0516m, Handler handler) {
        this.f1575e = c0514k;
        this.f1576f = c0516m;
        this.f1577g = handler;
        this.f1578h = c0514k.f1553a;
        this.f1571a = c0516m.f1564a;
        this.f1584n = c0516m.f1565b;
        this.f1572b = c0516m.f1566c;
        this.f1585o = c0516m.f1567d;
        this.f1573c = c0516m.f1568e;
        this.f1574d = c0516m.f1569f;
    }

    public void run() {
        if (!m3136b() && !m3137c()) {
            ReentrantLock reentrantLock = this.f1576f.f1570g;
            m3135b("Start display image task [%s]");
            if (reentrantLock.isLocked()) {
                m3135b("Image already is loading. Waiting... [%s]");
            }
            reentrantLock.lock();
            try {
                if (!m3138d()) {
                    Bitmap bitmap = (Bitmap) this.f1578h.f1518o.mo919a(this.f1584n);
                    if (bitmap == null) {
                        bitmap = m3140f();
                        if (bitmap == null) {
                            reentrantLock.unlock();
                            return;
                        } else if (m3138d() || m3139e()) {
                            reentrantLock.unlock();
                            return;
                        } else {
                            if (this.f1573c.m3042d()) {
                                m3135b("PreProcess image before caching in memory [%s]");
                                bitmap = this.f1573c.m3055q().m3059a(bitmap);
                                if (bitmap == null) {
                                    C0524d.m3154c("Pre-processor returned null [%s]", new Object[0]);
                                }
                            }
                            if (bitmap != null && this.f1573c.m3049k()) {
                                m3135b("Cache image in memory [%s]");
                                this.f1578h.f1518o.mo921a(this.f1584n, bitmap);
                            }
                        }
                    } else {
                        m3135b("...Get cached bitmap from memory after waiting. [%s]");
                    }
                    if (bitmap != null && this.f1573c.m3043e()) {
                        m3135b("PostProcess image before displaying [%s]");
                        bitmap = this.f1573c.m3056r().m3059a(bitmap);
                        if (bitmap == null) {
                            C0524d.m3154c("Pre-processor returned null [%s]", this.f1584n);
                        }
                    }
                    reentrantLock.unlock();
                    if (!m3138d() && !m3139e()) {
                        Runnable c0497c = new C0497c(bitmap, this.f1576f, this.f1575e);
                        c0497c.m3012a(this.f1583m);
                        this.f1577g.post(c0497c);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private boolean m3136b() {
        AtomicBoolean d = this.f1575e.m3126d();
        if (d.get()) {
            synchronized (d) {
                m3135b("ImageLoader is paused. Waiting...  [%s]");
                try {
                    d.wait();
                    m3135b(".. Resume loading [%s]");
                } catch (InterruptedException e) {
                    C0524d.m3155d("Task was interrupted [%s]", this.f1584n);
                    return true;
                }
            }
        }
        return m3138d();
    }

    private boolean m3137c() {
        if (!this.f1573c.m3044f()) {
            return false;
        }
        m3132a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.f1573c.m3053o()), this.f1584n);
        try {
            Thread.sleep((long) this.f1573c.m3053o());
            return m3138d();
        } catch (InterruptedException e) {
            C0524d.m3155d("Task was interrupted [%s]", this.f1584n);
            return true;
        }
    }

    private boolean m3138d() {
        boolean z = !this.f1584n.equals(this.f1575e.m3117a(this.f1572b));
        if (z) {
            this.f1577g.post(new C0518o(this));
        }
        if (z) {
            m3135b("ImageView is reused for another image. Task is cancelled. [%s]");
        }
        return z;
    }

    private boolean m3139e() {
        boolean interrupted = Thread.interrupted();
        if (interrupted) {
            m3135b("Task was interrupted [%s]");
        }
        return interrupted;
    }

    private Bitmap m3140f() {
        Bitmap a;
        Throwable e;
        Throwable th;
        File g = m3141g();
        try {
            if (g.exists()) {
                m3135b("Load image from disc cache [%s]");
                a = m3129a(C0501d.FILE.wrap(g.getAbsolutePath()));
            } else {
                a = null;
            }
            if (a == null) {
                try {
                    m3135b("Load image from network [%s]");
                    a = m3129a(this.f1573c.m3050l() ? m3130a(g) : this.f1571a);
                    if (a == null) {
                        m3131a(C0474b.DECODING_ERROR, null);
                    }
                } catch (IllegalStateException e2) {
                    m3131a(C0474b.NETWORK_DENIED, null);
                    return a;
                } catch (IOException e3) {
                    e = e3;
                    C0524d.m3152a(e);
                    m3131a(C0474b.IO_ERROR, e);
                    if (g.exists()) {
                        g.delete();
                    }
                    return a;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    C0524d.m3152a(e);
                    m3131a(C0474b.OUT_OF_MEMORY, e);
                    return a;
                } catch (Throwable th2) {
                    e = th2;
                    C0524d.m3152a(e);
                    m3131a(C0474b.UNKNOWN, e);
                    return a;
                }
            }
        } catch (IllegalStateException e5) {
            a = null;
            m3131a(C0474b.NETWORK_DENIED, null);
            return a;
        } catch (Throwable e6) {
            th = e6;
            a = null;
            e = th;
            C0524d.m3152a(e);
            m3131a(C0474b.IO_ERROR, e);
            if (g.exists()) {
                g.delete();
            }
            return a;
        } catch (Throwable e62) {
            th = e62;
            a = null;
            e = th;
            C0524d.m3152a(e);
            m3131a(C0474b.OUT_OF_MEMORY, e);
            return a;
        } catch (Throwable e622) {
            th = e622;
            a = null;
            e = th;
            C0524d.m3152a(e);
            m3131a(C0474b.UNKNOWN, e);
            return a;
        }
        return a;
    }

    private File m3141g() {
        File a = this.f1578h.f1519p.mo914a(this.f1571a);
        File parentFile = a.getParentFile();
        if (parentFile == null || !(parentFile.exists() || parentFile.mkdirs())) {
            a = this.f1578h.f1524u.mo914a(this.f1571a);
            parentFile = a.getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        return a;
    }

    private Bitmap m3129a(String str) {
        String str2 = str;
        return this.f1582l.mo934a(new C0491e(this.f1584n, str2, this.f1585o, C0484l.fromImageView(this.f1572b), m3142h(), this.f1573c));
    }

    private String m3130a(File file) {
        m3135b("Cache image on disc [%s]");
        try {
            int i = this.f1578h.f1507d;
            int i2 = this.f1578h.f1508e;
            boolean z = false;
            if (i > 0 || i2 > 0) {
                z = m3133a(file, i, i2);
            }
            if (!z) {
                m3134b(file);
            }
            this.f1578h.f1519p.mo916a(this.f1571a, file);
            return C0501d.FILE.wrap(file.getAbsolutePath());
        } catch (Throwable e) {
            C0524d.m3152a(e);
            return this.f1571a;
        }
    }

    private boolean m3133a(File file, int i, int i2) {
        Bitmap a = this.f1582l.mo934a(new C0491e(this.f1584n, this.f1571a, new C0478f(i, i2), C0484l.FIT_INSIDE, m3142h(), new C0509f().m3078a(this.f1573c).m3077a(C0477e.IN_SAMPLE_INT).m3080c()));
        boolean z = false;
        if (a != null) {
            Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            try {
                z = a.compress(this.f1578h.f1509f, this.f1578h.f1510g, bufferedOutputStream);
                if (z) {
                    a.recycle();
                }
            } finally {
                C0523c.m3148a(bufferedOutputStream);
            }
        }
        return z;
    }

    private void m3134b(File file) {
        Closeable a = m3142h().mo936a(this.f1571a, this.f1573c.m3054p());
        Closeable bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            C0523c.m3149a(a, bufferedOutputStream);
        } catch (Throwable th) {
            bufferedOutputStream = th;
        } finally {
            C0523c.m3148a(
/*
Method generation error in method: com.b.a.b.n.b(java.io.File):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE  (wrap: java.io.Closeable
  ?: MERGE  (r0_3 java.io.Closeable) = (r0_2 'bufferedOutputStream' java.io.Closeable), (r1_1 'a' java.io.Closeable)) com.b.a.c.c.a(java.io.Closeable):void type: STATIC in method: com.b.a.b.n.b(java.io.File):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r0_3 java.io.Closeable) = (r0_2 'bufferedOutputStream' java.io.Closeable), (r1_1 'a' java.io.Closeable) in method: com.b.a.b.n.b(java.io.File):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:679)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:649)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 21 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:211)
	... 26 more

*/

            private void m3131a(C0474b c0474b, Throwable th) {
                if (!Thread.interrupted()) {
                    this.f1577g.post(new C0519p(this, c0474b, th));
                }
            }

            private C0498c m3142h() {
                if (this.f1575e.m3127e()) {
                    return this.f1580j;
                }
                if (this.f1575e.m3128f()) {
                    return this.f1581k;
                }
                return this.f1579i;
            }

            String m3143a() {
                return this.f1571a;
            }

            private void m3135b(String str) {
                if (this.f1583m) {
                    C0524d.m3153b(str, this.f1584n);
                }
            }

            private void m3132a(String str, Object... objArr) {
                if (this.f1583m) {
                    C0524d.m3153b(str, objArr);
                }
            }
        }
