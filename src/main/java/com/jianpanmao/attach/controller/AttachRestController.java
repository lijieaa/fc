package com.jianpanmao.attach.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.attach.dto.AttachDto;
import com.jianpanmao.attach.entity.Attach;
import com.jianpanmao.attach.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attach")
public class AttachRestController {


@Autowired
AttachService attachService;

@PreAuthorize("hasAuthority('attach:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody Attach entity){
return attachService.add(entity);
}

@PreAuthorize("hasAuthority('attach:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return attachService.remove(id);
}

@PreAuthorize("hasAuthority('attach:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return attachService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('attach:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody Attach entity){
return attachService.update(entity);
}

@PreAuthorize("hasAuthority('attach:view')")
@RequestMapping(method = RequestMethod.GET)
public Attach get(@RequestParam("id") Integer id){
return attachService.get(id);
}

@PreAuthorize("hasAuthority('attach:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
AttachDto dto){

PageHelper.startPage(pageNum,pageSize);

List<Attach> list = attachService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<Attach> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
