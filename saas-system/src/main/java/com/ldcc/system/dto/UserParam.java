package com.ldcc.system.dto;

import lombok.Data;

/**
 * @author wwg
 * @version jdk1.8
 * @description 用户传入参数
 * @create 2021-08-06 09:00
 **/
@Data
public class UserParam {
    /** 部门ID */
    private Long deptId;

    /** 用户账号 */
    private String userName;

    /** 公司ID */
    private String companyId;

    /** 用户昵称 */
    private String nickName;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phoneNumber;

    /** 密码 */
    private String password;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 工号 */
    private String workNumber;

    /** 工作城市 */
    private String workingCity;

    /** 在职状态 1.在职 2.离职 */
    private Integer inServiceStatus;
}
