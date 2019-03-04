package com.slideme.sam.manager.net.response;

import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.model.data.inapp.InAppProduct;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.List;

public class InAppListResponse extends BaseNetworkResponse {
    @C0670c(a = "iap_payments_inhibited")
    public boolean iapInhibited;
    public List<InAppProduct> products;
    public int status;

    public InAppProduct getSingleIapDetails() {
        if (C1922m.m5794a(this.products)) {
            return null;
        }
        return (InAppProduct) this.products.get(0);
    }

    public ArrayList<String> productsToJson() {
        if (C1922m.m5794a(this.products)) {
            return new ArrayList();
        }
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < this.products.size(); i++) {
            arrayList.add(((InAppProduct) this.products.get(i)).toJSON());
        }
        return arrayList;
    }
}
