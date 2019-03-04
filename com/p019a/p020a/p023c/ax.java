package com.p019a.p020a.p023c;

import java.io.Closeable;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: ExceptionUtils */
final class ax {
    public static void m2571a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            ax.m2573b(th, outputStream);
        }
    }

    private static void m2573b(Throwable th, OutputStream outputStream) {
        Closeable printWriter;
        Throwable e;
        try {
            printWriter = new PrintWriter(outputStream);
            try {
                ax.m2572a(th, (Writer) printWriter);
                C0214m.m1913a(printWriter, "Failed to close stack trace writer.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to create PrintWriter", e);
                    C0214m.m1913a(printWriter, "Failed to close stack trace writer.");
                } catch (Throwable th2) {
                    e = th2;
                    C0214m.m1913a(printWriter, "Failed to close stack trace writer.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            printWriter = null;
            C0326f.m2298h().mo519e("CrashlyticsCore", "Failed to create PrintWriter", e);
            C0214m.m1913a(printWriter, "Failed to close stack trace writer.");
        } catch (Throwable th3) {
            e = th3;
            printWriter = null;
            C0214m.m1913a(printWriter, "Failed to close stack trace writer.");
            throw e;
        }
    }

    private static void m2572a(Throwable th, Writer writer) {
        Object obj = 1;
        while (th != null) {
            try {
                String a = ax.m2570a(th);
                writer.write((obj != null ? "" : "Caused by: ") + th.getClass().getName() + ": " + (a != null ? a : "") + "\n");
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    writer.write("\tat " + stackTraceElement.toString() + "\n");
                }
                th = th.getCause();
                obj = null;
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("CrashlyticsCore", "Could not write stack trace", e);
                return;
            }
        }
    }

    private static String m2570a(Throwable th) {
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            return null;
        }
        return localizedMessage.replaceAll("(\r\n|\n|\f)", " ");
    }
}
