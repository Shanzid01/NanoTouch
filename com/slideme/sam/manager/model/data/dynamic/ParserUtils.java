package com.slideme.sam.manager.model.data.dynamic;

import org.xmlpull.v1.XmlPullParser;

public abstract class ParserUtils {
    private ParserUtils() {
    }

    public static void skip(XmlPullParser xmlPullParser, String str) {
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 1) {
                if (eventType != 3 || !str.equals(xmlPullParser.getName())) {
                    xmlPullParser.next();
                } else {
                    return;
                }
            }
            return;
        }
    }
}
