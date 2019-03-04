package com.mopub.mobileads;

import android.os.AsyncTask;

public class VastVideoDownloadTask extends AsyncTask<String, Void, Boolean> {
    private final VastVideoDownloadTaskListener f2366a;

    public interface VastVideoDownloadTaskListener {
        void onComplete(boolean z);
    }

    protected java.lang.Boolean m4416a(java.lang.String... r9) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r1 = 0;
        if (r9 == 0) goto L_0x0007;
    L_0x0003:
        r0 = r9[r1];
        if (r0 != 0) goto L_0x000c;
    L_0x0007:
        r0 = java.lang.Boolean.valueOf(r1);
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r9[r1];
        r1 = 0;
        r1 = com.mopub.common.C1511s.m4151a();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2 = r1.execute(r2);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        if (r2 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
    L_0x001e:
        r3 = r2.getEntity();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        if (r3 != 0) goto L_0x005b;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
    L_0x0024:
        r2 = new java.io.IOException;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r4 = "Obtained null response from video url: ";	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        throw r2;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
    L_0x0039:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r3 = "Failed to download video: ";	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        com.mopub.common.p050b.C1486i.m4076a(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = 0;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        if (r1 == 0) goto L_0x000b;
    L_0x0057:
        r1.close();
        goto L_0x000b;
    L_0x005b:
        r3 = r2.getEntity();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r4 = r3.getContentLength();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r6 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        if (r3 <= 0) goto L_0x0079;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
    L_0x006a:
        r0 = new java.io.IOException;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2 = "Video exceeded max download size";	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        throw r0;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
    L_0x0072:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0078;
    L_0x0075:
        r1.close();
    L_0x0078:
        throw r0;
    L_0x0079:
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2 = r2.getEntity();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r2 = r2.getContent();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = com.mopub.common.C1497e.m4094a(r0, r3);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r3.close();	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x0039, all -> 0x0072 }
        if (r1 == 0) goto L_0x000b;
    L_0x0093:
        r1.close();
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastVideoDownloadTask.a(java.lang.String[]):java.lang.Boolean");
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4416a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4417a((Boolean) obj);
    }

    public VastVideoDownloadTask(VastVideoDownloadTaskListener vastVideoDownloadTaskListener) {
        this.f2366a = vastVideoDownloadTaskListener;
    }

    protected void onCancelled() {
        m4417a(Boolean.valueOf(false));
    }

    protected void m4417a(Boolean bool) {
        if (this.f2366a != null) {
            this.f2366a.onComplete(bool.booleanValue());
        }
    }
}
