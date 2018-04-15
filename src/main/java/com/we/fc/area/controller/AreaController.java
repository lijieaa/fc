package com.we.fc.area.controller;

import com.we.fc.area.dao.AreaMapper;
import com.we.fc.area.entity.Area;
import com.we.fc.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mayn on 2018/4/15.
 */
@Controller
@RequestMapping("area")
public class AreaController {
    @Autowired
    AreaMapper dao;

    @GetMapping("condition")
    @ResponseBody
    public ResponseEntity findByLP(@RequestParam Integer level,@RequestParam(required = false)Integer parent){
        ResponseEntity responseEntity = new ResponseEntity();
        List<Area>  areas = dao.findByLP(level, parent);
        if(level.intValue()==1){
            for (Area area:areas){
                area.setIsParent(true);
            }
        }
        responseEntity.setData(areas);
        return responseEntity;
    }
}
