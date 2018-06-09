package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dto.ExtConLabDto;
import com.jianpanmao.sys.entity.ExtConLab;
import com.jianpanmao.sys.service.ExtConLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/extconlab")
public class ExtConLabRestController {


    @Autowired
    ExtConLabService extconlabService;

    @PreAuthorize("hasAuthority('extconlab:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody ExtConLab entity) {
        return extconlabService.add(entity);
    }

    @PreAuthorize("hasAuthority('extconlab:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return extconlabService.remove(id);
    }

    @PreAuthorize("hasAuthority('extconlab:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return extconlabService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('extconlab:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody ExtConLab entity) {
        return extconlabService.update(entity);
    }

    @PreAuthorize("hasAuthority('extconlab:view')")
    @RequestMapping(method = RequestMethod.GET)
    public ExtConLab get(@RequestParam("id") Integer id) {
        return extconlabService.get(id);
    }

    @PreAuthorize("hasAuthority('extconlab:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       ExtConLabDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<ExtConLab> list = extconlabService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<ExtConLab> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
}
