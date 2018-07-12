package com.jianpanmao.intermediary.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.exception.CustomException;
import com.jianpanmao.intermediary.dao.IntermediaryMapper;
import com.jianpanmao.intermediary.dto.IntermediaryDto;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.intermediary.service.IntermediaryService;
import com.jianpanmao.sys.dao.DingtalkDeptMapper;
import com.jianpanmao.sys.dao.DingtalkUserDeptMapper;
import com.jianpanmao.sys.dao.DingtalkUserMapper;
import com.jianpanmao.sys.dao.SysUserRoleMapper;
import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.DingtalkUserDept;
import com.jianpanmao.sys.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/intermediary")
public class IntermediaryRestController {


    @Autowired
    IntermediaryService intermediaryService;

    @Autowired
    private IntermediaryMapper dao;


    @PreAuthorize("hasAuthority('intermediary:add')")
    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public Integer post(@Valid @RequestBody Intermediary entity) {
        //添加中间商
        return intermediaryService.add(entity);
    }

    @PreAuthorize("hasAuthority('intermediary:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) throws CustomException {
        return intermediaryService.removeI(id);
    }

    @PreAuthorize("hasAuthority('intermediary:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) throws CustomException {
        return intermediaryService.removeBatchI(ids);
    }

    @PreAuthorize("hasAuthority('intermediary:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Intermediary entity) {
        return intermediaryService.update(entity);
    }

    @PreAuthorize("hasAuthority('intermediary:view')")
    @GetMapping("{id}")
    public Intermediary get(@PathVariable("id") Integer id) {
        return intermediaryService.get(id);
    }

    @PreAuthorize("hasAuthority('intermediary:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       IntermediaryDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<Intermediary> list = intermediaryService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Intermediary> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }

    @PreAuthorize("hasAuthority('intermediary:view')")
    @GetMapping("idNameList")
    @ResponseBody
    public List<Intermediary> selectIdNameList() {
        return dao.selectIdNameList();
    }


}
