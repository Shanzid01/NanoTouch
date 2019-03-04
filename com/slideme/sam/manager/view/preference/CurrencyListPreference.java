package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.slideme.sam.manager.model.p054b.p062a.C1826c;
import com.slideme.sam.manager.util.C1919j;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class CurrencyListPreference extends ListPreference {
    private ArrayList<String> f3620a = new ArrayList();
    private ArrayList<String> f3621b = new ArrayList();

    public CurrencyListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDefaultValue(C1826c.m5486b());
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency instance = Currency.getInstance(locale);
                StringBuilder stringBuilder = new StringBuilder(locale.getDisplayCountry());
                stringBuilder.append(" (").append(instance.getCurrencyCode()).append(')');
                if (!this.f3620a.contains(stringBuilder.toString())) {
                    this.f3620a.add(stringBuilder.toString());
                    this.f3621b.add(instance.getCurrencyCode() + "#" + locale.getDisplayCountry());
                }
            } catch (IllegalArgumentException e) {
            }
        }
        Object[] objArr = new String[this.f3620a.size()];
        Object[] objArr2 = new String[this.f3621b.size()];
        this.f3620a.toArray(objArr);
        this.f3621b.toArray(objArr2);
        C1919j.m5778a(objArr, objArr2);
        setEntries(objArr);
        setEntryValues(objArr2);
    }
}
