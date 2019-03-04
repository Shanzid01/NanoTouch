package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.AbstractPendingResult.CallbackHandler;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends AbstractPendingResult<BatchResult> {
    private int zzLW;
    private boolean zzLX;
    private boolean zzLY;
    private final PendingResult<?>[] zzLZ;
    private final Object zznh;

    class C08301 implements BatchCallback {
        final /* synthetic */ Batch zzMa;

        C08301(Batch batch) {
            this.zzMa = batch;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzl(com.google.android.gms.common.api.Status r6) {
            /*
            r5 = this;
            r0 = r5.zzMa;
            r1 = r0.zznh;
            monitor-enter(r1);
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r0 = r0.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0017:
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.zzLY = r2;	 Catch:{ all -> 0x0039 }
        L_0x001d:
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r0.zzLW = r0.zzLW - 1;	 Catch:{ all -> 0x0039 }
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzLW;	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037;
        L_0x002a:
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzLY;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0049;
        L_0x0032:
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            super.cancel();	 Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0010;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = r6.isSuccess();	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x001d;
        L_0x0042:
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.zzLX = r2;	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0049:
            r0 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r0 = r0.zzLX;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0069;
        L_0x0051:
            r0 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0039 }
            r2 = 13;
            r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        L_0x0058:
            r2 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r3 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0039 }
            r4 = r5.zzMa;	 Catch:{ all -> 0x0039 }
            r4 = r4.zzLZ;	 Catch:{ all -> 0x0039 }
            r3.<init>(r0, r4);	 Catch:{ all -> 0x0039 }
            r2.setResult(r3);	 Catch:{ all -> 0x0039 }
            goto L_0x0037;
        L_0x0069:
            r0 = com.google.android.gms.common.api.Status.zzNo;	 Catch:{ all -> 0x0039 }
            goto L_0x0058;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.1.zzl(com.google.android.gms.common.api.Status):void");
        }
    }

    public final class Builder {
        private List<PendingResult<?>> zzMb = new ArrayList();
        private Looper zzMc;

        public Builder(GoogleApiClient googleApiClient) {
            this.zzMc = googleApiClient.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.zzMb.size());
            this.zzMb.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzMb, this.zzMc);
        }
    }

    private Batch(List<PendingResult<?>> list, Looper looper) {
        super(new CallbackHandler(looper));
        this.zznh = new Object();
        this.zzLW = list.size();
        this.zzLZ = new PendingResult[this.zzLW];
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.zzLZ[i] = pendingResult;
            pendingResult.addBatchCallback(new C08301(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.zzLZ) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zzLZ);
    }
}
