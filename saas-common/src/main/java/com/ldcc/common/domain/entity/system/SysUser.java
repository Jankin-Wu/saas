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

    /** 部门对象 */
    private SysDept dept;

    /** 入职时间 */
    private Date timeOfEntry;

    /** 聘用形式 */
    private int formOfEmployment;

    /** 工号 */
    private String workNumber;

    /** 管理形式 */
    private String formOfManagement;

    /** 工作城市 */
    private String workingCity;

    /** 转正时间 */
    private Date correctionTime;

    /** 在职状态 1.在职 2.离职 */
    private Integer inServiceStatus;

    /** 部门名称 */
    private String departmentName;

}
