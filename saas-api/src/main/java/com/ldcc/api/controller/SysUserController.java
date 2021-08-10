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
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userParam", value = "用户信息", dataType = "com.ldcc.system.dto.UserParam", paramType = "query")
    })
    public List<SysUser> list(UserParam userParam)
    {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userParam, sysUser);
        return userService.selectUserList(sysUser);
    }

    /**
     * 根据用户编号获取详细信息
     */
    @ApiOperation("根据用户id获取详细信息")
    @GetMapping("/{userId}")
    public List<SysRole> getInfo(@PathVariable(value = "userId", required = false) String userId)
    {
        return roleService.selectRoleAll();
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @PostMapping("/selectUserByUserName")
    public SysUser selectUserByUserName(String userName) {
        return userService.selectUserByUserName(userName);
    }

    /**
     * 新增用户
     */
    @ApiOperation("新增用户")
    @PostMapping("/add")
    public int add(@RequestBody SysUser user)
    {
        return userService.insertUser(user);
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    @PostMapping("/checkUserNameUnique")
    public String checkUserNameUnique(@RequestBody String userName) {
        return userService.checkUserNameUnique(userName);
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/checkEmailUnique")
    public String checkPhoneUnique(@RequestBody SysUser user) {
        return userService.checkEmailUnique(user);
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/checkEmailUnique")
    public String checkEmailUnique(@RequestBody SysUser user) {
        return userService.checkEmailUnique(user);
    }

    /**
     * 修改用户
     */
    @ApiOperation("修改用户信息")
    @PutMapping("/update")
    public int edit(@RequestBody SysUser user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public int deleteUserById(@PathVariable(value = "userId", required = false) String userId) {
        return userService.deleteUserById(userId);
    }
}
