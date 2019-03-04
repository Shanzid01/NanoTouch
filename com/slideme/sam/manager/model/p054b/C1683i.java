package com.slideme.sam.manager.model.p054b;

import android.text.TextUtils;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.C1880m;
import com.slideme.sam.manager.net.response.PurchaseResponse;

/* compiled from: PurchaseHelper */
public abstract class C1683i {
    private C1834j f2859a;

    protected abstract void mo4250a();

    protected abstract void mo4251a(PurchaseResponse purchaseResponse);

    public void m5015a(Application application) {
        if (!m5018c()) {
            this.f2859a = new C1834j();
            this.f2859a.execute(new Application[]{application});
        }
    }

    public void m5017b() {
        if (this.f2859a != null) {
            this.f2859a.cancel(true);
            this.f2859a = null;
        }
    }

    private static int m5013b(String str) {
        if (TextUtils.isEmpty(str)) {
            return C1880m.SUCCESS.code;
        }
        if (str.startsWith("invalid application uuid")) {
            return C1880m.FAILURE_INVALID_UUID.code;
        }
        if (str.startsWith("out of stock")) {
            return C1880m.FAILURE_OUT_OF_STOCK.code;
        }
        if (str.startsWith("prices do not match")) {
            return C1880m.FAILURE_PRICE_MISMATCH.code;
        }
        if (str.startsWith("error processing payment")) {
            return C1880m.ERROR_PROCESSING_PAYMENT.code;
        }
        if (str.contains("no payment method")) {
            return C1880m.ERROR_NO_PAYMENT_METHOD.code;
        }
        return C1880m.ERROR_UNKNOWN.code;
    }

    public boolean m5018c() {
        return this.f2859a != null && this.f2859a.m5528a();
    }
}
