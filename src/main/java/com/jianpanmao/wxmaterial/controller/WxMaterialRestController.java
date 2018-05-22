package com.jianpanmao.wxmaterial.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.wxmaterial.dto.WxMaterialDto;
import com.jianpanmao.wxmaterial.entity.WxMaterial;
import com.jianpanmao.wxmaterial.service.WxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wxmaterial")
public class WxMaterialRestController {


@Autowired
WxMaterialService wxmaterialService;

@PreAuthorize("hasAuthority('wxmaterial:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody WxMaterial entity){
return wxmaterialService.add(entity);
}

@PreAuthorize("hasAuthority('wxmaterial:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return wxmaterialService.remove(id);
}

@PreAuthorize("hasAuthority('wxmaterial:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return wxmaterialService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('wxmaterial:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody WxMaterial entity){
return wxmaterialService.update(entity);
}

@PreAuthorize("hasAuthority('wxmaterial:view')")
@RequestMapping(method = RequestMethod.GET)
public WxMaterial get(@RequestParam("id") Integer id){
return wxmaterialService.get(id);
}

@PreAuthorize("hasAuthority('wxmaterial:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
WxMaterialDto dto){

PageHelper.startPage(pageNum,pageSize);

List<WxMaterial> list = wxmaterialService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<WxMaterial> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
