package com.jianpanmao.customer.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.customer.dto.CustomerDto;
import com.jianpanmao.customer.entity.Customer;
import com.jianpanmao.customer.service.CustomerService;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {


    @Autowired
    CustomerService customerService;

    @PreAuthorize("hasAuthority('customer:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody Customer entity) {
        return customerService.add(entity);
    }

    @PreAuthorize("hasAuthority('customer:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return customerService.remove(id);
    }

    @PreAuthorize("hasAuthority('customer:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return customerService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('customer:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Customer entity) {
        return customerService.update(entity);
    }

    @PreAuthorize("hasAuthority('customer:view')")
    @RequestMapping(method = RequestMethod.GET)
    public Customer get(@RequestParam("id") Integer id) {
        return customerService.get(id);
    }

    @PreAuthorize("hasAuthority('customer:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       CustomerDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<Customer> list = customerService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Customer> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }


    @PreAuthorize("hasAuthority('customer:view')")
    @RequestMapping(method = RequestMethod.GET, value = "all")
    public Object all() {
        CustomerDto dto=new CustomerDto();
        DingtalkUser cuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        dto.setIntermediaryId(cuser.getIntermediaryId());
        List<Customer> list = customerService.getByDto(dto);
        return list;
    }
}
