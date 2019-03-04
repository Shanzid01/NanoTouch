package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzme;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private int zzAz;
    private JSONObject zzIX;
    private float zzJP;
    private int zzJQ;
    private int zzJR;
    private int zzJS;
    private int zzJT;
    private int zzJU;
    private int zzJV;
    private String zzJW;
    private int zzJX;
    private int zzJY;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzJP = DEFAULT_FONT_SCALE;
        this.zzJQ = 0;
        this.zzAz = 0;
        this.zzJR = -1;
        this.zzJS = 0;
        this.zzJT = -1;
        this.zzJU = 0;
        this.zzJV = 0;
        this.zzJW = null;
        this.zzJX = -1;
        this.zzJY = -1;
        this.zzIX = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzme.zzkj()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private int zzaH(String str) {
        int i = 0;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private String zzy(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        if ((this.zzIX == null) != (textTrackStyle.zzIX == null)) {
            return false;
        }
        if (this.zzIX != null && textTrackStyle.zzIX != null && !zzma.zzd(this.zzIX, textTrackStyle.zzIX)) {
            return false;
        }
        if (!(this.zzJP == textTrackStyle.zzJP && this.zzJQ == textTrackStyle.zzJQ && this.zzAz == textTrackStyle.zzAz && this.zzJR == textTrackStyle.zzJR && this.zzJS == textTrackStyle.zzJS && this.zzJT == textTrackStyle.zzJT && this.zzJV == textTrackStyle.zzJV && zzjv.zza(this.zzJW, textTrackStyle.zzJW) && this.zzJX == textTrackStyle.zzJX && this.zzJY == textTrackStyle.zzJY)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.zzAz;
    }

    public JSONObject getCustomData() {
        return this.zzIX;
    }

    public int getEdgeColor() {
        return this.zzJS;
    }

    public int getEdgeType() {
        return this.zzJR;
    }

    public String getFontFamily() {
        return this.zzJW;
    }

    public int getFontGenericFamily() {
        return this.zzJX;
    }

    public float getFontScale() {
        return this.zzJP;
    }

    public int getFontStyle() {
        return this.zzJY;
    }

    public int getForegroundColor() {
        return this.zzJQ;
    }

    public int getWindowColor() {
        return this.zzJU;
    }

    public int getWindowCornerRadius() {
        return this.zzJV;
    }

    public int getWindowType() {
        return this.zzJT;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzJP), Integer.valueOf(this.zzJQ), Integer.valueOf(this.zzAz), Integer.valueOf(this.zzJR), Integer.valueOf(this.zzJS), Integer.valueOf(this.zzJT), Integer.valueOf(this.zzJU), Integer.valueOf(this.zzJV), this.zzJW, Integer.valueOf(this.zzJX), Integer.valueOf(this.zzJY), this.zzIX);
    }

    public void setBackgroundColor(int i) {
        this.zzAz = i;
    }

    public void setCustomData(JSONObject jSONObject) {
        this.zzIX = jSONObject;
    }

    public void setEdgeColor(int i) {
        this.zzJS = i;
    }

    public void setEdgeType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzJR = i;
    }

    public void setFontFamily(String str) {
        this.zzJW = str;
    }

    public void setFontGenericFamily(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzJX = i;
    }

    public void setFontScale(float f) {
        this.zzJP = f;
    }

    public void setFontStyle(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzJY = i;
    }

    public void setForegroundColor(int i) {
        this.zzJQ = i;
    }

    public void setWindowColor(int i) {
        this.zzJU = i;
    }

    public void setWindowCornerRadius(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzJV = i;
    }

    public void setWindowType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzJT = i;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzJP);
            if (this.zzJQ != 0) {
                jSONObject.put("foregroundColor", zzy(this.zzJQ));
            }
            if (this.zzAz != 0) {
                jSONObject.put("backgroundColor", zzy(this.zzAz));
            }
            switch (this.zzJR) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzJS != 0) {
                jSONObject.put("edgeColor", zzy(this.zzJS));
            }
            switch (this.zzJT) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzJU != 0) {
                jSONObject.put("windowColor", zzy(this.zzJU));
            }
            if (this.zzJT == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzJV);
            }
            if (this.zzJW != null) {
                jSONObject.put("fontFamily", this.zzJW);
            }
            switch (this.zzJX) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzJY) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.zzIX != null) {
                jSONObject.put("customData", this.zzIX);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzd(JSONObject jSONObject) {
        String string;
        clear();
        this.zzJP = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzJQ = zzaH(jSONObject.optString("foregroundColor"));
        this.zzAz = zzaH(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzJR = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzJR = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzJR = 2;
            } else if ("RAISED".equals(string)) {
                this.zzJR = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzJR = 4;
            }
        }
        this.zzJS = zzaH(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.zzJT = 0;
            } else if ("NORMAL".equals(string)) {
                this.zzJT = 1;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.zzJT = 2;
            }
        }
        this.zzJU = zzaH(jSONObject.optString("windowColor"));
        if (this.zzJT == 2) {
            this.zzJV = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzJW = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.zzJX = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.zzJX = 1;
            } else if ("SERIF".equals(string)) {
                this.zzJX = 2;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.zzJX = 3;
            } else if ("CASUAL".equals(string)) {
                this.zzJX = 4;
            } else if ("CURSIVE".equals(string)) {
                this.zzJX = 5;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.zzJX = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.zzJY = 0;
            } else if ("BOLD".equals(string)) {
                this.zzJY = 1;
            } else if ("ITALIC".equals(string)) {
                this.zzJY = 2;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.zzJY = 3;
            }
        }
        this.zzIX = jSONObject.optJSONObject("customData");
    }
}
