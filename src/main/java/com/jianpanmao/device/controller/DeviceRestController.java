package com.jianpanmao.device.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.device.dao.DeviceMapper;
import com.jianpanmao.device.dto.DeviceDto;
import com.jianpanmao.device.dto.DpDto;
import com.jianpanmao.device.dto.control.DeviceControlVo;
import com.jianpanmao.device.dto.control.DeviceParam;
import com.jianpanmao.device.dto.control.DeviceUserParam;
import com.jianpanmao.device.dto.control.SystemTime;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.device.service.DeviceService;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceRestController {


    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceMapper deviceMapper;

    @PreAuthorize("hasAuthority('device:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody List<Device> entity) {
        deviceService.batAdd(entity);
        return null;
    }

    @PreAuthorize("hasAuthority('device:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return deviceService.remove(id);
    }

    @PreAuthorize("hasAuthority('device:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return deviceService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('device:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Device entity) {
        return deviceService.update(entity);
    }

    @PreAuthorize("hasAuthority('device:view')")
    @GetMapping("{id}")
    public Device get(@PathVariable("id") Integer id) {
        return deviceService.get(id);
    }

    @PreAuthorize("hasAuthority('device:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       DeviceDto dto) {

        PageHelper.startPage(pageNum, pageSize);
        List<Device> list = deviceService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Device> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }

    /**
     * 项目详情 项目设备列表
     * @param pageNum
     * @param pageSize
     * @param projectId
     * @return
     */
    @PreAuthorize("hasAuthority('device:view')")
    @GetMapping("byProjectId")
    public Object byProjectId(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                              @RequestParam(value = "draw", required = false) Integer draw,
                              Integer projectId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Device> devices = deviceMapper.findByProject(projectId);
        PageInfo pageInfo = new PageInfo(devices);

        //draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Device> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }
    }

    /**
     * 项目详情 项目设备编辑/删除关系
     * @param deviceDto
     */
    @PreAuthorize("hasAuthority('device:edit')")
    @PutMapping("updateProjectId")
    @Transactional
    public void updateDeviceUser(@RequestBody DeviceDto deviceDto) {
        deviceMapper.updateDeviceUser(deviceDto);
    }

    /**
     * 关联设备列表
     */
    @PreAuthorize("hasAuthority('device:view')")
    @GetMapping("freeDeviceList")
    public Object freeDeviceList(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                                 @RequestParam(value = "draw", required = false) Integer draw,
                                 @RequestParam(value = "num",required = false)String num,
                                 @RequestParam(value = "od",required = false)String od){
        PageHelper.startPage(pageNum, pageSize);
        List<Device> devices = deviceMapper.freeDeviceList(num,od);
        PageInfo pageInfo = new PageInfo(devices);

        //draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Device> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }
    }

    /**
     * 关联设备
     * @param dpDto
     */
    @PreAuthorize("hasAuthority('device:edit')")
    @PutMapping("projectId")
    public void updateProjectId(@RequestBody DpDto dpDto) {
        deviceMapper.updateProjectId(dpDto);
    }

    @PreAuthorize("hasAuthority('device:view')")
    @GetMapping("homePageDevice")
    public List<Device> homePageDevice() {
        DingtalkUser user = UserUtils.getUser();
        return deviceMapper.homePageDevice(user.getIntermediary().getIntermediaryId());
    }


    /**
     * 设备控制
     * @param num
     * @return
     */
    @PreAuthorize("hasAuthority('deviceControl:view')")
    @GetMapping("deviceControl")
    public DeviceControlVo deviceControl(String num) {
        return deviceService.deviceControl(num);
    }


}
