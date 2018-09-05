package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.SysMenuDto;
import com.jianpanmao.sys.entity.SysMenu;
import com.jianpanmao.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
@RequestMapping("/api/sysmenu")
public class SysMenuRestController {


    @Autowired
    SysMenuService sysmenuService;

    @PreAuthorize("hasAuthority('sysmenu:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody SysMenu entity) {
        return sysmenuService.add(entity);
    }

    @PreAuthorize("hasAuthority('sysmenu:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return sysmenuService.remove(id);
    }

    @PreAuthorize("hasAuthority('sysmenu:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return sysmenuService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('sysmenu:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody SysMenu entity) {
        return sysmenuService.update(entity);
    }

    @PreAuthorize("hasAuthority('sysmenu:view')")
    @RequestMapping(method = RequestMethod.GET)
    public SysMenu get(@RequestParam("id") Integer id) {
        return sysmenuService.get(id);
    }


    @PreAuthorize("hasAuthority('sysmenu:view')")
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public LinkedHashSet<SysMenu> getAll(HttpSession session) {
        LinkedHashSet<SysMenu> menus = (LinkedHashSet<SysMenu>) session.getAttribute("menus");
        return menus;
    }

    @PreAuthorize("hasAuthority('sysmenu:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       SysMenuDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<SysMenu> list = sysmenuService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<SysMenu> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
}
