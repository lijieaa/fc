package com.we.fc.device.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.device.entity.Device;
import com.we.fc.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zdc
 * @since 2018-04-05 21:29
 */
@Controller
@RequestMapping("device")
public class DeviceController extends BaseController<Device> {

    @Autowired
    DeviceService service;

    @Override
    public BaseService<Device> getService() {
        return service;
    }

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "device/index";
    }

    @GetMapping("log")
    public String log(Integer menuId){
        return "device/log";
    }

    @GetMapping("control")
    public String control(Integer menuId){
        return "device/control";
    }

}
