package com.we.fc.intermediary.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;
import com.we.fc.intermediary.service.IntermediaryService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author zdc
 * @since 2018-04-05 21:40
 */
@Controller
@RequestMapping("intermediary")
public class IntermediaryController extends BaseController<Intermediary> {

    @Autowired
    IntermediaryService service;

    @Override
    public BaseService<Intermediary> getService() {
        return service;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "intermediary/index";
    }

    /**
     * 查询单个数据
     * @param id
     * @return
     */
    @GetMapping("operator")
    @ResponseBody
    public ResponseEntity findById(Integer id){
        ResponseEntity responseEntity = new ResponseEntity();
        Intermediary intermediary = service.findById(id);
        responseEntity.setData(Arrays.asList(intermediary));
        return responseEntity;
    }

    /**
     * 添加中间商
     * @param intermediary
     * @return
     */
    @PostMapping("operator")
    @ResponseBody
    public ResponseEntity add(Intermediary intermediary){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            service.add(intermediary);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setMessages("添加失败！");
        }
        return responseEntity;
    }

    @PutMapping(value = "operator")
    @ResponseBody
    public ResponseEntity update(Intermediary intermediary){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            service.update(intermediary);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setMessages("修改失败！");
        }
        return responseEntity;
    }

    @GetMapping(value = "queryPage")
    @ResponseBody
    public ResponseEntity querPage(Integer page,Integer rows){
        ResponseEntity responseEntity = new ResponseEntity();
        PageHelper.startPage(1,5);
        List<Intermediary> list = service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        responseEntity.setData(Arrays.asList(pageInfo));
        return  responseEntity;
    }


}
