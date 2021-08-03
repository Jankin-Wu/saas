package com.ldcc.common.domain.entity.system;

import com.ldcc.common.domain.model.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysUser extends BaseEntity {

    /** 用户ID */
    private String userId;

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

    /** 盐加密 */
    private String salt;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 角色对象 */
    private List<SysRole> roles;

    /** 部门对象 */
    private SysDept dept;

    /** 公司对象 */
    private SysCompany company;

    /** 工号 */
    private String workNumber;

    /** 工作城市 */
    private String workingCity;

    /** 在职状态 1.在职 2.离职 */
    private Integer inServiceStatus;

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(String userId)
    {
        return userId != null && userId.equals("1");
    }

}
