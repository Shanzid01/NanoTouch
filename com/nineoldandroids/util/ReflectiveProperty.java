package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        char toUpperCase = Character.toUpperCase(str.charAt(0));
        String stringBuilder = new StringBuilder(String.valueOf(toUpperCase)).append(str.substring(1)).toString();
        String stringBuilder2 = new StringBuilder(PREFIX_GET).append(stringBuilder).toString();
        try {
            this.mGetter = cls.getMethod(stringBuilder2, null);
        } catch (NoSuchMethodException e) {
            try {
                this.mGetter = cls.getDeclaredMethod(stringBuilder2, null);
                this.mGetter.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                stringBuilder2 = new StringBuilder(PREFIX_IS).append(stringBuilder).toString();
                try {
                    this.mGetter = cls.getMethod(stringBuilder2, null);
                } catch (NoSuchMethodException e3) {
                    try {
                        this.mGetter = cls.getDeclaredMethod(stringBuilder2, null);
                        this.mGetter.setAccessible(true);
                    } catch (NoSuchMethodException e4) {
                        this.mField = cls.getField(str);
                        Class type = this.mField.getType();
                        if (!typesMatch(cls2, type)) {
                            throw new NoSuchPropertyException("Underlying type (" + type + ") " + "does not match Property type (" + cls2 + ")");
                        }
                        return;
                    } catch (NoSuchFieldException e5) {
                        throw new NoSuchPropertyException("No accessor method or field found for property with name " + str);
                    }
                }
            }
        }
        Class returnType = this.mGetter.getReturnType();
        if (typesMatch(cls2, returnType)) {
            stringBuilder = new StringBuilder(PREFIX_SET).append(stringBuilder).toString();
            try {
                this.mSetter = cls.getDeclaredMethod(stringBuilder, new Class[]{returnType});
                this.mSetter.setAccessible(true);
                return;
            } catch (NoSuchMethodException e6) {
                return;
            }
        }
        throw new NoSuchPropertyException("Underlying type (" + returnType + ") " + "does not match Property type (" + cls2 + ")");
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if ((cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class)))))))) {
            return true;
        }
        return false;
    }

    public void set(T t, V v) {
        if (this.mSetter != null) {
            try {
                this.mSetter.invoke(t, new Object[]{v});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                this.mField.set(t, v);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + getName() + " is read-only");
        }
    }

    public V get(T t) {
        V invoke;
        if (this.mGetter != null) {
            try {
                invoke = this.mGetter.invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                invoke = this.mField.get(t);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
        return invoke;
    }

    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }
}
