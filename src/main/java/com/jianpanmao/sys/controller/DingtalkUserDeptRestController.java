package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.DingtalkUserDeptDto;
import com.jianpanmao.sys.entity.DingtalkUserDept;
import com.jianpanmao.sys.service.DingtalkUserDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dingtalkuserdept")
public class DingtalkUserDeptRestController {


@Autowired
DingtalkUserDeptService dingtalkuserdeptService;

@PreAuthorize("hasAuthority('dingtalkuserdept:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody DingtalkUserDept entity){
return dingtalkuserdeptService.add(entity);
}

@PreAuthorize("hasAuthority('dingtalkuserdept:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return dingtalkuserdeptService.remove(id);
}

@PreAuthorize("hasAuthority('dingtalkuserdept:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return dingtalkuserdeptService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('dingtalkuserdept:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody DingtalkUserDept entity){
return dingtalkuserdeptService.update(entity);
}

@PreAuthorize("hasAuthority('dingtalkuserdept:view')")
@RequestMapping(method = RequestMethod.GET)
public DingtalkUserDept get(@RequestParam("id") Integer id){
return dingtalkuserdeptService.get(id);
}

@PreAuthorize("hasAuthority('dingtalkuserdept:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
DingtalkUserDeptDto dto){

PageHelper.startPage(pageNum,pageSize);

List<DingtalkUserDept> list = dingtalkuserdeptService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<DingtalkUserDept> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
