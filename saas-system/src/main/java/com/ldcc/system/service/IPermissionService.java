package com.ldcc.system.service;

import java.util.Map;

/**
 * @author wwg
 * @version jdk1.8
 * @description 权限业务层
 * @create 2021-08-03 09:28
 **/
public interface IPermissionService {

    void update(Map<String, Object> map);

    Map findById(String id);

    void deleteById(String id);
}
