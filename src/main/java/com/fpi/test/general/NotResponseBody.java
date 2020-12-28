package com.fpi.test.general;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @description: 排除封装，返回直接放行
 *
 * @author ZengShuo
 * @since 2020/12/24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NotResponseBody {
}
