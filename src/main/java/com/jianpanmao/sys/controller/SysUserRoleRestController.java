package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.SysUserRoleDto;
import com.jianpanmao.sys.entity.SysUserRole;
import com.jianpanmao.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sysuserrole")
public class SysUserRoleRestController {


@Autowired
SysUserRoleService sysuserroleService;

@PreAuthorize("hasAuthority('sysuserrole:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody SysUserRole entity){
return sysuserroleService.add(entity);
}

@PreAuthorize("hasAuthority('sysuserrole:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return sysuserroleService.remove(id);
}

@PreAuthorize("hasAuthority('sysuserrole:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return sysuserroleService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('sysuserrole:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody SysUserRole entity){
return sysuserroleService.update(entity);
}

@PreAuthorize("hasAuthority('sysuserrole:view')")
@RequestMapping(method = RequestMethod.GET)
public SysUserRole get(@RequestParam("id") Integer id){
return sysuserroleService.get(id);
}

@PreAuthorize("hasAuthority('sysuserrole:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
SysUserRoleDto dto){

PageHelper.startPage(pageNum,pageSize);

List<SysUserRole> list = sysuserroleService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<SysUserRole> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
