package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.SysRoleGroupDto;
import com.jianpanmao.sys.entity.SysRoleGroup;
import com.jianpanmao.sys.service.SysRoleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sysrolegroup")
public class SysRoleGroupRestController {


    @Autowired
    SysRoleGroupService sysrolegroupService;

    @PreAuthorize("hasAuthority('sysrolegroup:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody SysRoleGroup entity) {
        return sysrolegroupService.add(entity);
    }

    @PreAuthorize("hasAuthority('sysrolegroup:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return sysrolegroupService.remove(id);
    }

    @PreAuthorize("hasAuthority('sysrolegroup:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return sysrolegroupService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('sysrolegroup:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody SysRoleGroup entity) {
        return sysrolegroupService.update(entity);
    }

    @PreAuthorize("hasAuthority('sysrolegroup:view')")
    @RequestMapping(method = RequestMethod.GET)
    public SysRoleGroup get(@RequestParam("id") Integer id) {
        return sysrolegroupService.get(id);
    }

    @PreAuthorize("hasAuthority('sysrolegroup:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       SysRoleGroupDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<SysRoleGroup> list = sysrolegroupService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<SysRoleGroup> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }


    @PreAuthorize("hasAuthority('sysrolegroup:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public List<SysRoleGroup> list() {
        List<SysRoleGroup> all = sysrolegroupService.getAll(null);
        return all;
    }
}
