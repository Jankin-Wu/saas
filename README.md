# 基于多租户的 Sass 云平台用户权限管理系统

## 系统架构

![](http://oss.jankinwu.com/img/saas%E7%B3%BB%E7%BB%9F%E6%9E%B6%E6%9E%84.jpg)

## 登录及业务数据访问流程

![](http://oss.jankinwu.com/img/%E6%9D%83%E9%99%90%E6%A0%A1%E9%AA%8C%E6%B5%81%E7%A8%8B.jpg)

## 权限管理

> 数据权限示例

```java
// 符合system:user:list权限要求
@PreAuthorize("@ss.hasPermi('system:user:list')")

// 不符合system:user:list权限要求
@PreAuthorize("@ss.lacksPermi('system:user:list')")

// 符合system:user:add或system:user:edit权限要求即可
@PreAuthorize("@ss.hasAnyPermi('system:user:add,system:user:edit')")
```

> 角色权限示例

```java
// 属于user角色
@PreAuthorize("@ss.hasRole('user')")

// 不属于user角色
@PreAuthorize("@ss.lacksRole('user')")

// 属于user或者admin之一
@PreAuthorize("@ss.hasAnyRoles('user,admin')")
```

