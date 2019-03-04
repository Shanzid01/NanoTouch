package com.mopub.mobileads;

import java.util.Map;

/* compiled from: MraidCommandFactory */
class ao {
    protected static ao f2412a = new ao();
    private static /* synthetic */ int[] f2413b;

    ao() {
    }

    static /* synthetic */ int[] m4515a() {
        int[] iArr = f2413b;
        if (iArr == null) {
            iArr = new int[ap.values().length];
            try {
                iArr[ap.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ap.CREATE_CALENDAR_EVENT.ordinal()] = 14;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ap.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ap.GET_CURRENT_POSITION.ordinal()] = 10;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ap.GET_DEFAULT_POSITION.ordinal()] = 11;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ap.GET_MAX_SIZE.ordinal()] = 12;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ap.GET_RESIZE_PROPERTIES.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ap.GET_SCREEN_SIZE.ordinal()] = 13;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ap.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ap.PLAY_VIDEO.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ap.RESIZE.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[ap.SET_RESIZE_PROPERTIES.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[ap.STORE_PICTURE.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[ap.UNSPECIFIED.ordinal()] = 15;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[ap.USECUSTOMCLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
            f2413b = iArr;
        }
        return iArr;
    }

    public static ak m4514a(String str, Map<String, String> map, MraidView mraidView) {
        return f2412a.m4516b(str, map, mraidView);
    }

    protected ak m4516b(String str, Map<String, String> map, MraidView mraidView) {
        switch (m4515a()[ap.fromString(str).ordinal()]) {
            case 1:
                return new al(map, mraidView);
            case 2:
                return new an(map, mraidView);
            case 3:
                return new ba(map, mraidView);
            case 4:
                return new av(map, mraidView);
            case 5:
                return new ax(map, mraidView);
            case 6:
                return new at(map, mraidView);
            case 7:
                return new ay(map, mraidView);
            case 8:
                return new aw(map, mraidView);
            case 9:
                return new az(map, mraidView);
            case 10:
                return new aq(map, mraidView);
            case 11:
                return new ar(map, mraidView);
            case 12:
                return new as(map, mraidView);
            case 13:
                return new au(map, mraidView);
            case 14:
                return new am(map, mraidView);
            default:
                return null;
        }
    }
}
