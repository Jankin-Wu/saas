package com.ldcc.common.annotation;

import java.lang.annotation.*;

/**
 * @author ：wwg
 * @description ：数据权限过滤注解
 * @date ：2021/8/3 22:54
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";

    /**
     * 公司表的别名
     */
    public String companyAlias() default "";
}

