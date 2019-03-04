package com.slideme.sam.manager.model.p054b;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.widget.ToolTipPopup;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.C1880m;
import com.slideme.sam.manager.net.response.PurchaseResponse;
import com.slideme.sam.manager.net.response.PurchaseResponse.ItemData;
import com.slideme.sam.manager.net.response.PurchaseResponse.PurchaseStatus;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: PurchaseHelper */
class C1834j extends AsyncTask<Application, Void, PurchaseResponse> {
    private static /* synthetic */ int[] f3289c;
    final /* synthetic */ C1683i f3290a;
    private boolean f3291b;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m5526a((Application[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5527a((PurchaseResponse) obj);
    }

    private C1834j(C1683i c1683i) {
        this.f3290a = c1683i;
        this.f3291b = true;
    }

    static /* synthetic */ int[] m5525b() {
        int[] iArr = f3289c;
        if (iArr == null) {
            iArr = new int[PurchaseStatus.values().length];
            try {
                iArr[PurchaseStatus.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PurchaseStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PurchaseStatus.DELIVERED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PurchaseStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PurchaseStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PurchaseStatus.RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PurchaseStatus.UNDEFINED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            f3289c = iArr;
        }
        return iArr;
    }

    public boolean m5528a() {
        return !this.f3291b;
    }

    protected void onPreExecute() {
        this.f3290a.mo4250a();
        this.f3291b = false;
    }

    protected PurchaseResponse m5526a(Application... applicationArr) {
        Application application = applicationArr[0];
        if (TextUtils.isEmpty(application.token)) {
            PurchaseResponse a = SAM.f2614g.m5595a(application);
            if (a == null) {
                return null;
            }
            do {
                a.error = C1683i.m5013b(a.message);
                if (!C1922m.m5795a(a.applications)) {
                    ItemData itemData = a.applications[0];
                    switch (C1834j.m5525b()[itemData.status.ordinal()]) {
                        case 1:
                            m5524a(0, a, application);
                            break;
                        case 2:
                        case 3:
                        case 4:
                            if (!TextUtils.isEmpty(itemData.token)) {
                                return a;
                            }
                            a.error = C1880m.ERROR_MISSING_TOKEN.code;
                            return a;
                        case 5:
                            a.error = C1880m.FAILURE_NO_FUNDS.code;
                            return a;
                        case 6:
                            a.error = C1880m.FAILURE_PURCHASE_CANCELLED.code;
                            return a;
                    }
                }
            } while (C1683i.m5013b(a.message) == C1880m.SUCCESS.code);
            return a;
        }
        throw new IllegalArgumentException("Application is already purchased. \nForgot to inform the user, didn't we?");
    }

    private void m5524a(int i, PurchaseResponse purchaseResponse, Application application) {
        int i2 = i + 1;
        if (20 <= i || purchaseResponse.error != C1880m.SUCCESS.code) {
            purchaseResponse.error = C1880m.FAILURE_POLL_ELAPSED.code;
            return;
        }
        synchronized (this) {
            try {
                wait(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        PurchaseResponse b = SAM.f2614g.m5629b(application);
        if (b == null) {
            return;
        }
        if (!TextUtils.isEmpty(b.message)) {
            b.error = C1683i.m5013b(b.message);
        } else if (purchaseResponse.applications == null || purchaseResponse.applications.length <= 0) {
            purchaseResponse.error = C1880m.SUCCESS.code;
        } else {
            purchaseResponse.error = C1880m.ERROR_MISSING_ITEM.code;
        }
    }

    protected void m5527a(PurchaseResponse purchaseResponse) {
        this.f3291b = true;
        this.f3290a.mo4251a(purchaseResponse);
    }
}
