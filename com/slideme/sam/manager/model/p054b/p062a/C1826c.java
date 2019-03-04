package com.slideme.sam.manager.model.p054b.p062a;

import android.content.Context;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/* compiled from: CurrencyHelper */
public class C1826c {
    private C1824a f3265a;
    private Currency f3266b;

    public C1826c(Context context) {
        this.f3265a = new C1824a(context);
        m5488a();
    }

    private String m5485a(Currency currency, double d) {
        StringBuilder stringBuilder = new StringBuilder();
        double a = this.f3265a.m5478a(currency.getCurrencyCode());
        if (a == -1.0d) {
            currency = Currency.getInstance("USD");
        }
        if (!currency.getCurrencyCode().equals("USD")) {
            d *= a;
        }
        stringBuilder.append(currency.getSymbol()).append(' ');
        stringBuilder.append(m5484a(Double.valueOf(d), currency.getDefaultFractionDigits()));
        return stringBuilder.toString();
    }

    public void m5488a() {
        this.f3265a.m5480a(null, false);
    }

    public String m5487a(double d) {
        return m5485a(this.f3266b, d);
    }

    public void m5490a(Locale locale) {
        this.f3266b = Currency.getInstance(locale);
    }

    public void m5489a(String str) {
        try {
            if (str.contains("#")) {
                this.f3266b = Currency.getInstance(str.substring(0, str.indexOf("#")));
            } else {
                this.f3266b = Currency.getInstance(str);
            }
        } catch (Exception e) {
            m5490a(Locale.getDefault());
        }
    }

    private String m5484a(Number number, int i) {
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumFractionDigits(i);
        instance.setMaximumFractionDigits(i);
        return instance.format(number);
    }

    public static String m5486b() {
        try {
            return new StringBuilder(String.valueOf(Currency.getInstance(Locale.getDefault()).toString())).append("#").append(Locale.getDefault().getDisplayCountry()).toString();
        } catch (IllegalArgumentException e) {
            return new StringBuilder(String.valueOf(Currency.getInstance("USD").toString())).append("#").append("United States").toString();
        }
    }
}
