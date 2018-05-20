package com.jianpanmao.device.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.device.dto.DeviceDto;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceRestController {


@Autowired
DeviceService deviceService;

@PreAuthorize("hasAuthority('device:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody Device entity){
return deviceService.add(entity);
}

@PreAuthorize("hasAuthority('device:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return deviceService.remove(id);
}

@PreAuthorize("hasAuthority('device:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return deviceService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('device:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody Device entity){
return deviceService.update(entity);
}

@PreAuthorize("hasAuthority('device:view')")
@GetMapping("{id}")
public Device get(@PathVariable("id") Integer id){
return deviceService.get(id);
}

@PreAuthorize("hasAuthority('device:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
DeviceDto dto){

PageHelper.startPage(pageNum,pageSize);

List<Device> list = deviceService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<Device> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
