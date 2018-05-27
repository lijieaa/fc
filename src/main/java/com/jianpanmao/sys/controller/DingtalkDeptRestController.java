package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.DingtalkDeptDto;
import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkDeptService;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dingtalkdept")
public class DingtalkDeptRestController {


    @Autowired
    DingtalkDeptService dingtalkdeptService;

    @Autowired
    DingtalkUserService dingtalkUserService;

    @PreAuthorize("hasAuthority('dingtalkdept:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody DingtalkDept entity) {
        return dingtalkdeptService.add(entity);
    }

    @PreAuthorize("hasAuthority('dingtalkdept:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return dingtalkdeptService.remove(id);
    }

    @PreAuthorize("hasAuthority('dingtalkdept:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return dingtalkdeptService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('dingtalkdept:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody DingtalkDept entity) {
        return dingtalkdeptService.update(entity);
    }

    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.GET)
    public DingtalkDept get(@RequestParam("id") Integer id) {
        return dingtalkdeptService.get(id);
    }



    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public List<DingtalkDept> getAll() {
        return dingtalkdeptService.getAll(null);
    }


    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.GET, value = "path")
    public Map findByPath(@RequestParam("id") Integer id) {
        Map map=new HashMap<>();
        List<DingtalkDept> dingtalkDepts = dingtalkdeptService.selectByPath(id + "");
        map.put("depts",dingtalkDepts);
        List<DingtalkUser> users=dingtalkUserService.selectByDeptId(id);
        map.put("users",users);
        return map;
    }


    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.GET, value = "pid")
    public List<DingtalkDept> findByParentId(@RequestParam("pid") Integer pid) {
        return dingtalkdeptService.selectByParentId(pid);
    }


    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.GET, value = "name")
    public Map selectByLikeName(@RequestParam("name") String name) {
        Map map=new HashMap<>();
        List<DingtalkDept> dingtalkDepts = dingtalkdeptService.selectByLikeName(name);
        map.put("depts",dingtalkDepts);

        List<DingtalkUser> users=dingtalkUserService.selectByLikeName(name);


        map.put("users",users);


        return map;
    }



    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.POST, value = "sort")
    public Integer sort(@RequestBody List<DingtalkDept> depts) {

        dingtalkdeptService.sort(depts);

        return 1;
    }


    @PreAuthorize("hasAuthority('dingtalkdept:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       DingtalkDeptDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<DingtalkDept> list = dingtalkdeptService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<DingtalkDept> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
}
