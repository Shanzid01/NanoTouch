package p006b.p007a.p008a.p009a.p010a.p013c;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: AsyncTask */
class C0236d extends FutureTask<Result> {
    final /* synthetic */ C0232a f835a;

    C0236d(C0232a c0232a, Callable callable) {
        this.f835a = c0232a;
        super(callable);
    }

    protected void done() {
        try {
            this.f835a.mo474c(get());
        } catch (Throwable e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.f835a.mo474c(null);
        }
    }
}
