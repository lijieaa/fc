package com.jianpanmao.deviceLog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.deviceLog.dto.DeviceLogDto;
import com.jianpanmao.deviceLog.entity.DeviceLog;
import com.jianpanmao.deviceLog.service.DeviceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/devicelog")
public class DeviceLogRestController {


@Autowired
DeviceLogService devicelogService;

@PreAuthorize("hasAuthority('devicelog:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody DeviceLog entity){
return devicelogService.add(entity);
}

@PreAuthorize("hasAuthority('devicelog:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return devicelogService.remove(id);
}

@PreAuthorize("hasAuthority('devicelog:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return devicelogService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('devicelog:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody DeviceLog entity){
return devicelogService.update(entity);
}

@PreAuthorize("hasAuthority('devicelog:view')")
@GetMapping("{id}")
public DeviceLog get(@PathVariable("id") Integer id){
return devicelogService.get(id);
}

@PreAuthorize("hasAuthority('devicelog:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
DeviceLogDto dto){

PageHelper.startPage(pageNum,pageSize);

List<DeviceLog> list = devicelogService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<DeviceLog> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}


}
