package com.jianpanmao.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.annotation.NoResultEntity;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.sys.dao.DingtalkDeptMapper;
import com.jianpanmao.sys.dao.DingtalkUserMapper;
import com.jianpanmao.sys.dto.DeptUserDto;
import com.jianpanmao.sys.dto.DingtalkUserDto;
import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkUserService;
import com.jianpanmao.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dingtalkuser")
public class DingtalkUserRestController {


    @Autowired
    DingtalkUserService dingtalkuserService;

    @Autowired
    private DingtalkUserMapper dao;

    @Autowired
    DingtalkDeptMapper dingtalkDeptMapper;

    @PreAuthorize("hasAuthority('dingtalkuser:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody DingtalkUser entity) {
        return dingtalkuserService.add(entity);
    }

    @PreAuthorize("hasAuthority('dingtalkuser:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return dingtalkuserService.remove(id);
    }

    @PreAuthorize("hasAuthority('dingtalkuser:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return dingtalkuserService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('dingtalkuser:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody DingtalkUser entity) {
        return dingtalkuserService.update(entity);
    }


    @PreAuthorize("hasAuthority('dingtalkuser:edit')")
    @RequestMapping(method = RequestMethod.PUT, value = "editPwd")
    public Integer editPwd(@RequestParam(value = "id", required = true) Integer id,
                           @RequestParam(value = "pwd", required = true) String pwd) {
        return dingtalkuserService.editPwd(id, pwd);
    }


    @PreAuthorize("hasAuthority('dingtalkuser:edit')")
    @RequestMapping(method = RequestMethod.PUT, value = "info")
    public Integer info(@RequestBody DingtalkUser entity) {
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setUserid(user.getUserid());
        return dingtalkuserService.updateInfo(entity);
    }

    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET)
    public DingtalkUser get(@RequestParam(value = "id", required = false) Integer id) {


        if (id == null) {
            DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return dingtalkuserService.get(user.getUserid());
        } else {
            return dingtalkuserService.get(id);
        }


    }


    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET, value = "intermediary_id")
    public List<DingtalkUser> getByintermediaryId(@RequestParam(value = "intermediary_id", required = false) Integer id) {
        DingtalkUserDto dto = new DingtalkUserDto();
        if (id == null) {
            DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            dto.setIntermediaryId(user.getIntermediaryId());
        } else {
            dto.setIntermediaryId(id);
        }

        List<DingtalkUser> list = dingtalkuserService.getByDto(dto);
        return list;
    }


    @NoResultEntity
    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(value = "mobile")
    public Boolean findByMobile(HttpServletRequest request) {
        String mobile = request.getParameter("mobile");
        DingtalkUser byMobile = dingtalkuserService.findByMobile(mobile);
        if (null == byMobile) {
            return true;
        } else {

            return false;
        }
    }

    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       DingtalkUserDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<DingtalkUser> list = dingtalkuserService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<DingtalkUser> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }

    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @GetMapping("/idNameList")
    public List<DingtalkUser> idNameList() {
        DingtalkUser dingtalkUser = UserUtils.getUser();
        return dao.idNameList(dingtalkUser.getIntermediary().getIntermediaryId());
    }


    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET, value = "role")
    public List<DingtalkUser> findByRoleId(@RequestParam(value = "roleid", required = true) Integer roleId) {
        return dao.selectByRoleId(roleId);
    }

    /****
     * 部门人员树
     */
    @PreAuthorize("hasAuthority('dingtalkuser:view')")
    @RequestMapping(method = RequestMethod.GET, value = "deptUser")
    public List<DeptUserDto> deptUser(Integer iId, @RequestParam(required = false) String path) {
        if (null == path) {
            path = ",0,";
        }
        //人
        List<DeptUserDto> users = dao.selectDeptUser(iId, path);
        Map<Integer, List<DeptUserDto>> userMap = new HashMap<>();
        for (DeptUserDto user : users) {
            if (userMap.containsKey(user.getParentId())) {
                userMap.get(user.getParentId()).add(user);
            } else {
                List<DeptUserDto> dtos = new ArrayList<>();
                dtos.add(user);
                userMap.put(user.getParentId(), dtos);
            }
        }
//部门
        List<DeptUserDto> deptList = dingtalkDeptMapper.findByPI(path, iId);
        Integer topPid = Integer.valueOf(path.substring(path.lastIndexOf(",") - 1, path.lastIndexOf(",")));
        List<DeptUserDto> tops = new ArrayList<>();
        if (null!=deptList&&deptList.size()>0){
            for (DeptUserDto dept : deptList) {
                if (dept.getParentId().intValue() == topPid) {
                    tops.add(dept);
                }
            }
            for (DeptUserDto dept:tops){
                recursionDept(deptList, dept, 0, userMap);
            }
        }

        return tops;
    }


    private void recursionDept(List<DeptUserDto> deptList, DeptUserDto dept, Integer size, Map<Integer, List<DeptUserDto>> userMap) {
        List<DeptUserDto> children = new ArrayList<>();

        //装入人员
        if (userMap.containsKey(dept.getId())) {
            children.addAll(userMap.get(dept.getId()));
        }
        for (int i = 0; i < deptList.size(); i++) {
            if (deptList.get(i).getParentId().intValue() == dept.getId()) {
                children.add(deptList.get(i));
            }
        }
        dept.setChildren(children);
        if (null!=dept.getChildren()&&dept.getChildren().size()>0){
            dept.setIsParent(true);
        }else {
            dept.setIsParent(false);
        }
        if (size == deptList.size()) {
            return;
        }
        recursionDept(deptList, deptList.get(size), ++size, userMap);
    }

}
