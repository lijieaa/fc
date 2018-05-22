package com.jianpanmao.wxuserdetail.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.wxuserdetail.dto.WxUserDetailDto;
import com.jianpanmao.wxuserdetail.entity.WxUserDetail;
import com.jianpanmao.wxuserdetail.service.WxUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wxuserdetail")
public class WxUserDetailRestController {


@Autowired
WxUserDetailService wxuserdetailService;

@PreAuthorize("hasAuthority('wxuserdetail:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody WxUserDetail entity){
return wxuserdetailService.add(entity);
}

@PreAuthorize("hasAuthority('wxuserdetail:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return wxuserdetailService.remove(id);
}

@PreAuthorize("hasAuthority('wxuserdetail:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return wxuserdetailService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('wxuserdetail:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody WxUserDetail entity){
return wxuserdetailService.update(entity);
}

@PreAuthorize("hasAuthority('wxuserdetail:view')")
@RequestMapping(method = RequestMethod.GET)
public WxUserDetail get(@RequestParam("id") Integer id){
return wxuserdetailService.get(id);
}

@PreAuthorize("hasAuthority('wxuserdetail:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
WxUserDetailDto dto){

PageHelper.startPage(pageNum,pageSize);

List<WxUserDetail> list = wxuserdetailService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<WxUserDetail> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
