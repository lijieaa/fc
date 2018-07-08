package com.jianpanmao.contacts.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.contacts.dto.ContactsDto;
import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.contacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsRestController {


    @Autowired
    ContactsService contactsService;

    @PreAuthorize("hasAuthority('contacts:add')")
    @RequestMapping(method = RequestMethod.POST)
    public Integer post(@Valid @RequestBody Contacts entity) {
        return contactsService.add(entity);
    }

    @PreAuthorize("hasAuthority('contacts:delete')")
    @RequestMapping(method = RequestMethod.DELETE)
    public Integer delete(@RequestParam("id") Integer id) {
        return contactsService.remove(id);
    }

    @PreAuthorize("hasAuthority('contacts:delete')")
    @RequestMapping(method = RequestMethod.DELETE, value = "batch")
    public Integer batchDelete(@RequestBody Integer[] ids) {
        return contactsService.removeBatch(ids);
    }

    @PreAuthorize("hasAuthority('contacts:edit')")
    @RequestMapping(method = RequestMethod.PUT)
    public Integer put(@RequestBody Contacts entity) {
        return contactsService.update(entity);
    }

    @PreAuthorize("hasAuthority('contacts:view')")
    @RequestMapping(method = RequestMethod.GET)
    public Contacts get(@RequestParam("id") Integer id) {
        return contactsService.get(id);
    }

    @PreAuthorize("hasAuthority('contacts:view')")
    @RequestMapping(method = RequestMethod.GET,value = "cid")
    public List<Contacts> getByCustomerId(@RequestParam("cid") Integer cid) {
        ContactsDto dto=new ContactsDto();
        dto.setCusId(cid);
        return  contactsService.getByDto(dto);
    }

    @PreAuthorize("hasAuthority('contacts:view')")
    @RequestMapping(method = RequestMethod.GET, value = "page")
    public Object page(@RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize,
                       @RequestParam(value = "draw", required = false) Integer draw,
                       ContactsDto dto) {

        PageHelper.startPage(pageNum, pageSize);

        List<Contacts> list = contactsService.getByDto(dto);
        PageInfo pageInfo = new PageInfo(list);

//draw 不等于空是datatables分页
        if (draw != null) {
            DataTablesResponseEntity<Contacts> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }

    }
}