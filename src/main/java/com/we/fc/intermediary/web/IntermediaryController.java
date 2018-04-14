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

    @GetMapping("detail")
    public String IntermediaryDetail(){
        return "IntermediaryDetail";
    }

    @Override
    public BaseService<Intermediary> getService() {
        return service;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "intermediary/index";
    }


    @GetMapping("queryPage")
    @ResponseBody
    public ResponseEntity pageList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestParam(required = false)String name,
                                   @RequestParam(required = false)String area,@RequestParam(required = false)String contact,@RequestParam(required = false)String tel) {
        ResponseEntity responseEntity = new ResponseEntity();
       PageHelper.startPage(page,rows);
        List<Intermediary> list = service.queryPage(name, area, contact, tel);
        PageInfo pageInfo = new PageInfo(list);
        responseEntity.setData(Arrays.asList(pageInfo));
        return responseEntity;
    }

}
