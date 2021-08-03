package com.ldcc.common.domain.entity.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ：wwg
 * @description ：权限实体类
 * @date ：2021/8/2 19:18
 */
@Getter
@Setter
@NoArgsConstructor
public class Permission {
    private static final long serialVersionUID = -4990810027542971546L;
    /**
     * 主键
     */
    private String id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限类型 1为菜单 2为功能 3为API
     */
    private Integer type;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限描述
     */
    private String description;

    private String pid;

    //可见状态
    private String enVisible;

    public Permission(String name, Integer type, String code, String description) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
    }
}
