package com.jianpanmao.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.news.dto.NewsDto;
import com.jianpanmao.news.entity.News;
import com.jianpanmao.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsRestController {


@Autowired
NewsService newsService;

@PreAuthorize("hasAuthority('news:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody News entity){
return newsService.add(entity);
}

@PreAuthorize("hasAuthority('news:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return newsService.remove(id);
}

@PreAuthorize("hasAuthority('news:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return newsService.removeBatch(ids);
}

@PreAuthorize("hasAuthority('news:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody News entity){
return newsService.update(entity);
}

@PreAuthorize("hasAuthority('news:view')")
@RequestMapping(method = RequestMethod.GET)
public News get(@RequestParam("id") Integer id){
return newsService.get(id);
}

@PreAuthorize("hasAuthority('news:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
NewsDto dto){

PageHelper.startPage(pageNum,pageSize);

List<News> list = newsService.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<News> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
