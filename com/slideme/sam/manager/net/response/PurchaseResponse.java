package com.slideme.sam.manager.net.response;

import com.google.p043a.C0673v;
import com.google.p043a.C0675w;
import com.google.p043a.C0744u;
import com.google.p043a.p044a.C0670c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class PurchaseResponse extends BaseNetworkResponse {
    private static /* synthetic */ int[] f3407x187cf450;
    public ItemData[] applications;
    private ArrayList<String> purchased;
    private HashMap<String, String> txMap;
    private ArrayList<String> unclaimed;

    public class ItemData {
        @C0670c(a = "bundle_id")
        public String bundleId;
        public PurchaseStatus status;
        public String token;
        public int txnid;
    }

    public enum PurchaseStatus {
        PENDING("pending"),
        RECEIVED("received"),
        DELIVERED("downloaded"),
        COMPLETED("installed"),
        FAILED("failed"),
        CANCELLED("canceled"),
        UNDEFINED("undefined");
        
        String strRepresentation;

        public String toString() {
            return this.strRepresentation;
        }

        private PurchaseStatus(String str) {
            this.strRepresentation = str;
        }
    }

    public class PurchaseStatusDeserializer implements C0673v<PurchaseStatus> {
        public PurchaseStatus deserialize(C0675w c0675w, Type type, C0744u c0744u) {
            for (PurchaseStatus purchaseStatus : PurchaseStatus.values()) {
                if (purchaseStatus.toString().equals(c0675w.mo1114b())) {
                    return purchaseStatus;
                }
            }
            return PurchaseStatus.UNDEFINED;
        }
    }

    static /* synthetic */ int[] m5650x187cf450() {
        int[] iArr = f3407x187cf450;
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
            f3407x187cf450 = iArr;
        }
        return iArr;
    }

    public ArrayList<String> getUnclaimedApplications() {
        if (this.unclaimed != null) {
            return this.unclaimed;
        }
        initArrays();
        return this.unclaimed;
    }

    public ArrayList<String> getPurchasedApplications() {
        if (this.purchased != null) {
            return this.purchased;
        }
        initArrays();
        return this.purchased;
    }

    public HashMap<String, String> getTransactionMap() {
        if (this.txMap != null) {
            return this.txMap;
        }
        initArrays();
        return this.txMap;
    }

    private void initArrays() {
        this.unclaimed = new ArrayList();
        this.purchased = new ArrayList();
        this.txMap = new HashMap();
        if (this.applications != null) {
            for (ItemData itemData : this.applications) {
                this.txMap.put(itemData.bundleId, itemData.token);
                switch (m5650x187cf450()[itemData.status.ordinal()]) {
                    case 2:
                        this.unclaimed.add(itemData.bundleId);
                        break;
                    case 4:
                        this.purchased.add(itemData.bundleId);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
