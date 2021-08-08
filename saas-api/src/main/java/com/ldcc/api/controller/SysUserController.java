package com.ldcc.api.controller;

import com.ldcc.common.constant.UserConstants;
import com.ldcc.common.controller.BaseController;
import com.ldcc.common.domain.entity.system.SysRole;
import com.ldcc.common.domain.entity.system.SysUser;
import com.ldcc.common.domain.model.AjaxResult;
import com.ldcc.common.page.TableDataInfo;
import com.ldcc.common.utils.SecurityUtils;
import com.ldcc.common.utils.StringUtils;
import com.ldcc.system.dto.UserParam;
import com.ldcc.system.service.ISysRoleService;
import com.ldcc.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：wwg
 * @description ：用户控制层
 * @date ：2021/8/5 2:00
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    /**
     * 获取用户列表
     */
    @ApiOperation("用户列表")
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userParam", value = "用户信息", dataType = "com.ldcc.system.dto.UserParam", paramType = "query")
    })
    public TableDataInfo list(UserParam userParam)
    {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userParam, sysUser);
        startPage();
        List<SysUser> list = userService.selectUserList(sysUser);
        return getDataTable(list);
    }

    /**
     * 根据用户编号获取详细信息
     */
    @ApiOperation("根据用户id获取详细信息")
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/{userId}")
    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) String userId)
    {
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        if (StringUtils.isNotNull(userId))
        {
            ajax.put(AjaxResult.DATA_TAG, userService.selectUserById(userId));
        }
        return ajax;
    }

    /**
     * 新增用户
     */
    @ApiOperation("新增用户")
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody SysUser user)
    {
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName())))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setCreateBy(SecurityUtils.getUsername());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @ApiOperation("修改用户")
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysUser user)
    {
        if (StringUtils.isNotEmpty(user.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(userService.updateUser(user));
    }

}
