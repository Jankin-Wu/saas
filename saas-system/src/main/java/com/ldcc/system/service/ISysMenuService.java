package com.ldcc.system.service;

import com.ldcc.common.domain.entity.system.SysMenu;

import java.util.Collection;
import java.util.List;

/**
 * @author wwg
 * @version jdk1.8
 * @description 菜单业务层
 * @create 2021-08-04 09:32
 **/
public interface ISysMenuService {
    SysMenu selectMenuById(String menuId);

    List<SysMenu> selectMenuList(SysMenu menu, String userId);

    Collection<String> selectMenuPermsByUserId(String userId);

    String checkMenuNameUnique(SysMenu menu);

    int insertMenu(SysMenu menu);

    boolean hasChildByMenuId(String menuId);

    boolean checkMenuExistRole(String menuId);

    int deleteMenuById(String menuId);

    int updateMenu(SysMenu menu);
}
