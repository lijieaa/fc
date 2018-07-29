package com.jianpanmao.wechat.wx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.device.dto.DeviceDto;
import com.jianpanmao.device.dto.control.DeviceControlVo;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zdc
 * @since 2018-07-16 20:53
 */
@RequestMapping("wd")
@Controller
public class WxDeviceController {

    @Autowired private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET, value = "devices")
    @ResponseBody
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

    @GetMapping("device")
    @ResponseBody
    public Object getDevice(Integer id) {
        return deviceService.get(id);
    }

    @GetMapping("operate")
    public String operate(){
        return "wx/operate";
    }

    @GetMapping("getDeviceParams")
    @ResponseBody
    public DeviceControlVo getDeviceParams(String num) {
        return deviceService.deviceControl(num);
    }
}
