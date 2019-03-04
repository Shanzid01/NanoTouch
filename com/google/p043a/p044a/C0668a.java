package com.google.p043a.p044a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Expose */
public @interface C0668a {
    boolean m3252a() default true;

    boolean m3253b() default true;
}
