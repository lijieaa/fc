package com.jianpanmao.wxmessage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.wxmessage.dto.WxMessageDto;
import com.jianpanmao.wxmessage.entity.WxMessage;
import com.jianpanmao.wxmessage.service.WxMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wxmessage")
public class WxMessageRestController {


@Autowired
WxMessageService wxmessageService;

@PreAuthorize("hasAuthority('wxmessage:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody WxMessage entity){
return wxmessageService.add(entity);
}

@PreAuthorize("hasAuthority('wxmessage:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return wxmessageService.remove(id);
}

@PreAuthorize("hasAuthority('wxmessage:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return wxmessageService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('wxmessage:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody WxMessage entity){
return wxmessageService.update(entity);
}

@PreAuthorize("hasAuthority('wxmessage:view')")
@RequestMapping(method = RequestMethod.GET)
public WxMessage get(@RequestParam("id") Integer id){
return wxmessageService.get(id);
}

@PreAuthorize("hasAuthority('wxmessage:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
WxMessageDto dto){

PageHelper.startPage(pageNum,pageSize);

List<WxMessage> list = wxmessageService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<WxMessage> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
