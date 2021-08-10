package com.ldcc.api.controller;

import com.ldcc.common.constant.Constants;
import com.ldcc.common.constant.UserConstants;
import com.ldcc.common.controller.BaseController;
import com.ldcc.common.domain.entity.system.LoginUser;
import com.ldcc.common.domain.entity.system.SysMenu;
import com.ldcc.common.domain.model.AjaxResult;
import com.ldcc.common.utils.SecurityUtils;
import com.ldcc.common.utils.ServletUtils;
import com.ldcc.common.utils.StringUtils;
import com.ldcc.framework.web.service.TokenService;
import com.ldcc.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wwg
 * @version jdk1.8
 * @description 菜单控制类
 * @create 2021-08-04 09:27
 **/
@Api(tags = "菜单信息")
@RestController
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController {

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private TokenService tokenService;

    /**
     * 获取菜单列表
     */
    @PreAuthorize("@ss.hasPermi('system:menu:list')")
    @ApiOperation("查询菜单列表")
    @GetMapping("/list/{userId}")
    public List<SysMenu> list(SysMenu menu, @PathVariable("userId") String userId)
    {
        return  menuService.selectMenuList(menu, userId);
    }

    /**
     * 根据菜单编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:menu:query')")
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable String menuId)
    {
        return AjaxResult.success(menuService.selectMenuById(menuId));
    }

    /**
     * 新增菜单
     */
    @PreAuthorize("@ss.hasPermi('system:menu:add')")
    @PostMapping("/add")
    public int add(@RequestBody SysMenu menu)
    {
        return menuService.insertMenu(menu);
    }

    @GetMapping("/checkMenuNameUnique")
    public String checkMenuNameUnique(SysMenu menu) {
        return menuService.checkMenuNameUnique(menu);
    }


    /**
     * 修改菜单
     */
    @PreAuthorize("@ss.hasPermi('system:menu:edit')")
    @PutMapping("/update")
    public int edit(@RequestBody SysMenu menu)
    {
        return menuService.updateMenu(menu);
    }

    /**
     * 删除菜单
     */
    @PreAuthorize("@ss.hasPermi('system:menu:remove')")
    @DeleteMapping("/{menuId}")
    public int remove(@PathVariable("menuId") String menuId)
    {
        return menuService.deleteMenuById(menuId);
    }

    @GetMapping("/hasChildByMenuId")
    public boolean hasChildByMenuId(String menuId) {
        return menuService.hasChildByMenuId(menuId);
    }

    @GetMapping("/checkMenuExistRole")
    public boolean checkMenuExistRole(String menuId) {
        return menuService.checkMenuExistRole(menuId);
    }
}
