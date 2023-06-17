package com.iot.dodo.springboot.starter.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记在类上，类下所有方法都会打印；标记在方法上，仅打印标记方法；如果类或者方法上都有标记，以方法上注解为准
 *
 * @author lwh
 * @date 2023-06-11 15:35:33
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IotLog {

    /**
     * 入参打印
     */
    boolean input() default true;

    /**
     * 出参打印
     */
    boolean output() default true;
}
