package ${pkg}.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import ${pkg}.dto.${modelName}Dto;
import ${pkg}.entity.${modelName};
import ${pkg}.service.${modelName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/${modelName?lower_case}")
public class ${modelName}RestController {


@Autowired
${modelName}Service ${modelName?lower_case}Service;

@PreAuthorize("hasAuthority('${modelName?lower_case}:add')")
@RequestMapping(method = RequestMethod.POST)
public Integer post(@Valid @RequestBody ${modelName} entity){
return ${modelName?lower_case}Service.add(entity);
}

@PreAuthorize("hasAuthority('${modelName?lower_case}:delete')")
@RequestMapping(method = RequestMethod.DELETE)
public Integer delete(@RequestParam("id") Integer id){
return ${modelName?lower_case}Service.remove(id);
}

@PreAuthorize("hasAuthority('${modelName?lower_case}:delete')")
@RequestMapping(method = RequestMethod.DELETE,value = "batch")
public Integer batchDelete(@RequestBody Integer[] ids){
return ${modelName?lower_case}Service.removeBatch(ids);
}

@PreAuthorize("hasAuthority('${modelName?lower_case}:edit')")
@RequestMapping(method = RequestMethod.PUT)
public Integer put(@RequestBody ${modelName} entity){
return ${modelName?lower_case}Service.update(entity);
}

@PreAuthorize("hasAuthority('${modelName?lower_case}:view')")
@RequestMapping(method = RequestMethod.GET)
public ${modelName} get(@RequestParam("id") Integer id){
return ${modelName?lower_case}Service.get(id);
}

@PreAuthorize("hasAuthority('${modelName?lower_case}:view')")
@RequestMapping(method = RequestMethod.GET,value = "page")
public Object page(@RequestParam(value = "pageNum",defaultValue = "1",required = true) Integer pageNum,
@RequestParam(value = "pageSize",defaultValue = "10",required = true) Integer pageSize,
@RequestParam(value = "draw",required = false) Integer draw,
${modelName}Dto dto){

PageHelper.startPage(pageNum,pageSize);

List<${modelName}> list = ${modelName?lower_case}Service.getByDto(dto);
PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
if(draw!=null){
DataTablesResponseEntity<${modelName}> responseEntity=new DataTablesResponseEntity(draw,pageInfo.getTotal(),pageInfo.getTotal(),pageInfo.getList());
return responseEntity;
}else{
return pageInfo;
}

}
}
