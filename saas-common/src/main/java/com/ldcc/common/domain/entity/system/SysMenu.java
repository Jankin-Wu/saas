package com.ldcc.common.domain.entity.system;

import com.ldcc.common.domain.model.BaseEntity;
import lombok.Data;

import java.util.Map;

/**
 * @author wwg
 * @version jdk1.8
 * @description 菜单实体类
 * @create 2021-08-04 09:21
 **/
@Data
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    private String menuId;

    /** 菜单名称 */
    private String menuName;

    /** 父菜单名称 */
    private String parentName;

    /** 父菜单ID */
    private String parentId;

    /** 路由地址 */
    private String path;

    /** 是否为外链（0是 1否） */
    private String isFrame;

    /** 类型（M目录 C菜单 F按钮） */
    private String menuType;

    /** 显示状态（0显示 1隐藏） */
    private String visible;

    /** 菜单状态（0显示 1隐藏） */
    private String status;

    /** 权限字符串 */
    private String perms;

    /** 菜单图标 */
    private String icon;

}
