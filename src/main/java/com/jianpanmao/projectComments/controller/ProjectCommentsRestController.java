package com.jianpanmao.projectComments.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.projectComments.dto.ProjectCommentsDto;
import com.jianpanmao.projectComments.entity.ProjectComments;
import com.jianpanmao.projectComments.service.ProjectCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/projectcomments")
public class ProjectCommentsRestController {


@Autowired
ProjectCommentsService projectcommentsService;

@PreAuthorize("hasAuthority('projectcomments:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody ProjectComments entity){
return projectcommentsService.add(entity);
}

@PreAuthorize("hasAuthority('projectcomments:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return projectcommentsService.remove(id);
}

@PreAuthorize("hasAuthority('projectcomments:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return projectcommentsService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('projectcomments:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody ProjectComments entity){
return projectcommentsService.update(entity);
}

@PreAuthorize("hasAuthority('projectcomments:view')")
@RequestMapping(method = RequestMethod.GET)
public ProjectComments get(@RequestParam("id") Integer id){
return projectcommentsService.get(id);
}

@PreAuthorize("hasAuthority('projectcomments:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
ProjectCommentsDto dto){

PageHelper.startPage(pageNum,pageSize);

List<ProjectComments> list = projectcommentsService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<ProjectComments> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
