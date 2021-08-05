package com.ldcc.api.controller;

import com.ldcc.common.constant.Constants;
import com.ldcc.common.domain.entity.system.LoginBody;
import com.ldcc.common.domain.entity.system.LoginUser;
import com.ldcc.common.domain.model.AjaxResult;
import com.ldcc.framework.web.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wwg
 * @version jdk1.8
 * @description 登录验证
 * @create 2021-08-02 10:54
 **/
@Api(tags = "登录模块")
@RestController
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation(value = "登录功能")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            return AjaxResult.error("用户不存在/密码错误");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String token = tokenService.createToken(loginUser);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
}
