package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.slideme.sam.manager.util.C1919j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class CountryListPreference extends ListPreference {
    private ArrayList<Locale> f3616a = new ArrayList();
    private String[] f3617b;
    private String[] f3618c;
    private ArrayList<String> f3619d = new ArrayList();

    public CountryListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        for (Locale locale : Locale.getAvailableLocales()) {
            String displayCountry = locale.getDisplayCountry();
            if (!(displayCountry.trim().length() == 0 || this.f3619d.contains(displayCountry))) {
                this.f3616a.add(locale);
                this.f3619d.add(displayCountry);
            }
        }
        this.f3617b = new String[this.f3616a.size()];
        this.f3618c = new String[this.f3616a.size()];
        Iterator it = this.f3616a.iterator();
        int i = 0;
        while (it.hasNext()) {
            Locale locale2 = (Locale) it.next();
            this.f3617b[i] = locale2.getDisplayCountry();
            this.f3618c[i] = locale2.getCountry();
            i++;
        }
        C1919j.m5778a(this.f3617b, this.f3618c);
        setEntries(this.f3617b);
        setEntryValues(this.f3618c);
    }
}
