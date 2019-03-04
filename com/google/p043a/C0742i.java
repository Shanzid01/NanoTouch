package com.google.p043a;

import java.lang.reflect.Field;

/* compiled from: FieldNamingPolicy */
enum C0742i extends C0737d {
    C0742i(String str, int i) {
        super(str, i);
    }

    public String translateName(Field field) {
        return C0737d.separateCamelCase(field.getName(), "-").toLowerCase();
    }
}
