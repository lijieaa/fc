package com.jianpanmao.wechat.wx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.intermediary.service.IntermediaryService;
import com.jianpanmao.intermediary.service.impl.IntermediaryServiceImpl;
import com.jianpanmao.project.dto.ProjectDto;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.project.service.ProjectService;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
