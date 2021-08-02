package com.ldcc.common.domain.entity.system;

import lombok.Data;

/**
 * @author wwg
 * @version jdk1.8
 * @description 登录d对象
 * @create 2021-08-02 10:55
 **/
@Data
public class LoginBody {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

}
