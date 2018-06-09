package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.ConLabDto;
import com.jianpanmao.sys.entity.ConLab;
import com.jianpanmao.sys.service.ConLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/conlab")
public class ConLabRestController {


@Autowired
ConLabService conlabService;

@PreAuthorize("hasAuthority('conlab:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody ConLab entity){
return conlabService.add(entity);
}

@PreAuthorize("hasAuthority('conlab:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return conlabService.remove(id);
}

@PreAuthorize("hasAuthority('conlab:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return conlabService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('conlab:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody ConLab entity){
return conlabService.update(entity);
}

@PreAuthorize("hasAuthority('conlab:view')")
@RequestMapping(method = RequestMethod.GET)
public ConLab get(@RequestParam("id") Integer id){
return conlabService.get(id);
}

@PreAuthorize("hasAuthority('conlab:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
ConLabDto dto){

PageHelper.startPage(pageNum,pageSize);

List<ConLab> list = conlabService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<ConLab> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
