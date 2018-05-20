package com.jianpanmao.area.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.area.dao.AreaMapper;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.area.dto.AreaDto;
import com.jianpanmao.area.entity.Area;
import com.jianpanmao.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/area")
public class AreaRestController {


    @Autowired
    AreaService areaService;
    @Autowired
    AreaMapper dao;

    @PreAuthorize("hasAuthority('area:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody Area entity) {
        return areaService.add(entity);
    }

    @PreAuthorize("hasAuthority('area:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return areaService.remove(id);
    }

    @PreAuthorize("hasAuthority('area:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return areaService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('area:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Area entity) {
        return areaService.update(entity);
    }

    @PreAuthorize("hasAuthority('area:view')")
    @RequestMapping(method = RequestMethod.GET)
    public Area get(@RequestParam("id") Integer id) {
        return areaService.get(id);
    }

    @PreAuthorize("hasAuthority('area:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       AreaDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<Area> list = areaService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Area> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }


    @GetMapping("condition")
    @ResponseBody
    public List<Area> findByLP(@RequestParam Integer level, @RequestParam(required = false) Integer parent) {
        List<Area> areas = dao.findByLP(level, parent);
        if (level.intValue() == 1) {
            for (Area area : areas) {
                area.setParent(true);
            }
        }
        return areas;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Area> findByShortName(String shortName){
        List<Area> areas = dao.findByShortName(shortName);
        return areas;
    }
}
