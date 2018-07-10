package com.jianpanmao.contacts.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.contacts.dto.Contact2RoleDto;
import com.jianpanmao.contacts.entity.Contact2Role;
import com.jianpanmao.contacts.service.Contact2RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contact2role")
public class Contact2RoleRestController {


@Autowired
Contact2RoleService contact2roleService;

@PreAuthorize("hasAuthority('contact2role:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody Contact2Role entity){
return contact2roleService.add(entity);
}

@PreAuthorize("hasAuthority('contact2role:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return contact2roleService.remove(id);
}

@PreAuthorize("hasAuthority('contact2role:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return contact2roleService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('contact2role:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody Contact2Role entity){
return contact2roleService.update(entity);
}

@PreAuthorize("hasAuthority('contact2role:view')")
@RequestMapping(method = RequestMethod.GET)
public Contact2Role get(@RequestParam("id") Integer id){
return contact2roleService.get(id);
}

@PreAuthorize("hasAuthority('contact2role:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
Contact2RoleDto dto){

PageHelper.startPage(pageNum,pageSize);

List<Contact2Role> list = contact2roleService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<Contact2Role> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
