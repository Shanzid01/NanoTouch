package com.slideme.sam.manager.net.wrappers;

import android.os.AsyncTask;

/* compiled from: Catalog */
class C1895d extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Catalog f3477a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m5717a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5718a((Void) obj);
    }

    private C1895d(Catalog catalog) {
        this.f3477a = catalog;
    }

    protected void onPreExecute() {
        if (this.f3477a.f3435e != null) {
            this.f3477a.f3435e.mo4234b();
        }
    }

    protected Void m5717a(Void... voidArr) {
        this.f3477a.m5689g();
        return null;
    }

    protected void m5718a(Void voidR) {
        if (this.f3477a.f3435e != null) {
            this.f3477a.f3435e.mo4232a(null);
            this.f3477a.f3435e.mo4231a();
        }
    }

    protected void onCancelled() {
        if (this.f3477a.f3435e != null) {
            this.f3477a.f3435e.mo4233a(new Throwable("Catalog async task cancelled"), null);
            this.f3477a.f3435e.mo4231a();
        }
    }
}
