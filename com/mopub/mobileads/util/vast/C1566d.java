package com.mopub.mobileads.util.vast;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* compiled from: VastXmlManager */
class C1566d {
    private Document f2586a;

    C1566d() {
    }

    void m4711a(String str) {
        String str2 = "<MPMoVideoXMLDocRoot>" + str.replaceFirst("<\\?.*\\?>", "") + "</MPMoVideoXMLDocRoot>";
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        this.f2586a = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str2)));
    }

    String m4710a() {
        List a = C1569g.m4733a(this.f2586a, "VASTAdTagURI");
        return a.size() > 0 ? (String) a.get(0) : null;
    }

    List<String> m4712b() {
        List<String> a = C1569g.m4733a(this.f2586a, "Impression");
        a.addAll(C1569g.m4733a(this.f2586a, "MP_TRACKING_URL"));
        return a;
    }

    List<String> m4713c() {
        return m4709b("start");
    }

    List<String> m4714d() {
        return m4709b("firstQuartile");
    }

    List<String> m4715e() {
        return m4709b("midpoint");
    }

    List<String> m4716f() {
        return m4709b("thirdQuartile");
    }

    List<String> m4717g() {
        return m4709b("complete");
    }

    String m4718h() {
        List a = C1569g.m4733a(this.f2586a, "ClickThrough");
        return a.size() > 0 ? (String) a.get(0) : null;
    }

    List<String> m4719i() {
        return C1569g.m4733a(this.f2586a, "ClickTracking");
    }

    List<C1568f> m4720j() {
        NodeList elementsByTagName = this.f2586a.getElementsByTagName("MediaFile");
        List<C1568f> arrayList = new ArrayList(elementsByTagName.getLength());
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new C1568f(this, elementsByTagName.item(i)));
        }
        return arrayList;
    }

    List<C1567e> m4721k() {
        NodeList elementsByTagName = this.f2586a.getElementsByTagName("Companion");
        List<C1567e> arrayList = new ArrayList(elementsByTagName.getLength());
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new C1567e(this, elementsByTagName.item(i)));
        }
        return arrayList;
    }

    private List<String> m4709b(String str) {
        return C1569g.m4734a(this.f2586a, "Tracking", "event", str);
    }
}
