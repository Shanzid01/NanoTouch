package com.slideme.sam.manager.view.touchme;

import android.os.AsyncTask;
import android.util.Log;
import com.slideme.sam.manager.util.C1914e;

/* compiled from: VerifyableEditText */
class bd extends AsyncTask<Void, Void, bc> {
    final /* synthetic */ VerifyableEditText f3823a;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m6107a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m6108a((bc) obj);
    }

    private bd(VerifyableEditText verifyableEditText) {
        this.f3823a = verifyableEditText;
    }

    protected void onPreExecute() {
        this.f3823a.m6047a(bc.VERIFYING);
    }

    protected bc m6107a(Void... voidArr) {
        if (this.f3823a.f3763d != null) {
            return this.f3823a.f3763d.mo4244a(this.f3823a.m6053a()) ? bc.VERIFIED : bc.UNVERIFIED;
        } else {
            if (C1914e.f3493a) {
                Log.w(getClass().getName(), "Verifier not set!");
            }
            return bc.UNVERIFIED;
        }
    }

    protected void m6108a(bc bcVar) {
        this.f3823a.m6047a(bcVar);
    }
}
