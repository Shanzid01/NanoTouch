package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

@zzgi
public class zzfc {
    private final Context mContext;
    Object zzuV;

    public zzfc(Context context) {
        this.mContext = context;
    }

    public void destroy() {
        this.zzuV = null;
    }

    public Bundle zzb(String str, String str2, String str3) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzuV), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            zzhx.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public int zzg(String str, String str2) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.zzuV), new Object[]{Integer.valueOf(3), str, str2})).intValue();
        } catch (Throwable e) {
            zzhx.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return 5;
        }
    }

    public Bundle zzh(String str, String str2) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzuV), new Object[]{Integer.valueOf(3), str, "inapp", str2});
        } catch (Throwable e) {
            zzhx.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public void zzx(IBinder iBinder) {
        try {
            this.zzuV = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            zzhx.zzac("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }
}
