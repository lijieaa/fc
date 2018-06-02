package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.SysRoleMenuDto;
import com.jianpanmao.sys.entity.SysRoleMenu;
import com.jianpanmao.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sysrolemenu")
public class SysRoleMenuRestController {


@Autowired
SysRoleMenuService sysrolemenuService;

@PreAuthorize("hasAuthority('sysrolemenu:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody SysRoleMenu entity){
return sysrolemenuService.add(entity);
}

@PreAuthorize("hasAuthority('sysrolemenu:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return sysrolemenuService.remove(id);
}

@PreAuthorize("hasAuthority('sysrolemenu:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return sysrolemenuService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('sysrolemenu:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody SysRoleMenu entity){
return sysrolemenuService.update(entity);
}

@PreAuthorize("hasAuthority('sysrolemenu:view')")
@RequestMapping(method = RequestMethod.GET)
public SysRoleMenu get(@RequestParam("id") Integer id){
return sysrolemenuService.get(id);
}

@PreAuthorize("hasAuthority('sysrolemenu:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
SysRoleMenuDto dto){

PageHelper.startPage(pageNum,pageSize);

List<SysRoleMenu> list = sysrolemenuService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<SysRoleMenu> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
