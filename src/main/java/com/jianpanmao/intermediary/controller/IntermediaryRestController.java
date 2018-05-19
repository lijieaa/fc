package com.jianpanmao.intermediary.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.intermediary.dto.IntermediaryDto;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.intermediary.service.IntermediaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/intermediary")
public class IntermediaryRestController {


@Autowired
IntermediaryService intermediaryService;

@PreAuthorize("hasAuthority('intermediary:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody Intermediary entity){
return intermediaryService.add(entity);
}

@PreAuthorize("hasAuthority('intermediary:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return intermediaryService.remove(id);
}

@PreAuthorize("hasAuthority('intermediary:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return intermediaryService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('intermediary:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody Intermediary entity){
return intermediaryService.update(entity);
}

@PreAuthorize("hasAuthority('intermediary:view')")
@RequestMapping(method = RequestMethod.GET)
public Intermediary get(@RequestParam("id") Integer id){
return intermediaryService.get(id);
}

@PreAuthorize("hasAuthority('intermediary:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
IntermediaryDto dto){

PageHelper.startPage(pageNum,pageSize);

List<Intermediary> list = intermediaryService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<Intermediary> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
