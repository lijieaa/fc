package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.ExtConDto;
import com.jianpanmao.sys.entity.ExtCon;
import com.jianpanmao.sys.service.ExtConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/extcon")
public class ExtConRestController {


@Autowired
ExtConService extconService;

@PreAuthorize("hasAuthority('extcon:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody ExtCon entity){
return extconService.add(entity);
}

@PreAuthorize("hasAuthority('extcon:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return extconService.remove(id);
}

@PreAuthorize("hasAuthority('extcon:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return extconService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('extcon:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody ExtCon entity){
return extconService.update(entity);
}

@PreAuthorize("hasAuthority('extcon:view')")
@RequestMapping(method = RequestMethod.GET)
public ExtCon get(@RequestParam("id") Integer id){
return extconService.get(id);
}

@PreAuthorize("hasAuthority('extcon:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
ExtConDto dto){

PageHelper.startPage(pageNum,pageSize);

List<ExtCon> list = extconService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<ExtCon> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
