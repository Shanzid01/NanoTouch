package com.slideme.sam.manager.view.touchme;

import java.util.Comparator;
import java.util.Locale;

/* compiled from: LanguageListView */
class C1983q implements Comparator<String> {
    final /* synthetic */ LanguageListView f3840a;

    C1983q(LanguageListView languageListView) {
        this.f3840a = languageListView;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6113a((String) obj, (String) obj2);
    }

    public int m6113a(String str, String str2) {
        Locale locale = new Locale(str);
        Locale locale2 = new Locale(str2);
        return (locale.getDisplayLanguage() + " (" + locale.getDisplayCountry() + "-" + locale.getDisplayVariant() + ")").compareTo(locale2.getDisplayLanguage() + " (" + locale2.getDisplayCountry() + "-" + locale2.getDisplayVariant() + ")");
    }
}
