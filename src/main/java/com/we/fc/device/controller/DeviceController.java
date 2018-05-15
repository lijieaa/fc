package com.we.fc.device.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.device.entity.Device;
import com.we.fc.device.service.DeviceService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Override
    protected ResponseEntity hookExist(Device device) {
        return null;
    }

    @GetMapping("index")
    public String index(Integer menuId, HttpSession session, Model model) {
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "device/index";
    }

    @GetMapping("log")
    public String log(Integer menuId) {
        return "device/log";
    }

    @GetMapping("control")
    public String control(Integer menuId) {
        return "device/control";
    }

    @GetMapping("byProjectId")
    @ResponseBody
    public ResponseEntity byProjectId(Integer projectId) {
        List<Device> devices = service.findByProject(projectId);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setList(devices);
        return responseEntity;
    }
}
