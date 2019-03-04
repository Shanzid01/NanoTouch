package com.google.analytics.tracking.android;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: ExceptionReporter */
public class C0775s implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f2089a;
    private final bm f2090b;
    private final bi f2091c;
    private C0764r f2092d;

    public C0775s(bm bmVar, bi biVar, UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (bmVar == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (biVar == null) {
            throw new NullPointerException("serviceManager cannot be null");
        } else {
            this.f2089a = uncaughtExceptionHandler;
            this.f2090b = bmVar;
            this.f2091c = biVar;
            av.m3818e("ExceptionReporter created, original handler is " + (uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName()));
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "";
        if (this.f2092d == null) {
            str = th.getMessage();
        } else {
            str = this.f2092d.mo1202a(thread != null ? thread.getName() : null, th);
        }
        av.m3818e("Tracking Exception: " + str);
        this.f2090b.mo1210a(str, true);
        this.f2091c.mo1218c();
        if (this.f2089a != null) {
            av.m3818e("Passing exception to original handler.");
            this.f2089a.uncaughtException(thread, th);
        }
    }
}
