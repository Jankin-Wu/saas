package com.ldcc.common.domain.entity.system;

import com.ldcc.common.domain.model.BaseEntity;
import lombok.Data;

@Data
public class SysRole extends BaseEntity {

    /** 角色ID */
    private String roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色权限 */
    private String roleKey;

    /**
     * 企业id
     */
    private String companyId;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限） */
    private String dataScope;

    /** 角色状态（0正常 1停用） */
    private String status;

    /** 部门组（数据权限） */
    private Long[] deptIds;
}
