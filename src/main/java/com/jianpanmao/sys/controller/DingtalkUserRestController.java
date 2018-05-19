package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.DingtalkUserDto;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dingtalkuser")
public class DingtalkUserRestController {


@Autowired
DingtalkUserService dingtalkuserService;

@PreAuthorize("hasAuthority('dingtalkuser:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody DingtalkUser entity){
return dingtalkuserService.add(entity);
}

@PreAuthorize("hasAuthority('dingtalkuser:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return dingtalkuserService.remove(id);
}

@PreAuthorize("hasAuthority('dingtalkuser:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return dingtalkuserService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('dingtalkuser:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody DingtalkUser entity){
return dingtalkuserService.update(entity);
}

@PreAuthorize("hasAuthority('dingtalkuser:view')")
@RequestMapping(method = RequestMethod.GET)
public DingtalkUser get(@RequestParam("id") Integer id){
return dingtalkuserService.get(id);
}

@PreAuthorize("hasAuthority('dingtalkuser:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
DingtalkUserDto dto){

PageHelper.startPage(pageNum,pageSize);

List<DingtalkUser> list = dingtalkuserService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<DingtalkUser> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
