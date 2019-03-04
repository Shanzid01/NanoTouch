package com.mopub.mobileads.util.vast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: XmlUtils */
class C1569g {
    static Node m4735a(Node node, String str) {
        return C1569g.m4736a(node, str, null, null);
    }

    static Node m4736a(Node node, String str, String str2, List<String> list) {
        if (node == null || str == null) {
            return null;
        }
        List b = C1569g.m4739b(node, str, str2, list);
        if (b == null || b.isEmpty()) {
            return null;
        }
        return (Node) b.get(0);
    }

    static List<Node> m4739b(Node node, String str, String str2, List<String> list) {
        if (node == null || str == null) {
            return null;
        }
        List<Node> arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeName().equals(str) && C1569g.m4737a(item, str2, list)) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    static boolean m4737a(Node node, String str, List<String> list) {
        if (str == null || list == null) {
            return true;
        }
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            Node namedItem = attributes.getNamedItem(str);
            if (namedItem != null && list.contains(namedItem.getNodeValue())) {
                return true;
            }
        }
        return false;
    }

    static String m4732a(Node node) {
        if (node == null || node.getFirstChild() == null || node.getFirstChild().getNodeValue() == null) {
            return null;
        }
        return node.getFirstChild().getNodeValue().trim();
    }

    static Integer m4738b(Node node, String str) {
        Integer num = null;
        if (!(node == null || str == null)) {
            try {
                num = Integer.valueOf(Integer.parseInt(C1569g.m4740c(node, str)));
            } catch (NumberFormatException e) {
            }
        }
        return num;
    }

    static String m4740c(Node node, String str) {
        if (node == null || str == null) {
            return null;
        }
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem != null) {
            return namedItem.getNodeValue();
        }
        return null;
    }

    static List<String> m4733a(Document document, String str) {
        return C1569g.m4734a(document, str, null, null);
    }

    static List<String> m4734a(Document document, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (document == null) {
            return arrayList;
        }
        NodeList elementsByTagName = document.getElementsByTagName(str);
        if (elementsByTagName == null) {
            return arrayList;
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item != null) {
                if (C1569g.m4737a(item, str2, Arrays.asList(new String[]{str3}))) {
                    String a = C1569g.m4732a(item);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            }
        }
        return arrayList;
    }
}
