package com.google.p043a;

import java.lang.reflect.Field;

/* compiled from: FieldNamingPolicy */
enum C0740g extends C0737d {
    C0740g(String str, int i) {
        super(str, i);
    }

    public String translateName(Field field) {
        return C0737d.upperCaseFirstLetter(C0737d.separateCamelCase(field.getName(), " "));
    }
}
