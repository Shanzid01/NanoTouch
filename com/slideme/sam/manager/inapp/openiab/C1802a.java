package com.slideme.sam.manager.inapp.openiab;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.drive.DriveFile;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.inapp.InAppPurchasingActivity;
import com.slideme.sam.manager.inapp.openiab.p058a.C1799a;
import com.slideme.sam.manager.model.data.inapp.InAppProduct;
import com.slideme.sam.manager.net.response.InAppListResponse;
import com.slideme.sam.manager.net.response.InAppPurchasesListResponse;
import java.util.ArrayList;
import java.util.List;
import org.p059a.p060a.C1801d;

/* compiled from: OpenIabBillingService */
class C1802a extends C1801d {
    final /* synthetic */ OpenIabBillingService f3237a;

    private C1802a(OpenIabBillingService openIabBillingService) {
        this.f3237a = openIabBillingService;
    }

    public int mo4280a(int i, String str, String str2) {
        if (i < 3) {
            return 3;
        }
        if (str2.equals("inapp") || str2.equals("subs")) {
            return 0;
        }
        return 3;
    }

    public Bundle mo4281a(int i, String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (!bundle.containsKey("ITEM_ID_LIST") || i < 3) {
            bundle2.putInt("RESPONSE_CODE", 5);
            return bundle2;
        }
        List stringArrayList = bundle.getStringArrayList("ITEM_ID_LIST");
        if (stringArrayList == null || stringArrayList.size() <= 0 || stringArrayList.size() >= 20) {
            bundle2.putInt("RESPONSE_CODE", 5);
            return bundle2;
        }
        if (this.f3237a.m5321a()) {
            InAppListResponse a = SAM.f2614g.m5593a(i, stringArrayList, str);
            ArrayList arrayList = new ArrayList();
            for (InAppProduct a2 : a.products) {
                C1799a a3 = C1806c.m5412a(a2);
                if (a3 != null) {
                    arrayList.add(a3.m5382a());
                }
            }
            if (arrayList.size() <= 0) {
                bundle2.putInt("RESPONSE_CODE", 4);
            } else {
                bundle2.putInt("RESPONSE_CODE", 0);
                bundle2.putStringArrayList("DETAILS_LIST", arrayList);
            }
        } else {
            bundle2.putInt("RESPONSE_CODE", 4);
        }
        return bundle2;
    }

    public Bundle mo4283a(int i, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this.f3237a, InAppPurchasingActivity.class);
        intent.putExtra("com.slideme.sam.manager.extra.IAP_ID", str2);
        intent.putExtra("com.slideme.sam.manager.extra.CALLER_PACKAGE", str);
        intent.putExtra("com.slideme.sam.manager.extra.API_VERSION", i);
        intent.putExtra("com.slideme.sam.manager.extra.DEVELOPER_PAYLOAD", str4);
        intent.setFlags(8388608);
        intent.putExtra("OPENIAB", true);
        if (i < 3 || !(str3.equals("inapp") || str3.equals("subs"))) {
            bundle.putInt("RESPONSE_CODE", 5);
        } else {
            bundle.putInt("RESPONSE_CODE", 0);
        }
        bundle.putParcelable("BUY_INTENT", PendingIntent.getActivity(this.f3237a, 0, intent, DriveFile.MODE_READ_ONLY));
        return bundle;
    }

    public Bundle mo4282a(int i, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (i < 3 || !(str2.equals("inapp") || str2.equals("subs"))) {
            bundle.putInt("RESPONSE_CODE", 5);
        } else if (this.f3237a.m5321a()) {
            InAppPurchasesListResponse a = SAM.f2614g.m5594a(i, str);
            bundle.putInt("RESPONSE_CODE", 0);
            bundle.putStringArrayList("INAPP_PURCHASE_ITEM_LIST", new ArrayList(a.productIds));
            bundle.putStringArrayList("INAPP_PURCHASE_DATA_LIST", new ArrayList(a.itemData));
            bundle.putStringArrayList("INAPP_DATA_SIGNATURE_LIST", new ArrayList(a.signatures));
        } else {
            bundle.putInt("RESPONSE_CODE", 6);
        }
        return bundle;
    }

    public int mo4284b(int i, String str, String str2) {
        if (i < 3) {
            return 5;
        }
        if (this.f3237a.m5321a()) {
            return C1806c.m5411a(SAM.f2614g.m5592a(i, str2, str).status);
        }
        return 6;
    }
}
