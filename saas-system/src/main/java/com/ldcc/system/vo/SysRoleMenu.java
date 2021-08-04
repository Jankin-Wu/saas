package com.ldcc.system.vo;

import lombok.Data;

/**
 * @author wwg
 * @version jdk1.8
 * @description 菜单和角色关联
 * @create 2021-08-04 10:58
 **/
@Data
public class SysRoleMenu {
    /** 角色ID */
    private Long roleId;

    /** 菜单ID */
    private Long menuId;
}
