package com.jianpanmao.wechat.wx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.intermediary.service.IntermediaryService;
import com.jianpanmao.project.dto.ProjectDto;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.project.service.ProjectService;
import com.jianpanmao.projectComments.dao.ProjectCommentsMapper;
import com.jianpanmao.projectComments.dto.ProjectCommentsDto;
import com.jianpanmao.projectComments.entity.ProjectComments;
import com.jianpanmao.projectComments.service.ProjectCommentsService;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdc
 * @since 2018-07-06 22:18
 */
@RequestMapping("wx/common")
@RestController
public class WxCommonRestController {

    @Autowired private WxPublicService wxPublicService;

    @Autowired private ProjectService projectService;

    @Autowired private IntermediaryService intermediaryService;

    @Autowired private ProjectCommentsService projectcommentsService;

    @Autowired private ProjectCommentsMapper dao;


    @RequestMapping("companyInfo")
    public Intermediary findBySourceId(String sourceId) throws Exception {

        WxPublic wxPublic = wxPublicService.findBySourceId(sourceId);
        return intermediaryService.get(wxPublic.getIntermediary().getIntermediaryId());
    }

    @RequestMapping("projectList")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       @RequestParam(value = "sourceId") String sourceId,
                       ProjectDto dto) {

        WxPublic wxPublic = wxPublicService.findBySourceId(sourceId);
        dto.setIntermediary(wxPublic.getIntermediary());

        byte bt = 1;
        Byte v = new Byte(bt);
        dto.setProjectStatus(v);

        PageHelper.startPage(pageNum, pageSize);

        List<Project> list = projectService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Project> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }

    @RequestMapping("commentsList")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       ProjectCommentsDto dto) {

        byte bt = 1;
        Byte v = new Byte(bt);
        dto.setProjectCommentsType(v);// 外部评论
        dto.setProjectCommentsStatus(v);// 项目评论
        PageHelper.startPage(pageNum, pageSize);
//分页查询出项目评论列表
        List<ProjectComments> list = projectcommentsService.getByDto(dto);

        for (ProjectComments comments : list) {
            //查询项目评论下所有回复
            List<ProjectComments> commentses = dao.projectTopComments(comments.getProjectCommentsId());
            //查询评论下回复个数
            Integer count = dao.topCommentsUnderCount(comments.getProjectCommentsId());
            comments.setCount(count);
            //递归组装数据
            recursion(commentses, comments, 0);
        }

        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<ProjectComments> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }

    private void recursion(List<ProjectComments> list, ProjectComments projectComments, Integer size) {
        List<ProjectComments> children = new ArrayList<>();
        projectComments.setChildren(children);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProjectCommentsParent().intValue() == projectComments.getProjectCommentsId()) {
                list.get(i).setParentName(projectComments.getUser().getName());
                children.add(list.get(i));
            }
        }
        if (size==list.size()){
            return;
        }
        recursion(list,list.get(size),++size);

    }


}
