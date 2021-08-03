package com.ldcc.system.controller;

import com.ldcc.common.domain.entity.system.Permission;
import com.ldcc.common.domain.model.AjaxResult;
import com.ldcc.system.service.IPermissionService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：wwg
 * @description ：权限控制类
 * @date ：2021/8/2 19:16
 */
@RestController
@RequestMapping(value="/sys")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    /**
     * 保存
     */
    @PostMapping("/permission")
    public AjaxResult save(@RequestBody Map<String,Object> map) throws Exception {
        permissionService.save(map);
        return AjaxResult.success();
    }

    /**
     * 修改
     */
    @PutMapping ("/permission/{id}")
    public AjaxResult update(@PathVariable(value = "id") String id, @RequestBody Map<String,Object> map) throws Exception {
        //构造id
        map.put("id",id);
        permissionService.update(map);
        return AjaxResult.success();
    }

    /**
     * 查询列表
     */
    @GetMapping ("/permission")
    public AjaxResult findAll(@RequestParam Map map) {
        List<Permission> list =  permissionService.findAll(map);
        return AjaxResult.success(list);
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/permission/{id}")
    public AjaxResult findById(@PathVariable(value = "id") String id) throws Exception {
        Map map = permissionService.findById(id);
        return AjaxResult.success(map);
    }



    /**
     * 根据id删除
     */
    @DeleteMapping("/permission/{id}")
    public AjaxResult delete(@PathVariable(value = "id") String id) throws Exception {
        permissionService.deleteById(id);
        return AjaxResult.success();
    }
}
