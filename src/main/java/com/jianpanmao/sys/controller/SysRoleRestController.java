package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.SysRoleDto;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.entity.SysRole;
import com.jianpanmao.sys.service.SysMenuService;
import com.jianpanmao.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sysrole")
public class SysRoleRestController {


    @Autowired
    SysRoleService sysroleService;

    @Autowired
    SysMenuService sysMenuService;

    @PreAuthorize("hasAuthority('sysrole:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody SysRole entity) {
        return sysroleService.add(entity);
    }

    @PreAuthorize("hasAuthority('sysrole:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return sysroleService.remove(id);
    }

    @PreAuthorize("hasAuthority('sysrole:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return sysroleService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('sysrole:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody SysRole entity) {
        return sysroleService.update(entity);
    }

    @PreAuthorize("hasAuthority('sysrole:view')")
    @RequestMapping(method = RequestMethod.GET)
    public SysRole get(@RequestParam("id") Integer id) {
        return sysroleService.get(id);
    }



    public static void checkMenu(List<SysMenu> all,List<SysMenu> checkMenu,List<Map> outlist){
        for (SysMenu menu : all) {
            Map m=new HashMap<>();
            if(menu.getChildren().size()>0){
                checkMenu(menu.getChildren(),checkMenu,outlist);
            }else{

                m.put("menuId",menu.getMenuId());
                m.put("menuParentId",menu.getMenuParentId());
                m.put("menuName",menu.getMenuName());
                m.put("checked",true);
            }
            outlist.add(m);
        }
    }

    @PreAuthorize("hasAuthority('sysrole:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       SysRoleDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<SysRole> list = sysroleService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<SysRole> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
}
