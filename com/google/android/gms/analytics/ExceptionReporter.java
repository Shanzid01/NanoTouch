package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler zzBK;
    private final Tracker zzBL;
    private ExceptionParser zzBM;
    private GoogleAnalytics zzBN;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.zzBK = uncaughtExceptionHandler;
            this.zzBL = tracker;
            this.zzBM = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            zzae.zzab("ExceptionReporter created, original handler is " + (uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName()));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzBM;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzBM = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.zzBM != null) {
            str = this.zzBM.getDescription(thread != null ? thread.getName() : null, th);
        }
        zzae.zzab("Tracking Exception: " + str);
        this.zzBL.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics zzfC = zzfC();
        zzfC.dispatchLocalHits();
        zzfC.zzfj();
        if (this.zzBK != null) {
            zzae.zzab("Passing exception to original handler.");
            this.zzBK.uncaughtException(thread, th);
        }
    }

    GoogleAnalytics zzfC() {
        if (this.zzBN == null) {
            this.zzBN = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzBN;
    }

    UncaughtExceptionHandler zzfD() {
        return this.zzBK;
    }
}
