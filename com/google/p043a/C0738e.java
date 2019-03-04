package com.google.p043a;

import java.lang.reflect.Field;

/* compiled from: FieldNamingPolicy */
enum C0738e extends C0737d {
    C0738e(String str, int i) {
        super(str, i);
    }

    public String translateName(Field field) {
        return field.getName();
    }
}
