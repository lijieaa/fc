package com.we.fc.intermediary.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;
import com.we.fc.intermediary.service.IntermediaryService;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author zdc
 * @since 2018-04-05 21:40
 */
@RestController
@RequestMapping("intermediary")
public class IntermediaryController extends BaseController<Intermediary> {

    @Autowired
    IntermediaryService intermediaryService;

    @Override
    public BaseService<Intermediary> getService() {
        return intermediaryService;
    }
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "intermediary/index";
    }

    @GetMapping("findById")
    public ResponseEntity findById(Integer id){
        ResponseEntity responseEntity = new ResponseEntity();
        Intermediary intermediary = intermediaryService.findById(id);
        responseEntity.setData(Arrays.asList(intermediary));
        return responseEntity;
    }

}
