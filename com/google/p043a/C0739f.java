package com.google.p043a;

import java.lang.reflect.Field;

/* compiled from: FieldNamingPolicy */
enum C0739f extends C0737d {
    C0739f(String str, int i) {
        super(str, i);
    }

    public String translateName(Field field) {
        return C0737d.upperCaseFirstLetter(field.getName());
    }
}
