package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.slideme.sam.manager.util.C1919j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class LanguageListPreference extends ListPreference {
    private ArrayList<Locale> f3623a = new ArrayList();
    private String[] f3624b;
    private String[] f3625c;
    private ArrayList<String> f3626d = new ArrayList();

    public LanguageListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        for (Locale locale : Locale.getAvailableLocales()) {
            String displayLanguage = locale.getDisplayLanguage();
            if (!(displayLanguage.trim().length() == 0 || this.f3626d.contains(displayLanguage))) {
                this.f3623a.add(locale);
                this.f3626d.add(displayLanguage);
            }
        }
        this.f3624b = new String[this.f3623a.size()];
        this.f3625c = new String[this.f3623a.size()];
        Iterator it = this.f3623a.iterator();
        int i = 0;
        while (it.hasNext()) {
            Locale locale2 = (Locale) it.next();
            this.f3624b[i] = locale2.getDisplayLanguage();
            this.f3625c[i] = locale2.getLanguage();
            i++;
        }
        C1919j.m5778a(this.f3624b, this.f3625c);
        setEntries(this.f3624b);
        setEntryValues(this.f3625c);
    }
}
