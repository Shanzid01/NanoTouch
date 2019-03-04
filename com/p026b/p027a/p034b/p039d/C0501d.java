package com.p026b.p027a.p034b.p039d;

/* compiled from: ImageDownloader */
public enum C0501d {
    HTTP("http"),
    HTTPS("https"),
    FILE("file"),
    CONTENT("content"),
    ASSETS("assets"),
    DRAWABLE("drawable"),
    UNKNOWN("");
    
    private String scheme;
    private String uriPrefix;

    private C0501d(String str) {
        this.scheme = str;
        this.uriPrefix = str + "://";
    }

    public static C0501d ofUri(String str) {
        if (str != null) {
            for (C0501d c0501d : C0501d.values()) {
                if (c0501d.belongsTo(str)) {
                    return c0501d;
                }
            }
        }
        return UNKNOWN;
    }

    private boolean belongsTo(String str) {
        return str.startsWith(this.uriPrefix);
    }

    public String wrap(String str) {
        return this.uriPrefix + str;
    }

    public String crop(String str) {
        if (belongsTo(str)) {
            return str.substring(this.uriPrefix.length());
        }
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{str, this.scheme}));
    }
}
