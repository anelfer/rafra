package com.anelfer.rafra.core;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {

    String value() default "/";

}
